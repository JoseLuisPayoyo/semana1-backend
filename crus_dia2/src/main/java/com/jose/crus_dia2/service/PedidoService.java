package com.jose.crus_dia2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jose.crus_dia2.exception.RecursoNoEncontradoException;
import com.jose.crus_dia2.model.Pedido;
import com.jose.crus_dia2.repository.PedidoRepository;

@Service
public class PedidoService implements IPedidoService{

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido buscarPedidoPorId(Long id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    @Override
    public Pedido guardarPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public void eliminarPedido(Long id) {
        pedidoRepository.findById(id)
                        .orElseThrow(() -> new RecursoNoEncontradoException("Pedido no encontrado con id: " + id));
        pedidoRepository.deleteById(id);
    }
    
}
