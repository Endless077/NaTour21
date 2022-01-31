package com.natour.Server.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.natour.Server.Model.Tappa;
import com.natour.Server.Repository.TappaRepository;
import com.natour.Server.ServiceInterface.ITappaService;

@Service("mainTappaService")
public class TappaService implements ITappaService{
	
	@Autowired
	private TappaRepository tappaRep;

	/*********************************************************************************************/

	//Constructor
	public TappaService() {}

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
