package com.natour.Server.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.natour.Server.Model.Compilation;
import com.natour.Server.Service.CompilationService;

@RestController
@RequestMapping(path = "api/compilation", produces = { "application/json" })
public class CompilationController {

	@Autowired
	@Qualifier("mainCompilationService")
	private CompilationService compilationService;

	/*********************************************************************************************/

	//Constructor
	//	@Autowired
	//	public CompilationController(CompilationService compilationService) {
	//		super();
	//		this.compilationService = compilationService;
	//	}

	public CompilationController() {}

	/*********************************************************************************************/

	//Get Mapping
	@GetMapping(path = "listaCompilation")
	@ResponseBody
	public List<Compilation> getAll(){
		return this.compilationService.getAllCompilation();
	}

	@GetMapping(path = "getCompilation/{idCompilation}")
	@ResponseBody
	public Optional<Compilation> getCompilation(@PathVariable(name = "idCompilation") Long idCompilation){
		Optional<Compilation> result = this.compilationService.getCompilation(idCompilation);
		if(result.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Compilation non trovata.");
		return result;
	}

	//Post Mapping
	@PostMapping(path = "creaCompilation")
	@ResponseBody
	public ResponseEntity<String> createCompilation(@RequestBody Compilation compilation) {

		boolean creato = this.compilationService.creaCompilation(compilation);
		if(creato)
			return ResponseEntity.status(HttpStatus.CREATED).build();
		else
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Compilation non salvata.");
	}

	//Put Mapping


	//Delete Mapping
	@DeleteMapping(path = "deleteCompilatiod/{id_compilation}")
	@ResponseBody
	public ResponseEntity<String> deleteCompilation(@PathVariable(name = "id_compilation") Long id_compilation) {
		
		boolean eliminato = this.compilationService.deleteCompilation(id_compilation);
		if(eliminato)
			return ResponseEntity.status(HttpStatus.OK).build();
		else
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Utente non eliminato.");
	}

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
