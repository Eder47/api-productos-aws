package com.producto.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.producto.demo.dto.ProductoDto;
import com.producto.demo.service.ProductoService;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "http://localhost:5173")
public class ProductoController {
	
    @Autowired
    private ProductoService productoService;
    
    @GetMapping
    public ResponseEntity<List<ProductoDto>> listar() {
        return ResponseEntity.ok(productoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(productoService.buscarPorId(id));
    }

    @PostMapping("/guardar")
    public ResponseEntity<ProductoDto> guardar(@RequestBody ProductoDto productoDto) {
        ProductoDto guardado = productoService.guardar(productoDto);
        return new ResponseEntity<>(guardado, HttpStatus.CREATED);
    }

    @PutMapping("actualizar/{id}")
    public ResponseEntity<ProductoDto> actualizar(@PathVariable Long id, @RequestBody ProductoDto productoDto) {
        productoDto.setId(id); 
        ProductoDto actualizado = productoService.actualizar(productoDto);
        return ResponseEntity.ok(actualizado);
    }
    
    @GetMapping("/test-1")
    public ResponseEntity<String> test() {
        return new ResponseEntity<>("Test Exitoso 1", HttpStatus.CREATED);
    }
    
    @GetMapping("/test-2")
    public ResponseEntity<String> testTest() {
        return new ResponseEntity<>("Test Exitoso 2", HttpStatus.CREATED);
    }

}
