
package com.auth.common.oauth.generator;

import org.apache.commons.httpclient.HttpStatus;
import org.springframework.stereotype.Component;


/**
 * RuntimeException handler class
 * 
 * @author suchandp
 *
 */
//@Component
public class ClientException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private final int statusCode;

    public ClientException(final int statusCode, final String message) {
        this(statusCode, message, null);
    }

    public ClientException(final int statusCode, final String message, final Throwable e) {
        super(message, e);
        this.statusCode = statusCode;
    }

    public ClientException(final String message) {
        this(message, null);
    }

    public ClientException(final String message, final Throwable e) {
        this(0, message, e);
    }

    public boolean isClientError() {
        return isHttpError() && !isServerError();
    }

    public boolean isHttpError() {
        return statusCode >= HttpStatus.SC_BAD_REQUEST;
    }

    public boolean isServerError() {
        return statusCode >= HttpStatus.SC_INTERNAL_SERVER_ERROR;
    }

}