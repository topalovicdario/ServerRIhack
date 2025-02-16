package com.example.demo.api.model;
import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
public class User_event {

    @Id
    private String id;                // char(36) PK
    private Timestamp created_at;     // datetime
    private String user_id;           // char(36)
    private String event_id;          // char(36)
    private int completed;         // tinyint(1)

    // Constructor with parameters
    public User_event(String user_id, String event_id) {
        
        this.user_id = user_id;
        this.event_id = event_id;
        
    }
 public User_event(String user_id) {
        
        this.user_id = user_id;
     
        
    }

    // Default constructor
    public User_event() {
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getEvent_id() {
        return event_id;
    }

    public void setEvent_id(String event_id) {
        this.event_id = event_id;
    }

    public int isCompleted() {
        return completed;
    }

    public void setCompleted(int completed) {
        this.completed = completed;
    }
}