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

import com.babydevs.modelos.model.Asesor;
import com.babydevs.modelos.service.AsesorService;

@RestController
@RequestMapping(path="/api/asesores/")//http://localhost:8080/api/asesores/
public class AsesorController {
	private final AsesorService asesorService;
	@Autowired
	public AsesorController(AsesorService asesorService) {
		this.asesorService = asesorService;
	}//constructor
	
	@GetMapping  // http://localhost:8080/api/productos/
	public List<Asesor> getAllAsesores(){
		return asesorService.getAllAsesores();
	}//getAllProductos
	
	@GetMapping(path="{aseId}")  // http://localhost:8080/api/productos/1
	public Asesor getAsesor(@PathVariable("aseId") long id) {
		return asesorService.getAsesor(id);
		
	}//getAsesor
	
	@DeleteMapping(path="{aseId}")  // http://localhost:8080/api/productos/
	public Asesor deleteAsesor(@PathVariable("aseId") long id) {
		return asesorService.deleteAsesor(id);
		
	}//deleteAsesor
	
	@PostMapping
	public Asesor addAsesor(@RequestBody Asesor asesor){
		return asesorService.addAsesor(asesor);
	}//addProducto
	
	@PutMapping(path="{aseId}")
	public Asesor updateAsesor(@PathVariable("aseId") long id,
			@RequestParam(required=false) String nombre,
			@RequestParam(required=false) String descripcion,
			@RequestParam(required=false) String habilidad_principal,
			@RequestParam(required=false) String habilidades_secundarias,
			@RequestParam(required=false) Double tarifa_por_asesoria,
			@RequestParam(required=false) String fecha_de_inicio
			) {
		return asesorService.updateAsesor(id, nombre, descripcion, habilidad_principal, habilidades_secundarias,
											tarifa_por_asesoria, fecha_de_inicio);
	}//updateAsesor
	
}//class AsesorController
