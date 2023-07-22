package com.labtbd2.emergencias.repositories;

import com.labtbd2.emergencias.models.Emergencia;
import com.labtbd2.emergencias.models.Tarea;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

@Repository
public class EmergenciaRepositoryImp implements  EmergenciaRepository{
    @Autowired
    MongoDatabase database;

    @Override
    public int contarEmergencias(){
        MongoCollection<Document> collection = database.getCollection("emergencia");
        int count = (int) collection.countDocuments();
        return (int) count;
    }

    @Override
    public List<Emergencia> getEmergencias() {
        MongoCollection<Emergencia> collection = database.getCollection("emergencia", Emergencia.class);
        List <Emergencia> emergencias = collection.find().into(new ArrayList<>());
        return emergencias;
    }

    @Override
    public Emergencia crearEmergencia(Emergencia em) {
        MongoCollection<Emergencia> collection = database.getCollection("emergencia", Emergencia.class);
        collection.insertOne(em);
        return em;
    }

    @Override
    public Emergencia updateEmergencia(Emergencia nueva_emergencia) {
        MongoCollection<Emergencia> collection = database.getCollection("emergencia", Emergencia.class);
        Emergencia emergencia_actualizada = collection.find(eq("_id", nueva_emergencia.getId())).first();
        if (emergencia_actualizada == null) {
            throw new IllegalArgumentException("La emergencia no existe en la base de datos.");
        }

        emergencia_actualizada.setNombre(nueva_emergencia.getNombre());
        emergencia_actualizada.setDescripcion(nueva_emergencia.getDescripcion());
        emergencia_actualizada.setFecha_inicio(nueva_emergencia.getFecha_inicio());
        emergencia_actualizada.setFecha_termino(nueva_emergencia.getFecha_termino());

        collection.replaceOne(eq("_id", emergencia_actualizada.getId()), emergencia_actualizada);

        return emergencia_actualizada;
    }

    @Override
    public void deleteAllEmergencia() {
        MongoCollection<Emergencia> collection = database.getCollection("emergencia", Emergencia.class);
        DeleteResult result = collection.deleteMany(new Document());
    }

    @Override
    public ArrayList<Document> getTareasActivas(Integer i){
        MongoCollection<Document> collection = database.getCollection("emergencia");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(
                new Document("$match", new Document("_id", i)),
                new Document("$lookup", new Document("from", "tarea")
                        .append("localField", "_id")
                        .append("foreignField", "id_emergencia")
                        .append("as", "tareas")),
                new Document("$unwind", new Document("path", "$tareas")),
                new Document("$match", new Document("tareas.id_estado", 1L)),
                new Document("$replaceRoot", new Document("newRoot", "$tareas")) // Reemplaza la raíz del documento por el subdocumento de la tarea
        ));
        Iterator iterator = result.iterator();
        ArrayList<Document> documents = new ArrayList();
        // Ahora iteramos
        while (iterator.hasNext()) {
            documents.add((Document) iterator.next());
        }
        return documents;
    }

}
