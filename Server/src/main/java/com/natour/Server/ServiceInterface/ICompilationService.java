package com.natour.Server.ServiceInterface;

import java.util.List;
import java.util.Optional;

import com.natour.Server.Model.Compilation;
import com.natour.Server.Model.DTO.CompilationDTO;

public interface ICompilationService {

	//Methods
	public List<Compilation> getAllCompilation();
	public Optional<Compilation> getCompilationByID(Long idcompilation);
	public List<Compilation> getCompilationByUsername(String username);
	public boolean creaCompilation(Compilation utente);
	public boolean deleteCompilation(Long id_compilation);

}
