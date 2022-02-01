package com.natour.Server.ServiceInterface;

import java.util.List;
import java.util.Optional;

import com.natour.Server.Model.User;

public interface IUserService {

	//Methods GET
	public List<User> getAllUser();
	public Optional<User> getUtente(String username);
	
	//Methods POST
	public boolean creaUtente(User utente);
	
	//Methods PUT
	public boolean modificaUtente(User utente);
	
	//Methods DELETE
	public boolean deleteUtente(String username);
}
