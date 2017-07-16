
package com.auth.common.oauth.generator;

/**
 * @author suchandp
 */
public class OauthConstants {
    
    public static final String OAUTH_GRANT_TYPE = "urn:ietf:params:oauth:grant-type:saml2-bearer";
    public static final String OAUTH_REFRESH_GRANT_TYPE = "refresh_token";
    public static final String OAUTH_GET_BEARER_TOKEN_PATH_1 = "token/";
    public static final String OAUTH_GET_BEARER_TOKEN_PATH_2 = "v2/actions/GetBearerToken/invoke";
    public static final String ACCESS_TOKEN_PATH = "oauth2/v1/access_token";
    public static final String REFRESH_ACCESS_TOKEN_PATH = "oauth2/v1/access_token";
    public static final String APPLICATION_FORM_URLENCODED = "application/x-www-form-urlencoded";
    public static final String APPLICATION_FORM_JSON = "application/json";
    public static final String ACCESS_TOKEN_STRING = "AccessToken";
    public static final String REFRESH_TOKEN_STRING = "RefreshToken";
    public static final String CACHE = "Cache";
    public static final String CIS_BEARER_TOKEN_GET_REQUEST_TIMING_METRIC = "cis_bearer_token_get_request_timing_metric";
    public static final String CIS_BEARER_TOKEN_GET_REQUEST = "cis_bearer_token_get_request";
    public static final String CIS_BEARER_TOKEN_GET_REQUEST_SUCCESS = "cis_bearer_token_get_request_success";
    public static final String CIS_ACCESS_TOKEN_GET_REQUEST = "cis_access_token_get_request";
    public static final String CIS_ACCESS_TOKEN_GET_REQUEST_SUCCESS = "cis_access_token_get_request_success";
    public static final String CIS_ACCESS_TOKEN_GET_REQUEST_TIMING_METRIC = "cis_access_token_get_request_timing_metric";
    public static final String CIS_REFRESH_TOKEN_GET_REQUEST = "cis_refresh_token_get_request";
    public static final String CIS_REFRESH_TOKEN_GET_REQUEST_SUCCESS = "cis_refresh_token_get_request_success";
    public static final String CIS_REFRESH_TOKEN_GET_REQUEST_TIMING_METRIC = "cis_refresh_token_get_request_timing_metric";
    public static final String CIS_ACCESS_TOKEN_ACCOUNTEXPIRATION = "accountExpiration";
    public static final String CIS_ACCESS_TOKEN_EXPIRESIN = "expires_in";
    public static final String CIS_ACCESS_TOKEN_TYPE = "token_type";
    public static final String CIS_ACCESS_TOKEN = "access_token";
    public static final String CIS_REFRESH_TOKEN_EXPIRESIN = "refresh_token_expires_in";
    public static final String CIS_REFRESH_TOKEN = "refresh_token";
    public static final String CIS_BEARER_TOKEN = "BearerToken";
    
    /**
     * Creating Default private constructor of class,to avoid object creation,as all
     * members are static.
     */
    private OauthConstants()
    {
    
    }
}
