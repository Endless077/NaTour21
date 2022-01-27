package com.natour.Server.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.natour.Server.Model.CompilationItinerario;
import com.natour.Server.Repository.CompilationItinerarioRepository;

@Service("mainCompilationItinerarioService")
public class CompilationItinerarioSerivce {

	private final CompilationItinerarioRepository compilationItinerarioRep;

	/*********************************************************************************************/

	//Constructor
	@Autowired
	public CompilationItinerarioSerivce(CompilationItinerarioRepository compilationItinerarioRep) {
		super();
		this.compilationItinerarioRep = compilationItinerarioRep;
	}

	/*********************************************************************************************/

	//Methods
	public List<CompilationItinerario> getAllCompilationItinerario(){
		return this.compilationItinerarioRep.findAll();
	}

	/*********************************************************************************************/

	//Getter e Setter
	public CompilationItinerarioRepository getCompilationRep() {
		return compilationItinerarioRep;
	}

	/*********************************************************************************************/

}
