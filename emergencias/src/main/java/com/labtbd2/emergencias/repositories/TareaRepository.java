package com.labtbd2.emergencias.repositories;

import com.labtbd2.emergencias.models.Tarea;

import java.util.List;

public interface TareaRepository {

    public int contarTareas();

    public Tarea crearTarea(Tarea t);

    public List<Tarea> getTareas();

    public Tarea updateTarea(Tarea tareaActualizada);

    public void deleteAllTarea();
}
