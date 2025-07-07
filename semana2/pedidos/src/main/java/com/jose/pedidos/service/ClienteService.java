package com.jose.pedidos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jose.pedidos.dto.ClienteDTO;
import com.jose.pedidos.model.Cliente;
import com.jose.pedidos.repository.ClienteRepository;
import com.jose.pedidos.util.ClienteMapper;

@Service
public class ClienteService implements IClienteService{

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public ClienteDTO guardarCliente(ClienteDTO clienteDTO) {
        Cliente cliente = ClienteMapper.toEntity(clienteDTO);
        Cliente clienteGuardado = clienteRepository.save(cliente);
        return ClienteMapper.toDTO(clienteGuardado);
    }

    @Override
    public List<ClienteDTO> listarClientes() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarClientes'");
    }

    @Override
    public ClienteDTO buscarClientePorId(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarClientePorId'");
    }

    @Override
    public void eliminarCliente(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarCliente'");
    }
    
}
