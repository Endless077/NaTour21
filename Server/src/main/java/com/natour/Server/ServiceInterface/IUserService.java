package com.natour.Server.ServiceInterface;

import java.util.List;
import java.util.Optional;

import com.natour.Server.Model.User;

public interface IUserService {

	//Methods
	public List<User> getAllUser();
	public Optional<User> getUtente(String username);
	public boolean creaUtente(User utente);
	public boolean deleteUtente(String username);
}
