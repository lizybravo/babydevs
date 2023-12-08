package com.babydevs.modelos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.babydevs.modelos.model.Asesoria;

@Repository
public interface AsesoriaRepository extends JpaRepository<Asesoria, Long>{
	Optional<Asesoria> findByNombre(String nombre);
}//interface AsesoriaRepository
