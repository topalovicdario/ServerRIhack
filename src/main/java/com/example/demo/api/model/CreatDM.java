package com.example.demo.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table
public class CreatDM {
	@Id
	private String id;
	private String firstName;
	private String lastName;
    private int age;
    private String email;
    private String gender; 
    private String password; 
    private byte[] ProfilePicture;
    private String tagId;
    public CreatDM( String firstName, String lastName, int age, String email, String gender, String password, byte[] profilePicture, String tagId) {
        
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.gender = gender;
        this.password = password;
        this.ProfilePicture = profilePicture;
        this.tagId = tagId;
    }

	    // Getters and setters
    public String getFirstname() {
        return firstName;
    }

    public void setFirstname(String firstname) {
        this.firstName = firstname;
    }
    public String getID() {
        return firstName;
    }

    public void setId(String id) {
        this.id = id;
    }
    // Getter and Setter for lastname
    public String getLastname() {
        return lastName;
    }

    public void setLastname(String lastname) {
        this.lastName = lastname;
    }

    // Getter and Setter for age
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Getter and Setter for email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter and Setter for gender
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    // Getter and Setter for password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Getter and Setter for tag_id
    public String getTag_id() {
        return tagId;
    }

    public void setTag_id(String tag_id) {
        this.tagId = tag_id;
    }
    public byte[] getImg() {
        return ProfilePicture;
    }

    public void setImg(byte[]ProfilePicture) {
        this.ProfilePicture=ProfilePicture;
    }
    
	}

