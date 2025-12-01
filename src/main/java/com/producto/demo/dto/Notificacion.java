package com.producto.demo.dto;

import java.util.Date;

import lombok.Data;

@Data
public class Notificacion {
	
	private String canal;
	private Date fechaEnvio;
	private String asunto;
	private String descripcion;

}
