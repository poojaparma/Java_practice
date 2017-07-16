
package com.auth.common.oauth.generator;

import org.springframework.stereotype.Component;

/**
 * @author suchandp
 */
//@Component
public final class OauthClientInitializer {

    private static OauthClientInitializer oauthClientInitializer = new OauthClientInitializer();

    private final String serviceAccountUserId;
    private final String serviceAccountPassword;
    private final String scope;
    private final String cisHost;
    private final String cisAdminClientId;

    private final String cisAdminClientSecret;

    // Initialize the oauth environment values
    private OauthClientInitializer()
    {


        this.serviceAccountUserId = "CiscoUCServiceAccount";
        this.serviceAccountPassword = "|%a{!5w%N6sG:>~2f5M66HgJ56uXewGU";
        this.scope = "Identity:SCIM ciscouc:admin";
        this.cisHost =  "https://idbroker.webex.com/idb";
        this.cisAdminClientId = "C92dbdaea22b13c5dc1bf9e98cc47e7a479434c31dc35d63550cc2e65970c8ee1";
        this.cisAdminClientSecret = "4c843925318c2cda2c06722a7fcba61857e3b8815197be007111a183ca0b4f88";
    }

    // method to restrict the creation of object
    public static OauthClientInitializer getInstance()
    {

        return oauthClientInitializer;
    }

    /**
     * @return the cisAdminClientId
     */
    public String getCisAdminClientId()
    {

        return cisAdminClientId;
    }

    /**
     * @return the cisAdminClientSecret
     */
    public String getCisAdminClientSecret()
    {

        return cisAdminClientSecret;
    }

    /**
     * @return the cisHost
     */
    public String getCisHost()
    {

        return cisHost;
    }

    /**
     * @return the scope
     */
    public String getScope()
    {

        return scope;
    }

    /**
     * @return the serviceAccountPassword
     */
    public String getServiceAccountPassword()
    {

        return serviceAccountPassword;
    }

    /**
     * @return the serviceAccountUserId
     */
    public String getServiceAccountUserId()
    {

        return serviceAccountUserId;
    }

}
