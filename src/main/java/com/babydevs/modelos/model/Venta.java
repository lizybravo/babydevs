package com.babydevs.modelos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//POJO Plain Old Java Object
@Entity
@Table(name="venta")
public class Venta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique = true, nullable = false)
	private Long id;
	@Column(nullable = false)
	private String fecha_y_hora; 
	@Column(nullable = false)
	private String metodo_de_pago;
	@Column(nullable = false)
	private Double total;
	@Column(nullable = false)
	private Double impuestos;
	@Column(nullable = false)
	private Double comision_babydevs;
	@Column(nullable = false)
	private Double comision_asesor;
	

	public Venta(Long id, String fecha_y_hora, String metodo_de_pago, Double total,
			Double impuestos, Double comision_babydevs, Double comision_asesor) {

		this.fecha_y_hora = fecha_y_hora;
		this.metodo_de_pago = metodo_de_pago;
		this.total = total;
		this.impuestos = impuestos;
		this.comision_babydevs = comision_babydevs;
		this.comision_asesor = comision_asesor;

	}//constructor
 
	 public Venta() {

	 }//constructor


	public String getFecha_y_hora() {
		return fecha_y_hora;
	}

	public void setFecha_y_hora(String fecha_y_hora) {
		this.fecha_y_hora = fecha_y_hora;
	}

	public String getMetodo_de_pago() {
		return metodo_de_pago;
	}

	public void setMetodo_de_pago(String metodo_de_pago) {
		this.metodo_de_pago = metodo_de_pago;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Double getImpuestos() {
		return impuestos;
	}

	public void setImpuestos(Double impuestos) {
		this.impuestos = impuestos;
	}

	public Double getComision_babydevs() {
		return comision_babydevs;
	}

	public void setComision_babydevs(Double comision_babydevs) {
		this.comision_babydevs = comision_babydevs;
	}

	public Double getComision_asesor() {
		return comision_asesor;
	}

	public void setComision_asesor(Double comision_asesor) {
		this.comision_asesor = comision_asesor;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Venta [id=" + id + ", fecha_y_hora=" + fecha_y_hora + ", metodo_de_pago=" + metodo_de_pago + ", total="
				+ total + ", comision_babydevs=" + comision_babydevs
				+ ", impuestos=" + impuestos + ", comision_asesor=" + comision_asesor + "]";
	}//ToString
	
	
	
	
}//classVenta
