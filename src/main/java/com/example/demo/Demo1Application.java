package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
public class Demo1Application {
//    private final Communication communication;
//
//    public Demo1Application(Communication communication) {
//        this.communication = communication;
//    }
//    @Autowired
//    RestTemplate restTemplate = new RestTemplate();      Возможно ответ будет неправильный из-за доп. РестТемплейта

    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);

        User user1 = new User(3L, "James", "Brown", (byte)15);
        User user2 = new User(3L, "Thomas", "Shelby", (byte)15);


        Communication communication = new Communication(new RestTemplate());

        System.out.println(communication.getAllUsers());
        communication.addUser(user1);
        communication.editUser(user2);


    }
}


