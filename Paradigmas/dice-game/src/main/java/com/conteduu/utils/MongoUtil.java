package com.conteduu.utils;

/*

    Realiza a conexão com o banco apenas uma vez

    Qualquer parte do sistema que usar o banco, pode
    simplesmente chama o 'db' criado por essa classe

*/

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoUtil {

    private static final MongoClient CLIENT = MongoClients.create("mongodb://localhost:27017/");

    public static MongoDatabase db(){
        return CLIENT.getDatabase("dice_race");
    }
}
