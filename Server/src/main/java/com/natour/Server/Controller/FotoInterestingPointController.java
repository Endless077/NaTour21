package com.natour.Server.Controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.natour.Server.Model.FotoInterestingPoint;
import com.natour.Server.Model.DTO.FotoInterestingPointDTO;
import com.natour.Server.Service.FotoInterestingPointService;

@RestController
@RequestMapping(path = "api/fotoInterestingPoint", produces = { "application/json" })
public class FotoInterestingPointController {

	@Autowired
	@Qualifier("mainFotoInterestingPointService")
	private FotoInterestingPointService fotoInterestingPointService;

	@Autowired
	private ModelMapper modelMapper;

	/*********************************************************************************************/

	//Constructor
	//	@Autowired
	//	public FotoInterestingPointController(FotoInterestingPointService fotoInterestingPointService) {
	//		super();
	//		this.fotoInterestingPointService = fotoInterestingPointService;
	//	}

	public FotoInterestingPointController() {}

	/*********************************************************************************************/

	//Get Mapping
	@GetMapping(path = "listaFotoInterestingPoint")
	public List<FotoInterestingPoint> getAll() {
		return this.fotoInterestingPointService.getAllFotoInterestingPoint();
	}

	//Post Mapping


	//Put Mapping


	//Delete Mapping


	/*********************************************************************************************/

	//Getter e Setter
	public FotoInterestingPointService getFotoInterestingPointService() {
		return fotoInterestingPointService;
	}

	public void setFotoInterestingPointService(FotoInterestingPointService fotoInterestingPointService) {
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
	private FotoInterestingPointDTO convertEntityToDto(FotoInterestingPoint fotoIP){
		modelMapper.getConfiguration()
		.setMatchingStrategy(MatchingStrategies.LOOSE);
		FotoInterestingPointDTO fotoIPDTO = new FotoInterestingPointDTO();
		fotoIPDTO = modelMapper.map(fotoIP, FotoInterestingPointDTO.class);
		return fotoIPDTO;
	}

	private FotoInterestingPoint convertDtoToEntity(FotoInterestingPointDTO fotoIPDTO){
		modelMapper.getConfiguration()
		.setMatchingStrategy(MatchingStrategies.LOOSE);
		FotoInterestingPoint fotoIP = new FotoInterestingPoint();
		fotoIP = modelMapper.map(fotoIPDTO, FotoInterestingPoint.class);
		return fotoIP;
	}

	/*********************************************************************************************/

}
