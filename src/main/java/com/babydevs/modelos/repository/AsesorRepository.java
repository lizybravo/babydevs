package com.babydevs.modelos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.babydevs.modelos.model.Asesor;

@Repository
public interface AsesorRepository extends JpaRepository<Asesor, Long>{
	Optional<Asesor> findByNombre(String nombre);
}//interface ProductoRepository
