package com.mercadolibre.sdk;

public class AuthorizationFailureException extends Exception {

    private static final long serialVersionUID = 8688100047490895706L;

    public AuthorizationFailureException() {
        super();
    }

    public AuthorizationFailureException(final String message) {
	    super(message);
    }     

    public AuthorizationFailureException(Throwable cause) {
        super(cause);
    }

    public AuthorizationFailureException(final String message, Throwable cause) {
        super(message, cause);
    }
}
