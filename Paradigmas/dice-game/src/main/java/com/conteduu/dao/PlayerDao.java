package com.conteduu.dao;

import com.conteduu.model.Player;
import com.conteduu.utils.MongoUtil;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Sorts;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.*;

/*
    DAO = Data Access Object
    Chamara todos os metodos de unma classe intermediaria, sem passar pela main,
    desta forma a maisn não 'fala' direto com o banco

*/

public class PlayerDao {

// Obtem a collection 'players' (e se não existir, o mongo cria na hora)

    private final MongoCollection<Document> collection = MongoUtil.db().getCollection("players");

    private Player toPlayer(Document doc){
        return new Player(
                doc.getObjectId("_id").toHexString(),
                doc.getString("nome"),
                doc.getInteger("pontos", 0),
                doc.getInteger("vitorias", 0)
        );
    }

    public List<Player> findAll(){
        List<Player> list = new ArrayList<>();

        for(Document d : collection.find().sort(Sorts.ascending("nome"))){
            list.add(toPlayer(d));
        }
        return list;
    }

    public void insert(String nome){
        if (nome == null || nome.isBlank()) return;

        collection.insertOne(
                new Document("nome",nome)
                        .append("pontos", 0)
                        .append("vitorias", 0)
        );
    }

    public void addPoints(String id, int pts){
        ObjectId oi = new ObjectId(id);

        // Busca o documento pelo id que foi passado e atualiza e incrementa o valor no campo pontos
        collection.updateOne(eq("_id", oi),inc("pontos", pts));

       Document doc = collection.find(eq("_id", oi)).first();

       if (doc != null && doc.getInteger("pontos") >= 20){
           collection.updateOne(
                   eq("_id", oi),
                   combine(
                           set("pontos", 0), inc("vitorias", 1)
           ));
       }
    }

    public void resetAll(){
        collection.deleteMany(new Document());
    }

}
