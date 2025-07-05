package com.jose.sistema_productos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jose.sistema_productos.modelo.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
