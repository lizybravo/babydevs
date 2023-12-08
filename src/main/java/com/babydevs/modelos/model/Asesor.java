package com.babydevs.modelos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//POJO Plain Old Java Object
@Entity
@Table(name="asesores")
public class Asesor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique = true, nullable = false)
	private Long id;
	@Column(nullable = false)
	private String nombre; 
	@Column(nullable = false)
	private String descripcion;
	@Column(nullable = false)
	private String habilidad_principal;
	@Column(nullable = false)
	private String habilidades_secundarias;
	@Column(nullable = false)
	private Double tarifa_por_asesoria;
	@Column(nullable = false)
	private String fecha_de_inicio;
	

	public Asesor(Long id, String nombre, String descripcion, String habilidad_principal,
			String habilidades_secundarias, Double tarifa_por_asesoria, String fecha_de_inicio) {

		this.nombre = nombre;
		this.descripcion = descripcion;
		this.habilidad_principal = habilidad_principal;
		this.habilidades_secundarias = habilidades_secundarias;
		this.tarifa_por_asesoria = tarifa_por_asesoria;
		this.fecha_de_inicio = fecha_de_inicio;

	}//constructor
 
	 public Asesor() {

	 }//constructor
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getHabilidad_principal() {
		return habilidad_principal;
	}

	public void setHabilidad_principal(String habilidad_principal) {
		this.habilidad_principal = habilidad_principal;
	}

	public String getHabilidades_secundarias() {
		return habilidades_secundarias;
	}

	public void setHabilidades_secundarias(String habilidades_secundarias) {
		this.habilidades_secundarias = habilidades_secundarias;
	}

	public Double getTarifa_por_asesoria() {
		return tarifa_por_asesoria;
	}

	public void setTarifa_por_asesoria(Double tarifa_por_asesoria) {
		this.tarifa_por_asesoria = tarifa_por_asesoria;
	}

	public String getFecha_de_inicio() {
		return fecha_de_inicio;
	}

	public void setFecha_de_inicio(String fecha_de_inicio) {
		this.fecha_de_inicio = fecha_de_inicio;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Asesor [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", habilidad_principal="
				+ habilidad_principal + ", habilidades_secundarias=" + habilidades_secundarias
				+ ", tarifa_por_asesoria=" + tarifa_por_asesoria + ", fecha_de_inicio=" + fecha_de_inicio + "]";
	}//ToString
	
	
	
	
}//classAsesor
