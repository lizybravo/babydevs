package com.babydevs.modelos.service;

import java.util.List;
import com.babydevs.modelos.model.Venta;
import com.babydevs.modelos.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService {

	private final VentaRepository ventaRepository;	
	
	@Autowired
	public VentaService(VentaRepository ventaRepository) {
		this.ventaRepository = ventaRepository;
	}//constructor
	
	public List<Venta> getAllVentas() {
		return ventaRepository.findAll();
	}//getAllVentas
	
	public Venta getVenta(long id) {
		return ventaRepository.findById(id).orElseThrow(
				()-> new IllegalArgumentException("La venta con el id ["
						+ id + "] no existe")
				);
	}//getVenta
	
	public Venta deleteVenta(long id) {
		Venta vent=null;
		if(ventaRepository.existsById(id)) {
			vent = ventaRepository.findById(id).get();
			ventaRepository.deleteById(id);
		}//if existId
		return vent;
	}//deleteVenta
	
	@SuppressWarnings("null")
	public Venta addVenta(Venta venta){
			return ventaRepository.save(venta);
	}//addVenta
	
	public Venta updateVenta(long id, String fecha_y_hora, String metodo_de_pago, 
			Double total, Double impuestos, Double comision_babydevs, Double comision_asesor) {
		Venta vent=null;
		if(ventaRepository.existsById(id)) {
			vent = ventaRepository.findById(id).get();
				if(fecha_y_hora!= null) vent.setFecha_y_hora(fecha_y_hora);
				if(metodo_de_pago!=null) vent.setMetodo_de_pago(metodo_de_pago);
				if (total!=null) vent.setTotal(total);
				if(impuestos!=null) vent.setImpuestos(impuestos);
				if(comision_babydevs!=null) vent.setComision_babydevs(comision_babydevs);
				if(comision_asesor!=null) vent.setComision_asesor(comision_asesor);
				ventaRepository.save(vent);
		}//existById
		return vent;
	}//updateVenta

}//class VentaService
