package com.babydevs.modelos.service;

import java.util.List;
import java.util.Optional;

import com.babydevs.modelos.model.Asesor;
import com.babydevs.modelos.repository.AsesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsesorService {

	private final AsesorRepository asesorRepository;	
	
	@Autowired
	public AsesorService(AsesorRepository asesorRepository) {
		this.asesorRepository = asesorRepository;
	}//constructor
	
	public List<Asesor> getAllAsesores() {
		return asesorRepository.findAll();
	}//getAllAsesores
	
	public Asesor getAsesor(long id) {
		return asesorRepository.findById(id).orElseThrow(
				()-> new IllegalArgumentException("El Producto con el id ["
						+ id + "] no existe")
				);
	}//getAsesor
	
	public Asesor deleteAsesor(long id) {
		Asesor ases=null;
		if(asesorRepository.existsById(id)) {
			ases = asesorRepository.findById(id).get();
			asesorRepository.deleteById(id);
		}//if existId
		return ases;
	}//deleteAsesor
	
	public Asesor addAsesor(Asesor asesor) {
		Optional<Asesor> tmpAses = asesorRepository.findByNombre(asesor.getNombre());
		if(tmpAses.isEmpty()) {//no se encuentra el producto con ese nombre
			return asesorRepository.save(asesor);
		}else {
			System.out.println("Ya existe el producto con el nombre ["
					+ asesor.getNombre() +"]");
			return null;
		}//else
	}//addAsesor
	
	public Asesor updateAsesor(long id, String nombre, String descripcion, String habilidad_principal,
			String habilidades_secundarias, Double tarifa_por_asesoria, String fecha_de_inicio) {
		Asesor ases=null;
		if(asesorRepository.existsById(id)) {
			ases = asesorRepository.findById(id).get();
				if(nombre!= null) ases.setNombre(nombre);
				if(descripcion!=null) ases.setDescripcion(descripcion);
				if(habilidad_principal!=null) ases.setHabilidad_principal(habilidad_principal);
				if(habilidades_secundarias!=null) ases.setHabilidades_secundarias(habilidades_secundarias);
				if(tarifa_por_asesoria!=null) ases.setTarifa_por_asesoria(tarifa_por_asesoria);
				if(fecha_de_inicio!=null)ases.setFecha_de_inicio(fecha_de_inicio);
				asesorRepository.save(ases);
		}//existById
		return ases;
	}//updateAsesor

}//class AsesorService
