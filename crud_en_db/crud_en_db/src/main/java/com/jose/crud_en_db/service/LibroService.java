package com.jose.crud_en_db.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.jose.crud_en_db.model.Libro;

@Service
public class LibroService {
    
    private List<Libro> libros = new ArrayList<>();

    //listar libros
    public List<Libro> listarLibros(){
        return libros;
    }

    //crear libros
    public Libro crearLibro(Libro libro){
        libros.add(libro);
        return libro;
    }

    //eliminar libro
    public void eliminarLibroPorId(Long id){
        libros.removeIf(l -> l.getId().equals(id));
    }

    //buscar por id
    public Libro buscarLibroPorId(Long id) {
        return libros.stream()
                .filter(l -> l.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    //solo los disponibles
    public List<Libro> listarSoloDisponibles(){
        return libros.stream()
                        .filter(l -> l.isDisponible())
                        .collect(Collectors.toList());
    }

}
