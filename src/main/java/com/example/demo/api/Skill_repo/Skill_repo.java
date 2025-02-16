package com.example.demo.api.Skill_repo;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.api.model.Skill;
import com.example.demo.api.model.User;

import jakarta.transaction.Transactional;

public interface Skill_repo extends JpaRepository<Skill, String> { 
	
	 @Query(value = "SELECT s.*, us.experience, us.level " +
             "FROM user_skill us " +
             "LEFT JOIN skill s ON us.skill_id = s.id " +
             "WHERE us.user_id = :userId", nativeQuery = true)
List<Skill> findUserSkillsByUserId(@Param("userId") String userId);
	 @Modifying
	    @Transactional
	    @Query(value = "INSERT INTO user_skill (id, created_at, user_id, skill_id, experience, level) " +
	                   "VALUES (uuid(), NOW(), :userId, :skillId, 0, 1)", nativeQuery = true)
	    int insertUserSkill(@Param("userId") String userId, @Param("skillId") String skillId);
	
}
// Use Long here
