
package com.example.demo.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Timestamp;

@Entity
@Table(name = "event_tag")  // Specify the table name in the database
public class Event_tag {

    @Id
    @Column(name = "id", columnDefinition = "char(36)") // Mapping to CHAR(36)
    private String id;  // Primary Key, assuming it's a UUID or similar

    @Column(name = "created_at") // Mapping to DATETIME
    private Timestamp createdAt;  // Use LocalDateTime for DATETIME

    @Column(name = "event_id", columnDefinition = "char(36)") // Mapping to CHAR(36)
    private String eventId;  // ID of the associated event

    @Column(name = "tag_id", columnDefinition = "char(36)") // Mapping to CHAR(36)
    private String tagId;  // ID of the associated tag

    // Default constructor
    public Event_tag() {}

    // Constructor with fields
    public Event_tag(String id, Timestamp createdAt, String eventId, String tagId) {
        this.id = id;
        this.createdAt = createdAt;
        this.eventId = eventId;
        this.tagId = tagId;
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

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }
}