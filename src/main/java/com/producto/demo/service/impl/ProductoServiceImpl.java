package com.producto.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.producto.demo.dto.ProductoDto;
import com.producto.demo.entity.Producto;
import com.producto.demo.repository.ProductoRepository;
import com.producto.demo.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService{
	
	@Autowired
	private ProductoRepository productoRepository;
	
	@Autowired
	private ModelMapper modelMapper;

    public List<ProductoDto> listar() {
        return productoRepository.findAll()
                .stream()
                .map(producto -> modelMapper.map(producto, ProductoDto.class))
                .collect(Collectors.toList());
    }

    public ProductoDto guardar(ProductoDto productoDto) {
        Producto producto = modelMapper.map(productoDto, Producto.class);
        Producto guardado = productoRepository.save(producto);
        return modelMapper.map(guardado, ProductoDto.class);
    }

    public ProductoDto actualizar(ProductoDto productoDto) {
    	
        Producto existente = productoRepository.findById(productoDto.getId())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con id: " + productoDto.getId()));

        existente.setNombre(productoDto.getNombre());
        existente.setNumeroLote(productoDto.getNumeroLote());

        Producto actualizado = productoRepository.save(existente);
        return modelMapper.map(actualizado, ProductoDto.class);
    }

    public ProductoDto buscarPorId(Long id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con id: " + id));
        return modelMapper.map(producto, ProductoDto.class);
    }

}
