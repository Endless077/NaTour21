package com.natour.Server.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.natour.Server.Model.Itinerario;
import com.natour.Server.Service.ItinerarioService;

@RestController
@RequestMapping("api/itinerario")
public class ItinerarioController {
	
	private ItinerarioService itinerarioService;
	
	//Constructor
	@Autowired
	public ItinerarioController(ItinerarioService itinerarioService) {
		super();
		this.itinerarioService = itinerarioService;
	}
	
	public ItinerarioController() {}

	//Get Mapping
	@GetMapping("listaItinerari")
	public List<Itinerario> getAll() {
		return this.itinerarioService.getAllItinerari();
	}
	
}
