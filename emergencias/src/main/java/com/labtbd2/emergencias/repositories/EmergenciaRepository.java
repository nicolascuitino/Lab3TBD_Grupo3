package com.labtbd2.emergencias.repositories;

import com.labtbd2.emergencias.models.emergencia;
import com.labtbd2.emergencias.models.tarea;
import com.mongodb.client.AggregateIterable;
import org.bson.Document;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;

import java.util.ArrayList;
import java.util.List;

public interface EmergenciaRepository {
    public int contarEmergencias();
    public List<emergencia> getEmergencias();
    public emergencia crearEmergencia(emergencia emrg);

    public ArrayList<Document> getTareasActivas(Integer i);
}
