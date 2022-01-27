package com.natour.Server.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.natour.Server.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import com.natour.Server.Repository.UserRepository;
import com.natour.Server.ServiceInterface.IUserService;

@Service("mainUserService")
public class UserService implements IUserService {

	private final UserRepository userRep;

	//Constructor
	@Autowired
	public UserService(UserRepository userRep) {
		super();
		this.userRep = userRep;
	}

	/*********************************************************************************************/

	//Methods
	@Override
	public List<User> getAllUser() {
		return this.userRep.findAll();
	}

	@Override
	public Optional<User> getUtente(String username) {
		return this.userRep.findById(username);
	}
	
	@Override
	public boolean creaUtente(User utente) {
		try {
			if(!this.userRep.existsById(utente.getUsername()))
				this.userRep.save(utente);
			else
				return false;
		}catch(IllegalArgumentException e){
			return false;
		}
		return true;
	}
	
	@Override
	public boolean deleteUtente(String username) {
		try {
			if(this.userRep.existsById(username))
				this.userRep.deleteById(username);
			else
				return false;
		}catch(IllegalArgumentException e){
			return false;
		}
		return true;
	}


	/*********************************************************************************************/

	//Getter e Setter
	public UserRepository getUserRep() {
		return userRep;
	}
	
}
