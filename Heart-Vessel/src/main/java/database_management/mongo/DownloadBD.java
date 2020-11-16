package database_management.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import database_management.AuxDB;
import objects.area.Area;
import objects.area.areas.Garaje;
import objects.area.areas.HabitableRoom;
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

        ArrLarea = downloadAreasBackUp();
        /*ArrlPerson = AuxDB.ArrlPerson;
        ArrlProduct = AuxDB.ArrlProduct;
        ArrlProvider = AuxDB.ArrlProvider;
        ArrlTransport = AuxDB.ArrlTransport;*/

    }

    public static void inicializar(){
        //Inicializacion de conexion BD
        mongoClient = new MongoClient("localhost", 27017);
        db = mongoClient.getDatabase("vessel");

        //Inializacion de colecciones mongo
        collectionArea = db.getCollection("area");
        collectionPerson = db.getCollection("person");
        collectionProduct = db.getCollection("product");
        collectionProvider = db.getCollection("provider");
        collectionTransportSystem = db.getCollection("transportSystem");

    }

    public static ArrayList<Area> downloadAreasBackUp(){

        inicializar();

        //Tenemos que crear un iterable que sera la coleccion en la que estamos, y el cursos sera la posicion dentro del iterable
        FindIterable<Document> findIterable = collectionArea.find();
        MongoCursor<Document> cursor = findIterable.iterator();

        //Arraylist de retorno
        ArrayList<Area> areas = new ArrayList<Area>();

        while(cursor.hasNext()){

            Document nodoArea = cursor.next();

            switch (nodoArea.getString("Tipo")){
                case "Area":
                    Area area = new Area(
                            nodoArea.getString("idArea"),
                            nodoArea.getString("Nombre"),
                            nodoArea.getString("Estado"),
                            nodoArea.getInteger("Planta"),
                            nodoArea.getInteger("Riesgo"),
                            (ArrayList<String>) nodoArea.get("Equipamiento"),
                            (ArrayList<String>) nodoArea.get("Personal")
                    );

                    areas.add(area);
                    break;

                case "Habitacion":
                    HabitableRoom room = new HabitableRoom(
                            nodoArea.getString("idArea"),
                            nodoArea.getString("Nombre"),
                            nodoArea.getString("Estado"),
                            nodoArea.getInteger("Planta"),
                            nodoArea.getInteger("Riesgo"),
                            nodoArea.getString("idPaciente"),
                            (ArrayList<String>) nodoArea.get("Personal"),
                            (ArrayList<String>) nodoArea.get("Equipamiento")
                    );

                    areas.add(room);
                    break;

                case "Garaje":
                    Garaje garaje = new Garaje(
                            nodoArea.getString("idArea"),
                            nodoArea.getString("Nombre"),
                            nodoArea.getString("Estado"),
                            nodoArea.getInteger("Planta"),
                            nodoArea.getInteger("Riesgo"),
                            (ArrayList<String>) nodoArea.get("Equipamiento"),
                            (ArrayList<String>) nodoArea.get("Personal"),
                            (ArrayList<String>) nodoArea.get("Vehiculos")
                    );

                    areas.add(garaje);
                    break;
            }
        }

        //Cerramos el cursor para que no de problemas por no dejarle vacio
        cursor.close();
        return areas;
    }

    public static ArrayList<Person> downloadPersonBackUp(){

        inicializar();

        //Tenemos que crear un iterable que sera la coleccion en la que estamos, y el cursos sera la posicion dentro del iterable
        FindIterable<Document> findIterable = collectionPerson.find();
        MongoCursor<Document> cursor = findIterable.iterator();
        ArrayList<Person> people = new ArrayList<>();

        while(cursor.hasNext()){

            Document nodoArea = cursor.next();

            switch (nodoArea.getString("Tipo")){
                case "Paciente":


                    break;

                case "Empleado":

                    break;
            }
        }

        return people;
    }

}
