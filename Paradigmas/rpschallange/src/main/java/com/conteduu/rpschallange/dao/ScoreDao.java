package com.conteduu.rpschallange.dao;


import com.conteduu.rpschallange.util.MongoConfig;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

//Data Access Object
public class ScoreDao {
    // Metodo save(score), vai salvar o score no banco
    // Metodo list(), vai devolver List<String> prontas para exibir num listView
    // O metodo List deveria retornar uma lista de scores.

    private final MongoCollection<Document> collection = MongoConfig.scores().getCollection("players");

    public void list(){



    }
}
