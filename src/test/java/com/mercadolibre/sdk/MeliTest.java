package com.mercadolibre.sdk;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.FluentStringsMap;
import com.ning.http.client.HttpResponseStatus;
import com.ning.http.client.ListenableFuture;
import com.ning.http.client.Response;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;

public class MeliTest extends Assert {

    @Test
    public void testGetAuthUrl() {
        assertEquals(
                "https://auth.mercadolibre.com.ar/authorization?response_type=code&client_id=123456&redirect_uri=http%3A%2F%2Fsomeurl.com",
                new Meli(123456l, "client secret")
                        .getAuthUrl("http://someurl.com", Meli.AuthUrls.MLA));
    }

    @Test(expected = AuthorizationFailure.class)
    public void testAuthorizationFailure() throws AuthorizationFailure, IOException, ExecutionException, InterruptedException {
        String jsonResponse = getFileContent("src/test/resources/api_responses/authorization_bad_request.json");
        int statusCode = 400;
        Meli.apiUrl = "https://api.mercadolibre.com";
        Meli meli = new Meli(123456l, "client secret");
        mockHttpRequest(meli, jsonResponse, statusCode);

        meli.authorize("bad code", "http://someurl.com");
    }

    @Test
    public void testAuthorizationSuccess() throws AuthorizationFailure, IOException, ExecutionException, InterruptedException {
        String jsonResponse = getFileContent("src/test/resources/api_responses/authorization_success.json");
        int statusCode = 200;
        Meli.apiUrl = "https://api.mercadolibre.com";
        Meli meli = new Meli(123456l, "client secret");
        mockHttpRequest(meli, jsonResponse, statusCode);

        meli.authorize("valid code with refresh token", "http://someurl.com");

        assertEquals("APP_USR-6092-3246532-cb45c82853f6e620bb0deda096b128d3-8035443", meli.getAccessToken());
        assertEquals("TG-5005b6b3e4b07e60756a3353", meli.getRefreshToken());
    }

    @Test
    public void testGet() throws MeliException, IOException {
        Meli.apiUrl = "https://api.mercadolibre.com";
        Meli m = new Meli(123456l, "client secret", "valid token");

        Response response = m.get("/sites");

        assertEquals(200, response.getStatusCode());
        assertFalse(response.getResponseBody().isEmpty());
    }

    @Test
    public void testGetWithRefreshToken() throws MeliException, IOException {
        Meli.apiUrl = "https://api.mercadolibre.com";
        Meli m = new Meli(123456l, "client secret", "expired token",
                "valid refresh token");

        FluentStringsMap params = new FluentStringsMap();
        params.add("access_token", m.getAccessToken());
        Response response = m.get("/users/me", params);

        assertEquals(200, response.getStatusCode());
        assertFalse(response.getResponseBody().isEmpty());
    }

    @Test
    public void testErrorHandling() throws IOException, MeliException {
        Meli m = new Meli(123456l, "client secret", "invalid token");

        FluentStringsMap params = new FluentStringsMap();
        params.add("access_token", m.getAccessToken());
        Response response = m.get("/users/me", params);
        assertEquals(403, response.getStatusCode());
    }

    @Test
    public void testUserAgent() throws IOException, MeliException {
        Meli m = new Meli(123456l, "client secret", "invalid token");

        FluentStringsMap params = new FluentStringsMap();
        params.add("access_token", m.getAccessToken());
        Response response = m.get("/echo/user_agent", params);
        assertEquals(200, response.getStatusCode());
    }

    public void testPost() throws MeliException {
        Meli m = new Meli(123456l, "client secret", "valid token");

        FluentStringsMap params = new FluentStringsMap();
        params.add("access_token", m.getAccessToken());
        Response r = m.post("/items", params, "{\"foo\":\"bar\"}");

        assertEquals(201, r.getStatusCode());
    }

    public void testPostWithRefreshToken() throws MeliException {
        Meli m = new Meli(123456l, "client secret", "expired token",
                "valid refresh token");

        FluentStringsMap params = new FluentStringsMap();
        params.add("access_token", m.getAccessToken());
        Response r = m.post("/items", params, "{\"foo\":\"bar\"}");

        assertEquals(201, r.getStatusCode());
    }

    public void testPut() throws MeliException {
        Meli m = new Meli(123456l, "client secret", "valid token");

        FluentStringsMap params = new FluentStringsMap();
        params.add("access_token", m.getAccessToken());
        Response r = m.put("/items/123", params, "{\"foo\":\"bar\"}");

        assertEquals(200, r.getStatusCode());
    }

    public void testPutWithRefreshToken() throws MeliException {
        Meli m = new Meli(123456l, "client secret", "expired token",
                "valid refresh token");

        FluentStringsMap params = new FluentStringsMap();
        params.add("access_token", m.getAccessToken());
        Response r = m.put("/items/123", params, "{\"foo\":\"bar\"}");

        assertEquals(200, r.getStatusCode());
    }

    public void testDelete() throws MeliException {
        Meli m = new Meli(123456l, "client secret", "valid token");

        FluentStringsMap params = new FluentStringsMap();
        params.add("access_token", m.getAccessToken());
        Response r = m.delete("/items/123", params);

        assertEquals(200, r.getStatusCode());
    }

    public void testDeleteWithRefreshToken() throws MeliException {
        Meli m = new Meli(123456l, "client secret", "expired token",
                "valid refresh token");

        FluentStringsMap params = new FluentStringsMap();
        params.add("access_token", m.getAccessToken());
        Response r = m.delete("/items/123", params);

        assertEquals(200, r.getStatusCode());
    }

    private String getFileContent(String filePath) throws IOException {
        InputStream inputStream = new FileInputStream(filePath);
        return IOUtils.toString(inputStream, "UTF-8");
    }

    private void mockHttpRequest(Meli meli, String jsonResponse, int statusCode) throws IOException, ExecutionException, InterruptedException {
        Response responseMock = mock(Response.class);
        given(responseMock.getStatusCode()).willReturn(statusCode);
        given(responseMock.getResponseBody()).willReturn(jsonResponse);

        ListenableFuture listenableFutureMock = mock(ListenableFuture.class);
        given(listenableFutureMock.get()).willReturn(responseMock);

        AsyncHttpClient.BoundRequestBuilder boundRequestBuilderMock = mock(AsyncHttpClient.BoundRequestBuilder.class);
        given(boundRequestBuilderMock.addHeader(anyString(), anyString())).willReturn(boundRequestBuilderMock);
        given(boundRequestBuilderMock.setQueryParameters(any(FluentStringsMap.class))).willReturn(boundRequestBuilderMock);
        given(boundRequestBuilderMock.execute()).willReturn(listenableFutureMock);

        AsyncHttpClient asyncHttpClientMock = mock(AsyncHttpClient.class);
        given(asyncHttpClientMock.preparePost(anyString())).willReturn(boundRequestBuilderMock);

        meli.setHttp(asyncHttpClientMock);
    }

}