package com.mercadolibre.sdk;

import com.mercadolibre.sdk.dao.MeliHttpDao;
import com.mercadolibre.sdk.dao.impl.MeliHttpDaoImpl;
import com.mercadolibre.sdk.exception.AuthorizationFailure;
import com.mercadolibre.sdk.exception.MeliException;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.FluentStringsMap;
import com.ning.http.client.ListenableFuture;
import com.ning.http.client.Response;
import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;

public class MeliTest {

    private enum HttpMethod {
        GET, POST, PUT, DELETE
    }

    private Meli meli;
    private MeliHttpDao meliHttpDao;

    @Before
    public void setUp() {
        meli = new Meli(1234561L, "client secret", "valid token");
        meliHttpDao = new MeliHttpDaoImpl();
        meli.setMeliHttpDao(meliHttpDao);
    }

    @Test
    public void getAuthUrl_returnsAuthUrl() {
        String authUrl = meli.getAuthUrl("http://someurl.com", Meli.AuthUrls.MLA);

        assertEquals("https://auth.mercadolibre.com.ar/authorization?response_type=code&client_id=1234561&redirect_uri=http%3A%2F%2Fsomeurl.com", authUrl);
    }

    @Test
    public void authorize_withValidCode_returnsAccessToken() throws AuthorizationFailure, IOException, ExecutionException, InterruptedException, MeliException {
        String jsonResponse = getFileContent("authorization_success.json");
        int statusCode = 200;
        MeliHttpDaoImpl.apiUrl = "https://api.mercadolibre.com";
        mockHttpRequest(jsonResponse, statusCode, HttpMethod.POST, null);

        meli.authorize("valid code with refresh token", "http://someurl.com");

        assertEquals("APP_USR-6092-3246532-cb45c82853f6e620bb0deda096b128d3-8035443", meli.getAccessToken());
        assertEquals("TG-5005b6b3e4b07e60756a3353", meli.getRefreshToken());
    }

    @Test(expected = AuthorizationFailure.class)
    public void authorize_withInvalidCode_throwsAuthorizationFailureException() throws AuthorizationFailure, IOException, ExecutionException, InterruptedException, MeliException {
        String jsonResponse = getFileContent("authorization_bad_request.json");
        int statusCode = 400;
        MeliHttpDaoImpl.apiUrl = "https://api.mercadolibre.com";
        mockHttpRequest(jsonResponse, statusCode, HttpMethod.POST, null);

        meli.authorize("bad code", "http://someurl.com");
    }

    @Test
    public void get_withExistingEndpointAndNoParams_returnsSuccessfulResponse() throws MeliException, IOException, ExecutionException, InterruptedException {
        String jsonResponse = getFileContent("get_sites_success.json");
        MeliHttpDaoImpl.apiUrl = "https://api.mercadolibre.com";
        int statusCode = 200;
        mockHttpRequest(jsonResponse, statusCode, HttpMethod.GET, null);

        Response response = meli.get("/sites");

        assertEquals(200, response.getStatusCode());
        assertEquals(jsonResponse, response.getResponseBody());
    }

    @Test
    public void get_withExistingEndpointAndParams_returnsSuccessfulResponse() throws MeliException, IOException, ExecutionException, InterruptedException {
        String jsonResponse = getFileContent("get_custid_success.json");
        MeliHttpDaoImpl.apiUrl = "https://api.mercadolibre.com";
        int statusCode = 200;
        mockHttpRequest(jsonResponse, statusCode, HttpMethod.GET, null);
        FluentStringsMap params = new FluentStringsMap();
        params.add("access_token", meli.getAccessToken());

        Response response = meli.get("/sites", params);

        assertEquals(200, response.getStatusCode());
        assertEquals(jsonResponse, response.getResponseBody());
    }

    @Test
    public void post_withExistingEndpoint_returnsSuccessfulResponse() throws MeliException, IOException, ExecutionException, InterruptedException {
        String jsonResponse = getFileContent("post_item_success.json");
        FluentStringsMap params = new FluentStringsMap();
        params.add("access_token", meli.getAccessToken());
        int statusCode = 201;
        String body = "{\"foo\":\"bar\"}";
        mockHttpRequest(jsonResponse, statusCode, HttpMethod.POST, body);

        Response response = meli.post("/items", params, body);

        assertEquals(201, response.getStatusCode());
        assertEquals(jsonResponse, response.getResponseBody());
    }

    @Test
    public void put_withExistingItem_returnsSuccessfulResponse() throws MeliException, InterruptedException, ExecutionException, IOException {
        int statusCode = 200;
        String body = "{\"tags\":[\"immediate_payment\"]}";
        mockHttpRequest("", statusCode, HttpMethod.PUT, body);

        FluentStringsMap params = new FluentStringsMap();
        params.add("access_token", meli.getAccessToken());
        Response response = meli.put("/items/123", params, "{\"tags\":[\"immediate_payment\"]}");

        assertEquals(200, response.getStatusCode());
    }

    @Test
    public void delete_WithExistingItem_returnsSuccessfulResponse() throws MeliException, InterruptedException, ExecutionException, IOException {
        int statusCode = 200;
        FluentStringsMap params = new FluentStringsMap();
        params.add("access_token", meli.getAccessToken());
        mockHttpRequest("", statusCode, HttpMethod.DELETE, null);

        Response response = meli.delete("/items/123", params);

        assertEquals(200, response.getStatusCode());
    }

    private String getFileContent(String filename) throws IOException {
        InputStream inputStream = new FileInputStream("src/test/resources/api_responses/" + filename);
        return IOUtils.toString(inputStream, "UTF-8");
    }

    private void mockHttpRequest(String jsonResponse, int statusCode, HttpMethod httpMethod, String body) throws IOException, ExecutionException, InterruptedException {
        Response responseMock = mock(Response.class);
        given(responseMock.getStatusCode()).willReturn(statusCode);
        given(responseMock.getResponseBody()).willReturn(jsonResponse);

        ListenableFuture listenableFutureMock = mock(ListenableFuture.class);
        given(listenableFutureMock.get()).willReturn(responseMock);

        AsyncHttpClient.BoundRequestBuilder boundRequestBuilderMock = mock(AsyncHttpClient.BoundRequestBuilder.class);
        given(boundRequestBuilderMock.addHeader(anyString(), anyString())).willReturn(boundRequestBuilderMock);
        given(boundRequestBuilderMock.setQueryParameters(any(FluentStringsMap.class))).willReturn(boundRequestBuilderMock);

        if (body != null) {
            given(boundRequestBuilderMock.setHeader(anyString(), anyString())).willReturn(boundRequestBuilderMock);
            given(boundRequestBuilderMock.setBody(body)).willReturn(boundRequestBuilderMock);
            given(boundRequestBuilderMock.setBodyEncoding(anyString())).willReturn(boundRequestBuilderMock);
        }

        given(boundRequestBuilderMock.execute()).willReturn(listenableFutureMock);

        AsyncHttpClient asyncHttpClientMock = mock(AsyncHttpClient.class);
        switch (httpMethod) {
            case GET:
                given(asyncHttpClientMock.prepareGet(anyString())).willReturn(boundRequestBuilderMock);
                break;
            case POST:
                given(asyncHttpClientMock.preparePost(anyString())).willReturn(boundRequestBuilderMock);
                break;
            case PUT:
                given(asyncHttpClientMock.preparePut(anyString())).willReturn(boundRequestBuilderMock);
                break;
            case DELETE:
                given(asyncHttpClientMock.prepareDelete(anyString())).willReturn(boundRequestBuilderMock);
                break;
        }

        ((MeliHttpDaoImpl) meliHttpDao).setHttpClient(asyncHttpClientMock);
    }

}