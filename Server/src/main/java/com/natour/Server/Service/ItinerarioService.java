package com.natour.Server.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.natour.Server.Model.Itinerario;
import com.natour.Server.Repository.ItinerarioRepository;
import com.natour.Server.ServiceInterface.IItinerarioService;

@Service("mainItinerarioService")
public class ItinerarioService implements IItinerarioService {

	@Autowired
	private ItinerarioRepository itinerarioRep;

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
