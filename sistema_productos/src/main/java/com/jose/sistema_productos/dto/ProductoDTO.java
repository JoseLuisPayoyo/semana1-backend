package com.jose.sistema_productos.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductoDTO {

    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @Min(value = 0, message = "El precio no puede ser menor a 0")
    private double precio;

    @Min(value = 0, message = "El stock no puede ser negativo")
    private int stock;

    @NotNull(message = "El ID de categoría es obligatorio")
    private Long categoriaId;
    
}
