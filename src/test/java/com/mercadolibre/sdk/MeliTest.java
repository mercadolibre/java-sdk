package com.mercadolibre.sdk;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.FluentStringsMap;
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
    public void getAuthUrl_returnsAuthUrl() {
        Meli meli = new Meli(123456L, "client secret");

        String authUrl = meli.getAuthUrl("http://someurl.com", Meli.AuthUrls.MLA);

        assertEquals("https://auth.mercadolibre.com.ar/authorization?response_type=code&client_id=123456&redirect_uri=http%3A%2F%2Fsomeurl.com", authUrl);
    }

    @Test
    public void authorize_withValidCode_returnsAccessToken() throws AuthorizationFailure, IOException, ExecutionException, InterruptedException {
        String jsonResponse = getFileContent("authorization_success.json");
        int statusCode = 200;
        Meli.apiUrl = "https://api.mercadolibre.com";
        Meli meli = new Meli(123456l, "client secret");
        mockHttpPostRequestWithoutBody(meli, jsonResponse, statusCode);

        meli.authorize("valid code with refresh token", "http://someurl.com");

        assertEquals("APP_USR-6092-3246532-cb45c82853f6e620bb0deda096b128d3-8035443", meli.getAccessToken());
        assertEquals("TG-5005b6b3e4b07e60756a3353", meli.getRefreshToken());
    }

    @Test(expected = AuthorizationFailure.class)
    public void authorize_withInvalidCode_throwsAuthorizationFailureException() throws AuthorizationFailure, IOException, ExecutionException, InterruptedException {
        String jsonResponse = getFileContent("authorization_bad_request.json");
        int statusCode = 400;
        Meli.apiUrl = "https://api.mercadolibre.com";
        Meli meli = new Meli(1234561L, "client secret");
        mockHttpPostRequestWithoutBody(meli, jsonResponse, statusCode);

        meli.authorize("bad code", "http://someurl.com");
    }

    @Test
    public void get_withExistingEndpoint_returnsSuccessfulResponse() throws MeliException, IOException, ExecutionException, InterruptedException {
        String jsonResponse = getFileContent("get_sites_success.json");
        Meli.apiUrl = "https://api.mercadolibre.com";
        Meli meli = new Meli(1234561L, "client secret", "valid token");
        int statusCode = 200;
        mockHttpGetRequest(meli, jsonResponse, statusCode);

        Response response = meli.get("/sites");

        assertEquals(200, response.getStatusCode());
        assertEquals(jsonResponse, response.getResponseBody());
    }

    @Test
    public void post_withExistingEndpoint_returnsSuccessfulResponse() throws MeliException, IOException, ExecutionException, InterruptedException {
        String jsonResponse = getFileContent("post_item_success.json");
        Meli meli = new Meli(1234561L, "client secret", "valid token");
        FluentStringsMap params = new FluentStringsMap();
        params.add("access_token", meli.getAccessToken());
        int statusCode = 201;
        String body = "{\"foo\":\"bar\"}";
        mockHttpPostRequestWithBody(meli, jsonResponse, statusCode, body);

        Response response = meli.post("/items", params, body);

        assertEquals(201, response.getStatusCode());
        assertEquals(jsonResponse, response.getResponseBody());
    }

    @Test
    public void put_withExistingItem_returnsSuccessfulResponse() throws MeliException, InterruptedException, ExecutionException, IOException {
        int statusCode = 200;
        Meli meli = new Meli(1234561L, "client secret", "valid token");
        String body = "{\"tags\":[\"immediate_payment\"]}";

        mockHttpPutRequestWithBody(meli, "", statusCode, body);

        FluentStringsMap params = new FluentStringsMap();
        params.add("access_token", meli.getAccessToken());
            Response response = meli.put("/items/123", params, "{\"tags\":[\"immediate_payment\"]}");

        assertEquals(200, response.getStatusCode());
    }

    public void testDelete() throws MeliException {
        Meli m = new Meli(123456l, "client secret", "valid token");

        FluentStringsMap params = new FluentStringsMap();
        params.add("access_token", m.getAccessToken());
        Response r = m.delete("/items/123", params);

        assertEquals(200, r.getStatusCode());
    }

    private String getFileContent(String filename) throws IOException {
        InputStream inputStream = new FileInputStream("src/test/resources/api_responses/" + filename);
        return IOUtils.toString(inputStream, "UTF-8");
    }

    private void mockHttpPostRequestWithoutBody(Meli meli, String jsonResponse, int statusCode) throws IOException, ExecutionException, InterruptedException {
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

    private void mockHttpPostRequestWithBody(Meli meli, String jsonResponse, int statusCode, String body) throws IOException, ExecutionException, InterruptedException {
        Response responseMock = mock(Response.class);
        given(responseMock.getStatusCode()).willReturn(statusCode);
        given(responseMock.getResponseBody()).willReturn(jsonResponse);

        ListenableFuture listenableFutureMock = mock(ListenableFuture.class);
        given(listenableFutureMock.get()).willReturn(responseMock);

        AsyncHttpClient.BoundRequestBuilder boundRequestBuilderMock = mock(AsyncHttpClient.BoundRequestBuilder.class);
        given(boundRequestBuilderMock.addHeader(anyString(), anyString())).willReturn(boundRequestBuilderMock);
        given(boundRequestBuilderMock.setQueryParameters(any(FluentStringsMap.class))).willReturn(boundRequestBuilderMock);
        given(boundRequestBuilderMock.setHeader(anyString(), anyString())).willReturn(boundRequestBuilderMock);
        given(boundRequestBuilderMock.setBody(body)).willReturn(boundRequestBuilderMock);
        given(boundRequestBuilderMock.setBodyEncoding(anyString())).willReturn(boundRequestBuilderMock);
        given(boundRequestBuilderMock.execute()).willReturn(listenableFutureMock);

        AsyncHttpClient asyncHttpClientMock = mock(AsyncHttpClient.class);
        given(asyncHttpClientMock.preparePost(anyString())).willReturn(boundRequestBuilderMock);

        meli.setHttp(asyncHttpClientMock);
    }

    private void mockHttpGetRequest(Meli meli, String jsonResponse, int statusCode) throws IOException, ExecutionException, InterruptedException {
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
        given(asyncHttpClientMock.prepareGet(anyString())).willReturn(boundRequestBuilderMock);

        meli.setHttp(asyncHttpClientMock);
    }

    private void mockHttpPutRequestWithBody(Meli meli, String jsonResponse, int statusCode, String body) throws IOException, ExecutionException, InterruptedException {
        Response responseMock = mock(Response.class);
        given(responseMock.getStatusCode()).willReturn(statusCode);
        given(responseMock.getResponseBody()).willReturn(jsonResponse);

        ListenableFuture listenableFutureMock = mock(ListenableFuture.class);
        given(listenableFutureMock.get()).willReturn(responseMock);

        AsyncHttpClient.BoundRequestBuilder boundRequestBuilderMock = mock(AsyncHttpClient.BoundRequestBuilder.class);
        given(boundRequestBuilderMock.addHeader(anyString(), anyString())).willReturn(boundRequestBuilderMock);
        given(boundRequestBuilderMock.setQueryParameters(any(FluentStringsMap.class))).willReturn(boundRequestBuilderMock);
        given(boundRequestBuilderMock.setHeader(anyString(), anyString())).willReturn(boundRequestBuilderMock);
        given(boundRequestBuilderMock.setBody(body)).willReturn(boundRequestBuilderMock);
        given(boundRequestBuilderMock.setBodyEncoding(anyString())).willReturn(boundRequestBuilderMock);
        given(boundRequestBuilderMock.execute()).willReturn(listenableFutureMock);

        AsyncHttpClient asyncHttpClientMock = mock(AsyncHttpClient.class);
        given(asyncHttpClientMock.preparePut(anyString())).willReturn(boundRequestBuilderMock);

        meli.setHttp(asyncHttpClientMock);
    }

}