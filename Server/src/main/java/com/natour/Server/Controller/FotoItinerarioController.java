package com.natour.Server.Controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.natour.Server.Model.FotoItinerario;
import com.natour.Server.Model.DTO.FotoItinerarioDTO;
import com.natour.Server.Service.FotoItinerarioService;

@RestController
@RequestMapping(path = "api/fotoInterestingPoint", produces = { "application/json" })
public class FotoItinerarioController {

	@Autowired
	@Qualifier("mainFotoInterestingPointService")
	private FotoItinerarioService fotoInterestingPointService;

	@Autowired
	private ModelMapper modelMapper;
	
	/*********************************************************************************************/

	//Get Mapping
	@GetMapping(path = "listaFotoInterestingPoint")
	public List<FotoItinerario> getAll() {
		return this.fotoInterestingPointService.getAllFotoInterestingPoint();
	}

	//Post Mapping


	//Put Mapping


	//Delete Mapping


	/*********************************************************************************************/

	//Getter e Setter
	public FotoItinerarioService getFotoInterestingPointService() {
		return fotoInterestingPointService;
	}

	public void setFotoInterestingPointService(FotoItinerarioService fotoInterestingPointService) {
		this.fotoInterestingPointService = fotoInterestingPointService;
	}

	public ModelMapper getModelMapper() {
		return modelMapper;
	}

	public void setModelMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	/*********************************************************************************************/

	//Mapper
	private FotoItinerarioDTO convertEntityToDto(FotoItinerario fotoIP){
		modelMapper.getConfiguration()
		.setMatchingStrategy(MatchingStrategies.LOOSE);
		FotoItinerarioDTO fotoIPDTO = new FotoItinerarioDTO();
		fotoIPDTO = modelMapper.map(fotoIP, FotoItinerarioDTO.class);
		return fotoIPDTO;
	}

	private FotoItinerario convertDtoToEntity(FotoItinerarioDTO fotoIPDTO){
		modelMapper.getConfiguration()
		.setMatchingStrategy(MatchingStrategies.LOOSE);
		FotoItinerario fotoIP = new FotoItinerario();
		fotoIP = modelMapper.map(fotoIPDTO, FotoItinerario.class);
		return fotoIP;
	}

	/*********************************************************************************************/

}
