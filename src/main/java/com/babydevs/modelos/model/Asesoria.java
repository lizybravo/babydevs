package com.babydevs.modelos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//POJO Plain Old Java Object
@Entity
@Table(name="asesorias")
public class Asesoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique = true, nullable = false)
	private Long id;
	@Column(nullable = false)
	private String nombre; 
	@Column(nullable = false)
	private String materia;
	@Column(nullable = false)
	private String duracion;

	

	public Asesoria(Long id, String nombre, String materia, String duracion) {

		this.nombre = nombre;
		this.materia = materia;
		this.duracion = duracion;

	}//constructor
 
	 public Asesoria() {

	 }//constructor
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMateria() {
		return materia;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Asesor [id=" + id + ", nombre=" + nombre + ", materia=" + materia + ", duracion="
				+ duracion + "]";
	}//ToString
	
	
	
	
}//classAsesoria
