package com.natour.Server.ServiceInterface;

import java.util.List;
import java.util.Optional;

import com.natour.Server.Model.Compilation;
import com.natour.Server.Model.DTO.CompilationDTO;

public interface ICompilationService {

	//Methods GET
	public List<Compilation> getAllCompilation();
	public Optional<Compilation> getCompilationByID(Long idcompilation);
	public List<Compilation> getCompilationByUsername(String username);
	
	//Methods POST
	public boolean creaCompilation(Compilation utente);
	
	//Methods PUT
	
	//Methods DELETE
	public boolean deleteCompilation(Long id_compilation);

}
