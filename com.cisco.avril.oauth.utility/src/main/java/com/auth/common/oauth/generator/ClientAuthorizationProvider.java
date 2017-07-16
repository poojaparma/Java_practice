
package com.auth.common.oauth.generator;

import java.io.Closeable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.springframework.stereotype.Component;

import com.auth.common.CacheManager;
import com.auth.common.CommonConstants;
import com.auth.common.InMemoryManager;

/**
 * class to provide oauth access token to the client to access the rest api.
 *
 * @author suchandp
 */
///@Component
public final class ClientAuthorizationProvider implements Closeable {

    private static volatile ClientAuthorizationProvider clientAuthProvider;
    private static CommonIdentityClient client = new CommonIdentityClient();
    private static OauthClientInitializer oauthInitClient = OauthClientInitializer.getInstance();
  //  private static final Logger LOG = LogManager.getLogger(ClientAuthorizationProvider.class.getName());

    private final Object lock = new Object();
    private volatile String accessToken;
    private volatile String refreshToken;
    private volatile String retiredAccessToken;

    private volatile CacheManager<String, String> accessTokenCache = null;

    private volatile CacheManager<String, String> refreshTokenCache = null;

    private ClientAuthorizationProvider()
    {
    }

    /**
     * To Make class Singleton
     *
     * @return Instance of ClientAuthorizationProvider class
     */
    public static ClientAuthorizationProvider getInstance()
    {

        if (null == clientAuthProvider)
        {
            synchronized (ClientAuthorizationProvider.class)
            {
                if (null == clientAuthProvider)
                {
                    clientAuthProvider = new ClientAuthorizationProvider();
                }
            }
        }
        return clientAuthProvider;
    }

    @Override
    public void close() throws IOException
    {

        if (retiredAccessToken != null)
        {
            deleteAccessToken(retiredAccessToken);
            retiredAccessToken = null;
        }

        if (accessToken != null)
        {
            deleteAccessToken(accessToken);
            accessToken = null;
        }
    }

    /**
     * @param tokenToBeDeleted
     */
    private void deleteAccessToken(final String tokenToBeDeleted)
    {

        if (tokenToBeDeleted != null)
        {
            try
            {
                if (tokenToBeDeleted.equals(accessTokenCache.getValue(OauthConstants.ACCESS_TOKEN_STRING)))
                {
                    accessTokenCache.deleteValue(OauthConstants.ACCESS_TOKEN_STRING);
                }
            }
            catch (final Exception e)
            {
              //  LOG.warn(CommonConstants.ERROR_LOG + "Failed to delete an access token." + e);
            }
        }
    }

    /**
     * This function will provide a valid access token.
     *
     * @return accessToken
     */
    public String getAccessToken()
    {

        if (!isAccessTokenExpired())
        {
            return accessToken;
        }
        synchronized (lock)
        {
            // Another thread may have already done the refresh so see if it's
            // still needed
            if (isAccessTokenExpired())
            {
                if (isRefreshTokenExpired())
                {
                  //  LOG.debug("Refreshing both refresh & access token");
                    renewAccessAndRefreshTokens();
                }
                else
                {
                //    LOG.debug("Refreshing access token");
                    renewAccessToken();
                }
            }
            return accessToken;
        }
    }

    /**
     * @return boolean
     */
    private boolean isAccessTokenExpired()
    {

        return accessToken == null || (accessTokenCache.getValue(OauthConstants.ACCESS_TOKEN_STRING) == null);
    }

    /**
     * @return
     */
    private boolean isRefreshTokenExpired()
    {

        return refreshToken == null || (refreshTokenCache.getValue(OauthConstants.REFRESH_TOKEN_STRING) == null);
    }

    /**
     * renew the expired access token
     */
    private void renewAccessAndRefreshTokens()
    {

        OauthAccessToken token = null;
        try
        {
            token = client.getAccessTokenForServiceAccount(oauthInitClient.getServiceAccountUserId(), oauthInitClient.getServiceAccountPassword(),
                    oauthInitClient.getScope());
            if (null != token)
            {
                if (accessTokenCache == null)
                {
                    accessTokenCache = new InMemoryManager<String, String>(token.getExpiresIn().intValue(), CommonConstants.DEFAULT_MAX_ENTRIES_INMEM,
                            OauthConstants.ACCESS_TOKEN_STRING + OauthConstants.CACHE);
                }

                if (refreshTokenCache == null)
                {
                    refreshTokenCache = new InMemoryManager<String, String>(token.getRefreshTokenExpiresIn().intValue(),
                            CommonConstants.DEFAULT_MAX_ENTRIES_INMEM, OauthConstants.REFRESH_TOKEN_STRING + OauthConstants.CACHE);
                }

                accessTokenCache.setValue(OauthConstants.ACCESS_TOKEN_STRING, token.getAccessToken());

                refreshTokenCache.setValue(OauthConstants.REFRESH_TOKEN_STRING, token.getRefreshToken());
                updateAccessToken(token, true);
            }

        }
        catch (UnsupportedEncodingException | ClientException e)
        {
        }

    }

    /**
     * renew access token
     */
    private void renewAccessToken()
    {

        try
        {
            final OauthAccessToken token = client.refreshAccessToken(refreshToken);
            accessTokenCache.setValue(OauthConstants.ACCESS_TOKEN_STRING, token.getAccessToken());
            updateAccessToken(token, false);
        }
        catch (final ClientException e)
        {
            if (e.isClientError())
            {
                renewAccessAndRefreshTokens();
            }

        }

        catch (final Exception e)
        {
        }
    }

    /**
     * @param token
     *            : access token
     * @param includeRefreshToken
     *            : boolean to include or exclude refresh token
     */
    private void updateAccessToken(final OauthAccessToken token, final boolean includeRefreshToken)
    {

        if (token.getAccountExpiration() != null && token.getAccountExpiration() < 30)
        {
        }

        final String tokenToBeDeleted = retiredAccessToken;
        retiredAccessToken = accessToken;

        accessToken = accessTokenCache.getValue(OauthConstants.ACCESS_TOKEN_STRING);
        deleteAccessToken(tokenToBeDeleted);
        if (includeRefreshToken)
        {
            refreshToken = refreshTokenCache.getValue(OauthConstants.REFRESH_TOKEN_STRING);
        }
    }

}
