package com.jose.pedidos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jose.pedidos.dto.PedidoDTO;
import com.jose.pedidos.repository.ClienteRepository;

@Service
public class PedidoService implements IPedidoService{

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public PedidoDTO guardarPedido(PedidoDTO pedidoDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'guardarPedido'");
    }

    @Override
    public List<PedidoDTO> listarPedido() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarPedido'");
    }

    @Override
    public PedidoDTO buscarPedidoPorId(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPedidoPorId'");
    }

    @Override
    public void eliminarPedido(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarPedido'");
    }
    
}
