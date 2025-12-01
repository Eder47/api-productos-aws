package com.producto.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.producto.demo.dto.ReponseSolicitudDto;



@RestController
@RequestMapping("/solicitudes-notificacion")
public class CotrollerNotificacio {
	
	public ResponseEntity<ReponseSolicitudDto> solicitarNotificacion(RequestBody dto){
		return ResponseEntity.ok(null);
	}

}
