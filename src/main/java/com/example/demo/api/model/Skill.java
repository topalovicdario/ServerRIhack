package com.example.demo.api.model;
import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
public class Skill {

    @Id
    private String id;                // char(36) PK
    private Timestamp created_at;     // datetime
    private String name;  
  private int experience;
  private int level;
   
    // Constructor with parameters
    public Skill(String id, Timestamp created_at, String name,int experience,int level) {
        this.id = id;
        this.created_at = created_at;
        this.name = name;
        this.experience=experience;
        this.level=level;
    }
    

    // Default constructor
    public Skill() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getExperience() {
        return experience;
    }

    // Setter for experience
    public void setExperience(int experience) {
        this.experience = experience;
    }

    // Getter for level
    public int getLevel() {
        return level;
    }

    // Setter for level
    public void setLevel(int level) {
        this.level = level;
    }
}