package com.example.demo.api.model;
import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
public class Event {

    @Id
    private String id;
    private Timestamp created_at;
    private byte[] image;
    private String name;
    private Timestamp date;
    private String address;
    private int is_anonymous;
    private String description;
    private int is_outside_event;
    private int max_capacity;
    private String status;
    private int experience;
    private int is_sponsored;
    private String owner_id;
    private String skill_id;
/*
    private String skill_name;
    private String first_name;
    private String last_name;
    */
    // Reference the foreign key column in the user table

    public Event(String id,Timestamp created_at,byte[] image,String name,Timestamp date,
    		String address,int is_anonymous,String description, int is_outside_event,
    		int max_capacity,String status, int experience,int is_sponsored,String owner_id,String skill_id) {
    	
    	this.id=id;
    	this.name=name;
    	this.date=date;
    	this.address=address;
    	this.is_anonymous=is_anonymous;
    	this.description=description;
    	this.is_outside_event=is_outside_event;
    	this.max_capacity=max_capacity;
    	this.status=status;
    	this.experience=experience;
    	this.is_sponsored=is_sponsored;
    	this.owner_id=owner_id;
    	this.skill_id=skill_id;
    }
    
    /*public Event(String id,Timestamp created_at,byte[] image,String name,Timestamp date,
    		String address,int is_anonymous,String description, int is_outside_event,
    		int max_capacity,String status, int experience,int is_sponsored,String owner_id,String skill_id,String first_name,String lastname,String skill_name) {
    	
    	this.id=id;
    	this.name=name;
    	this.date=date;
    	this.address=address;
    	this.is_anonymous=is_anonymous;
    	this.description=description;
    	this.is_outside_event=is_outside_event;
    	this.max_capacity=max_capacity;
    	this.status=status;
    	this.experience=experience;
    	this.is_sponsored=is_sponsored;
    	this.owner_id=owner_id;
    	this.skill_id=skill_id;
    	this.first_name=first_name;
    	this.last_name=lastname;
    }
    */
    public Event(){
    	
    }
   
/*
    // Getter and Setter for skil (Skill object)
    public String getSkil() {
        return skill_name;
    }

    public void setSkil(String skil) {
        this.skill_name = skil;
    }

    // Getter and Setter for first_name
    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    // Getter and Setter for last_name
    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }*/
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getIs_anonymous() {
        return is_anonymous;
    }

    public void setIs_anonymous(int is_anonymous) {
        this.is_anonymous = is_anonymous;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIs_outside_event() {
        return is_outside_event;
    }

    public void setIs_outside_event(int is_outside_event) {
        this.is_outside_event = is_outside_event;
    }

    public int getMax_capacity() {
        return max_capacity;
    }

    public void setMax_capacity(int max_capacity) {
        this.max_capacity = max_capacity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getIs_sponsored() {
        return is_sponsored;
    }

    public void setIs_sponsored(int is_sponsored) {
        this.is_sponsored = is_sponsored;
    }

    public String getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(String owner_id) {
        this.owner_id = owner_id;
    }

    public String getSkill_id() {
        return skill_id;
    }

    public void setSkill_id(String skill_id) {
        this.skill_id = skill_id;
    }
    
}