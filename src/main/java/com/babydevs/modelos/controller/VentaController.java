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

import com.babydevs.modelos.model.Venta;
import com.babydevs.modelos.service.VentaService;

@RestController
@RequestMapping(path="/api/ventas/")//http://localhost:8080/api/ventas/
public class VentaController {
	private final VentaService ventaService;
	@Autowired
	public VentaController(VentaService ventaService) {
		this.ventaService = ventaService;
	}//constructor
	
	@GetMapping  // http://localhost:8080/api/productos/
	public List<Venta> getAllVentas(){
		return ventaService.getAllVentas();
	}//getAllVentas
	
	@GetMapping(path="{ventId}")  // http://localhost:8080/api/ventas/1
	public Venta getVenta(@PathVariable("ventId") long id) {
		return ventaService.getVenta(id);
		
	}//getVenta
	
	@DeleteMapping(path="{ventId}")  // http://localhost:8080/api/ventas/
	public Venta deleteVenta(@PathVariable("ventId") long id) {
		return ventaService.deleteVenta(id);
		
	}//deleteVenta
	
	@PostMapping
	public Venta addVenta(@RequestBody Venta venta){
		return ventaService.addVenta(venta);
	}//addVenta
	
	@PutMapping(path="{ventId}")
	public Venta updateVenta(@PathVariable("ventId") long id,
			@RequestParam(required=false) String fecha_y_hora,
			@RequestParam(required=false) String metodo_de_pago,
			@RequestParam(required=false) Double total,
			@RequestParam(required=false) Double impuestos,
			@RequestParam(required=false) Double comision_babydevs,
			@RequestParam(required=false) Double comision_asesor
			) {
		return ventaService.updateVenta(id, fecha_y_hora, metodo_de_pago, total, 
				impuestos, comision_babydevs, comision_asesor);
	}//updateVenta
	
}//class VentaController
