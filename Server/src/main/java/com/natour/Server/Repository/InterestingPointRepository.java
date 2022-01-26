package com.natour.Server.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.natour.Server.Model.InterestingPoint;

public interface InterestingPointRepository extends JpaRepository<InterestingPoint,Long> {}