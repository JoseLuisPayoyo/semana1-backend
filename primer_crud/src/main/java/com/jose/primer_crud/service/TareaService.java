package com.jose.primer_crud.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jose.primer_crud.model.Tarea;

@Service
public class TareaService {

    List<Tarea> tareas = new ArrayList<>();

    public List<Tarea> listarTareas() {
        return tareas;
    }

    public Tarea crearTarea(Tarea tarea) {
        tareas.add(tarea);
        return tarea;
    }

    public void eliminarTarea(Tarea tarea) {
        tareas.remove(tarea);
    }
    
}
