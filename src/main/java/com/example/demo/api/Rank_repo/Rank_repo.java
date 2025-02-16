package com.example.demo.api.Rank_repo;

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
	public interface Rank_repo extends JpaRepository<Rank, String> {
		@Query(value = "SELECT r.* FROM user_rank ur " +
                "LEFT JOIN kiko.rank r ON ur.rank_id = r.id " +
                "LEFT JOIN skill s ON r.skill_id = s.id " +
                "WHERE ur.user_id = :userId", nativeQuery = true)
 List<Rank> findUserRanksWithSkillsByUserId(@Param("userId") String userId);
		
		 @Query(value = "SELECT r.* FROM `user_rank` ur JOIN `rank` r ON ur.rank_id = r.id WHERE ur.user_id = :userId", nativeQuery = true)
		    List<Rank> findRankbyUserID(@Param("userId")String userId);
}
