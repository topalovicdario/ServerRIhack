package com.example.demo.api.Task_repo;

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
	public interface Task_repo extends JpaRepository<Tag, String> {
		  @Query(value = "SELECT * FROM tag WHERE name IN ('Student', 'Company', 'Other')", nativeQuery = true)
		    List<Tag> findTagsByName();
		  @Query(value = "SELECT * FROM tag WHERE name NOT IN ('Student', 'Company', 'Other')", nativeQuery = true)
		    List<Tag> findTagsNotInSpecifiedNames();
	}
