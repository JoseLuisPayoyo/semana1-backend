package com.jose.crus_dia2.mapper;


import com.jose.crus_dia2.DTO.PedidoDTO;
import com.jose.crus_dia2.model.Pedido;

public class PedidoMapper {

    //convertir DTO a entidad
    public static Pedido toEntity(PedidoDTO dto){
        Pedido pedido = new Pedido();
        pedido.setCliente(dto.getCliente());
        pedido.setFecha(dto.getFecha());
        pedido.setEstado(dto.getEstado());
        pedido.setTotal(dto.getTotal());

        return pedido;
    }
    
    //convertir de entidad a dto
    public static PedidoDTO toDTO(Pedido pedido) {
        PedidoDTO dto = new PedidoDTO();
        dto.setCliente(pedido.getCliente());
        dto.setFecha(pedido.getFecha());
        dto.setTotal(pedido.getTotal());
        dto.setEstado(pedido.getEstado());
        return dto;
    }

    
}
