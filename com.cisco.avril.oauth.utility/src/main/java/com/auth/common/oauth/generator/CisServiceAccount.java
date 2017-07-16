
package com.auth.common.oauth.generator;

import org.springframework.stereotype.Component;

/*
 * @author suchandp
 *
 */
//@Component
public class CisServiceAccount {
    String uid;
    String password;

    public CisServiceAccount() {
    }

    public CisServiceAccount(final String uid, final String password) {
        this.uid = uid;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getUid() {
        return uid;
    }

}
