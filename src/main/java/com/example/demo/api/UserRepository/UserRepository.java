
/*
package com.example.demo.api.UserRepository;

import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.api.model.Rank;
import com.example.demo.api.model.User;

public interface UserRepository extends JpaRepository<User,String> {
	 Optional<User> findById(Long id);

	    // Custom query to find all ranks by user ID
	    @Query("SELECT nova_baza.rank.name FROM user_rank JOIN nova_baza.rank ON user_rank.rank_id = nova_baza.rank.id WHERE user_rank.user_id = ?;")
	    List<Rank> findRankbyUserID(Long userId);
	
    // You can define custom query methods here if needed
}*/

package com.example.demo.api.UserRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.api.model.User;

import jakarta.transaction.Transactional;

import com.example.demo.api.model.Event;
import com.example.demo.api.model.Rank;
import com.example.demo.api.model.Skill;

public interface UserRepository extends JpaRepository<User, String> {  // Use Long here
    
    // Fetch a specific user by ID
	 Optional<User> findById(String id);
	 @Query(value = "SELECT * FROM event WHERE status = 'over' ORDER BY created_at DESC", nativeQuery = true)
	    List<Event> findOverEvents();
	@Query(value = "SELECT e.* FROM user_event ue LEFT JOIN event e ON ue.event_id = e.id WHERE ue.user_id = :userId", nativeQuery = true)
	 List<Event> getEventsbyUser(@Param("userId") String userId);
	
	 @Query(value = "SELECT e.* FROM event", nativeQuery = true)
	    List<Object[]> findAllEvents();
	 
	 
	 @Query(value = "SELECT u.* FROM user_event ue LEFT JOIN user u ON ue.user_id = u.id WHERE ue.event_id = :eventId", nativeQuery = true)
	 List<User> getUsersfromEvent(@Param("eventId") String eventId);
	 @Query(value = "SELECT s.*, us.experience, us.level " +
             "FROM user_skill us " +
             "LEFT JOIN skill s ON us.skill_id = s.id " +
             "WHERE us.user_id = :userId", nativeQuery = true)
List<Skill> findUserSkillsByUserId(@Param("userId") String userId);
	 
	 @Query(value = "SELECT u.*, t.id as tag_table_id, t.created_at as tag_table_created_at, t.name as tag_table_name FROM user u LEFT JOIN tag t ON u.tag_id = t.id", nativeQuery = true)
	 List<User> findUsers();
	    // Custom native query to find all rank names by user ID
	 @Query(value = "SELECT r.name FROM `user_rank` ur JOIN `rank` r ON ur.rank_id = r.id WHERE ur.user_id = :userId", nativeQuery = true)
	    List<Rank> findRankbyUserID(@Param("userId")String userId);
	 
	    @Modifying  // Indicates this is a data-modifying query
	    @Transactional // Required for DML queries (INSERT, UPDATE, DELETE)
	    @Query(value = "INSERT INTO user_event (id, created_at, user_id, event_id, completed) " +
	                   "VALUES (uuid(), NOW(), :userId, :eventId, 0)", nativeQuery = true)
	    int insertUserEvent(@Param("userId") String userId, @Param("eventId") String eventId);
	   
	    @Query(value = "SELECT * FROM last4.user WHERE email = :email AND password = :password", nativeQuery = true)
	    User findByEmailAndPassword(@Param("email") String email, @Param("password") String password);
	
}


