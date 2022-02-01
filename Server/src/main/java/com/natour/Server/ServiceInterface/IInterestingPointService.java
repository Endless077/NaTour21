package com.natour.Server.ServiceInterface;

import java.util.List;
import java.util.Optional;

import com.natour.Server.Model.InterestingPoint;

public interface IInterestingPointService {

	//Methods GET
	List<InterestingPoint> getAllInterestinPoint();
	Optional<InterestingPoint> getInterestingPointByID(Long idinterestingpoint);
	List<InterestingPoint> getInterestingPointByItinerario(Long iditinerario);
	
	//Methods POST
	boolean creaInterestingPoint(InterestingPoint interestingPoint);
	
	//Methods PUT
	boolean modificaInterestingPoint(InterestingPoint interestingPoint);
	
	//Methods DELETE
	boolean cancellaInterestingPoint(Long idInterestingPoint);
	boolean cancellaFotoInterestingPoint(Long idInterestingPoint);
	

}
