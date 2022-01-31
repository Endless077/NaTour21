package com.natour.Server.Controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.natour.Server.Model.Tappa;
import com.natour.Server.Model.DTO.TappaDTO;
import com.natour.Server.Service.TappaService;

@RestController
@RequestMapping(path = "api/tappa", produces = { "application/json" })
public class TappaController {

	@Autowired
	@Qualifier("mainTappaService")
	private TappaService tappaService;

	@Autowired
	private ModelMapper modelMapper;

	/*********************************************************************************************/

	//Constructor
	//	@Autowired
	//	public TappaController(TappaService tappaService) {
	//		super();
	//		this.tappaService = tappaService;
	//	}

	public TappaController() {}

	/*********************************************************************************************/

	//Get Mapping
	@GetMapping(path = "listaTappe")
	public List<Tappa> getAll() {
		return this.tappaService.getAllTappe();
	}

	//Post Mapping


	//Put Mapping


	//Delete Mapping


	/*********************************************************************************************/

	//Getter e Setter
	public TappaService getTappaService() {
		return tappaService;
	}

	public void setTappaService(TappaService tappaService) {
		this.tappaService = tappaService;
	}

	public ModelMapper getModelMapper() {
		return modelMapper;
	}

	public void setModelMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	/*********************************************************************************************/

	//Mapper
	private TappaDTO convertEntityToDto(Tappa tappa){
		modelMapper.getConfiguration()
		.setMatchingStrategy(MatchingStrategies.LOOSE);
		TappaDTO tappaDTO = new TappaDTO();
		tappaDTO = modelMapper.map(tappa, TappaDTO.class);
		return tappaDTO;
	}

	private Tappa convertDtoToEntity(TappaDTO tappaDTO){
		modelMapper.getConfiguration()
		.setMatchingStrategy(MatchingStrategies.LOOSE);
		Tappa tappa = new Tappa();
		tappa = modelMapper.map(tappaDTO, Tappa.class);
		return tappa;
	}

	/*********************************************************************************************/

}
