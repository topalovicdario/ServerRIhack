package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.api.model.Rank;
import com.example.demo.api.model.Skill;
import com.example.demo.api.model.User;

public class UserWithRanksDTO {
	 private Optional<User> user;
	    private List<Rank> ranks;
	    private List<Skill> skill;
	    public UserWithRanksDTO(Optional<User> user2, List<Rank> ranks2, List<Skill> userskil) {
	        this.user = user2;
	        this.ranks = ranks2;
	        this.skill=userskil;
	    }

	    // Getters and Setters
	    public Optional<User> getUser() {
	        return user;
	    }

	    public void setUser(User user) {
	        this.user = Optional.ofNullable(user);
	    }

	    public List<Rank> getRanks() {
	        return ranks;
	    }

	    public void setRanks(List<Skill> skill) {
	        this.skill = skill;
	    }
	    public List<Skill> getSkill() {
	        return skill;
	    }

	    public void setSkill(List<Skill> skill) {
	        this.skill = skill;
	    }
}
