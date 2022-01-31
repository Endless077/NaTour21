package com.natour.Server.Controller;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.natour.Server.Model.User;
import com.natour.Server.Model.DTO.UserDTO;
import com.natour.Server.ServiceInterface.IUserService;

@RestController
@RequestMapping(path = "api/user", produces = { "application/json" })
public class UserController {

	@Autowired
	@Qualifier("mainUserService")
	private IUserService userService;

	@Autowired
	private ModelMapper modelMapper;

	/*********************************************************************************************/

	//Constructor
	//	@Autowired
	//	public UserController(UserService userService) {
	//		super();
	//		this.userService = userService;
	//	}

	public UserController() {}

	/*********************************************************************************************/

	//Get Mapping
	@GetMapping(path = "listaUtenti")
	@ResponseBody
	public List<User> getAll() {
		return this.userService.getAllUser();
	}

	@GetMapping(path = "getUtente/{username}")
	@ResponseBody
	public Optional<User> getUser(@PathVariable(name = "username") String username) {
		Optional<User> result = this.userService.getUtente(username);
		if(result.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Utente non trovato.");
		return result;
	}

	//Post Mapping
	@PostMapping(path = "createUtente")
	@ResponseBody
	public ResponseEntity<String> createUser(@RequestBody User utente) {

		boolean creato = this.userService.creaUtente(utente);
		if(creato)
			return ResponseEntity.status(HttpStatus.CREATED).build();
		else
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Utente non salvato.");
	}

	//Put Mapping
	//Not implemented.

	//Delete Mapping
	@DeleteMapping(path = "deleteUtente/{username}")
	@ResponseBody
	public ResponseEntity<String> deleteUser(@PathVariable(name = "username") String username) {

		boolean eliminato = this.userService.deleteUtente(username);
		if(eliminato)
			return ResponseEntity.status(HttpStatus.OK).build();
		else
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Utente non eliminato.");
	}

	/*********************************************************************************************/

	//Getter e Setter
	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
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
