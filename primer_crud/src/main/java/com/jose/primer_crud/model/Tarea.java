package com.jose.primer_crud.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tarea {

    private Long id;
    private String titulo;
    private String descripcion;
    private boolean completada;
    
}
