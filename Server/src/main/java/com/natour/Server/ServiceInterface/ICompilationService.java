package com.natour.Server.ServiceInterface;

import java.util.List;
import java.util.Optional;

import com.natour.Server.Model.Compilation;

public interface ICompilationService {

	//Methods
	public List<Compilation> getAllCompilation();
	public Optional<Compilation> getCompilation(Long idcompilation);
	public boolean creaCompilation(Compilation utente);
	public boolean deleteCompilation(Long id_compilation);

}
