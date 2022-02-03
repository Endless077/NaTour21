package com.natour.Server.Service;

import java.util.List;
import java.util.Optional;

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
	@Override
	public List<Itinerario> getAllItinerari() {
		return this.itinerarioRep.findAll();
	}
	
	@Override
	public List<Itinerario> getAllRecentItinerari() {
		return this.itinerarioRep.findAllByRecent();
	}
	
	@Override
	public List<Itinerario> getItinerariByName(String nomeItinerario) {
		return this.itinerarioRep.findAllByName(nomeItinerario);
		
	}
	@Override
	public Optional<Itinerario> getItinerarioByID(Long id) {
		return this.itinerarioRep.findById(id);
	}

	@Override
	public List<Itinerario> getItinerariByUsername(String username) {
		return this.itinerarioRep.findByUsername(username);
	}

	/*********************************************************************************************/

	//Getter e Setter
	public ItinerarioRepository getItinerarioRep() {
		return itinerarioRep;
	}

	/*********************************************************************************************/

}
