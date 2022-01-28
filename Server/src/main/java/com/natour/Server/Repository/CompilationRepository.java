package com.natour.Server.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.natour.Server.Model.Compilation;

@Repository
public interface CompilationRepository extends JpaRepository<Compilation,Long> {

	@Query(value = "SELECT * FROM compilation c WHERE c.id_utente = ?1", nativeQuery = true)
	List<Compilation> findByUsername(String username);
	
}
