package database_management.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import database_management.AuxDB;
import objects.area.Area;
import objects.people.Person;
import objects.product.Product;
import objects.provider.Provider;
import objects.transportsystem.Transport;
import org.bson.Document;

import java.util.ArrayList;

public class DownloadBD {

    //Declaracion de Conexion a BD
    private static MongoClient mongoClient;
    private static MongoDatabase db;

    //Declaracion de colecciones mongo
    private static MongoCollection<Document> collectionArea;
    private static MongoCollection<Document> collectionTransportSystem;
    private static MongoCollection<Document> collectionPerson;
    private static MongoCollection<Document> collectionProduct;
    private static MongoCollection<Document> collectionProvider;

    //Declaracion de ArrayLists
    private static ArrayList<Area> ArrLarea;
    private static ArrayList<Person> ArrlPerson;
    private static ArrayList<Product> ArrlProduct;
    private static ArrayList<Provider> ArrlProvider;
    private static ArrayList<Transport> ArrlTransport;

    public static void main(String[] args) {

        //Inicializacion de conexion BD
        mongoClient = new MongoClient("localhost", 27017);
        db = mongoClient.getDatabase("vessel");

        //Inializacion de colecciones mongo
        collectionArea = db.getCollection("area");
        collectionPerson = db.getCollection("person");
        collectionProduct = db.getCollection("product");
        collectionProvider = db.getCollection("provider");
        collectionTransportSystem = db.getCollection("transportSystem");


        ArrLarea = downloadAreasBackUp();
        /*ArrlPerson = AuxDB.ArrlPerson;
        ArrlProduct = AuxDB.ArrlProduct;
        ArrlProvider = AuxDB.ArrlProvider;
        ArrlTransport = AuxDB.ArrlTransport;*/

        /*for (Area a : ArrLarea) {
            System.out.println(a.getName());
        }*/

    }

    public static ArrayList<Area> downloadAreasBackUp(){

        //Tenemos que crear un iterable que sera la coleccion en la que estamos, y el cursos sera la posicion dentro del iterable
        FindIterable<Document> findIterable = collectionArea.find();
        MongoCursor<Document> cursor = findIterable.iterator();

        //Arraylist de retorno
        ArrayList<Area> areas = new ArrayList<Area>();

        while(cursor.hasNext()){

            Area area = new Area();
            Document nodoArea = cursor.next();

            nodoArea.getObjectId("_id");

//            area.setIdArea(nodoArea.getString("idArea"));
//            area.setName(nodoArea.getString("Nombre"));
//            area.setStatus(nodoArea.getString("Estado"));
//            area.setFloor(nodoArea.getInteger("Planta"));
//            area.setRisk(nodoArea.getInteger("Riesgo"));
//            area.setPersonal(nodoArea.getString(""));
//            area.setEquipment();

            areas.add(area);
        }

        //Cerramos el cursor para que no de problemas por no dejarle vacio
        cursor.close();
        return areas;
    }

}
