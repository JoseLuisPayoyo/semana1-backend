package com.payoyo.clientes_pedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payoyo.clientes_pedidos.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{} 
