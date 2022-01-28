package com.natour.Server.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.natour.Server.Model.Itinerario;
import com.natour.Server.Repository.ItinerarioRepository;

@Service("mainItinerarioService")
public class ItinerarioService {

	@Autowired
	private ItinerarioRepository itinerarioRep;

	/*********************************************************************************************/

	//Constructor
	public ItinerarioService() {}

	/*********************************************************************************************/

	//Methods
	public List<Itinerario> getAllItinerari() {
		return this.itinerarioRep.findAll();
	}

	/*********************************************************************************************/

	//Getter e Setter
	public ItinerarioRepository getItinerarioRep() {
		return itinerarioRep;
	}

	/*********************************************************************************************/

}
