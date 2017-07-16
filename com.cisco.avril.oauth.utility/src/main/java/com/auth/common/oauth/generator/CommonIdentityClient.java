/**
 * $COPYRIGHTSTART ******************************************************* Copyright (c)
 * 2015 Cisco Systems, Inc. All rights reserved. This product is protected by one or more
 * of the following US patents: 5,070,526; 5,434,906; 5,488,650; 5,533,102; 5,568,540;
 * 5,581,604; 5,625,676; 5,651,054; 5,940,488; 6,041,114; 6,404,874. Additional US and
 * foreign patents pending. Cisco Unity is a registered trademark of Cisco Systems, Inc.
 * and/or its affiliates in the United States and certain other countries. Cisco Systems,
 * Inc. San Jose, California U.S.A. COPYRIGHT(c)2014 by Cisco Systems, Inc. All rights
 * reserved.
 */
package com.auth.common.oauth.generator;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.auth.common.AvrilConsts;
import com.auth.common.CommonConstants;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;

/**
 * @author suchandp
 */
public class CommonIdentityClient {

  //  private static final Logger LOG = LogManager.getLogger(CommonIdentityClient.class.getName());
    // Early initialization of environment variables
    Gson gson = new Gson();

    OauthClientInitializer oauthInitClient = OauthClientInitializer.getInstance();
    private static final String UTF_8 ="UTF-8";
    public CommonIdentityClient(){

    }

    /**
     * Obtains a new access token for service-to-service access using a service account.
     *
     * @param bearerToken
     *            the bearer token from cis, to get access token
     * @param scope
     *            scope of API access
     * @return the access token for the service
     * @throws UnsupportedEncodingException
     *             , ClientException
     * @throws JSONException
     * @throws UniformInterfaceException
     * @throws ClientHandlerException
     */
    private OauthAccessToken getAccessToken(final String scope, final OauthBearerToken bearerToken)
            throws ClientException, UnsupportedEncodingException, ClientHandlerException, UniformInterfaceException
    {

        // increment the request counter

        final StringBuilder oauthAccessUrl = new StringBuilder(oauthInitClient.getCisHost());
        oauthAccessUrl.append(CommonConstants.CONSTANT_SLASH);
        oauthAccessUrl.append(OauthConstants.ACCESS_TOKEN_PATH);


        final StringBuilder encodedBody = new StringBuilder();
        String urlEncodedBody = null;
        try
        {
            urlEncodedBody = encodedBody.append("grant_type=").append(URLEncoder.encode(OauthConstants.OAUTH_GRANT_TYPE, UTF_8))
                    .append("&assertion=").append(bearerToken.getBearer()).append("&scope=").append(URLEncoder.encode(scope, UTF_8)).toString();
        }
        catch (final UnsupportedEncodingException exp)
        {
          //  LOG.error("UTF-8 encoding is not supported" + exp + exp.getMessage());
        }
HttpEntity< String>entity = new HttpEntity<String>(urlEncodedBody, getHeadersAcessToken());
        // Start the timing metric to calculate the total response time.
RestTemplate restTemplate = new RestTemplate();

final ResponseEntity<String> response = restTemplate.postForEntity(oauthAccessUrl.toString(), entity,String.class);

        OauthAccessToken accessToken = null;
        if (AvrilConsts.OAUTH_POST_RESPONSE_CODE == response.getStatusCode().value())
        {
            accessToken = getTokenResponse(response.getBody(), true);
            // stop the timing metric
        }
        else
        {
         //   LOG.error("Not able to fetch Access Token");
            throw new ClientException(response.getBody());
        }
        // add the success counter
        return accessToken;
    }

    /**
     * Obtains a new access token for service-to-service access using a service account.
     * See <a href=
     * "http://wikicentral.cisco.com/display/PROJECT/Using+OAuth+2+for+Service+to+Service+Access+By+a+Service+Account"
     * > OAuth2 REST API Docs</a> for details.
     *
     * @param serviceUserId
     *            the service account user id
     * @param serviceScretId
     *            the service account password
     * @param scope
     *            scope of API access
     * @return the access token for the service
     * @throws UnsupportedEncodingException
     *             , ClientException
     */
    public OauthAccessToken getAccessTokenForServiceAccount(final String serviceUserId, final String serviceScretId, final String scope)
            throws UnsupportedEncodingException, ClientException
    {

        if (!validateParameters(serviceUserId, serviceScretId, scope))
        {
          //  LOG.error("Received service account detail is null");
            return null;
        }

        OauthBearerToken bearerToken = null;
        OauthAccessToken accessToken = null;
        try
        {
            bearerToken = getBearerToken(serviceUserId, serviceScretId);
            accessToken = getAccessToken(scope, bearerToken);
        }
        catch (final Exception exception)
        {
           // LOG.error("Exception while fetching bearer & access token " + exception);
            throw new ClientException(exception.getMessage());
        }
        return accessToken;
    }

    /**
     * Encoding the bearer token to base64 for access token generation.
     *
     * @param clientId
     *            client id
     * @param clientSecret
     *            client password
     * @return encoded bearer token
     * @throws UnsupportedEncodingException
     */
    private String getAuthorization(final String clientId, final String clientSecret) throws UnsupportedEncodingException
    {

        final StringBuilder authValueBuilder = new StringBuilder();
        final String authValue = authValueBuilder.append(clientId).append(":").append(clientSecret).toString();
        return new String(Base64.encodeBase64(authValue.getBytes(Charset.forName(UTF_8))), UTF_8);
    }

    /**
     * Obtains a new bearer token for service-to-service access using a service account.
     *
     * @param userId
     *            the service account user id
     * @param password
     *            the service account password
     * @return the bearer token for the service
     * @throws ClientException
     */
    private OauthBearerToken getBearerToken(final String userId, final String password) throws ClientException
    {

        // increment request counter

        final StringBuilder oauthBearerUrl = new StringBuilder();
        oauthBearerUrl.append(oauthInitClient.getCisHost());
        oauthBearerUrl.append(AvrilConsts.CONSTANT_SLASH);
        oauthBearerUrl.append(OauthConstants.OAUTH_GET_BEARER_TOKEN_PATH_1);
        oauthBearerUrl.append(OauthConstants.OAUTH_GET_BEARER_TOKEN_PATH_2);

        final CisServiceAccount clientServiceAccount = new CisServiceAccount(userId, password);

        final Map<String, Object> headers = new HashMap<String, Object>();
        HttpHeaders  httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-type", OauthConstants.APPLICATION_FORM_JSON);
        HttpEntity< String>entity = new HttpEntity<String>( gson.toJson(clientServiceAccount), httpHeaders);
        // Start the timing metric to calculate the total response time.
RestTemplate restTemplate = new RestTemplate();
final ResponseEntity<String> response = restTemplate.postForEntity(oauthBearerUrl.toString(), entity,String.class);
        // Start the timing metric to calculate the total response time.


        OauthBearerToken bearerToken = null;
        if (AvrilConsts.OAUTH_POST_RESPONSE_CODE == response.getStatusCode().value())
        {
            bearerToken = getBearerTokenResponse(response.getBody());
            // stop the timing metric
        }
        else
        {
           // LOG.error("Not able to fetch Bearer Token");
            throw new ClientException(response.getBody());
        }
        // add the success counter
        return bearerToken;
    }

    /**
     * Paser Json response for bearer token
     *
     * @param responseEntity
     * @return
     */
    private OauthBearerToken getBearerTokenResponse(final String responseEntity)
    {

        final OauthBearerToken oauthBearerToken = new OauthBearerToken();

        	JsonElement jelement = new com.google.gson.JsonParser().parse(responseEntity);
            JsonObject  jobject = jelement.getAsJsonObject();
            oauthBearerToken.setBearerToken(jobject.get(OauthConstants.CIS_BEARER_TOKEN).toString());


        return oauthBearerToken;
    }
    /**
     * Set header for access token generation.
     * @return 
     *
     * @return Map<String, Object>
     * @throws UnsupportedEncodingException
     */
    private  HttpHeaders getHeadersAcessToken() throws UnsupportedEncodingException
    {

        final String authorization = getAuthorization(oauthInitClient.getCisAdminClientId(), oauthInitClient.getCisAdminClientSecret());
        HttpHeaders  httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "Basic " + authorization);
        httpHeaders.add("accept", OauthConstants.APPLICATION_FORM_JSON);
        httpHeaders.add("Content-type", OauthConstants.APPLICATION_FORM_URLENCODED);
      
        return httpHeaders;
    }

    /**
     * Parse CIS token POST response to get Access token on the basis of BearerToken or
     * RefreshToken
     *
     * @param responseEntity
     *            Resposne entity of POST response
     * @param isBearerToken
     *            true: request for accesstoken with bearer token false: request for
     *            accesstoken with refresh token
     * @return
     */
    private OauthAccessToken getTokenResponse(final String responseEntity, final boolean isBearerToken)
    {

        final OauthAccessToken accessToken = new OauthAccessToken();

        	JsonElement jelement = new com.google.gson.JsonParser().parse(responseEntity);
            JsonObject  jsonBody = jelement.getAsJsonObject();
            accessToken.setAccountExpiration(Long.parseLong(jsonBody.get(OauthConstants.CIS_ACCESS_TOKEN_ACCOUNTEXPIRATION).toString()));
            accessToken.setExpiresIn(Long.parseLong(jsonBody.get(OauthConstants.CIS_ACCESS_TOKEN_EXPIRESIN).toString()));
            accessToken.setTokenType(jsonBody.get(OauthConstants.CIS_ACCESS_TOKEN_TYPE).toString());
            accessToken.setAccessToken(jsonBody.get(OauthConstants.CIS_ACCESS_TOKEN).toString());
            if (isBearerToken)
            {
                accessToken.setRefreshTokenExpiresIn(Long.parseLong(jsonBody.get(OauthConstants.CIS_REFRESH_TOKEN_EXPIRESIN).toString()));
                accessToken.setRefreshToken(jsonBody.get(OauthConstants.CIS_REFRESH_TOKEN).toString());
            }

        return accessToken;
    }

    /**
     * Obtains a new access token for the specified refresh token.
     *
     * @param refreshToken
     *            the refresh token returned from the authorization code exchange
     * @return the new access token
     * @throws ClientException
     *             In case of client exception
     * @throws UnsupportedEncodingException
     *             In case of encoding exception
     * @throws JSONException
     *             In case of JSON conversion
     * @throws UniformInterfaceException
     *             Uniform Interface Exception
     * @throws ClientHandlerException
     *             Client Handler Exception
     */
    public OauthAccessToken refreshAccessToken(final String refreshToken)
            throws ClientException, UnsupportedEncodingException, ClientHandlerException, UniformInterfaceException
    {

        // increment the request counter

        final StringBuilder oauthAccessUrl = new StringBuilder(oauthInitClient.getCisHost());
        oauthAccessUrl.append(AvrilConsts.CONSTANT_SLASH);
        oauthAccessUrl.append(OauthConstants.REFRESH_ACCESS_TOKEN_PATH);
      

        final StringBuilder encodedBody = new StringBuilder();
        String urlEncodedBody = null;
        try
        {
            urlEncodedBody = encodedBody.append("grant_type=").append(URLEncoder.encode(OauthConstants.OAUTH_REFRESH_GRANT_TYPE, UTF_8))
                    .append("&refresh_token=").append(refreshToken).toString();
        }
        catch (final UnsupportedEncodingException e)
        {
          //  LOG.error("Unsupported Encode" + e + e.getMessage());
            throw new UnsupportedEncodingException(e.getMessage());
        }
        HttpEntity< String>entity = new HttpEntity<String>(oauthAccessUrl.toString(), getHeadersAcessToken());
        // Start the timing metric to calculate the total response time.
RestTemplate restTemplate = new RestTemplate();
final ResponseEntity<String> response = restTemplate.postForEntity(oauthAccessUrl.toString(), entity,String.class);
        // Start the timing metric to calculate the total response time.

        OauthAccessToken accessToken = null;
        if (AvrilConsts.OAUTH_POST_RESPONSE_CODE == response.getStatusCode().value())
        {
            accessToken = getTokenResponse(response.getBody(),false);
            // stop the timing metric
        }
        else
        {
         //   LOG.error("Not able to fetch Access Token with provided Refresh token");
            throw new ClientException(response.getBody());
        }

        // add the success counter

        return accessToken;
    }

    /**
     * Validation of received parameters.
     *
     * @param serviceUserId
     *            the service account user id
     * @param serviceScretId
     *            the service account password
     * @param scope
     *            scope of API access
     * @return boolean value
     */
    private boolean validateParameters(final String serviceUserId, final String serviceScretId, final String scope)
    {

        Boolean isValid = false;
        try
        {
            checkNotNull(serviceUserId, "serviceAccountUserId");
            checkNotNull(serviceScretId, "serviceAccountPassword");
            checkNotNull(scope, "scope");
            isValid = true;
        }
        catch (final Exception exp)
        {
           // LOG.error("Null fields of service account, paasword or scope " + exp + exp.getMessage());
        }
        return isValid;
    }
}
