package com.babydevs.modelos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.babydevs.modelos.model.ChangePassword;
import com.babydevs.modelos.model.Asesorado;
import com.babydevs.modelos.repository.AsesoradoRepository;

@Service
public class AsesoradoService {

	private final AsesoradoRepository asesoradoRepository;	
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	public AsesoradoService(AsesoradoRepository asesoradoRepository) {
		this.asesoradoRepository = asesoradoRepository;
	}//constructor
	
	public List<Asesorado> getAllAsesorados() {
		return asesoradoRepository.findAll();
	}//getAllAsesorados
	
	public Asesorado getAsesorado(Long id) {
		return asesoradoRepository.findById(id).orElseThrow(
				()-> new IllegalArgumentException("El Asesorado con el id ["
						+ id + "] no existe")
				);
	}//getAses
	
	public Asesorado deleteAsesorado(Long id) {
		Asesorado ases=null;
		if(asesoradoRepository.existsById(id)) {
			ases = asesoradoRepository.findById(id).get();
			asesoradoRepository.deleteById(id);
		}//if existId
		return ases;
	}//deleteAsesorado
	
	public Asesorado addAsesorado(Asesorado asesorado) {
		Asesorado ases = null;
		if(asesoradoRepository.findByEmail(asesorado.getEmail()).isEmpty()) {
			//cifrar la contraseña
			asesorado.setPassword(
			passwordEncoder.encode(asesorado.getPassword()));
			ases = asesoradoRepository.save(asesorado);
		}else {
			System.out.println("El asesorado con el email [" + asesorado.getEmail()
			+ "] ya se encuentra registrado");
		}//if is empty
		return ases;
	}//addAsesorado
	
	public Asesorado updateAsesorado(Long id, ChangePassword changePassword) {
		Asesorado ases=null;
		if(asesoradoRepository.existsById(id)) {
			ases = asesoradoRepository.findById(id).get();
			if(passwordEncoder.matches(changePassword.getPassword(), ases.getPassword())) {
				ases.setPassword(passwordEncoder.encode(changePassword.getNewPassword()));
				asesoradoRepository.save(ases);
			}else {
				System.out.println("updateAsesorado - El password es incorrecto id["+ id + "]");
				ases=null;
				
				}//if equals
			}else {
				System.out.println("updateAsesorado - El password con el id["+ 
						id + "] no se encuentra registrado");
				ases=null;
		}//else if exist
		return ases;
	}//updateAsesorado

	
	public boolean validateAsesorado(Asesorado asesorado) {
		Optional<Asesorado> userByEmail = asesoradoRepository.findByEmail(asesorado.getEmail());
		if(userByEmail.isPresent()) {
			Asesorado ases = userByEmail.get();
			if(ases.getPassword().equals(asesorado.getPassword())) {
				return true;
			}//if password equals
		}//if isPresent
		return false;
	}//validateUser
	
}//class AsesoradoService
