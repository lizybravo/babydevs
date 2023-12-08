package com.babydevs.modelos.service;

import java.util.List;
import java.util.Optional;

import com.babydevs.modelos.model.Asesoria;
import com.babydevs.modelos.repository.AsesoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsesoriaService {

	private final AsesoriaRepository asesoriaRepository;	
	
	@Autowired
	public AsesoriaService(AsesoriaRepository asesoriaRepository) {
		this.asesoriaRepository = asesoriaRepository;
	}//constructor
	
	public List<Asesoria> getAllAsesorias() {
		return asesoriaRepository.findAll();
	}//getAllAsesorias
	
	public Asesoria getAsesoria(long id) {
		return asesoriaRepository.findById(id).orElseThrow(
				()-> new IllegalArgumentException("La asesoria con el id ["
						+ id + "] no existe")
				);
	}//getAsesoria
	
	public Asesoria deleteAsesoria(long id) {
		Asesoria ases=null;
		if(asesoriaRepository.existsById(id)) {
			ases = asesoriaRepository.findById(id).get();
			asesoriaRepository.deleteById(id);
		}//if existId
		return ases;
	}//deleteAsesoria
	
	public Asesoria addAsesoria(Asesoria asesoria) {
		Optional<Asesoria> tmpAses = asesoriaRepository.findByNombre(asesoria.getNombre());
		if(tmpAses.isEmpty()) {//no se encuentra el producto con ese nombre
			return asesoriaRepository.save(asesoria);
		}else {
			System.out.println("Ya existe la asesoria con el nombre ["
					+ asesoria.getNombre() +"]");
			return null;
		}//else
	}//addAsesoria
	
	public Asesoria updateAsesoria(long id, String nombre, String materia, String duracion) {
		Asesoria ases=null;
		if(asesoriaRepository.existsById(id)) {
			ases = asesoriaRepository.findById(id).get();
				if(nombre!= null) ases.setNombre(nombre);
				if(materia!=null) ases.setMateria(materia);
				if (duracion!=null) ases.setDuracion(duracion);
				asesoriaRepository.save(ases);
		}//existById
		return ases;
	}//updateAsesor

}//class AsesorService
