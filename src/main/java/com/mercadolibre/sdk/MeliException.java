package com.mercadolibre.sdk;

public class MeliException extends Exception {

    private static final long serialVersionUID = 7263275678852231779L;

    public MeliException() {
        super();
    }

    public MeliException(Throwable cause) {
        super(cause);
    }

    public MeliException(final String message) {
        super(message);
    }

    public MeliException(final String message, Throwable cause) {
        super(message, cause);
    }
}
