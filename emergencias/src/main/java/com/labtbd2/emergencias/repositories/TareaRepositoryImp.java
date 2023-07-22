package com.labtbd2.emergencias.repositories;

import com.labtbd2.emergencias.models.Tarea;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

@Repository
public class TareaRepositoryImp implements TareaRepository {
    @Autowired
    MongoDatabase database;

    @Override
    public int contarTareas() {
        MongoCollection<Document> collection = database.getCollection("tarea");
        int count = (int) collection.countDocuments();
        return (int) count;
    }

    @Override
    public List<Tarea> getTareas() {
        MongoCollection<Tarea> collection = database.getCollection("tarea", Tarea.class);
        List<Tarea> tareas = collection.find().into(new ArrayList<>());
        return tareas;
    }

    @Override
    public Tarea crearTarea(Tarea tarea) {
        MongoCollection<Tarea> collection = database.getCollection("tarea", Tarea.class);
        collection.insertOne(tarea);
        return tarea;
    }

    @Override
    public Tarea updateTarea(Tarea nueva_tarea) {
        MongoCollection<Tarea> collection = database.getCollection("tarea", Tarea.class);
        Tarea tarea_actualizada = collection.find(eq("_id", nueva_tarea.getId())).first();
        if (tarea_actualizada == null) {
            throw new IllegalArgumentException("La tarea no existe en la base de datos.");
        }

        tarea_actualizada.setNombre(nueva_tarea.getNombre());
        tarea_actualizada.setDescripcion(nueva_tarea.getDescripcion());
        tarea_actualizada.setCantidad_requeridos(nueva_tarea.getCantidad_requeridos());
        tarea_actualizada.setCantidad_inscritos((nueva_tarea.getCantidad_inscritos()));
        tarea_actualizada.setId_estado(nueva_tarea.getId_estado());

        collection.replaceOne(eq("_id", tarea_actualizada.getId()), tarea_actualizada);

        return tarea_actualizada;
    }

    @Override
    public void deleteAllTarea() {
        MongoCollection<Tarea> collection = database.getCollection("tarea", Tarea.class);
        DeleteResult result = collection.deleteMany(new Document());
    }
}
