package com.natour.Server.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.natour.Server.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import com.natour.Server.Repository.UserRepository;

@Service
public class UserService {
	
	private final UserRepository userRep;
	
	//Constructor
	@Autowired
	public UserService(UserRepository userRep) {
		super();
		this.userRep = userRep;
	}
	
	//Methods
	public Optional<User> getUtente(String username) {
		return this.userRep.findById(username);
	}

	public List<User> getALL() {
		return this.userRep.findAll();
	}
	
	public UserRepository getUserRep() {
		return userRep;
	}

}
