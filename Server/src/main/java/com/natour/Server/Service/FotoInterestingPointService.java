package com.natour.Server.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.natour.Server.Model.FotoInterestingPoint;
import com.natour.Server.Repository.FotoInterestingPointRepository;

@Service("mainFotoInterestingPointService")
public class FotoInterestingPointService {

	@Autowired
	private FotoInterestingPointRepository fotoInterestingPointRep;

	/*********************************************************************************************/

	//Constructor
	public FotoInterestingPointService() {}

	/*********************************************************************************************/

	//Methods
	public List<FotoInterestingPoint> getAllFotoInterestingPoint() {
		return this.fotoInterestingPointRep.findAll();
	}

	/*********************************************************************************************/

	//Getter e Setter
	public FotoInterestingPointRepository getFotoInterestingPointRep() {
		return fotoInterestingPointRep;
	}

	/*********************************************************************************************/

}
