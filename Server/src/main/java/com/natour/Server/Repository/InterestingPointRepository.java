package com.natour.Server.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.natour.Server.Model.InterestingPoint;

@Repository
public interface InterestingPointRepository extends JpaRepository<InterestingPoint,Long> {
	
	@Query(value = "SELECT * FROM interestingpoint i WHERE i.id_itinerario = ?1", nativeQuery = true)
	List<InterestingPoint> findByItinerario(long id_itinerario);
	
}
