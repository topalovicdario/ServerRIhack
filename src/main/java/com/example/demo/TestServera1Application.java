package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.api.model.Event;

@SpringBootApplication
public class TestServera1Application {

	public static void main(String[] args) {
		SpringApplication.run(TestServera1Application.class, args);
		Event event =new Event();
		System.out.println(event.getId());
	}

}
