package com.natour.Server.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.natour.Server.Model.FotoInterestingPoint;

@Repository
public interface FotoInterestingPointRepository extends JpaRepository<FotoInterestingPoint,Long> {}
