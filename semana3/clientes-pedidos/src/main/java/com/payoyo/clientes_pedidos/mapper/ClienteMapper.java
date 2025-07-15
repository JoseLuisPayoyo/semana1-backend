package com.payoyo.clientes_pedidos.mapper;

import com.payoyo.clientes_pedidos.dto.ClienteDTO;
import com.payoyo.clientes_pedidos.model.Cliente;

public class ClienteMapper {

    public ClienteDTO toDTO(Cliente cliente){
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(cliente.getId());
        clienteDTO.setNombre(cliente.getNombre());
        clienteDTO.setCorreo(cliente.getCorreo());
        clienteDTO.setTelefono(cliente.getTelefono());

        return clienteDTO;
    }

    public Cliente toEntity(ClienteDTO clienteDTO){
        Cliente cliente = new Cliente();
        cliente.setId(clienteDTO.getId());
        cliente.setNombre(clienteDTO.getNombre());
        cliente.setCorreo(clienteDTO.getCorreo());
        cliente.setTelefono(clienteDTO.getTelefono());

        return cliente;
    }
    
}
