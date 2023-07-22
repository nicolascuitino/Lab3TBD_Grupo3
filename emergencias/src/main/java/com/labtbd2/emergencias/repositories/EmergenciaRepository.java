package com.labtbd2.emergencias.repositories;

import com.labtbd2.emergencias.models.Emergencia;
import com.labtbd2.emergencias.models.Tarea;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public interface EmergenciaRepository {
    public int contarEmergencias();
    public List<Emergencia> getEmergencias();
    public Emergencia crearEmergencia(Emergencia emrg);
    public ArrayList<Document> getTareasActivas(Integer i);
    public Emergencia updateEmergencia(Emergencia emergenciaActualizada);
    public void deleteAllEmergencia();
}
