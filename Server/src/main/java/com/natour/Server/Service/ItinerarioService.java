package com.natour.Server.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.natour.Server.Model.Itinerario;
import com.natour.Server.Repository.ItinerarioRepository;

@Service
public class ItinerarioService {

	private final ItinerarioRepository itinerarioRep;
	
	public ItinerarioService(ItinerarioRepository itinerarioRep) {
		super();
		this.itinerarioRep = itinerarioRep;
	}
	
	public List<Itinerario> getAllItinerari() {
		return this.itinerarioRep.findAll();
	}
	
	public ItinerarioRepository getItinerarioRep() {
		return itinerarioRep;
	}
	
}
