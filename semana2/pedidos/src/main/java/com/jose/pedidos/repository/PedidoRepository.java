package com.jose.pedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jose.pedidos.model.Pedido;
import java.util.List;


public interface PedidoRepository extends JpaRepository<Pedido, Long>{
    List<Pedido> findByClienteId(Long clienteId);
}
