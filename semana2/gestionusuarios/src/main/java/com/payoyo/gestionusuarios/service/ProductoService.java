package com.payoyo.gestionusuarios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.payoyo.gestionusuarios.dto.ProductoRequestDTO;
import com.payoyo.gestionusuarios.dto.ProductoResponseDTO;
import com.payoyo.gestionusuarios.entity.Producto;
import com.payoyo.gestionusuarios.mapper.ProductoMapper;
import com.payoyo.gestionusuarios.repository.ProductoRepository;

public class ProductoService implements IProductoService{

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public ProductoResponseDTO crearProducto(ProductoRequestDTO request) {
        //pasar a entidad
        Producto producto = ProductoMapper.toEntity(request);

        //guardamos en db
        Producto productoGuardado = productoRepository.save(producto);

        //devolvemos el dto
        return ProductoMapper.toDto(productoGuardado);
    }

    @Override
    public List<ProductoResponseDTO> listarProductos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarProductos'");
    }

    @Override
    public ProductoResponseDTO obtenerProducto(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerProducto'");
    }

    @Override
    public ProductoResponseDTO actualizarProducto(Long id, ProductoRequestDTO request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizarProducto'");
    }

    @Override
    public void eliminarProducto(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarProducto'");
    }
    
}
