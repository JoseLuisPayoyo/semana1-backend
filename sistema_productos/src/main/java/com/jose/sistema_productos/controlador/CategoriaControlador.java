package com.jose.sistema_productos.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.jose.sistema_productos.dto.CategoriaDTO;
import com.jose.sistema_productos.servicio.ICategoriaServicio;

@RestController
@RequestMapping("/api/categorias")
@CrossOrigin(origins = "*")
public class CategoriaControlador {

    @Autowired
    ICategoriaServicio categoriaServicio;

    // Listar todas las categorías
    @GetMapping
    public List<CategoriaDTO> listarCategorias() {
        return categoriaServicio.listarCategorias();
    }

    // Buscar una categoría por ID
    @GetMapping("/{id}")
    public CategoriaDTO buscarCategoriaPorId(@PathVariable Long id) {
        return categoriaServicio.obtenerCategoriaPorId(id);
    }

    // Crear una nueva categoría
    @PostMapping
    public CategoriaDTO crearCategoria(@RequestBody CategoriaDTO categoriaDTO) {
        return categoriaServicio.crearCategoria(categoriaDTO);
    }

    // Actualizar una categoría
    @PutMapping("/{id}")
    public CategoriaDTO actualizarCategoria(@PathVariable Long id, @RequestBody CategoriaDTO categoriaDTO) {
        return categoriaServicio.actualizarCategoria(id, categoriaDTO);
    }

    // Eliminar una categoría
    @DeleteMapping("/{id}")
    public void eliminarCategoria(@PathVariable Long id) {
        categoriaServicio.eliminarCategoria(id);
    }
}
