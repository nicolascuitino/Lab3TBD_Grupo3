package com.labtbd2.emergencias.services;

import com.labtbd2.emergencias.models.emergencia;
import com.labtbd2.emergencias.models.tarea;
import com.labtbd2.emergencias.repositories.EmergenciaRepository;
import com.labtbd2.emergencias.repositories.TareaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TareaService {
    private final TareaRepository tareaRepository;
    public TareaService(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    @GetMapping("/tarea/count")
    public String contarTareas(){
        int total = tareaRepository.contarTareas();
        return String.format("Hay %s tareas", total);
    }

    @GetMapping("/tarea")
    public List<tarea> getTareas(){
        return tareaRepository.getTareas();
    }

    @PostMapping("/tarea")
    @ResponseBody
    public tarea crearTarea(@RequestBody tarea t){
        tarea result = tareaRepository.crearTarea(t);
        return result;
    }
}
