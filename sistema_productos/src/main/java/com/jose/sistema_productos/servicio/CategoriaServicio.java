package com.jose.sistema_productos.servicio;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jose.sistema_productos.dto.CategoriaDTO;
import com.jose.sistema_productos.exception.RecursoNoEncontradoException;
import com.jose.sistema_productos.modelo.Categoria;
import com.jose.sistema_productos.repository.CategoriaRepository;
import com.jose.sistema_productos.util.CategoriaMapper;

@Service
public class CategoriaServicio implements ICategoriaServicio{

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<CategoriaDTO> listarCategorias() {
        return categoriaRepository.findAll()
            .stream()
            .map(CategoriaMapper::toDTO)
            .collect(Collectors.toList());
    }

    @Override
    public CategoriaDTO obtenerCategoriaPorId(Long id) {
        //1. buscar producto por su id
        Categoria categoria = categoriaRepository.findById(id)
            //2. Si no lo encentra, lanza exception
            .orElseThrow(() -> new RecursoNoEncontradoException("Categoria no encontrada con id: " + id));
        //3. Si la encuentra, se convierte a DTO
        return CategoriaMapper.toDTO(categoria);
    }

    @Override
    public CategoriaDTO crearCategoria(CategoriaDTO categoriaDTO) {
        // 1. Convertir el DTO a entidad, pasando la categoría encontrada
        Categoria categoria = CategoriaMapper.toEntity(categoriaDTO);
        
        // 2. Guardar el producto en la base de datos
        Categoria categoriaGuardada = categoriaRepository.save(categoria);

        // 3. Convertir la entidad guardada a DTO y devolverla
        return CategoriaMapper.toDTO(categoriaGuardada);
    }

    @Override
    public CategoriaDTO actualizarCategoria(Long id, CategoriaDTO categoriaDTO) {
        // 2. Buscar la nueva categoría
        Categoria categoria = categoriaRepository.findById(id)
            .orElseThrow(() -> new RecursoNoEncontradoException("No se ha encontrado la categoria con id: " + categoriaDTO.getId()));
            
        // 2. Actualizar los campos de la categoria
        categoria.setNombre(categoriaDTO.getNombre());

        // 4. Guardar y devolver
        Categoria categoriaActualizada = categoriaRepository.save(categoria);
        return CategoriaMapper.toDTO(categoriaActualizada);
    }

    @Override
    public void eliminarCategoria(Long id) {
        // 1. Verificar que la categoria existe
        categoriaRepository.findById(id)
            .orElseThrow(() -> new RecursoNoEncontradoException("Categoria no encontrada con id: " + id));

        // 2. Eliminarlo por ID
        categoriaRepository.deleteById(id);
    }
    
}
