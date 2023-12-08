package com.babydevs.modelos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.babydevs.modelos.model.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long>{
	Optional<Venta> findById(Long id);
}//interface VentaRepository
