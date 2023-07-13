package com.labtbd2.emergencias.repositories;

import com.labtbd2.emergencias.models.emergencia;
import com.labtbd2.emergencias.models.tarea;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TareaRepositoryImp implements TareaRepository{
    @Autowired
    MongoDatabase database;

    @Override
    public int contarTareas(){
        MongoCollection<Document> collection = database.getCollection("tarea");
        int count = (int) collection.countDocuments();
        return (int) count;
    }

    @Override
    public List<tarea> getTareas() {
        MongoCollection<tarea> collection = database.getCollection("tarea", tarea.class);
        List <tarea> tareas = collection.find().into(new ArrayList<>());
        return tareas;
    }

    @Override
    public tarea crearTarea(tarea t) {
        MongoCollection<tarea> collection = database.getCollection("tarea", tarea.class);
        collection.insertOne(t);
        return t;
    }
}
