package com.natour.Server.ServiceInterface;

import java.util.List;
import java.util.Optional;

import com.natour.Server.Model.Itinerario;

public interface IItinerarioService {
	
	//Methods GET
	List<Itinerario> getAllItinerari();
	Optional<Itinerario> getItinerarioByID(Long id);
	List<Itinerario> getItinerariByUsername(String username);

}
