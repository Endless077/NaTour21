package com.natour.Server.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.natour.Server.Model.CompilationItinerario;
import com.natour.Server.Repository.CompilationItinerarioRepository;

@Service("mainCompilationItinerarioService")
public class CompilationItinerarioSerivce {

	@Autowired
	private CompilationItinerarioRepository compilationItinerarioRep;

	/*********************************************************************************************/

	//Constructor
	public CompilationItinerarioSerivce() {}

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
