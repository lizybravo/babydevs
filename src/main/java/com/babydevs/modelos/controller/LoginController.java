package com.babydevs.modelos.controller;

import javax.servlet.ServletException;
import java.util.Calendar;
import java.util.Date;
import io.jsonwebtoken.Jwts;

import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.babydevs.modelos.config.JwtFilter;
import com.babydevs.modelos.model.Token;
import com.babydevs.modelos.model.Asesorado;
import com.babydevs.modelos.service.AsesoradoService;

@RestController
@RequestMapping(path="/api/login")
public class LoginController {
	private final AsesoradoService asesoradoService; 
	
	@Autowired
	public LoginController(AsesoradoService asesoradoService) {
		this.asesoradoService = asesoradoService;
	}//constructor
	
	@PostMapping
	public Token loginAsesorado(@RequestBody Asesorado asesorado) throws ServletException {
		if(asesoradoService.validateAsesorado(asesorado)) {
			System.out.println("asesorado válido" + asesorado.getEmail());
			return new Token(generateToken(asesorado.getEmail()));
		}//if
		throw new ServletException("Nombre de usuario o contraseña incorrectos");
	}//loginUsuario
	
	private String generateToken(String username) {
		Calendar calendar = Calendar.getInstance();//Fecha hora actual
		calendar.add(Calendar.HOUR, 10); // Pruebas
		//calendar.add(Calendar.MINUTE, 30);// Producción
		return Jwts.builder().setSubject(username).claim("role", "user")
		.setIssuedAt(new Date())
		.setExpiration(calendar.getTime())
		.signWith(SignatureAlgorithm.HS256, JwtFilter.secret)
		.compact();
	}//generateToken

}//Class LoginController
