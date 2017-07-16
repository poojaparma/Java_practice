
package com.auth.common.oauth.generator;

import org.springframework.stereotype.Component;

/**
 * @author suchandp
 *
 */
//@Component
public class OauthAccessToken {
    Long accountExpiration;

    Long expiresIn;

    String tokenType;

    String refreshToken;

    Long refreshTokenExpiresIn;

    String accessToken;

    /**
     * @return : access token
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * @return account expiration time
     */
    public Long getAccountExpiration() {
        return accountExpiration;
    }

    /**
     * @return : expiration time
     */
    public Long getExpiresIn() {
        return expiresIn;
    }

    /**
     * @return : refresh token
     */
    public String getRefreshToken() {
        return refreshToken;
    }

    /**
     * @return : refresh token expire time
     */
    public Long getRefreshTokenExpiresIn() {
        return refreshTokenExpiresIn;
    }

    /**
     * @return : token type
     */
    public String getTokenType() {
        return tokenType;
    }

    /**
     * @param accessToken
     */
    public void setAccessToken(final String accessToken) {
        this.accessToken = accessToken;
    }

    /**
     * @param accountExpiration
     */
    public void setAccountExpiration(final Long accountExpiration) {
        this.accountExpiration = accountExpiration;
    }

    /**
     * @param expiresIn
     */
    public void setExpiresIn(final Long expiresIn) {
        this.expiresIn = expiresIn;
    }

    /**
     * @param refresToken
     */
    public void setRefreshToken(final String refresToken) {
        this.refreshToken = refresToken;
    }

    /**
     * @param refreshTokenExpiresIn
     */
    public void setRefreshTokenExpiresIn(final Long refreshTokenExpiresIn) {
        this.refreshTokenExpiresIn = refreshTokenExpiresIn;
    }

    /**
     * @param tokenType
     */
    public void setTokenType(final String tokenType) {
        this.tokenType = tokenType;
    }

}
