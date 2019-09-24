package com.perficient.onlineshop.appuserui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestOperations;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

public class AppUserClient {
    private static ParameterizedTypeReference<List<AppUserUI>> appUserListType = new ParameterizedTypeReference<List<AppUserUI>>() {};
    private String appUserURL;
    private RestOperations restOperations;


    public AppUserClient(String appUserURL, RestOperations restOperations) {
        this.appUserURL = appUserURL;
        this.restOperations = restOperations;
    }

    public void create(AppUserUI appUserUI) {
        restOperations.postForEntity(appUserURL, appUserUI, AppUserUI.class);
    }

    public List<AppUserUI> getAll() {
        return restOperations.exchange(appUserURL, HttpMethod.GET, null, appUserListType).getBody();
    }

    public void delete(Long id) {
        String deleteURL = new StringBuilder(appUserURL).append("/").append(id).toString();
        restOperations.delete(deleteURL);
    }

    public int countAll() {
        return restOperations.getForEntity(appUserURL + "/count", Integer.class).getBody();
    }

    public List<AppUserUI> findAll() {
        String URI = UriComponentsBuilder.fromUriString(appUserURL).toUriString();
        return restOperations.exchange(URI, HttpMethod.GET, null, appUserListType).getBody();
    }

    public List<AppUserUI> findRange(String field, String key) {
        String URI = UriComponentsBuilder.fromUriString(appUserURL)
                .queryParam("field", field)
                .queryParam("key", key)
                .toUriString();
        return restOperations.exchange(URI, HttpMethod.GET, null, appUserListType).getBody();
    }
}


