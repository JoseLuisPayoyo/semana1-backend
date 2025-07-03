package com.jose.primer_crud.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jose.primer_crud.model.Nota;

@Service
public class NotaService {

    private List<Nota> notas = new ArrayList<>();

    //listar notas
    public List<Nota> listarNotas(){
        return notas;
    }
}
