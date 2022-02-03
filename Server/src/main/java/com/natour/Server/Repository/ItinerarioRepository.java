package com.natour.Server.Repository;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.natour.Server.Model.Itinerario;

@Repository
public interface ItinerarioRepository extends JpaRepository<Itinerario,Long> {
	
	@Query(value = "SELECT * FROM itinerario i WHERE i.id_utente = ?1", nativeQuery = true)
	List<Itinerario> findByUsername(String username);
	
	@Query(value = "SELECT * FROM itinerario ORDER BY  ", nativeQuery = true)
	List<Itinerario> findAllByRecent();
	
	@Query(value = "SELECT * FROM itinerario i WHERE UPPER(i.titolo) LIKE concat('%', UPPER(?1), '%')", nativeQuery = true)
	List<Itinerario> findAllByName(String nomeItinerario);
	
	@Query(value = "SELECT * FROM itinerario i WHERE UPPER(i.titolo) LIKE concat('%', UPPER(:nome), '%')"
					+" AND UPPER(i.puntoinizio) LIKE concat('%', UPPER(:puntoinizio), '%')"
					+" AND UPPER(i.puntofine) LIKE concat('%', UPPER(:puntofine), '%')"
					+" AND i.durata <= :durata"
					+" AND i.lunghezza <= :lunghezza"
					+" AND i.difficulty LIKE %:difficulty%"
					+" AND (i.accessodisabili = 'true' OR i.accessodisabili = :accessoDisabili)"
					+" AND i.areageografica LIKE %:areageografica%"
					+" ORDER BY id_itinerario DESC", nativeQuery = true)
	List<Itinerario> findByFilter(@Param(value = "nome")String nome,
									@Param(value = "puntoinizio")String puntoinizio,
									@Param(value = "puntofine")String puntofine,
									@Param(value = "durata")Timestamp durata,
									@Param(value = "lunghezza")double lunghezza,
									@Param(value = "difficulty")String difficulty,
									@Param(value = "accessoDisabili")boolean accessoDisabili,
									@Param(value = "areageografica")String areageografica);
}
