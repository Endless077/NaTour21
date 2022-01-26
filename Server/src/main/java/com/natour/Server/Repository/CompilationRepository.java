package com.natour.Server.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.natour.Server.Model.Compilation;

public interface CompilationRepository extends JpaRepository<Compilation, Long> {

}
