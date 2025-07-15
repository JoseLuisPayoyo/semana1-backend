package com.payoyo.clientes_pedidos.service;

import java.util.Optional;

import com.payoyo.clientes_pedidos.dto.ClienteDTO;
import com.payoyo.clientes_pedidos.dto.PedidoDTO;

public interface IClienteService {

    ClienteDTO crearCliente(ClienteDTO clienteDTO);

    Optional<ClienteDTO> obtenerCliente(Long id);

    PedidoDTO agregarPedido(Long clienteId, PedidoDTO pedidoDTO);
    
}
