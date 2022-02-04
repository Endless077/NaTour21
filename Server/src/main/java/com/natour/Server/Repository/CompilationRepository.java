package com.natour.Server.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.natour.Server.Model.Compilation;

@Repository
public interface CompilationRepository extends JpaRepository<Compilation,Long> {

	@Query(value = "SELECT * FROM compilation c WHERE c.id_utente = :username", nativeQuery = true)
	List<Compilation> findByUsername(@Param(value = "username") String username);
	
	@Query(value = "SELECT i.id_itinerario, i.titolo, i.areageografica, i.difficulty, i.id_utente"
			+" FROM compilation_itinerario_map AS c JOIN itinerario AS i ON c.id_itinerario_map = i.id_itinerario"
			+" WHERE id_compilation_map = :idCompilation", nativeQuery = true)
	List<String> getItinerarioInCompilation(@Param(value = "idCompilation") long idCompilation);
	
	@Query(value = "INSERT INTO compilation_itinerario_map VALUES (:idCompilation,:idItinerario)", nativeQuery = true)
	void insertItinerarioInCompilation(@Param(value = "idCompilation") long idCompilation,
									  	@Param(value = "idItinerario") long idItinerario);
	
	@Query(value = "SELECT *"
			+ " FROM compilation_itinerario_map i"
			+ " WHERE i.id_compilation_map = :idCompilation AND i.id_itinerario_map = :idItinerario", nativeQuery = true)
	Optional<String> ifExistIC(@Param(value = "idCompilation") long idCompilation,
							   	@Param(value = "idItinerario") long idItinerario);
	
	@Query(value = "DELETE FROM compilation_itinerario_map"
			+ " WHERE id_compilation_map = :idCompilation"
			+ " AND id_itinerario_map = :idItinerario", nativeQuery = true)
	void deleteItinerarioInCompilation(@Param(value = "idCompilation") long idCompilation, 
									   	@Param(value = "idItinerario") long idItinerario);

}
