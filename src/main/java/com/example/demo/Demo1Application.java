package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import javax.print.attribute.standard.Media;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Demo1Application {

    RestTemplate restTemplate = new RestTemplate();
    private static final String URL = "http://91.241.64.178:7081/api/users";

    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);

        User user1 = new User(3L, "James", "Brown", (byte) 15);
        User user2 = new User(3L, "Thomas", "Shelby", (byte) 15);


        Communication communication = new Communication(new RestTemplate());
        communication.getAllUsers();
        communication.addUser(user1);
        communication.editUser(user2);
        communication.deleteUser(3L);
    }

}


