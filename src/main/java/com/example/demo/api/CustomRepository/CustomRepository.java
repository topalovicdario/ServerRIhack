package com.example.demo.api.CustomRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.api.model.Event;
import com.example.demo.api.model.User;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.api.model.User;
import com.example.demo.api.model.Event;
import com.example.demo.api.model.Rank;
import com.example.demo.api.model.Tag;
	public interface CustomRepository extends JpaRepository<Event, String> {
		 @Query(value = "SELECT * FROM event WHERE status = 'over' ORDER BY created_at DESC", nativeQuery = true)
		    List<Event> findOverEvents();
		
		 @Query(value = "SELECT * FROM event WHERE status = 'active' AND is_outside_event = 1 ORDER BY created_at DESC", nativeQuery = true)
		    List<Event> findActiveOutsideEvents();
		
		
		@Query(value = "SELECT e.* FROM event", nativeQuery = true)
	    List<Event> findAllEvents();
		@Query(value = "SELECT e.* FROM user_event ue LEFT JOIN event e ON ue.event_id = e.id WHERE ue.user_id = :userId", nativeQuery = true)
		 List<Event> getEventsbyUser(@Param("userId") String userId);
		
		 @Query(value = "SELECT * FROM event WHERE status = 'active' AND is_sponsored = 1 ORDER BY created_at DESC", nativeQuery = true)
		    List<Event> findActiveSponsoredEvents();
		 @Query(value = "SELECT * FROM event WHERE status = 'active' ORDER BY created_at DESC", nativeQuery = true)
		    List<Event> findActiveEvents();
		 @Query(value = "SELECT e.*, COUNT(et.event_id) AS tag_count " +
                 "FROM event_tag et " +
                 "LEFT JOIN tag t ON et.tag_id = t.id " +
                 "LEFT JOIN event e ON et.event_id = e.id " +
                 "WHERE t.name IN :tagNames " +
                 "GROUP BY et.event_id, e.created_at " +
                 "ORDER BY tag_count DESC", nativeQuery = true)
  List<Event> findEventsByTags(@Param("tagNames") List<String> tagNames);
		 
		 @Query(value = "SELECT * FROM event WHERE id = :id", nativeQuery = true)
		    Optional<Event> findEventById(@Param("id") String id);
		  @Query(value = "SELECT e.* " +
                  "FROM user_event ue " +
                  "LEFT JOIN event e ON ue.event_id = e.id " +
                  "WHERE ue.user_id = :userId " +
                  "AND e.status = 'active' " +
                  "ORDER BY e.date ASC", nativeQuery = true)
   List<Event> findActiveEventsByUserId(@Param("userId") String userId);
		 
		  @Query(value = "SELECT e.* " +
                  "FROM user_event ue " +
                  "LEFT JOIN event e ON ue.event_id = e.id " +
                  "WHERE ue.user_id = :userId " +
                  "AND e.status = 'over' " +
                  "ORDER BY e.created_at DESC", nativeQuery = true)
   List<Event> findOverEventsByUserId(@Param("userId") String userId); 
		  
		  
		  @Query(value = "SELECT * FROM event WHERE owner_id = :userId ORDER BY created_at DESC", nativeQuery = true)
		    List<Event> findEventsByOwnerId(@Param("userId") String userId);
	}

