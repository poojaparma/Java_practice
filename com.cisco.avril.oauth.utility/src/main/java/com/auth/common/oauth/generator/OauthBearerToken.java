
package com.auth.common.oauth.generator;

import org.springframework.stereotype.Component;

//@Component
public class OauthBearerToken {
    String bearerToken;

    /**
     * @return : bearer token
     */
    public String getBearer() {
        return bearerToken;
    }

    /**
     * @param bearerToken
     */
    public void setBearerToken(final String bearerToken) {
        this.bearerToken = bearerToken;
    }
}
