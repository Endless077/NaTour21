package com.natour.Server.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.natour.Server.Model.Itinerario;

@Repository
public interface ItinerarioRepository extends JpaRepository<Itinerario,Long> {
	
	@Query(value = "SELECT * FROM itinerario i WHERE i.id_utente = ?1", nativeQuery = true)
	List<Itinerario> findByUsername(String username);
	
	@Query(value = "SELECT * FROM itinerario ORDER BY id_itinerario DESC", nativeQuery = true)
	List<Itinerario> findAllByRecent();
	
	@Query(value = "SELECT * FROM itinerario i WHERE i.titolo = ?1", nativeQuery = true)
	List<Itinerario> findAllByName(String nomeItinerario);
}
