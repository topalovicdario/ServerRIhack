
package com.example.demo.api.user_event_repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.api.model.User;
import com.example.demo.api.model.User_event;

import jakarta.transaction.Transactional;

import com.example.demo.api.model.Event;
import com.example.demo.api.model.Rank;

public interface User_event_repo extends JpaRepository<User_event, String>{
	@Modifying  // Marks this as a data modification query (UPDATE, DELETE, INSERT)
    @Transactional  // Ensures the operation is wrapped in a transaction
    @Query(value = "UPDATE user_event SET completed = 1 WHERE user_id = :userId", nativeQuery = true)
    int markUserEventCompleted(@Param("userId") String userId);
}
// Use Long here