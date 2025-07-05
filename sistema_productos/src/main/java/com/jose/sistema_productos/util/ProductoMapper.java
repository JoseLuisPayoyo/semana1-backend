package com.jose.sistema_productos.util;

import com.jose.sistema_productos.dto.ProductoDTO;
import com.jose.sistema_productos.modelo.Categoria;
import com.jose.sistema_productos.modelo.Producto;

public class ProductoMapper {

    //convertir DTO a entity
    public static Producto toEntity(ProductoDTO productoDTO, Categoria categoria){
        Producto producto = new Producto();
        producto.setId(productoDTO.getId());
        producto.setNombre(productoDTO.getNombre());
        producto.setPrecio(productoDTO.getPrecio());
        producto.setStock(productoDTO.getStock());
        producto.setCategoria(categoria);

        return producto;
    }
    
    //convertir entity a dto
    public static ProductoDTO toDTO(Producto producto) {
        ProductoDTO productoDTO = new ProductoDTO();
        productoDTO.setId(producto.getId());
        productoDTO.setNombre(producto.getNombre());
        productoDTO.setPrecio(producto.getPrecio());
        productoDTO.setStock(producto.getStock());
        productoDTO.setCategoriaId(producto.getCategoria().getId());

        return productoDTO;
    }
}
