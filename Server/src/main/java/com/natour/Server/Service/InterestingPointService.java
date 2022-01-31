package com.natour.Server.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.natour.Server.Model.InterestingPoint;
import com.natour.Server.Repository.InterestingPointRepository;
import com.natour.Server.ServiceInterface.IInterestingPointService;

@Service("mainInterestingPointService")
public class InterestingPointService implements IInterestingPointService {

	@Autowired
	private InterestingPointRepository interestinpointRep;

	/*********************************************************************************************/

	//Constructor
	@Autowired
	public InterestingPointService() {}

	/*********************************************************************************************/

	//Methods
	public List<InterestingPoint> getAllInterestinPoint() {
		return this.interestinpointRep.findAll();
	}

	/*********************************************************************************************/

	//Getter e Setter
	public InterestingPointRepository getInterestinpointRep() {
		return interestinpointRep;
	}

	/*********************************************************************************************/
}
