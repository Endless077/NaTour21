package com.natour.Server.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.natour.Server.Model.FotoItinerario;

@Repository
public interface FotoItinerarioRepository extends JpaRepository<FotoItinerario,Long> {}
