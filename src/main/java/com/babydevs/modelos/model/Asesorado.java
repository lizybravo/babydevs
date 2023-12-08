package com.babydevs.modelos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//POJO Plain Old Java Object
@Entity
@Table(name="asesorados")
public class Asesorado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique = true, nullable = false)
	private Long id;
	@Column(nullable = false)
	private String email; 
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private String nombre; 
	@Column(nullable = false)
	private String edad;
	@Column(nullable = false)
	private String nivel_de_estudios;
	@Column(nullable = false)
	private String ocupacion;
	@Column(nullable = false)
	private String locacion;
	

	public Asesorado(Long id,  String email, String password, String nombre, String edad, String nivel_de_estudios,
			String ocupacion,  String locacion) {

		 this.email = email;
		 this.password = password;
		this.nombre = nombre;
		this.edad = edad;
		this.nivel_de_estudios = nivel_de_estudios;
		this.ocupacion = ocupacion;
		this.locacion = locacion;

	}//constructor
 
	 public Asesorado() {

	 }//constructor
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getNivel_de_estudios() {
		return nivel_de_estudios;
	}

	public void setNivel_de_estudios(String nivel_de_estudios) {
		this.nivel_de_estudios = nivel_de_estudios;
	}

	public String getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}

	public String getLocacion() {
		return locacion;
	}

	public void setLocacion(String locacion) {
		this.locacion = locacion;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Asesor [id=" + id + ", email=" + email + ", password=" + password + ", nombre=" + nombre + ", edad=" + edad + ", nivel_de_estudios="
				+ nivel_de_estudios + ", ocupacion=" + ocupacion
				+  ", locacion=" + locacion + "]";
	}//ToString
	
	
	
	
}//classAsesorado
