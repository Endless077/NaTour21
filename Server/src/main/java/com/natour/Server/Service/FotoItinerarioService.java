package com.natour.Server.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.natour.Server.Model.FotoItinerario;
import com.natour.Server.Repository.FotoItinerarioRepository;
import com.natour.Server.ServiceInterface.IFotoItinerario;

@Service("mainFotoInterestingPointService")
public class FotoItinerarioService implements IFotoItinerario {

	@Autowired
	private FotoItinerarioRepository fotoInterestingPointRep;

	/*********************************************************************************************/

	//Methods
	public List<FotoItinerario> getAllFotoInterestingPoint() {
		return this.fotoInterestingPointRep.findAll();
	}

	/*********************************************************************************************/

	//Getter e Setter
	public FotoItinerarioRepository getFotoInterestingPointRep() {
		return fotoInterestingPointRep;
	}

	/*********************************************************************************************/

}
