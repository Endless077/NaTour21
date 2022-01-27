package com.natour.Server.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.natour.Server.Model.Tappa;
import com.natour.Server.Repository.TappaRepository;

@Service("mainTappaService")
public class TappaService {

	private final TappaRepository tappaRep;

	/*********************************************************************************************/

	//Constructor
	public TappaService(TappaRepository tappaRep) {
		super();
		this.tappaRep = tappaRep;
	}

	/*********************************************************************************************/

	//Methods
	public List<Tappa> getAllTappe() {
		return this.tappaRep.findAll();
	}

	/*********************************************************************************************/

	//Getter e Setter
	public TappaRepository getTappaRep() {
		return tappaRep;
	}

	/*********************************************************************************************/

}
