package com.labtbd2.emergencias.repositories;

import com.labtbd2.emergencias.models.Emergencia;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

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
        // Then iterate over the iterator
        while (iterator.hasNext()) {
            documents.add((Document) iterator.next());
        }
        return documents;
    }

}
