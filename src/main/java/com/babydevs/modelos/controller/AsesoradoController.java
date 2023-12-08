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
import org.springframework.web.bind.annotation.RestController;

import com.babydevs.modelos.model.ChangePassword;
import com.babydevs.modelos.model.Asesorado;
import com.babydevs.modelos.service.AsesoradoService;

@RestController
@RequestMapping(path="/api/asesorados/")//http://localhost:8080/api/asesorados/
public class AsesoradoController {
	
	private final AsesoradoService asesoradoService;
	@Autowired
	public AsesoradoController(AsesoradoService asesoradoService) {
		this.asesoradoService = asesoradoService;
	}//constructor
	
	@GetMapping  // http://localhost:8080/api/asesorados/
	public List<Asesorado> getAllAsesorados(){
		return asesoradoService.getAllAsesorados();
	}//getAllAsesorados
	
	@GetMapping(path="{aseId}")  // http://localhost:8080/api/productos/1
	public Asesorado getAsesorado(@PathVariable("aseId") long id) {
		return asesoradoService.getAsesorado(id);
		
	}//getAsesorado
	
	@DeleteMapping(path="{aseId}")  // http://localhost:8080/api/productos/
	public Asesorado deleteAsesorado(@PathVariable("aseId") long id) {
		return asesoradoService.deleteAsesorado(id);
		
	}//deleteAsesorado
	
	@PostMapping
	public Asesorado addAsesorado(@RequestBody Asesorado asesorado){
		return asesoradoService.addAsesorado(asesorado);
	}//addAsesorado
	
	@PutMapping(path="{aseId}")
	public Asesorado updateAsesorado(@PathVariable("aseId") long id,
			@RequestBody ChangePassword changePassword
			) {
		return asesoradoService.updateAsesorado(id,  changePassword);
	}//updateAsesorado
	
}//class AsesorController
