package com.natour.Server.ServiceInterface;

import java.util.List;
import java.util.Optional;

import com.natour.Server.Model.Compilation;

public interface ICompilationService {

	//Methods GET
	List<Compilation> getAllCompilation();
	Optional<Compilation> getCompilationByID(Long idcompilation);
	List<Compilation> getCompilationByUsername(String username);
	List<String> getItinerariInCompilation(Long idCompilation);
	
	//Methods POST
	boolean creaCompilation(Compilation utente);
	boolean addItinerarioInCompilation(Long idCompilation, Long idItinerario);
	
	//Methods PUT
	boolean modificaCompilation(Compilation compilation);
	
	//Methods DELETE
	boolean cancellaCompilation(Long id_compilation);
	boolean removeItinerarioInCompilation(Long idCompilation, Long idItinerario);
	

}
