package com.natour.Server.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.natour.Server.Model.Compilation;
import com.natour.Server.Repository.CompilationRepository;

public class CompilationService {

	
	private final CompilationRepository compilationRep;

	//Constructor
	@Autowired
	public CompilationService(CompilationRepository compilationRep) {
		super();
		this.compilationRep = compilationRep;
	}
	
	//Methods
	public List<Compilation> getAllCompilation(){
		return this.compilationRep.findAll();
	}
	
	
}
