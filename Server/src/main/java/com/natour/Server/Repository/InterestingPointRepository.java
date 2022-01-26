package com.natour.Server.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.natour.Server.Model.InterestingPoint;

@Repository
public interface InterestingPointRepository extends JpaRepository<InterestingPoint,Long> {}
