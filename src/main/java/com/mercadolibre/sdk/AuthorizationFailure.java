package com.mercadolibre.sdk;

public class AuthorizationFailure extends Exception {
    private static final long serialVersionUID = 8688100047490895706L;

    public AuthorizationFailure(String message) {
	super(message);

    }     

    public AuthorizationFailure(Throwable cause) {
	super(cause);
    }
}
