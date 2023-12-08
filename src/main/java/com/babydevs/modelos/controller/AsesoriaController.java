package com.babydevs.modelos.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.babydevs.modelos.model.Asesoria;
import com.babydevs.modelos.service.AsesoriaService;

@RestController
@RequestMapping(path="/api/asesorias/")//http://localhost:8080/api/asesorias/
public class AsesoriaController {
	private final AsesoriaService asesoriaService;
	@Autowired
	public AsesoriaController(AsesoriaService asesoriaService) {
		this.asesoriaService = asesoriaService;
	}//constructor
	
	@GetMapping  // http://localhost:8080/api/asesorias/
	public List<Asesoria> getAllAsesorias(){
		return asesoriaService.getAllAsesorias();
	}//getAllAsesorias
	
	@GetMapping(path="{aseId}")  // http://localhost:8080/api/asesorias/1
	public Asesoria getAsesoria(@PathVariable("aseId") long id) {
		return asesoriaService.getAsesoria(id);
		
	}//getAsesoria
	
	@DeleteMapping(path="{aseId}")  // http://localhost:8080/api/asesorias/
	public Asesoria deleteAsesoria(@PathVariable("aseId") long id) {
		return asesoriaService.deleteAsesoria(id);
		
	}//deleteAsesoria
	
	@PostMapping
	public Asesoria addAsesoria(@RequestBody Asesoria asesoria){
		return asesoriaService.addAsesoria(asesoria);
	}//addAsesoria
	
	@PutMapping(path="{aseId}")
	public Asesoria updateAsesoria(@PathVariable("aseId") long id,
			@RequestParam(required=false) String nombre,
			@RequestParam(required=false) String materia,
			@RequestParam(required=false) String duracion
			) {
		return asesoriaService.updateAsesoria(id, nombre, materia, duracion);
	}//updateAsesoria
	
}//class AsesorController
