package com.labtbd2.emergencias.repositories;

import com.labtbd2.emergencias.models.emergencia;
import com.labtbd2.emergencias.models.tarea;

import java.util.List;

public interface TareaRepository {
    public int contarTareas();
    public List<tarea> getTareas();
    public tarea crearTarea(tarea t);
}
