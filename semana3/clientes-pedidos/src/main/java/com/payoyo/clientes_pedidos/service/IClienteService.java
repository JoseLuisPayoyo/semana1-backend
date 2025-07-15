package com.payoyo.clientes_pedidos.service;

import java.util.Optional;

import com.payoyo.clientes_pedidos.dto.ClienteDTO;

public interface IClienteService {

    ClienteDTO crearCliente(ClienteDTO clienteDTO);

    Optional<ClienteDTO> obtenerCliente(Long id);
    
}
