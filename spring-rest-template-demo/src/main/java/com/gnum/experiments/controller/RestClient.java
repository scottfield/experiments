package com.gnum.experiments.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jackie
 * @date 2015/10/12
 */
public abstract class RestClient {
    private static final RestTemplate restTemplate = new RestTemplate();
    private static final Map<String, String> defaultHttpHeaders = new HashMap<String, String>();

    static {
        defaultHttpHeaders.put("api", "test");
    }

    public static <T> T get(String url, Class<T> responseType, HttpHeaders headers, Object... urlVariables) {
        T response = restTemplate.getForObject(url, responseType, urlVariables);
        return response;
    }

    public static <T> T post(String url, Class<T> responseType, Map<String, String> headers, MultiValueMap<String, Object> request, Object... urlVariables) {
        HttpEntity httpEntity = getHttpEntity(headers, request);
        T response = restTemplate.postForObject(url, httpEntity, responseType, urlVariables);
        return response;
    }

    private static HttpEntity getHttpEntity(Map<String, String> headers, MultiValueMap<String, ?> request) {
        HttpHeaders httpHeaders = new HttpHeaders();
        addDefaultHeaders(defaultHttpHeaders, httpHeaders);
        addHeaders(headers, httpHeaders);
        return new HttpEntity(request, httpHeaders);
    }

    private static void addHeaders(Map<String, String> headers, HttpHeaders httpHeaders) {
        if (headers != null && headers.size() > 0) {
            for (String key : headers.keySet()) {
                httpHeaders.add(key, headers.get(key));
            }
        }
    }

    private static void addDefaultHeaders(Map<String, String> headers, HttpHeaders httpHeaders) {
        addHeaders(headers, httpHeaders);
    }

    public static void configureDefaultHttpHeaders(Map<String, String> headers) {
        defaultHttpHeaders.putAll(headers);
    }

    public static <T> T put(String url, Class<T> responseType, Map<String, String> headers, MultiValueMap<String,Object> request, Object... urlVariables) {
        request.add("dfad","PUT");
        HttpEntity httpEntity = getHttpEntity(headers, request);
        T response = restTemplate.postForObject(url, httpEntity, responseType, urlVariables);
        return response;
    }

    public static <T> T delete(String url, Class<T> responseType, Map<String, String> headers, MultiValueMap<String, ?> request, Object... urlVariables) {
        HttpEntity httpEntity = getHttpEntity(headers, request);
        T response = restTemplate.postForObject(url, httpEntity, responseType, urlVariables);
        return response;
    }
}
