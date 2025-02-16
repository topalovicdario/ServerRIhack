package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.api.UserRepository.UserRepository;
import com.example.demo.api.user_event_repo.User_event_repo;

@Service
public class UserUpdate {

	
	 @Autowired
	    private User_event_repo userrepo;
	 public void markEventsAsCompleted(String userId) {
	       userrepo.markUserEventCompleted(userId);
	    }
}
