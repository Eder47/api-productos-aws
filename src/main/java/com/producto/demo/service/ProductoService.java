package com.producto.demo.service;

import java.util.List;

import com.producto.demo.dto.ProductoDto;

public interface ProductoService {
	
	List<ProductoDto> listar();
	ProductoDto guardar(ProductoDto productoDto);
	ProductoDto actualizar(ProductoDto productoDto);
	ProductoDto buscarPorId(Long id);

}
