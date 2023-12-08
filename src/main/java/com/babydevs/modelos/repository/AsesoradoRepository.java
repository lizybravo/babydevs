package com.babydevs.modelos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.babydevs.modelos.model.Asesorado;

@Repository
public interface AsesoradoRepository extends JpaRepository<Asesorado, Long>{
	Optional<Asesorado> findByEmail(String email);
}//interface AsesoradoRepository
