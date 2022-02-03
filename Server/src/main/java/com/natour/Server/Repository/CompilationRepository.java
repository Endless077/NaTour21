package com.natour.Server.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.natour.Server.Model.Compilation;

@Repository
public interface CompilationRepository extends JpaRepository<Compilation,Long> {

	@Query(value = "SELECT * FROM compilation c WHERE c.id_utente = ?1", nativeQuery = true)
	List<Compilation> findByUsername(String username);
	
	@Query(value = "SELECT i.id_itinerario, i.titolo, i.areageografica, i.difficulty, i.id_utente"
			+" FROM compilation_itinerario_map AS c JOIN itinerario AS i ON c.id_itinerario_map = i.id_itinerario"
			+" WHERE id_compilation_map = ?1", nativeQuery = true)
	List<String> getItinerarioInCompilation(Long idCompilation);
	
	@Query(value = "INSERT INTO compilation_itinerario_map VALUES (?1,?2)", nativeQuery = true)
	void insertItinerarioInCompilation(Long idCompilation, Long idItinerario);
	
	@Query(value = "SELECT FROM compilation_itinerario_map i WHERE i.id_compilation_map = ?1 AND i.id_itinerario_map = ?2", nativeQuery = true)
	Optional<String> ifExistIC(Long idCompilation, Long idItinerario);
	
	@Query(value = "DELETE FROM compilation_itinerario_map WHERE id_compilation_map = ?1 AND id_itinerario_map = ?2", nativeQuery = true)
	void deleteItinerarioInCompilation(Long idCompilation, Long idItinerario);

}
