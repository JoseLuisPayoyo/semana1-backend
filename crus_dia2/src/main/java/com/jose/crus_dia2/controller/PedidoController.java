package com.jose.crus_dia2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jose.crus_dia2.DTO.PedidoDTO;
import com.jose.crus_dia2.model.Pedido;
import com.jose.crus_dia2.service.IPedidoService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/api/pedidos")
@CrossOrigin(origins = "*")
public class PedidoController {

    @Autowired
    IPedidoService pedidoService;
    

    //listar
    @GetMapping()
    public List<Pedido> listarPedidos(){
        return pedidoService.listarPedidos();
    }
    
    //buscar por id
    @GetMapping("/{id}")
    public Pedido buscarPedidoPorId(@PathVariable Long id){
        return pedidoService.buscarPedidoPorId(id);
    }
    
    //crear
    @PostMapping
    public Pedido crearPedido(@Valid @RequestBody PedidoDTO pedidoDTO) {
        Pedido pedido = new Pedido();
        pedido.setCliente(pedidoDTO.getCliente());
        pedido.setFecha(pedidoDTO.getFecha());
        pedido.setTotal(pedidoDTO.getTotal());
        pedido.setEstado(pedidoDTO.getEstado());
        return pedidoService.crearPedido(pedido);
    }
    
    //borrar
    @DeleteMapping("/{id}")
    public void eliminarPedido(@PathVariable Long id){
        pedidoService.eliminarPedido(id);
    }
}
