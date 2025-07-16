package com.payoyo.gestion_ferreteria.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.payoyo.gestion_ferreteria.dto.CreateProductoDTO;
import com.payoyo.gestion_ferreteria.dto.ProductoResponseDTO;
import com.payoyo.gestion_ferreteria.exception.ProductoNoEncontradoException;
import com.payoyo.gestion_ferreteria.mapper.ProductoMapper;
import com.payoyo.gestion_ferreteria.model.Producto;
import com.payoyo.gestion_ferreteria.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements IProductoService{

    private final ProductoRepository productoRepository;
    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    //Crear producto
    @Override
    public ProductoResponseDTO crear(CreateProductoDTO dto) {
        // cambiamos a entidad
        Producto producto = ProductoMapper.toEntity(dto);

        //guardamos en la db
        Producto guardado = productoRepository.save(producto);

        //devolvemos entidad
        return ProductoMapper.toDTO(guardado);

    }

    //Listar todos los productos
    @Override
    public List<ProductoResponseDTO> buscarTodos() {
        return productoRepository.findAll()
            .stream()
            .map(ProductoMapper::toDTO)
            .collect(Collectors.toList());
    }

    //Listar producto por ID
    @Override
    public ProductoResponseDTO obtenerPorId(Long id) {
        Producto producto = productoRepository.findById(id)
            .orElseThrow(() -> new ProductoNoEncontradoException(id));
        
        return ProductoMapper.toDTO(producto);
    }

    @Override
    public void eliminar(Long id) {
        Producto producto = productoRepository.findById(id)
            .orElseThrow(() -> new ProductoNoEncontradoException(id));

        productoRepository.delete(producto);    
    }

    @Override
    public ProductoResponseDTO actualizar(Long id, CreateProductoDTO dto) {
        Producto productoExistente = productoRepository.findById(id)
            .orElseThrow(() -> new ProductoNoEncontradoException(id));

        productoExistente.setNombre(dto.getNombre());
        productoExistente.setCategoria(dto.getCategoria());
        productoExistente.setPrecio(dto.getPrecio());
        productoExistente.setStock(dto.getStock());

        Producto actualizado = productoRepository.save(productoExistente);
        return ProductoMapper.toDTO(actualizado);
    }
    
}
