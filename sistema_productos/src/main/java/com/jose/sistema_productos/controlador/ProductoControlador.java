package com.jose.sistema_productos.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.jose.sistema_productos.dto.ProductoDTO;
import com.jose.sistema_productos.servicio.IProductoServicio;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "*")
public class ProductoControlador {

    @Autowired
    private IProductoServicio productoServicio;

    // 1. Listar todos los productos
    @GetMapping
    public List<ProductoDTO> listarProductos() {
        return productoServicio.listarProductos();
    }

    // 2. Buscar producto por ID
    @GetMapping("/{id}")
    public ProductoDTO obtenerProductoPorId(@PathVariable Long id) {
        return productoServicio.obtenerProductoPorId(id);
    }

    // 3. Crear producto
    @PostMapping
    public ProductoDTO crearProducto(@Valid @RequestBody ProductoDTO productoDTO) {
        return productoServicio.crearProducto(productoDTO);
    }

    // 4. Actualizar producto
    @PutMapping("/{id}")
    public ProductoDTO actualizarProducto(@PathVariable Long id, @Valid @RequestBody ProductoDTO productoDTO) {
        return productoServicio.actualizarProducto(id, productoDTO);
    }

    // 5. Eliminar producto
    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable Long id) {
        productoServicio.eliminarProducto(id);
    }
}
