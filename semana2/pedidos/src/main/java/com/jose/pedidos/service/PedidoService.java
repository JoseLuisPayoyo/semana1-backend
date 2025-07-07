package com.jose.pedidos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jose.pedidos.dto.PedidoDTO;
import com.jose.pedidos.model.Cliente;
import com.jose.pedidos.model.Pedido;
import com.jose.pedidos.repository.ClienteRepository;

@Service
public class PedidoService implements IPedidoService{

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public PedidoDTO guardarPedido(PedidoDTO pedidoDTO) {}

    @Override
    public List<PedidoDTO> listarPedido() {}

    @Override
    public PedidoDTO buscarPedidoPorId(Long id) {}

    @Override
    public void eliminarPedido(Long id) {}
    
}
