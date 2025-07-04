package com.jose.crus_dia2.DTO;

import java.time.LocalDate;

import com.jose.crus_dia2.model.Pedido.EstadoPedido;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoDTO {
    
    @NotBlank(message = "El nombre del cliente no puede estar vacio")
    private String cliente;

    @NotNull(message = "La fecha no puede estar vacia")
    private LocalDate fecha;

    @Min(value = 0, message = "El total no puede ser menos a 0")
    private Double total;

    @NotNull(message = "El estado no puede estar vacio")
    private EstadoPedido estado;
}
