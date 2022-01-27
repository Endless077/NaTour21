package com.natour.Server.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.natour.Server.Model.Compilation;
import com.natour.Server.Repository.CompilationRepository;
import com.natour.Server.ServiceInterface.ICompilationService;

@Service("mainCompilationService")
public class CompilationService implements ICompilationService{

	private final CompilationRepository compilationRep;

	/*********************************************************************************************/

	//Constructor
	@Autowired
	public CompilationService(CompilationRepository compilationRep) {
		super();
		this.compilationRep = compilationRep;
	}

	/*********************************************************************************************/

	//Methods
	public List<Compilation> getAllCompilation(){
		return this.compilationRep.findAll();
	}
	
	@Override
	public Optional<Compilation> getCompilation(Long idCompilation){
		return this.compilationRep.findById(idCompilation);
	}

	/*********************************************************************************************/

	//Getter e Setter
	public CompilationRepository getCompilationRep() {
		return compilationRep;
	}

	/*********************************************************************************************/

}
