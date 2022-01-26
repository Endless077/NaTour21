package com.natour.Server.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.natour.Server.Model.FotoInterestingPoint;
import com.natour.Server.Service.FotoInterestingPointService;

@RestController
@RequestMapping("api/fotoInterestingPoint")
public class FotoInterestingPointController {

	private FotoInterestingPointService fotoInterestingPointService;

	/*********************************************************************************************/

	//Constructor
	@Autowired
	public FotoInterestingPointController(FotoInterestingPointService fotoInterestingPointService) {
		super();
		this.fotoInterestingPointService = fotoInterestingPointService;
	}

	public FotoInterestingPointController() {}

	/*********************************************************************************************/

	//Get Mapping
	@GetMapping("listaFotoInterestingPoint")
	public List<FotoInterestingPoint> getAll() {
		return this.fotoInterestingPointService.getAllFotoInterestingPoint();
	}

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

	/*********************************************************************************************/

}
