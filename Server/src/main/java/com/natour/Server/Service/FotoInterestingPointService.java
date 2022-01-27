package com.natour.Server.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.natour.Server.Model.FotoInterestingPoint;
import com.natour.Server.Repository.FotoInterestingPointRepository;

@Service("mainFotoInterestingPointService")
public class FotoInterestingPointService {

	private final FotoInterestingPointRepository fotoInterestingPointRep;

	/*********************************************************************************************/

	//Constructor
	public FotoInterestingPointService(FotoInterestingPointRepository fotoInterestingPointRep) {
		super();
		this.fotoInterestingPointRep = fotoInterestingPointRep;
	}

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
