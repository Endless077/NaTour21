package com.natour.Server.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.natour.Server.Model.Compilation;
import com.natour.Server.Service.CompilationService;

@RestController
@RequestMapping("api/compilation")
public class CompilationController {

	private CompilationService compilationService;

	/*********************************************************************************************/

	//Constructor
	@Autowired
	public CompilationController(CompilationService compilationService) {
		super();
		this.compilationService = compilationService;
	}

	public CompilationController() {}

	/*********************************************************************************************/

	//Get Mapping
	@GetMapping("listaCompilation")
	public List<Compilation> getAll(){
		return this.compilationService.getAllCompilation();
	}

	//Put Mapping


	//Delete Mapping


	/*********************************************************************************************/

	//Getter e Setter
	public CompilationService getCompilationService() {
		return compilationService;
	}

	public void setCompilationService(CompilationService compilationService) {
		this.compilationService = compilationService;
	}

	/*********************************************************************************************/

}
