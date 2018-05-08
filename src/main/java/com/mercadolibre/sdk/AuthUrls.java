package com.mercadolibre.sdk;

/**
 *	Availables auth sites. One user - application can only operate in one site
 *
 */
public enum AuthUrls {

    MLA("https://auth.mercadolibre.com.ar"), // Argentina
    MLB("https://auth.mercadolivre.com.br"), // Brasil
    MCO("https://auth.mercadolibre.com.co"), // Colombia
    MCR("https://auth.mercadolibre.com.cr"), // Costa Rica
    MEC("https://auth.mercadolibre.com.ec"), // Ecuador
    MLC("https://auth.mercadolibre.cl"),     // Chile
    MLM("https://auth.mercadolibre.com.mx"), // Mexico
    MLU("https://auth.mercadolibre.com.uy"), // Uruguay
    MLV("https://auth.mercadolibre.com.ve"), // Venezuela
    MPA("https://auth.mercadolibre.com.pa"), // Panama
    MPE("https://auth.mercadolibre.com.pe"), // Peru
    MPT("https://auth.mercadolibre.com.pt"), // Portugal
    MRD("https://auth.mercadolibre.com.do"); // Dominicana

    private String value;

    private AuthUrls(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
