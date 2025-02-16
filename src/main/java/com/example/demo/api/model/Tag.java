
package com.example.demo.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Timestamp;

@Entity
@Table(name = "tag")  // Specify the table name in the database
public class Tag {

    @Id
    @Column(name = "id", columnDefinition = "char(36)") // Mapping to CHAR(36)
    private String id;  // Primary Key, assuming it's a UUID or similar

    @Column(name = "created_at") // Mapping to DATETIME
    private Timestamp createdAt;  // Use LocalDateTime for DATETIME

    @Column(name = "name", length = 50) // Mapping to VARCHAR(50)
    private String name;  // Name of the tag

    // Default constructor
    public Tag() {}

    // Constructor with fields
    public Tag(String id,  Timestamp createdAt, String name) {
        this.id = id;
        this.createdAt = createdAt;
        this.name = name;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public  Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt( Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}