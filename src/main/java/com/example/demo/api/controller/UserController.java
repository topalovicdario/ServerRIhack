package com.example.demo.api.controller;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.api.model.Event;
import com.example.demo.api.model.Rank;
import com.example.demo.api.model.Skill;
import com.example.demo.api.model.Tag;
import com.example.demo.api.model.User;
import com.example.demo.api.model.User_event;
import com.example.demo.service.UserService;
import com.example.demo.service.UserUpdate;
import com.example.demo.service.UserWithRanksDTO;

@RestController
@RequestMapping("/user")
public class UserController {
	  @Autowired
	    private UserService userService;
	  private UserUpdate userService2;
	/*
@GetMapping("/user")
public User getUser(@RequestParam Integer i) {
	Optional user=userService.getUser(id);
	if (user.isPresent()) {
		return (User) user.get();
	}
	return null;
}
*///event/recent
//provjera rada
	    @GetMapping("/rank{id_user}")
	  public ResponseEntity<List<Rank>> getUserRanksWithSkillsByUserId(@PathVariable String userId) {
	        List<Rank> userRanksWithSkills = userService.getUserRanksWithSkillsByUserId(userId);
	        return ResponseEntity.ok(userRanksWithSkills);
	    }
	  
	  
	  @GetMapping("/event/over")
	    public ResponseEntity<List<Event>> getOverEvents() {
	        List<Event> events = userService.getOverEvents();
	        return ResponseEntity.ok(events);
	    }
	  
	  @GetMapping("/event/outside")
	    public ResponseEntity<List<Event>> getActiveOutsideEvents() {
	        List<Event> events = userService.getActiveOutsideEvents();
	        return ResponseEntity.ok(events);
	    }
	  @GetMapping("event/owner/{userId}")//
	    public ResponseEntity<List<Event>> getEventsByOwnerId(@PathVariable String userId) {
	        List<Event> events = userService.getEventsByOwnerId(userId);
	        return ResponseEntity.ok(events);
	    }
	  
	  
	  @GetMapping("event/finished/{userId}")
	    public ResponseEntity<List<Event>> getOverEventsByUserId(@PathVariable String userId) {
	        List<Event> events = userService.getOverEventsByUserId(userId);
	        return ResponseEntity.ok(events);
	    }
	  
	  
	  @GetMapping("/upcoming/{userId}")//
	    public ResponseEntity<List<Event>> getActiveEventsByUserId(@PathVariable String userId) {
	        List<Event> events = userService.getActiveEventsByUserId(userId);
	        return ResponseEntity.ok(events);
	    }
	  
	  
	  
	  @GetMapping("/event/{id}")
	  public ResponseEntity<Event> getEventById(@PathVariable String id) {
	        Optional<Event> eventOptional = userService.getEventById(id);
	        if (eventOptional.isPresent()) {
	            return ResponseEntity.ok(eventOptional.get());
	        } else {
	            return ResponseEntity.status(404).body(null);  // Return 404 if no event is found
	        }
	  
	  }
	  @GetMapping("/skils/{userId}")
	    public ResponseEntity<List<Skill>> getUserSkillsByUserId(@PathVariable String userId) {
	        List<Skill> userSkills = userService.getUserSkillsByUserId(userId);
	        return ResponseEntity.ok(userSkills);
	    }
	  
	  
	  
	  @GetMapping("/tags/events")
	  public ResponseEntity<List<Tag>> getTagsNotInSpecifiedNames() {
	        List<Tag> tags = userService.getTagsNotInSpecifiedNames();
	        return ResponseEntity.ok(tags);
	    }
	  
	  
	  @GetMapping("/tag/users")
	    public ResponseEntity<List<Tag>> getTagsByName() {
	        List<Tag> tags = userService.getTagsByName();
	        return ResponseEntity.ok(tags);
	    }
	  
	  
	  
	  @PostMapping("/event/tags")
	    public ResponseEntity<List<Event>> getEventsByTags(@RequestBody List<String> tagNames) {
	        List<Event> events = userService.getEventsByTags(tagNames);
	        return ResponseEntity.ok(events);
	    }
	  
	  @GetMapping("/event/recent")//
	    public ResponseEntity<List<Event>> getActiveEvents() {
	        List<Event> events = userService.getActiveEvents();
	        return ResponseEntity.ok(events);
	    }
	
	  @GetMapping("/event/sponsored")
	    public ResponseEntity<List<Event>> getActiveSponsoredEvents() {
	        List<Event> events = userService.getActiveSponsoredEvents();
	        return ResponseEntity.ok(events);
	    }

    @GetMapping
    public List<User> getAllUsers2() {
        return userService.getAllUsers2();
    }

    @GetMapping("/{id_user}")//vraca usera sa svim podatcima
    public UserWithRanksDTO getUserById(@PathVariable("id_user") String idUser) {
        return userService.getUserWithRanks(idUser);
    }
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
    	User newUser;
    	 byte[] profilePictureBytes = Base64.getDecoder().decode(user.getProfilePicture());
    newUser = userService.createUser(user);
       return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    // Get users from event by event ID
    @GetMapping("/event/{id_event}/")
    public List<User> getUsersFromEvent(@PathVariable("id_event") String idEvent) {
        // Call the service to get users for the event
        return userService.getUsersfromEvent(idEvent);
    }
    
    @GetMapping("/event2/{event_id}")
    public List<Event> getEvenetsbyUser(@PathVariable("event_id") String idEventuserid) {
        // Call the service to get users for the event
        return userService.geteventsbyuser(idEventuserid);
    }
    @GetMapping("/event")
    public List<Event> getEvens() {
        // Call the service to get users for the event
        return userService.getAll();
    }
   // user_event/attend
    @PostMapping("/attend")
    public ResponseEntity<User_event> createUser(@RequestBody User_event user) {
    	
        User_event newUser = userService.createUserEvent(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
    
    @PostMapping("/complete")
    public ResponseEntity<User_event> update(@RequestBody User_event user) {
        User_event newUser = userService.createUserEvent(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
    
   
   // user_event/user/{id_user)
    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        user = userService.authenticateUser(user.getEmail(), user.getPassword());
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    
    //event/sponsored
    
    
    @GetMapping("/{id}/ranks")
    public UserWithRanksDTO getUserWithRanks(@PathVariable String id) {
        return userService.getUserWithRanks(id);
    }
   
}
