package com.mercadolibre.sdk;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.concurrent.ExecutionException;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.ning.http.client.*;
import com.ning.http.client.AsyncHttpClient.BoundRequestBuilder;

import static com.mercadolibre.sdk.Constants.*;
import static com.mercadolibre.sdk.Constants.Http.*;
import static com.mercadolibre.sdk.Constants.Misc.UTF_8;

public class Meli {
    
	public static String apiUrl = "https://api.mercadolibre.com";

    private String accessToken;
    private String refreshToken;
    private Long clientId;
    private String clientSecret;
    private AsyncHttpClient http;
    /** news **/
    private Long   expiresIn;
    private String scope;
    private String userId;
    private String tokenType;

    public Meli(final Long clientId, final String clientSecret) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;

        initializeAsyncHttpClient();
    }

    public Meli(final Long clientId, final String clientSecret, final String accessToken) {
        this(clientId, clientSecret);
        this.accessToken = accessToken;
    }

    public Meli(final Long clientId, final String clientSecret, final String accessToken, final String refreshToken) {
        this(clientId, clientSecret, accessToken);
        this.refreshToken = refreshToken;
    }

    public Response get(final String path) throws MeliException {
        return get(path, new FluentStringsMap());
    }

    public Response get(final String path, FluentStringsMap params) throws MeliException {
        BoundRequestBuilder r = prepareGet(path, params);
        return executeHttpRequest(r);
    }

    public Response post(final String path, FluentStringsMap params, final String body) throws MeliException {
        BoundRequestBuilder r = preparePost(path, params, body);
        return executeHttpRequest(r);
    }

    public Response put(final String path, FluentStringsMap params, final String body) throws MeliException {
        BoundRequestBuilder r = preparePut(path, params, body);
        return executeHttpRequest(r);
    }

    public Response delete(final String path, FluentStringsMap params) throws MeliException {
        BoundRequestBuilder r = prepareDelete(path, params);
        return executeHttpRequest(r);
    }

    public void refreshAccessToken() throws AuthorizationFailureException {
        FluentStringsMap params = new FluentStringsMap();
        params.add(GRANT_TYPE, REFRESH_TOKEN);
        params.add(CLIENT_ID, String.valueOf(this.clientId));
        params.add(CLIENT_SECRET, this.clientSecret);
        params.add(REFRESH_TOKEN, this.refreshToken);

        BoundRequestBuilder req = preparePost("/oauth/token", params);
        parseToken(req);
    }

    /**
     *
     * @param callback: The callback URL. Must be the applications redirect URI
     * @param authUrl: The authorization URL. Get from Meli.AuthUrls
     * @return the authorization URL
     */
    public String getAuthUrl(final String callback, AuthUrls authUrl) {
        try {
            return authUrl.getValue() + "/authorization?response_type=code&client_id="
                    + clientId
                    + "&redirect_uri="
                    + URLEncoder.encode(callback, UTF_8);
        } catch (UnsupportedEncodingException e) {
            return authUrl+"/authorization?response_type=code&client_id="
                    + clientId + "&redirect_uri=" + callback;
        }
    }

    public void authorize(final String code, final String redirectUri) throws AuthorizationFailureException {
        FluentStringsMap params = new FluentStringsMap();
        params.add(GRANT_TYPE, "authorization_code");
        params.add(CLIENT_ID, String.valueOf(clientId));
        params.add(CLIENT_SECRET, clientSecret);
        params.add(CODE, code);
        params.add(REDIRECT_URI, redirectUri);

        BoundRequestBuilder r = preparePost("/oauth/token", params);
        parseToken(r);
    }

    private void parseToken(BoundRequestBuilder r) throws AuthorizationFailureException {
        Response response;
        String responseBody;

        try {
            response = r.execute().get();
            responseBody = response.getResponseBody();

        } catch (InterruptedException e) {
            throw new AuthorizationFailureException(e);
        } catch (ExecutionException e) {
            throw new AuthorizationFailureException(e);
        } catch (IOException e) {
            throw new AuthorizationFailureException(e);
        }

        JsonParser p = new JsonParser();
        JsonObject object;

        try {
            object = p.parse(responseBody).getAsJsonObject();

        } catch (JsonSyntaxException e) {
            throw new AuthorizationFailureException(responseBody);
        }

        if (response.getStatusCode() == HTTP_STATUS_OK) {

            this.accessToken = object.get(ACCESS_TOKEN).getAsString();
            this.refreshToken = getFromJson(object, REFRESH_TOKEN);
            /** News **/
            this.expiresIn = Long.parseLong(getFromJson(object, EXPIRES_IN));
            this.scope = getFromJson(object, SCOPE);
            this.userId = getFromJson(object, USER_ID);
            this.tokenType = getFromJson(object, TOKEN_TYPE);

        } else {
            throw new AuthorizationFailureException(object.get("message").getAsString());
        }
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public String getRefreshToken() {
        return this.refreshToken;
    }
    /** news **/
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

    private void initializeAsyncHttpClient() {
        AsyncHttpClientConfig cf = new AsyncHttpClientConfig.Builder().setUserAgent("MELI-JAVA-SDK-0.0.4").build();
        this.http = new AsyncHttpClient(cf);
    }

    private BoundRequestBuilder prepareGet(final String path, FluentStringsMap params) {
        return http.prepareGet(apiUrl + path)
                .addHeader(HEADER_ACCEPT, APPLICATION_JSON)
                .setQueryParameters(params);
    }


    private BoundRequestBuilder prepareDelete(final String path, FluentStringsMap params) {
        return http.prepareDelete(apiUrl + path)
                .addHeader(HEADER_ACCEPT, APPLICATION_JSON)
                .setQueryParameters(params);
    }

    private BoundRequestBuilder preparePost(final String path, FluentStringsMap params) {
        return http.preparePost(apiUrl + path)
                .addHeader(HEADER_ACCEPT, APPLICATION_JSON)
                .setQueryParameters(params);
    }

    private BoundRequestBuilder preparePost(final String path, FluentStringsMap params, final String body) {
        return http.preparePost(apiUrl + path)
                .addHeader(HEADER_ACCEPT, APPLICATION_JSON)
                .setQueryParameters(params)
                .setHeader(HEADER_CONTENT_TYPE, APPLICATION_JSON).setBody(body)
                .setBodyEncoding(UTF_8);
    }

    private BoundRequestBuilder preparePut(final String path, FluentStringsMap params, final String body) {
        return http.preparePut(apiUrl + path)
                .addHeader(HEADER_ACCEPT, APPLICATION_JSON)
                .setQueryParameters(params)
                .setHeader(HEADER_CONTENT_TYPE, APPLICATION_JSON).setBody(body)
                .setBodyEncoding(UTF_8);
    }

    private String getFromJson(JsonObject jsonObject, final String key) {
        JsonElement jsonElement = jsonObject.get(key);
        return jsonElement != null ? jsonElement.getAsString() : null;
    }

    private Response executeHttpRequest(BoundRequestBuilder r) throws MeliException {
        Response response;

        try {
            response = r.execute().get();

        } catch (Exception e) {
            throw new MeliException(e);
        }

        return response;
    }
}

