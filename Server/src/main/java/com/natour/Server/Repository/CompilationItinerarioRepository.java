package com.natour.Server.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.natour.Server.Model.CompilationItinerario;

@Repository
public interface CompilationItinerarioRepository extends JpaRepository<CompilationItinerario,Long>{}
