package com.mercadolibre.sdk.dao;

import com.mercadolibre.sdk.exception.MeliException;
import com.ning.http.client.FluentStringsMap;
import com.ning.http.client.Response;

public interface MeliHttpDao {

    Response get(String path) throws MeliException;

    Response get(String path, FluentStringsMap params) throws MeliException;

    Response post(String path, FluentStringsMap params) throws MeliException;

    Response post(String path, FluentStringsMap params, String body) throws MeliException;

    Response put(String path, FluentStringsMap params, String body) throws MeliException;

    Response delete(String path, FluentStringsMap params) throws MeliException;

}
