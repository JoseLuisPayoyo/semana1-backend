package com.jose.pedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jose.pedidos.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{}
