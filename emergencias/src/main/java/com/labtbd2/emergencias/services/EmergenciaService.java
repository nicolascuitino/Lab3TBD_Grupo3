package com.labtbd2.emergencias.services;

import com.labtbd2.emergencias.models.Emergencia;
import com.labtbd2.emergencias.repositories.EmergenciaRepository;
import org.bson.Document;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmergenciaService {
    private final EmergenciaRepository emergenciaRepository;
    public EmergenciaService(EmergenciaRepository emergenciaRepository) {
        this.emergenciaRepository = emergenciaRepository;
    }

    @GetMapping("/emergencia/count")
    public String contarEmergencias(){
        int total = emergenciaRepository.contarEmergencias();
        return String.format("Hay %s emergencias", total);
    }

    @GetMapping("/emergencia")
    public List<Emergencia> getEmergencias(){
        return emergenciaRepository.getEmergencias();
    }

    @PostMapping("/emergencia")
    @ResponseBody
    public Emergencia crearEmergencia(@RequestBody Emergencia em){
        Emergencia result = emergenciaRepository.crearEmergencia(em);
        return result;
    }

    @GetMapping("/emergencia/get/tareas/{id}")
    @ResponseBody
    public ArrayList<Document> obtenerTareasActivas(@PathVariable Integer id){
        ArrayList<Document> result = emergenciaRepository.getTareasActivas(id);

        return result;
    }
}
