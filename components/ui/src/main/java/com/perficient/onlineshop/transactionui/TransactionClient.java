package com.perficient.onlineshop.transactionui;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestOperations;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

public class TransactionClient {
    private static ParameterizedTypeReference<List<TransactionUI>> transactionListType = new ParameterizedTypeReference<List<TransactionUI>>() {};
    private String transactionURL;
    private RestOperations restOperations;


    public TransactionClient(String transactionURL, RestOperations restOperations) {
        this.transactionURL = transactionURL;
        this.restOperations = restOperations;
    }

    public void create(TransactionUI transactionUI) {
        restOperations.postForEntity(transactionURL, transactionUI, TransactionUI.class);
    }

    public List<TransactionUI> getAll() {
        return restOperations.exchange(transactionURL, HttpMethod.GET, null, transactionListType).getBody();
    }

    public void delete(Long id) {
        String deleteURL = new StringBuilder(transactionURL).append("/").append(id).toString();
        restOperations.delete(deleteURL);
    }

    public int countAll() {
        return restOperations.getForEntity(transactionURL + "/count", Integer.class).getBody();
    }

    public List<TransactionUI> findAll() {
        String URI = UriComponentsBuilder.fromUriString(transactionURL).toUriString();
        return restOperations.exchange(URI, HttpMethod.GET, null, transactionListType).getBody();
    }

    public List<TransactionUI> findRange(String field, String key) {
        String URI = UriComponentsBuilder.fromUriString(transactionURL)
                .queryParam("field", field)
                .queryParam("key", key)
                .toUriString();
        return restOperations.exchange(URI, HttpMethod.GET, null, transactionListType).getBody();
    }
}


