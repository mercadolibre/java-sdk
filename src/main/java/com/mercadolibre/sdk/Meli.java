package com.mercadolibre.sdk;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.mercadolibre.sdk.dao.MeliHttpDao;
import com.mercadolibre.sdk.dao.impl.MeliHttpDaoImpl;
import com.mercadolibre.sdk.exception.AuthorizationFailure;
import com.mercadolibre.sdk.exception.MeliException;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.AsyncHttpClientConfig;
import com.ning.http.client.FluentStringsMap;
import com.ning.http.client.Response;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Meli {

    /**
     * Availables auth sites. One user - application can only operate in one site
     */

    public static enum AuthUrls {
        MLA("https://auth.mercadolibre.com.ar"), // Argentina
        MLB("https://auth.mercadolivre.com.br"), // Brasil
        MCO("https://auth.mercadolibre.com.co"), // Colombia
        MCR("https://auth.mercadolibre.com.cr"), // Costa Rica
        MEC("https://auth.mercadolibre.com.ec"), // Ecuador
        MLC("https://auth.mercadolibre.cl"), // Chile
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

    ;

    private String accessToken;
    private String refreshToken;
    private Long clientId;
    private String clientSecret;
    /**
     * news
     **/
    private Long expiresIn;
    private String scope;
    private String userId;
    private String tokenType;
    private MeliHttpDao meliHttpDao;


    {
        AsyncHttpClientConfig cf = new AsyncHttpClientConfig.Builder()
                .setUserAgent("MELI-JAVA-SDK-0.0.4").build();
        meliHttpDao = new MeliHttpDaoImpl(new AsyncHttpClient(cf));
    }

    public Meli(Long clientId, String clientSecret) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    public Meli(Long clientId, String clientSecret, String accessToken) {
        this.accessToken = accessToken;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    public Meli(Long clientId, String clientSecret, String accessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.refreshToken = refreshToken;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public String getRefreshToken() {
        return this.refreshToken;
    }

    /**
     * news
     **/
    public Long getExpiresIn() {
        return this.expiresIn;
    }

    public String getScope() {
        return this.scope;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getTokenType() {
        return this.tokenType;
    }

    public void setMeliHttpDao(MeliHttpDao meliHttpDao) {
        this.meliHttpDao = meliHttpDao;
    }

    public void refreshAccessToken() throws AuthorizationFailure {
        FluentStringsMap params = new FluentStringsMap();
        params.add("grant_type", "refresh_token");
        params.add("client_id", String.valueOf(this.clientId));
        params.add("client_secret", this.clientSecret);
        params.add("refresh_token", this.refreshToken);
        try {
            Response response = meliHttpDao.post("/oauth/token", params);
            parseToken(response);
        } catch (AuthorizationFailure e1) {
            System.out.println(e1.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * @param callback: The callback URL. Must be the applications redirect URI
     * @param authUrl:  The authorization URL. Get from Meli.AuthUrls
     * @return the authorization URL
     */
    public String getAuthUrl(String callback, AuthUrls authUrl) {
        try {
            return authUrl.getValue() + "/authorization?response_type=code&client_id="
                    + clientId
                    + "&redirect_uri="
                    + URLEncoder.encode(callback, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return authUrl + "/authorization?response_type=code&client_id="
                    + clientId + "&redirect_uri=" + callback;
        }
    }

    public void authorize(String code, String redirectUri) throws AuthorizationFailure, MeliException {
        FluentStringsMap params = new FluentStringsMap();

        params.add("grant_type", "authorization_code");
        params.add("client_id", String.valueOf(clientId));
        params.add("client_secret", clientSecret);
        params.add("code", code);
        params.add("redirect_uri", redirectUri);

        Response response = meliHttpDao.post("/oauth/token", params);

        parseToken(response);
    }

    public Response get(String path) throws MeliException {
        return meliHttpDao.get(path);
    }

    public Response get(String path, FluentStringsMap params) throws MeliException {
        return meliHttpDao.get(path, params);
    }

    public Response post(String path, FluentStringsMap params) throws MeliException {
        return meliHttpDao.post(path, params);
    }

    public Response post(String path, FluentStringsMap params, String body) throws MeliException {
        return meliHttpDao.post(path, params, body);
    }

    public Response put(String path, FluentStringsMap params, String body) throws MeliException {
        return meliHttpDao.put(path, params, body);
    }

    public Response delete(String path, FluentStringsMap params) throws MeliException {
        return meliHttpDao.delete(path, params);
    }

    private void parseToken(Response response) throws AuthorizationFailure {
        String responseBody;
        try {
            responseBody = response.getResponseBody();
        } catch (IOException e) {
            throw new AuthorizationFailure(e);
        }

        JsonParser p = new JsonParser();
        JsonObject object;

        try {
            object = p.parse(responseBody).getAsJsonObject();
        } catch (JsonSyntaxException e) {
            throw new AuthorizationFailure(responseBody);
        }

        if (response.getStatusCode() == 200) {

            this.accessToken = object.get("access_token").getAsString();

            JsonElement jsonElement = object.get("refresh_token");
            this.refreshToken = jsonElement != null ? object.get(
                    "refresh_token").getAsString() : null;
            /** News **/
            JsonElement jsonElementExpires = object.get("expires_in");
            this.expiresIn = jsonElementExpires != null ? Long.parseLong(object.get(
                    "expires_in").getAsString()) : null;

            JsonElement jsonElementScope = object.get("scope");
            this.scope = jsonElementScope != null ? object.get(
                    "scope").getAsString() : null;

            JsonElement jsonElementUserID = object.get("user_id");
            this.userId = jsonElementUserID != null ? object.get(
                    "user_id").getAsString() : null;

            JsonElement jsonElementToken = object.get("token_type");
            this.tokenType = jsonElementToken != null ? object.get(
                    "token_type").getAsString() : null;

        } else {
            throw new AuthorizationFailure(object.get("message").getAsString());
        }

    }

    private boolean hasRefreshToken() {
        return this.refreshToken != null && !this.refreshToken.isEmpty();
    }

}

