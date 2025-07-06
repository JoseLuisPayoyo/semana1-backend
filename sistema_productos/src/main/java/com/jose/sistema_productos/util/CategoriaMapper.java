package com.jose.sistema_productos.util;

import com.jose.sistema_productos.dto.CategoriaDTO;
import com.jose.sistema_productos.modelo.Categoria;

public class CategoriaMapper {

    //convertir DTO a entity
    public static Categoria toEntity(CategoriaDTO categoriaDTO){
        Categoria categoria = new Categoria();
        categoria.setId(categoriaDTO.getId());
        categoria.setNombre(categoriaDTO.getNombre());

        return categoria;
    }
    
    //convertir entity a dto
    public static CategoriaDTO toDTO(Categoria categoria) {
        CategoriaDTO categoriaDTO = new CategoriaDTO();
        categoriaDTO.setId(categoria.getId());
        categoriaDTO.setNombre(categoria.getNombre());

        return categoriaDTO;
    }
    
}
