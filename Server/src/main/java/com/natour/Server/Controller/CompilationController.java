package com.natour.Server.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.natour.Server.Exception.RequestApiException;
import com.natour.Server.Model.Compilation;
import com.natour.Server.Model.User;
import com.natour.Server.Model.DTO.CompilationDTO;
import com.natour.Server.Service.CompilationService;
import com.natour.Server.Service.UserService;

@RestController
@RequestMapping(path = "api/compilation", produces = { "application/json" })
public class CompilationController {

	@Autowired
	@Qualifier("mainCompilationService")
	private CompilationService compilationService;

	@Autowired
	@Qualifier("mainUserService")
	private UserService userService;

	@Autowired
	private ModelMapper modelMapper;

	/*********************************************************************************************/

	//Get Mapping
	@GetMapping(path = "listaCompilation")
	@ResponseBody
	public List<Compilation> getAll() {
		return this.compilationService.getAllCompilation();
	}

	@GetMapping(path = "getCompilation/byID/{idCompilation}")
	@ResponseBody
	public CompilationDTO getCompilationByID(@PathVariable(name = "idCompilation") Long idCompilation) {
		Optional<Compilation> result = this.compilationService.getCompilationByID(idCompilation);

		if(result.isEmpty())
			throw new RequestApiException("Compilation non trovata.", HttpStatus.NOT_FOUND);

		CompilationDTO compilation = convertEntityToDto(result.get());
		return compilation;

	}

	@GetMapping(path = "getComplation/byUsername/{username}")
	@ResponseBody
	public List<CompilationDTO> getCompilationByUsername(@PathVariable(name = "username") String username) {
		List<Compilation> listaCompilation = this.compilationService.getCompilationByUsername(username);

		if(listaCompilation.isEmpty())
			throw new RequestApiException("L'utente non possiede compilation.", HttpStatus.NOT_FOUND);

		List<CompilationDTO> ret = new ArrayList<CompilationDTO>();
		for(Compilation c : listaCompilation)
			ret.add(convertEntityToDto(c));

		return ret;
	}

	@GetMapping(path = "getComplation/itinerari/{idCompilation}")
	@ResponseBody
	public List<String> getCompilationItinerariByUsername(@PathVariable(name = "idCompilation") Long idCompilation) {
		List<String> itinerariInCompilation = this.compilationService.getItinerariInCompilation(idCompilation);

		if(itinerariInCompilation.isEmpty())
			throw new RequestApiException("Compilation vuota.", HttpStatus.NOT_FOUND);

		return itinerariInCompilation;
	}

	//Post Mapping
	@PostMapping(path = "createCompilation")
	@ResponseBody
	public ResponseEntity<String> createCompilation(@RequestBody CompilationDTO compilationDTO) {

		Compilation compilation = this.convertDtoToEntity(compilationDTO);

		boolean creato = this.compilationService.creaCompilation(compilation);
		if(creato)
			return ResponseEntity.status(HttpStatus.CREATED).build();
		else
			throw new RequestApiException("Compilation non salvata.", HttpStatus.BAD_REQUEST);
	}

	@PostMapping(path = "addItinerario/{idCompilation}/{idItinerario}")
	@ResponseBody
	public ResponseEntity<String> addItinerario(@PathVariable(name = "idCompilation") Long idCompilation,
												@PathVariable(name = "idItinerario") Long idItinerario) {

		boolean creato = this.compilationService.addItinerarioInCompilation(idCompilation,idItinerario);
		if(creato)
			return ResponseEntity.status(HttpStatus.CREATED).build();
		else
			throw new RequestApiException("Itinerario non salvato in Compilation.", HttpStatus.BAD_REQUEST);
	}

	//Put Mapping
	@PutMapping(path = "modifyCompilation")
	@ResponseBody
	public ResponseEntity<String> modifyCompilation(@RequestBody CompilationDTO compilationDTO) {

		Compilation compilation = this.convertDtoToEntity(compilationDTO);

		boolean modificato = this.compilationService.modificaCompilation(compilation);
		if(modificato)
			return ResponseEntity.status(HttpStatus.OK).build();
		else
			throw new RequestApiException("Compilation non modificata.", HttpStatus.BAD_REQUEST);
	}

	//Delete Mapping
	@DeleteMapping(path = "deleteCompilation/{id_compilation}")
	@ResponseBody
	public ResponseEntity<String> removeItinerario(@PathVariable(name = "id_compilation") Long id_compilation) {

		boolean eliminato = this.compilationService.cancellaCompilation(id_compilation);
		if(eliminato)
			return ResponseEntity.status(HttpStatus.OK).build();
		else
			throw new RequestApiException("Compilation non eliminata.", HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping(path = "removeItinerario/{idCompilation}/{idItinerario}")
	@ResponseBody
	public ResponseEntity<String> deleteCompilation(@PathVariable(name = "idCompilation") Long idCompilation,
													@PathVariable(name = "idItinerario") Long idItinerario) {

		boolean eliminato =  this.compilationService.removeItinerarioInCompilation(idCompilation,idItinerario);
		if(eliminato)
			return ResponseEntity.status(HttpStatus.OK).build();
		else
			throw new RequestApiException("Itinerario non rimosso in Compilation.", HttpStatus.BAD_REQUEST);
	}

	/*********************************************************************************************/

	//Getter e Setter
	public CompilationService getCompilationService() {
		return compilationService;
	}

	public void setCompilationService(CompilationService compilationService) {
		this.compilationService = compilationService;
	}

	public ModelMapper getModelMapper() {
		return modelMapper;
	}

	public void setModelMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	/*********************************************************************************************/

	//Mapper
	private CompilationDTO convertEntityToDto(Compilation compilation) {
		modelMapper.getConfiguration()
		.setMatchingStrategy(MatchingStrategies.LOOSE);
		CompilationDTO compilationDTO = new CompilationDTO();
		compilationDTO = modelMapper.map(compilation, CompilationDTO.class);

		//Mapping
		String username = compilation.getUtente().getUsername();
		compilationDTO.setId_utente(username);
		return compilationDTO;
	}

	private Compilation convertDtoToEntity(CompilationDTO compilationDTO) {
		modelMapper.getConfiguration()
		.setMatchingStrategy(MatchingStrategies.LOOSE);
		Compilation compilation = new Compilation();
		compilation = modelMapper.map(compilationDTO, Compilation.class);

		//Mapping
		String username = compilationDTO.getId_utente();
		Optional<User> userOptional = this.userService.getUtente(username);

		User utente = null;
		if(!userOptional.isEmpty())
			utente = userOptional.get();
		compilation.setUtente(utente);
		return compilation;
	}

}
