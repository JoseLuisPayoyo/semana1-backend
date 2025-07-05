package com.jose.sistema_productos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jose.sistema_productos.modelo.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{

}
