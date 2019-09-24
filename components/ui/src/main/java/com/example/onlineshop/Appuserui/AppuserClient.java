package com.example.onlineshop.Appuserui;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestOperations;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

public class AppuserClient
{

    private static ParameterizedTypeReference<List<AppuserClient>> appuserListType = new ParameterizedTypeReference<List<AppuserClient>>() {
    };
    private RestOperations restOperations;
    private String appuserurl;
    public AppuserClient(String appuserurl, RestOperations restOperations) {
        this.restOperations = restOperations;
        this.appuserurl = appuserurl;
    }

    public void create(AppuserClient appuser) {
        restOperations.postForEntity(appuserurl, appuser, AppuserClient.class);
    }

    public List<AppuserClient> getAll() {
        return restOperations.exchange(appuserurl, HttpMethod.GET, null, appuserListType).getBody();
    }

    public void delete(Long id) {
        String deleteURL = new StringBuilder(appuserurl).append("/").append(id).toString();
        restOperations.delete(deleteURL);
    }

    public int count(String field, String key) {
        String URI = UriComponentsBuilder.fromHttpUrl(appuserurl + "/count")
                .queryParam("field", field)
                .queryParam("key", key)
                .build().toUriString();
        return restOperations.getForEntity(URI, Integer.class).getBody();
    }

    public int countAll() {
        return restOperations.getForEntity(appuserurl + "/count", Integer.class).getBody();
    }

    public List<AppuserClient> findAll(int offset, int size) {
        String URI = UriComponentsBuilder.fromUriString(appuserurl)
                .queryParam("start", offset)
                .queryParam("pageSize", size)
                .toUriString();
        return restOperations.exchange(URI, HttpMethod.GET, null, appuserListType).getBody();
    }

    public List<AppuserClient> findRange(String field, String key, int offset, int size) {
        String URI = UriComponentsBuilder.fromUriString(appuserurl)
                .queryParam("field", field)
                .queryParam("key", key)
                .queryParam("start", offset)
                .queryParam("pageSize", size)
                .toUriString();
        return restOperations.exchange(URI, HttpMethod.GET, null, appuserListType).getBody();

    }
}


