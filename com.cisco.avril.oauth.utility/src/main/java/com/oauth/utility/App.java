package com.oauth.utility;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.auth.common.oauth.generator.ClientAuthorizationProvider;

/**
 * Hello world!
 *
 */
@RestController

public class App 
 {
	@RequestMapping(value="/get", method = RequestMethod.GET)
	//@ExceptionHandler(CustomerNotFoundException.class)
    public String getAuthToken() {
    
        String authToken = null;
        try {
            final ClientAuthorizationProvider client = ClientAuthorizationProvider.getInstance();
            authToken = client.getAccessToken();
            System.out.println("print: " + authToken);
        } catch (Exception e) {
            System.out.println("not loaded");
        }
        return authToken;
    }
}