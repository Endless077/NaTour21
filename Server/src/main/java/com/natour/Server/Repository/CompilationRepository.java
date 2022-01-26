package com.natour.Server.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.natour.Server.Model.Compilation;

@Repository
public interface CompilationRepository extends JpaRepository<Compilation,Long> {}
