package com.natour.Server.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.natour.Server.Model.User;
import com.natour.Server.Service.UserService;

@RestController
@RequestMapping("api/user")
public class UserController {
	
	private UserService userService;
	
	//Constructor
	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	public UserController() {}
	
	//Get Mapping
	@GetMapping("listaUtenti")
	public List<User> getAll() {
		return this.userService.getALL();
	}
	
	@GetMapping("getUtente/{username}")
	public Optional<User> getUser(@PathVariable String username) {
		return this.userService.getUtente(username);
	}
	
	//Put Mapping
	
	
	//Delete Mapping
	
	//Getter e Setter
	public UserService getUserService() {
		return userService;
	}


	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
