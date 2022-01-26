package com.natour.Server.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.natour.Server.Model.CompilationItinerario;
import com.natour.Server.Service.CompilationItinerarioSerivce;

@RestController
@RequestMapping("api/compilationItinerario")
public class CompilationItinerarioController  {

	private CompilationItinerarioSerivce compilationItinerarioService;

	/*********************************************************************************************/

	//Constructor
	@Autowired
	public CompilationItinerarioController(CompilationItinerarioSerivce compilationItinerarioService) {
		super();
		this.compilationItinerarioService = compilationItinerarioService;
	}

	public CompilationItinerarioController() {}

	/*********************************************************************************************/

	//Get Mapping
	@GetMapping("listaCompilationItinerario")
	public List<CompilationItinerario> getAll(){
		return this.compilationItinerarioService.getAllCompilationItinerario();
	}

	//Put Mapping


	//Delete Mapping


	/*********************************************************************************************/

	//Getter e Setter
	public CompilationItinerarioSerivce getCompilationItinerarioService() {
		return compilationItinerarioService;
	}

	public void setCompilationItinerarioService(CompilationItinerarioSerivce compilationItinerarioService) {
		this.compilationItinerarioService = compilationItinerarioService;
	}

	/*********************************************************************************************/

}
