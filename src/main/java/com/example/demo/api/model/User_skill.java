package com.example.demo.api.model;
import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
public class User_skill {

    @Id
    private String id;                // char(36) PK
    private Timestamp createdAt;      // datetime
    private String userId;            // char(36)
    private String skillId;           // char(36)
    private int experience;            // int
    private int level;                 // int

    // Constructor with parameters
    public User_skill(String id, Timestamp createdAt, String userId, String skillId, int experience, int level) {
        this.id = id;
        this.createdAt = createdAt;
        this.userId = userId;
        this.skillId = skillId;
        this.experience = experience;
        this.level = level;
    }

    // Default constructor
    public User_skill() {
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSkillId() {
        return skillId;
    }

    public void setSkillId(String skillId) {
        this.skillId = skillId;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}