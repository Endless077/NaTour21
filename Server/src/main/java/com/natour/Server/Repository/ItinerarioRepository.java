package com.natour.Server.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.natour.Server.Model.Itinerario;

@Repository
public interface ItinerarioRepository extends JpaRepository<Itinerario,Long> {}
