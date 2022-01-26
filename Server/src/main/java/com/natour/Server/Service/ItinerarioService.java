package com.natour.Server.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.natour.Server.Model.Itinerario;
import com.natour.Server.Repository.ItinerarioRepository;

@Service
public class ItinerarioService {

	private final ItinerarioRepository itinerarioRep;

	/*********************************************************************************************/

	//Constructor
	public ItinerarioService(ItinerarioRepository itinerarioRep) {
		super();
		this.itinerarioRep = itinerarioRep;
	}

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
