package com.labtbd2.emergencias.services;

import com.labtbd2.emergencias.models.Tarea;
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
    public List<Tarea> getTareas(){
        return tareaRepository.getTareas();
    }

    @PostMapping("/tarea")
    @ResponseBody
    public Tarea crearTarea(@RequestBody Tarea t){
        Tarea result = tareaRepository.crearTarea(t);
        return result;
    }

    @PutMapping("/tarea")
    public Tarea actualizarTarea(@RequestBody Tarea t){
        return tareaRepository.updateTarea(t);
    }

    @DeleteMapping("/tarea")
    public void eliminarTareas(){
        tareaRepository.deleteAllTarea();
    }
}
