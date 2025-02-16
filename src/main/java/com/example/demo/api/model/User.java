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
public class User {
	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String gender;
	private int age;
	private byte[] Profile_Picture;
	private Timestamp created_at;
	
	
	  @ManyToOne
	    @JoinColumn(name = "tag_id")  // Reference the foreign key column in the user table
private Tag tag;
	    // Constructor initializing fields in the specified order
	    public User(String id,byte[] profile_picture, Timestamp created_at, String first_name, String last_name, 
	                int age, String email, String gender, String password, 
	                String tag_id,String id_tag,Timestamp cre,String naziv) {
	        this.id = id;
	        this.created_at = created_at;
	        this.firstName = first_name;
	        this.lastName = last_name;
	        this.age = age;
	        this.email = email;
	        this.gender = gender;
	        this.password = password;
	       
	        this.Profile_Picture = profile_picture; // Optional, can be null
	       tag=new Tag();
	        this.tag.setId(id_tag);
	        this.tag.setName(naziv);
	        this.tag.setCreatedAt(cre);
	    }
	    public User(String firstName, String lastName, int age, String email, String gender, String password, byte[] profilePicture, String tagId) {
        
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.gender = gender;
        this.password = password;
        this.Profile_Picture = profilePicture;
        this.tag.setId(tagId);
       
     
    }
	    
	public User() {
		
	}
public User(String email,String password) {
	  this.email = email;
    
      this.password = password;
	}
	public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }
	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // profile_picture
    public byte[] getProfilePicture() {
        return Profile_Picture;
    }

    public void setProfilePicture(byte[] profile_picture) {
        this.Profile_Picture = profile_picture;
    }

    // created_at
    public Timestamp getCreatedAt() {
        return created_at;
    }

    public void setCreatedAt(Timestamp created_at) {
        this.created_at = created_at;
    }

    // first_name
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String first_name) {
        this.firstName = first_name;
    }

    // last_name
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String last_name) {
        this.lastName = last_name;
    }

    // age
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // gender
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    // password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // tag_id
   
}
