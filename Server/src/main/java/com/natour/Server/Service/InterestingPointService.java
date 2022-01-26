package com.natour.Server.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.natour.Server.Model.InterestingPoint;
import com.natour.Server.Repository.InterestingPointRepository;

@Service
public class InterestingPointService {


	private final InterestingPointRepository interestinpointRep;

	//Constructor
	@Autowired
	public InterestingPointService(InterestingPointRepository interestinpointRep) {
		super();
		this.interestinpointRep = interestinpointRep;
	}

	//Methods
	public List<InterestingPoint> getAllInterestinPoint() {
		return this.interestinpointRep.findAll();
	}
}
