package com.anuj.security.app.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.anuj.security.app.domain.Guest;
import com.anuj.security.app.domain.GuestModel;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author Anuj Parmar
 */
@Service
public class GuestService {
    private static final String GUESTS = "/guests";
    private static final String SLASH = "/";

    @Value("${landon.guest.service.url}")
    private String guestServiceUrl;

    private final RestTemplate restTemplate;

    public GuestService(RestTemplate restTemplate){
        super();
        this.restTemplate = restTemplate;
    }

    public List<Guest> getAllGuests(){
        String url = guestServiceUrl + GUESTS;
        HttpEntity<String> request = new HttpEntity<>(null, null);
        return this.restTemplate.exchange(url, HttpMethod.GET, request, new ParameterizedTypeReference<List<Guest>>() { }).getBody();
    }

    public Guest addGuest(GuestModel guestModel){
        String url = guestServiceUrl + GUESTS;
        HttpEntity<GuestModel> request = new HttpEntity<>(guestModel, null);
        return this.restTemplate.exchange(url, HttpMethod.POST, request, Guest.class).getBody();
    }

    public Guest getGuest(long id) {
        String url = guestServiceUrl + GUESTS + SLASH + id;
        HttpEntity<String> request = new HttpEntity<>(null, null);
        return this.restTemplate.exchange(url, HttpMethod.GET, request, Guest.class).getBody();
    }

    public Guest updateGuest(long id, GuestModel guestModel) {
        System.out.println(guestModel);
        String url = guestServiceUrl + GUESTS + SLASH + id;
        HttpEntity<GuestModel> request = new HttpEntity<>(guestModel, null);
        return this.restTemplate.exchange(url, HttpMethod.PUT, request, Guest.class).getBody();
    }
}