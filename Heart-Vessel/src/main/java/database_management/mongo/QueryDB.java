package database_management.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import database_management.AuxDB;
import objects.area.Area;
import objects.inventory.Inventory;
import objects.people.Person;
import objects.product.Product;
import objects.provider.Provider;
import objects.transportsystem.Transport;
import org.bson.Document;

import java.util.ArrayList;

public class QueryDB {

    public static void main(String[] args) {

        //Declaracion de Conexion a BD
        MongoClient mongoClient = new MongoClient("localhost",27017);
        MongoDatabase db = mongoClient.getDatabase("vessel");

        //Declaracion de colecciones mongo
        MongoCollection<Document> collectionTransportSystem = db.getCollection("area");
        MongoCollection<Document> collectionArea = db.getCollection("inventory");
        MongoCollection<Document> collectionInventory = db.getCollection("person");
        MongoCollection<Document> collectionPerson = db.getCollection("product");
        MongoCollection<Document> collectionProduct = db.getCollection("provider");
        MongoCollection<Document> collectionProvider = db.getCollection("transportSystem");

        //Declaracion de ArrayLists
        ArrayList<Area> areaArrL = AuxDB.ArrLarea;
        ArrayList<Inventory> ArrlInventories = AuxDB.ArrlInventories;
        ArrayList<Person> ArrlPerson = AuxDB.ArrlPerson;
        ArrayList<Product> ArrlProduct = AuxDB.ArrlProduct;
        ArrayList<Provider> ArrlProvider = AuxDB.ArrlProvider;
        ArrayList<Transport> ArrlTransport = AuxDB.ArrlTransport;

        /*
            Una vez declarado todas la variables con la trabajaremos haremos que estas se pasen a la BD

            Las colecciones apuntan a una misma BD solo que siempre cambiamos coleccion a la hora de insertar datos,
            se pude ver en db.getCollection("area"), y las listas son las usadas dentro del programa.
         */

    }

}

