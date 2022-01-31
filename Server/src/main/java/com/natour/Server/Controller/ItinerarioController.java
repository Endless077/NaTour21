package com.natour.Server.Controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.natour.Server.Model.Itinerario;
import com.natour.Server.Model.DTO.ItinerarioDTO;
import com.natour.Server.Service.ItinerarioService;

@RestController
@RequestMapping(path = "api/itinerario", produces = { "application/json" })
public class ItinerarioController {

	@Autowired
	@Qualifier("mainItinerarioService")
	private ItinerarioService itinerarioService;

	@Autowired
	private ModelMapper modelMapper;

	/*********************************************************************************************/

	//Constructor
	//	@Autowired
	//	public ItinerarioController(ItinerarioService itinerarioService) {
	//		super();
	//		this.itinerarioService = itinerarioService;
	//	}

	public ItinerarioController() {}

	/*********************************************************************************************/

	//Get Mapping
	@GetMapping(path = "listaItinerari")
	public List<Itinerario> getAll() {
		return this.itinerarioService.getAllItinerari();
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
		return itinerarioDTO;
	}

	private Itinerario convertDtoToEntity(ItinerarioDTO itinerarioDTO){
		modelMapper.getConfiguration()
		.setMatchingStrategy(MatchingStrategies.LOOSE);
		Itinerario itinerario = new Itinerario();
		itinerario = modelMapper.map(itinerarioDTO, Itinerario.class);
		return itinerario;
	}

	/*********************************************************************************************/
}
