package com.jose.sistema_productos.servicio;

import java.util.List;

import com.jose.sistema_productos.dto.ProductoDTO;


public interface IProductoServicio {
    
    List<ProductoDTO> listarProductos();

    ProductoDTO obtenerProductoPorId(Long id);

    ProductoDTO crearProducto(ProductoDTO productoDTO);

    ProductoDTO actualizarProducto(Long id, ProductoDTO productoDTO);

    void eliminarProducto(Long id);

}
