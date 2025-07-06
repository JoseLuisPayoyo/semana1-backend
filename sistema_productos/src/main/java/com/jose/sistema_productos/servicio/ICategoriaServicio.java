package com.jose.sistema_productos.servicio;

import java.util.List;

import com.jose.sistema_productos.dto.CategoriaDTO;

public interface ICategoriaServicio {

    List<CategoriaDTO> listarCategorias();

    CategoriaDTO obtenerCategoriaPorId(Long id);

    CategoriaDTO crearCategoria(CategoriaDTO categoriaDTO);

    CategoriaDTO actualizarCategoria(Long id, CategoriaDTO categoriaDTO);

    void eliminarCategoria(Long id);

}
