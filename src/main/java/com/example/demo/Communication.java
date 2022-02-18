package com.example.demo;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Communication {

    private static HttpHeaders headers = new HttpHeaders();
    private final String URL = "http://91.241.64.178:7081/api/users";
    RestTemplate restTemplate = new RestTemplate();
    List<String> cookies;

    public Communication(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void getAllUsers() {
        ResponseEntity<List<User>> responseEntity =
                restTemplate.exchange(URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {
                });
        ResponseEntity<String> entity = restTemplate.getForEntity(URL, String.class);
        entity.getHeaders().get("Set-Cookie").stream().forEach(System.out::println);
        cookies = responseEntity.getHeaders().get(HttpHeaders.SET_COOKIE);
        System.out.println(responseEntity.getBody().toString());

    }

    public void addUser(User user) {
        RestTemplate restTemplate = new RestTemplate();
        headers.set("Cookie",cookies.stream().collect(Collectors.joining(";")));
        HttpEntity<User> entity = new HttpEntity<>(user, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(URL, HttpMethod.POST, entity, String.class, user);
        System.out.println(responseEntity.getBody());
    }

    public void editUser(User user) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<User> entity = new HttpEntity<>(user, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(URL, HttpMethod.PUT, entity, String.class, user);
        System.out.println(responseEntity.getBody());

    }

    public void deleteUser(Long id) {

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<User> entity = new HttpEntity<>(headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(URL + "/" + id, HttpMethod.DELETE, entity, String.class);
        System.out.println(responseEntity.getBody());
    }
}