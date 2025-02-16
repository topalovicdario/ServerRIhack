package com.example.demo.api.model;
import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
public class Rank {

    @Id
    private String id;                // char(36) PK
    private Timestamp created_at;     // datetime
    private String name;              // varchar(50)
    private String skill_id;          // varchar(50)
    
    public Rank(String id, Timestamp created_at, String name, String skill_id) {
        this.id = id;
        this.created_at = created_at;
        this.name = name;
        this.skill_id = skill_id;
    }public Rank(){
    	
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

    public String getSkill_id() {
        return skill_id;
    }

    public void setSkill_id(String skill_id) {
        this.skill_id = skill_id;
    }
}