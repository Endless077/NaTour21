package com.natour.Server.Controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.natour.Server.Model.InterestingPoint;
import com.natour.Server.Model.DTO.InterestingPointDTO;
import com.natour.Server.Model.DTO.UserDTO;
import com.natour.Server.Service.InterestingPointService;

@RestController
@RequestMapping(path = "api/interestingpoint", produces = { "application/json" })
public class InterestingPointController {

	@Autowired
	@Qualifier("mainInterestingPointService")
	private InterestingPointService interestingpointService;

	@Autowired
	private ModelMapper modelMapper;

	/*********************************************************************************************/

	//Constructor
	//	@Autowired
	//	public InterestingPointController(InterestingPointService interestingpointService) {
	//		super();
	//		this.interestingpointService = interestingpointService;
	//	}

	public InterestingPointController() {}

	/*********************************************************************************************/

	//Get Mapping
	@GetMapping(path = "listaInterestingPoint")
	public List<InterestingPoint> getAll() {
		return this.interestingpointService.getAllInterestinPoint();
	}

	//Post Mapping


	//Put Mapping


	//Delete Mapping


	/*********************************************************************************************/

	//Getter e Setter
	public InterestingPointService getInterestingpointService() {
		return interestingpointService;
	}

	public void setInterestingpointService(InterestingPointService interestingpointService) {
		this.interestingpointService = interestingpointService;
	}

	public ModelMapper getModelMapper() {
		return modelMapper;
	}

	public void setModelMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	/*********************************************************************************************/

	//Mapper
	private InterestingPointDTO convertEntityToDto(InterestingPoint interestingPoint){
		modelMapper.getConfiguration()
		.setMatchingStrategy(MatchingStrategies.LOOSE);
		InterestingPointDTO interestingPointDTO = new InterestingPointDTO();
		interestingPointDTO = modelMapper.map(interestingPoint, InterestingPointDTO.class);
		return interestingPointDTO;
	}

	private InterestingPoint convertDtoToEntity(UserDTO interestingPointDTO){
		modelMapper.getConfiguration()
		.setMatchingStrategy(MatchingStrategies.LOOSE);
		InterestingPoint interestingPoint = new InterestingPoint();
		interestingPoint = modelMapper.map(interestingPointDTO, InterestingPoint.class);
		return interestingPoint;
	}

	/*********************************************************************************************/

}
