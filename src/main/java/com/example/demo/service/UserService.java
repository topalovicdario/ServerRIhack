package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.api.Create_rop.creat_rop;
import com.example.demo.api.CustomRepository.CustomRepository;
import com.example.demo.api.Rank_repo.Rank_repo;
import com.example.demo.api.Skill_repo.Skill_repo;
import com.example.demo.api.Task_repo.Task_repo;
import com.example.demo.api.UserRepository.UserRepository;
import com.example.demo.api.model.Event;
import com.example.demo.api.model.Rank;
import com.example.demo.api.model.*;
import com.example.demo.api.model.User;
import com.example.demo.api.model.User_event;
import com.example.demo.api.user_event_repo.User_event_repo;

@Service
public class UserService {
	
	/*
private List<User> userList;
public UserService() {
	userList=new ArrayList<User>();
	User user =new User(1,"luka","ha","email.com","1234");
	
	User user1 =new User(2,"luka2","ha","email.com","1234");
	User user2 =new User(3,"luka4","ha","email.com","1234");
	User user3 =new User(4,"luka3","ha","email.com","1234");
	User user4 =new User(5,"luka5","ha","email.com","1234");
	userList.addAll(Arrays.asList(user,user1,user2,user3,user4));
}
	public Optional<User> getUser(Integer id) {
		Optional optional=Optional.empty();
		for (User user:userList) {
			if (id==user.getId()) {
				optional=Optional.of(user);
				
				return optional;
			}
		}
		return optional;
	}
*/

    @Autowired
    private UserRepository userRepository;
    @Autowired
private CustomRepository custom;
    @Autowired
    private Skill_repo custom4;
    @Autowired
    private User_event_repo user_event;
    @Autowired
    private Task_repo tagRepository;
    @Autowired
    private Rank_repo userRankRepository;
    @Autowired
    private creat_rop rop;
    
    public List<Rank> getUserRanksWithSkillsByUserId(String userId) {
        return userRankRepository.findUserRanksWithSkillsByUserId(userId);
    }
    
    
    
    public List<Event> getOverEvents() {
        return custom.findOverEvents();
    }
    public List<Event> getActiveOutsideEvents() {
        return custom.findActiveOutsideEvents();
    }
    
    
    public List<Event> getEventsByOwnerId(String userId) {
        return custom.findEventsByOwnerId(userId);
    }
    
    public List<Event> getOverEventsByUserId(String userId) {
        return custom.findOverEventsByUserId(userId);
    }
    public List<Event> getActiveEventsByUserId(String userId) {
        return custom.findActiveEventsByUserId(userId);
    }
    public Optional<Event> getEventById(String id) {
        return custom.findEventById(id);
    }
    public List<Skill> getUserSkillsByUserId(String userId) {
        return custom4.findUserSkillsByUserId(userId);
    }
    
    
    public List<Tag> getTagsByName() {
        return tagRepository.findTagsByName();
    }
    
    public List<Tag> getTagsNotInSpecifiedNames() {
        return tagRepository.findTagsNotInSpecifiedNames();
    }
    
    
    
    
    
    public List<User> getAllUsers2() {
        return userRepository.findUsers();
    }
    public List<Event> getAll(){
    	return custom.findAll();
    }
    public List<Event> getActiveSponsoredEvents() {
        return custom.findActiveSponsoredEvents();
    }
    public List<Event> getActiveEvents() {
        return custom.findActiveEvents();
    }
    public List<Event> getEventsByTags(List<String> tagNames) {
        return custom.findEventsByTags(tagNames);
    }
    public List<Event> geteventsbyuser(String id){
    	return custom.getEventsbyUser(id);
    }
    
   public List<User> getUsersfromEvent(String id) {
        return userRepository.getUsersfromEvent(id);
    }
    //public List<Event> getEventsbyUser(String id) {
      //  return userRepository.getEventsbyUser(id);
    //}
    
    public List<Object[]> getEvents() {
        return userRepository.findAllEvents();
    }
    public User getUserById(String id) {
    	//userRepository=(UserRepository) userRepository.findById(id).orElse(null);
        return userRepository.findById(id).orElse(null);
    	//return (User) userRepository;
    }
    //public List<Rank> getUserRanks(String userId) {
      //  return userRepository.findRankbyUserID(userId);
    //}
    public UserWithRanksDTO getUserWithRanks(String userId) {
        Optional<User> user = userRepository.findById(userId);
        List<Rank> userRanks = userRankRepository.findRankbyUserID(userId);
        List<Skill> userskil = custom4.findUserSkillsByUserId(userId);
        return new UserWithRanksDTO(user, userRanks,userskil);
    }

	public User createUser(User user) {
		user.setId(UUID.randomUUID().toString());
		return userRepository.save(user);  
		
	}
	public void addUserSkill(String userId, String skillId) {
        custom4.insertUserSkill(userId, skillId);
    }
	
	public User_event createUserEvent(User_event user) {
		user.setId(UUID.randomUUID().toString());
       return user_event.save(user);
    }
	public void markEventsAsCompleted(String userId) {
       user_event.markUserEventCompleted(userId);
    }
	public User authenticateUser(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
	}
	
}
