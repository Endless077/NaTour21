package com.natour.Server.ServiceInterface;

import java.util.List;
import java.util.Optional;

import com.natour.Server.Model.Itinerario;

public interface IItinerarioService {
	
	//Methods GET
	List<Itinerario> getAllItinerari();
	List<Itinerario> getAllRecentItinerari();
	
	List<Itinerario> getItinerariByUsername(String username);
	List<Itinerario> getItinerariByName(String nomeItinerario);
	Optional<Itinerario> getItinerarioByID(Long id);

}
