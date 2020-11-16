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
import objects.people.person.Employee;
import objects.people.person.Patient;
import objects.product.Product;
import objects.provider.Provider;
import objects.transportsystem.Transport;
import objects.transportsystem.transportsystems.MovementAid;
import objects.transportsystem.transportsystems.vehicle.vehicles.Ambulance;
import objects.transportsystem.transportsystems.vehicle.vehicles.CompanyCar;
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
        ArrlPerson = downloadPersonBackUp();
        ArrlProvider = downloadProviderBackUp();
        /*ArrlProvider = AuxDB.ArrlProvider;
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

            Document nodo = cursor.next();

            switch (nodo.getString("Tipo")){
                case "Area":
                    Area area = new Area(
                            nodo.getString("idArea"),
                            nodo.getString("Nombre"),
                            nodo.getString("Estado"),
                            nodo.getInteger("Planta"),
                            nodo.getInteger("Riesgo"),
                            (ArrayList<String>) nodo.get("Equipamiento"),
                            (ArrayList<String>) nodo.get("Personal")
                    );

                    areas.add(area);
                    break;

                case "Habitacion":
                    HabitableRoom room = new HabitableRoom(
                            nodo.getString("idArea"),
                            nodo.getString("Nombre"),
                            nodo.getString("Estado"),
                            nodo.getInteger("Planta"),
                            nodo.getInteger("Riesgo"),
                            nodo.getString("idPaciente"),
                            (ArrayList<String>) nodo.get("Personal"),
                            (ArrayList<String>) nodo.get("Equipamiento")
                    );

                    areas.add(room);
                    break;

                case "Garaje":
                    Garaje garaje = new Garaje(
                            nodo.getString("idArea"),
                            nodo.getString("Nombre"),
                            nodo.getString("Estado"),
                            nodo.getInteger("Planta"),
                            nodo.getInteger("Riesgo"),
                            (ArrayList<String>) nodo.get("Equipamiento"),
                            (ArrayList<String>) nodo.get("Personal"),
                            (ArrayList<String>) nodo.get("Vehiculos")
                    );

                    areas.add(garaje);
                    break;

                default:
                    System.out.println("Error inesperado en Area");
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

            Document nodo = cursor.next();

            switch (nodo.getString("Tipo")){
                case "Paciente":

                    Patient patient = new Patient(
                            nodo.getString("idPersona"),
                            nodo.getString("Nombre"),
                            nodo.getString("Apellido"),
                            nodo.getString("Estado"),
                            nodo.getBoolean("VisitasPermitidas"),
                            nodo.getString("idHabitacion"),
                            (ArrayList<String>)nodo.get("Registro")
                    );

                    people.add(patient);
                    break;

                case "Empleado":
                    Employee employee = new Employee(
                            nodo.getString("idPersona"),
                            nodo.getString("Nombre"),
                            nodo.getString("Apellido"),
                            nodo.getString("Estado"),
                            nodo.getString("Departamento"),
                            nodo.getString("Puesto"),
                            nodo.getInteger("Salario"),
                            nodo.getString("Jornada")
                    );

                    people.add(employee);
                    break;

                default:
                    System.out.println("Error inesperado en Personas");
                    break;
            }
        }

        cursor.close();
        return people;
    }

    public static ArrayList<Provider> downloadProviderBackUp(){

        inicializar();

        //Tenemos que crear un iterable que sera la coleccion en la que estamos, y el cursos sera la posicion dentro del iterable
        FindIterable<Document> findIterable = collectionProvider.find();
        MongoCursor<Document> cursor = findIterable.iterator();
        ArrayList<Provider> providers = new ArrayList<>();

        while (cursor.hasNext()){

            Document nodo = cursor.next();

            providers.add(new Provider(
                    nodo.getString("idProveedor"),
                    nodo.getString("Nombre"),
                    nodo.getString("IBAN")
            ));
        }

        cursor.close();
        return providers;
    }

    public static ArrayList<Transport> downloadTransportBackUp(){

        inicializar();

        //Tenemos que crear un iterable que sera la coleccion en la que estamos, y el cursos sera la posicion dentro del iterable
        FindIterable<Document> findIterable = collectionTransportSystem.find();
        MongoCursor<Document> cursor = findIterable.iterator();

        //Arraylist de retorno
        ArrayList<Transport> Trps = new ArrayList<>();

        while(cursor.hasNext()){

            Document nodoTrp = cursor.next();

            switch (nodoTrp.getString("Tipo")){
                case "Ayuda Movil":
                    MovementAid nuevoAM = new MovementAid(
                            nodoTrp.getString("idTransporte"),
                            nodoTrp.getString("Estado"),
                            nodoTrp.getString("idPaciente"),
                            nodoTrp.getString("idArea")
                    );

                    Trps.add(nuevoAM);
                    break;

                case "Ambulancia":
                    Ambulance nuevoAmbu = new Ambulance(
                            nodoTrp.getString("idArea"),
                            nodoTrp.getString("Estado"),
                            nodoTrp.getString("Especialidad"),
                            nodoTrp.getInteger("Gasolina"),
                            (ArrayList<String>) nodoTrp.get("Equipamiento"),
                            (ArrayList<String>) nodoTrp.get("Personal")
                    );

                    Trps.add(nuevoAmbu);
                    break;

                case "CocheCorporativo":
                    CompanyCar nuevoCC = new CompanyCar(
                            nodoTrp.getString("idTransporte"),
                            nodoTrp.getString("Estado"),
                            nodoTrp.getString("Transmision"),
                            nodoTrp.getInteger("Gasolina"),
                            nodoTrp.getString("Modelo"),
                            nodoTrp.getString("Marca"),
                            nodoTrp.getString("Dueño")
                    );

                    Trps.add(nuevoCC);
                    break;
            }
        }

        //Cerramos el cursor para que no de problemas por no dejarle vacio
        cursor.close();
        return Trps;
    }
}
