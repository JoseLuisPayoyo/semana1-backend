package com.jose.pedidos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jose.pedidos.dto.PedidoDTO;
import com.jose.pedidos.service.PedidoService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api/pedidos")
@CrossOrigin(origins = "*")
public class PedidoController {
    
    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public PedidoDTO guardarPedido(@Valid @RequestBody PedidoDTO pedidoDTO){
        return pedidoService.guardarPedido(pedidoDTO);
    }

    @GetMapping
    public List<PedidoDTO> listarPedidos(){
        return pedidoService.listarPedido();
    }

    @GetMapping("/{id}")
    public PedidoDTO buscarPedidoPorId(@PathVariable Long id){
        return pedidoService.buscarPedidoPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarPedido(@PathVariable Long id){
        pedidoService.eliminarPedido(id);
    }
    
}
