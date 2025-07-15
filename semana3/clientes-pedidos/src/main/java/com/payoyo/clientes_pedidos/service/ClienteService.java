package com.payoyo.clientes_pedidos.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payoyo.clientes_pedidos.dto.ClienteDTO;
import com.payoyo.clientes_pedidos.mapper.ClienteMapper;
import com.payoyo.clientes_pedidos.model.Cliente;
import com.payoyo.clientes_pedidos.repository.ClienteRepository;

@Service
public class ClienteService implements IClienteService{

    @Autowired
    private ClienteRepository clienteRepository;

    private final ClienteMapper clienteMapper = new ClienteMapper();

    @Override
    public ClienteDTO crearCliente(ClienteDTO clienteDTO) {
        //pasamos a entidad
        Cliente cliente = clienteMapper.toEntity(clienteDTO);
        //guardamos en db
        Cliente clienteGuardado = clienteRepository.save(cliente);

        //devolvemos dto
        return clienteMapper.toDTO(clienteGuardado);
    }

    @Override
    public Optional<ClienteDTO> obtenerCliente(Long id) {
        return clienteRepository.findById(id)
            .map(clienteMapper::toDTO);
    }
    
}
