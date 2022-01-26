package com.natour.Server.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.natour.Server.Model.Tappa;
import com.natour.Server.Service.TappaService;

@RestController
@RequestMapping("api/tappa")
public class TappaController {

private TappaService tappaService;
	
	//Constructor
	@Autowired
	public TappaController(TappaService tappaService) {
		super();
		this.tappaService = tappaService;
	}
	
	public TappaController() {}

	//Get Mapping
	@GetMapping("listaTappe")
	public List<Tappa> getAll() {
		return this.tappaService.getAllTappe();
	}
	
}
