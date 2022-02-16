package com.example.demo;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class Communication {

    HttpHeaders headers = new HttpHeaders();
    private final String URL = "http://91.241.64.178:7081/api/users";
    private final RestTemplate restTemplate;

    public Communication(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void showAllUsers() {
        ResponseEntity<List<User>> responseEntity =
                restTemplate.exchange(URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {
                });
        List<User> list = responseEntity.getBody();
        System.out.println(list);
    }

    public List getAllUsers() {
        ResponseEntity<List<User>> responseEntity =
                restTemplate.exchange(URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {
                });
        headers.add("Cookie", responseEntity.getHeaders().get(HttpHeaders.SET_COOKIE).toString());
        showAllUsers();
//        HEADER = responseEntity.getHeaders().get(HttpHeaders.SET_COOKIE)
        return responseEntity.getHeaders().get(HttpHeaders.SET_COOKIE);
    }

    public void addUser(User user) {
        ResponseEntity<String> responseEntity =
                restTemplate.postForEntity(URL, user, String.class, headers);
        System.out.println(responseEntity.getBody());
//        ResponseEntity<String> responseEntity =
//                restTemplate.postForEntity(URL, user, String.class, HttpMethod.POST );

    }

    public void editUser(User user) {

//        ResponseEntity<String> responseEntity =
//                restTemplate.exchange(URL, HttpMethod.PUT, user, String.class, headers);
//        System.out.println(responseEntity.getBody());
        restTemplate.put(URL, user, headers);
//        System.out.println(restTemplate);
    }

//    public void editUser(User user) {
//        ResponseEntity<String> responseEntity =
//                restTemplate.put(URL, user);
//        System.out.println(responseEntity.getBody());
////        return null;
//    }

    public void removeUser(Long id) {

    }
}