package com.natour.Server.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.natour.Server.Exception.RequestApiException;
import com.natour.Server.Model.Itinerario;
import com.natour.Server.Model.User;
import com.natour.Server.Model.DTO.CompilationDTO;
import com.natour.Server.Model.DTO.ItinerarioDTO;
import com.natour.Server.Service.ItinerarioService;
import com.natour.Server.Service.UserService;

@RestController
@RequestMapping(path = "api/itinerario", produces = { "application/json" })
public class ItinerarioController {

	@Autowired
	@Qualifier("mainItinerarioService")
	private ItinerarioService itinerarioService;

	@Autowired
	@Qualifier("mainUserService")
	private UserService userService;
	
	@Autowired
	private ModelMapper modelMapper;

	/*********************************************************************************************/

	//Get Mapping
	@GetMapping(path = "listaItinerari")
	public List<Itinerario> getAll() {
		return this.itinerarioService.getAllItinerari();
	}

	@GetMapping(path = "getItinerario/byID/{idItinerario}")
	@ResponseBody
	public ItinerarioDTO getItinerarioByID(@PathVariable(name = "idItinerario") Long idItinerario){
		Optional<Itinerario> result = this.itinerarioService.getItinerarioByID(idItinerario);
		
		if(result.isEmpty())
			throw new RequestApiException("Itinerario non trovato.", HttpStatus.NOT_FOUND);
		
		ItinerarioDTO itinerario = convertEntityToDto(result.get());
		return itinerario;
	}

	@GetMapping(path = "getItinerario/byUsername/{username}")
	@ResponseBody
	public List<ItinerarioDTO> getItinerarioByUsername(@PathVariable(name = "username") String username) {
		List<Itinerario> listaItinerari = this.itinerarioService.getItinerariByUsername(username);

		if(listaItinerari.isEmpty())
			throw new RequestApiException("L'utente non possiede itinerari.", HttpStatus.NOT_FOUND);

		List<ItinerarioDTO> ret = new ArrayList<ItinerarioDTO>();

		for(Itinerario c : listaItinerari)
			ret.add(convertEntityToDto(c));

		return ret;
	}

	//Put Mapping


	//Delete Mapping


	/*********************************************************************************************/

	//Getter e Setter
	public ItinerarioService getItinerarioService() {
		return itinerarioService;
	}

	public void setItinerarioService(ItinerarioService itinerarioService) {
		this.itinerarioService = itinerarioService;
	}

	public ModelMapper getModelMapper() {
		return modelMapper;
	}

	public void setModelMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	/*********************************************************************************************/

	//Mapper
	private ItinerarioDTO convertEntityToDto(Itinerario itinerario){
		modelMapper.getConfiguration()
		.setMatchingStrategy(MatchingStrategies.LOOSE);
		ItinerarioDTO itinerarioDTO = new ItinerarioDTO();
		itinerarioDTO = modelMapper.map(itinerario, ItinerarioDTO.class);
		
		//Mapping
		String username = itinerario.getUtente().getUsername();
		itinerarioDTO.setId_utente(username);
		
		return itinerarioDTO;
	}

	private Itinerario convertDtoToEntity(ItinerarioDTO itinerarioDTO){
		modelMapper.getConfiguration()
		.setMatchingStrategy(MatchingStrategies.LOOSE);
		Itinerario itinerario = new Itinerario();
		itinerario = modelMapper.map(itinerarioDTO, Itinerario.class);
		
		//Mapping
		String username = itinerarioDTO.getId_utente();
		Optional<User> userOptional = this.userService.getUtente(username);

		User utente = null;
		if(!userOptional.isEmpty())
			utente = userOptional.get();
		itinerario.setUtente(utente);
		
		return itinerario;
	}

	/*********************************************************************************************/
}
