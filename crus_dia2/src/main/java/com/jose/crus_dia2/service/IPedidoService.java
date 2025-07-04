package com.jose.crus_dia2.service;

import java.util.List;

import com.jose.crus_dia2.model.Pedido;

public interface IPedidoService {
    
    List<Pedido> listarPedidos();

    Pedido buscarPedidoPorId(Long id);

    Pedido guardarPedido(Pedido pedido);

    void eliminarPedido(Long id);
}
