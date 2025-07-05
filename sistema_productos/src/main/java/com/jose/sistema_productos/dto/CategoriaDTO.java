package com.jose.sistema_productos.dto;

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
public class CategoriaDTO {
    
    @NotNull(message = "El ID de categoria es obligatorio")
    private Long id;

    @NotBlank(message = "El nombre no puede ir en blanco")
    private String nombre;
}
