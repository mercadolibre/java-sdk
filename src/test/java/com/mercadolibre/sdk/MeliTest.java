package com.mercadolibre.sdk;

import java.io.IOException;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ning.http.client.FluentStringsMap;
import com.ning.http.client.Response;

public class MeliTest extends Assert {

    @BeforeClass
    public static void setupClass() {
        Meli.apiUrl = "http://localhost:3000";
    }

    @Test
    public void testGetAuthUrl() {
        assertEquals(
                "https://auth.mercadolibre.com.ar/authorization?response_type=code&client_id=123456&redirect_uri=http%3A%2F%2Fsomeurl.com",
                new Meli(123456L, "client secret")
                        .getAuthUrl("http://someurl.com", AuthUrls.MLA));
    }

    @Test(expected = AuthorizationFailureException.class)
    public void testAuthorizationFailure() throws AuthorizationFailureException {
        new Meli(123456L, "client secret").authorize("bad code",
                "http://someurl.com");
    }

    @Test
    public void testAuthorizationSuccess() throws AuthorizationFailureException {
        Meli m = new Meli(123456L, "client secret");
        m.authorize("valid code with refresh token", "http://someurl.com");

        assertEquals("valid token", m.getAccessToken());
        assertEquals("valid refresh token", m.getRefreshToken());
    }

    @Test
    public void testGet() throws MeliException, IOException {
        Meli m = new Meli(123456L, "client secret", "valid token");

        Response response = m.get("/sites");

        assertEquals(200, response.getStatusCode());
        assertFalse(response.getResponseBody().isEmpty());
    }

    @Test
    public void testGetWithRefreshToken() throws MeliException, IOException {
        Meli m = new Meli(123456L, "client secret", "expired token",
                "valid refresh token");

        FluentStringsMap params = new FluentStringsMap();
        params.add("access_token", m.getAccessToken());
        Response response = m.get("/users/me", params);

        assertEquals(404, response.getStatusCode());
        assertFalse(response.getResponseBody().isEmpty());
    }

    @Test
    public void testErrorHandling() throws MeliException {
        Meli m = new Meli(123456L, "client secret", "invalid token");

        FluentStringsMap params = new FluentStringsMap();
        params.add("access_token", m.getAccessToken());
        Response response = m.get("/users/me", params);
        assertEquals(403, response.getStatusCode());
    }

    @Test
    public void testUserAgent() throws MeliException {
        Meli m = new Meli(123456L, "client secret", "invalid token");

        FluentStringsMap params = new FluentStringsMap();
        params.add("access_token", m.getAccessToken());
        Response response = m.get("/echo/user_agent", params);
        assertEquals(200, response.getStatusCode());
    }

    public void testPost() throws MeliException {
        Meli m = new Meli(123456L, "client secret", "valid token");

        FluentStringsMap params = new FluentStringsMap();
        params.add("access_token", m.getAccessToken());
        Response r = m.post("/items", params, "{\"foo\":\"bar\"}");

        assertEquals(201, r.getStatusCode());
    }

    public void testPostWithRefreshToken() throws MeliException {
        Meli m = new Meli(123456L, "client secret", "expired token",
                "valid refresh token");

        FluentStringsMap params = new FluentStringsMap();
        params.add("access_token", m.getAccessToken());
        Response r = m.post("/items", params, "{\"foo\":\"bar\"}");

        assertEquals(201, r.getStatusCode());
    }

    public void testPut() throws MeliException {
        Meli m = new Meli(123456L, "client secret", "valid token");

        FluentStringsMap params = new FluentStringsMap();
        params.add("access_token", m.getAccessToken());
        Response r = m.put("/items/123", params, "{\"foo\":\"bar\"}");

        assertEquals(200, r.getStatusCode());
    }

    public void testPutWithRefreshToken() throws MeliException {
        Meli m = new Meli(123456L, "client secret", "expired token",
                "valid refresh token");

        FluentStringsMap params = new FluentStringsMap();
        params.add("access_token", m.getAccessToken());
        Response r = m.put("/items/123", params, "{\"foo\":\"bar\"}");

        assertEquals(200, r.getStatusCode());
    }

    public void testDelete() throws MeliException {
        Meli m = new Meli(123456L, "client secret", "valid token");

        FluentStringsMap params = new FluentStringsMap();
        params.add("access_token", m.getAccessToken());
        Response r = m.delete("/items/123", params);

        assertEquals(200, r.getStatusCode());
    }

    public void testDeleteWithRefreshToken() throws MeliException {
        Meli m = new Meli(123456L, "client secret", "expired token",
                "valid refresh token");

        FluentStringsMap params = new FluentStringsMap();
        params.add("access_token", m.getAccessToken());
        Response r = m.delete("/items/123", params);

        assertEquals(200, r.getStatusCode());
    }
}