package com.jose.pedidos.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.jose.pedidos.repository.PedidoRepository;
import com.jose.pedidos.util.PedidoMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jose.pedidos.dto.PedidoDTO;
import com.jose.pedidos.exception.RecursoNoEncontradoException;
import com.jose.pedidos.model.Cliente;
import com.jose.pedidos.model.Pedido;
import com.jose.pedidos.repository.ClienteRepository;

@Service
public class PedidoService implements IPedidoService{

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    // PedidoService(PedidoRepository pedidoRepository) {
    //     this.pedidoRepository = pedidoRepository;
    // }

    @Override
    public PedidoDTO guardarPedido(PedidoDTO pedidoDTO) {
        Cliente cliente = clienteRepository.findById(pedidoDTO.getClienteId())
            .orElseThrow(() -> new RecursoNoEncontradoException("Cliente no encontrado con id: " + pedidoDTO.getClienteId()));
        Pedido pedido = PedidoMapper.toEntity(pedidoDTO, cliente);
        Pedido pedidoGuardado = pedidoRepository.save(pedido);

        return PedidoMapper.toDTO(pedidoGuardado);
    }

    @Override
    public List<PedidoDTO> listarPedido() {
        return pedidoRepository.findAll()
            .stream()
            .map(PedidoMapper::toDTO)
            .collect(Collectors.toList());
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
