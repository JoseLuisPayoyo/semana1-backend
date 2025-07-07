package com.jose.pedidos.service;

import java.util.List;

import com.jose.pedidos.dto.PedidoDTO;

public interface IPedidoService {

    PedidoDTO guardarPedido(PedidoDTO pedidoDTO);

    List<PedidoDTO> listarPedido();

    PedidoDTO buscarPedidoPorId(Long id);

    void eliminarPedido(Long id);
}
