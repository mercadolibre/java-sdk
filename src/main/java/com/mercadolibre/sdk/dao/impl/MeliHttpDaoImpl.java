package com.mercadolibre.sdk.dao.impl;

import com.mercadolibre.sdk.MeliException;
import com.mercadolibre.sdk.dao.MeliHttpDao;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.AsyncHttpClient.BoundRequestBuilder;
import com.ning.http.client.FluentStringsMap;
import com.ning.http.client.Response;

public class MeliHttpDaoImpl implements MeliHttpDao {

    public static String apiUrl = "https://api.mercadolibre.com";

    private AsyncHttpClient httpClient;

    public MeliHttpDaoImpl() {
    }

    public MeliHttpDaoImpl(AsyncHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public Response get(String path) throws MeliException {
        return get(path, new FluentStringsMap());
    }

    @Override
    public Response get(String path, FluentStringsMap params) throws MeliException {
        BoundRequestBuilder r = prepareGet(path, params);

        Response response;
        try {
            response = r.execute().get();
        } catch (Exception e) {
            throw new MeliException(e);
        }

        return response;
    }

    @Override
    public Response post(String path, FluentStringsMap params) throws MeliException {
        BoundRequestBuilder r = preparePost(path, params);

        Response response;
        try {
            response = r.execute().get();
        } catch (Exception e) {
            throw new MeliException(e);
        }

        return response;
    }

    @Override
    public Response post(String path, FluentStringsMap params, String body) throws MeliException {
        BoundRequestBuilder r = preparePost(path, params, body);

        Response response;
        try {
            response = r.execute().get();
        } catch (Exception e) {
            throw new MeliException(e);
        }

        return response;
    }

    @Override
    public Response put(String path, FluentStringsMap params, String body) throws MeliException {
        BoundRequestBuilder r = preparePut(path, params, body);

        Response response;
        try {
            response = r.execute().get();
        } catch (Exception e) {
            throw new MeliException(e);
        }

        return response;
    }

    @Override
    public Response delete(String path, FluentStringsMap params) throws MeliException {
        BoundRequestBuilder r = prepareDelete(path, params);

        Response response;
        try {
            response = r.execute().get();
        } catch (Exception e) {
            throw new MeliException(e);
        }

        return response;
    }

    private BoundRequestBuilder prepareGet(String path, FluentStringsMap params) {
        return httpClient.prepareGet(apiUrl + path)
                .addHeader("Accept", "application/json")
                .setQueryParameters(params);
    }


    private BoundRequestBuilder prepareDelete(String path,
                                              FluentStringsMap params) {
        return httpClient.prepareDelete(apiUrl + path)
                .addHeader("Accept", "application/json")
                .setQueryParameters(params);
    }

    private BoundRequestBuilder preparePost(String path,
                                            FluentStringsMap params, String body) {
        return httpClient.preparePost(apiUrl + path)
                .addHeader("Accept", "application/json")
                .setQueryParameters(params)
                .setHeader("Content-Type", "application/json")
                .setBody(body)
                .setBodyEncoding("UTF-8");
    }

    private BoundRequestBuilder preparePost(String path, FluentStringsMap params) {
        return httpClient.preparePost(apiUrl + path)
                .addHeader("Accept", "application/json")
                .setQueryParameters(params);
    }

    private BoundRequestBuilder preparePut(String path,
                                           FluentStringsMap params, String body) {
        return httpClient.preparePut(apiUrl + path)
                .addHeader("Accept", "application/json")
                .setQueryParameters(params)
                .setHeader("Content-Type", "application/json").setBody(body)
                .setBodyEncoding("UTF-8");
    }

    public void setHttpClient(AsyncHttpClient httpClient) {
        this.httpClient = httpClient;
    }

}
