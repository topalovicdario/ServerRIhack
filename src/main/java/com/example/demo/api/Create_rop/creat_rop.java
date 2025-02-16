
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

package com.example.demo.api.Create_rop;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.api.model.User;

import jakarta.transaction.Transactional;

import com.example.demo.api.model.CreatDM;
import com.example.demo.api.model.Event;
import com.example.demo.api.model.Rank;
import com.example.demo.api.model.Skill;

public interface creat_rop extends JpaRepository<CreatDM, String> {

	
	
	
}  // Use Long here