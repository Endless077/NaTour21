package com.natour.Server.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.natour.Server.Model.InterestingPoint;
import com.natour.Server.Service.InterestingPointService;

@RestController
@RequestMapping("api/interestingpoint")
public class InterestingPointController {

	private InterestingPointService interestingpointService;

	//Constructor
	@Autowired
	public InterestingPointController(InterestingPointService interestingpointService) {
		super();
		this.interestingpointService = interestingpointService;
	}

	public InterestingPointController() {}

	/*********************************************************************************************/

	//Get Mapping
	@GetMapping("listaInterestingPoint")
	public List<InterestingPoint> getAll() {
		return this.interestingpointService.getAllInterestinPoint();
	}

	//Put Mapping


	//Delete Mapping

	/*********************************************************************************************/


	/*********************************************************************************************/

}
