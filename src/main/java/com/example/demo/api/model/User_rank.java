package com.example.demo.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Timestamp;

@Entity
@Table(name = "user_rank")
public class User_rank {

    @Id
    @Column(name = "id", columnDefinition = "CHAR(36)")
    private String id;  // Primary key (UUID)

    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;  // DATETIME in MySQL

    @Column(name = "user_id", columnDefinition = "CHAR(36)", nullable = false)
    private String userId;  // Foreign key to User (UUID)

    @Column(name = "rank_id", columnDefinition = "CHAR(36)", nullable = false)
    private String rankId;  // Rank ID (UUID)

    // Default constructor
    public User_rank() {}

    // Parameterized constructor
    public User_rank(String id, Timestamp createdAt, String userId, String rankId) {
        this.id = id;
        this.createdAt = createdAt;
        this.userId = userId;
        this.rankId = rankId;
    }

    // Getters and setters

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

    public String getRankId() {
        return rankId;
    }

    public void setRankId(String rankId) {
        this.rankId = rankId;
    }
}