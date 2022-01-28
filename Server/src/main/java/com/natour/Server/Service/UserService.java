package com.natour.Server.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.natour.Server.Model.Compilation;
import com.natour.Server.Model.User;
import com.natour.Server.Model.DTO.UserDTO;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.natour.Server.Repository.UserRepository;
import com.natour.Server.ServiceInterface.IUserService;

@Service("mainUserService")
public class UserService implements IUserService {

	@Autowired
	private UserRepository userRep;
	
	@Autowired
    private ModelMapper modelMapper;

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
	
	/*********************************************************************************************/
	
	//Mapper
	private UserDTO convertEntityToDto(User user){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        UserDTO userDTO = new UserDTO();
        userDTO = modelMapper.map(user, UserDTO.class);
        return userDTO;
    }

    private User convertDtoToEntity(UserDTO userDTO){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        User user = new User();
        user = modelMapper.map(userDTO, User.class);
        return user;
    }
    
    /*********************************************************************************************/
    
}
