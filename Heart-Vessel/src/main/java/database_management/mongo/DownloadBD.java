package database_management.mongo;
import java.util.stream.Collectors;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import database_management.AuxDB;
import objects.Generic;
import objects.area.Area;
import objects.area.areas.Garaje;
import objects.area.areas.HabitableRoom;
import objects.people.Person;
import objects.people.person.Employee;
import objects.people.person.Patient;
import objects.product.Product;
import objects.product.products.CleaningEquipment;
import objects.product.products.Machinery;
import objects.product.products.SanitationMaterials;
import objects.product.products.substance.substances.CleaningProducts;
import objects.product.products.substance.substances.consumable.consumables.FoodMenu;
import objects.product.products.substance.substances.consumable.consumables.Medicine;
import objects.provider.Provider;
import objects.transportsystem.Transport;
import objects.transportsystem.transportsystems.MovementAid;
import objects.transportsystem.transportsystems.vehicle.vehicles.Ambulance;
import objects.transportsystem.transportsystems.vehicle.vehicles.CompanyCar;
import org.bson.Document;
import service.utility.OpsID;

import javax.crypto.Mac;
import java.util.ArrayList;

import static database_management.AuxDB.initMaxID;

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

   public static void descargar(){
       //Inicializacion de conexion BD
       mongoClient = new MongoClient("localhost", 27017);
       db = mongoClient.getDatabase("vessel");

       //Inializacion de colecciones mongo
       collectionArea = db.getCollection("area");
       collectionPerson = db.getCollection("person");
       collectionProduct = db.getCollection("product");
       collectionProvider = db.getCollection("provider");
       collectionTransportSystem = db.getCollection("transportSystem");


       AuxDB.Complete.addAll(downloadAreasBackUp());
       AuxDB.Complete.addAll(downloadPersonBackUp());
       AuxDB.Complete.addAll(downloadProviderBackUp());
       AuxDB.Complete.addAll(downloadProductBackUp());
       AuxDB.Complete.addAll(downloadTransportBackUp());

       initMaxID();

       mongoClient.close();

   }

    public static void inicializar() {

    }

    public static ArrayList<Generic> downloadAreasBackUp(){

        inicializar();

        //Tenemos que crear un iterable que sera la coleccion en la que estamos, y el cursos sera la posicion dentro del iterable
        FindIterable<Document> findIterable = collectionArea.find();
        MongoCursor<Document> cursor = findIterable.iterator();

        //Arraylist de retorno
        ArrayList<Generic> areas = new ArrayList<>();

        while (cursor.hasNext()) {

            Document nodo = cursor.next();

            switch (nodo.getString("Tipo")) {
                case "Area":
                    Area area = new Area(
                            nodo.getString("idArea"),
                            nodo.getString("Nombre"),
                            nodo.getString("Estado"),
                            nodo.getInteger("Planta"),
                            nodo.getString("Riesgo"),
                            (ArrayList<String>) nodo.get("Equipamiento"),
                            (ArrayList<String>) nodo.get("Personal")
                    );

                    if (OpsID.decodeID(area.getId())==null)
                        areas.add(area);
                    break;

                case "Habitacion":
                    HabitableRoom room = new HabitableRoom(
                            nodo.getString("idArea"),
                            nodo.getString("Nombre"),
                            nodo.getString("Estado"),
                            nodo.getInteger("Planta"),
                            nodo.getString("Riesgo"),
                            nodo.getString("idPaciente"),
                            (ArrayList<String>) nodo.get("Personal"),
                            (ArrayList<String>) nodo.get("Equipamiento")
                    );

                    if (!AuxDB.Complete.contains(room))
                        areas.add(room);
                    break;

                case "Garaje":
                    Garaje garaje = new Garaje(
                            nodo.getString("idArea"),
                            nodo.getString("Nombre"),
                            nodo.getString("Estado"),
                            nodo.getInteger("Planta"),
                            nodo.getString("Riesgo"),
                            (ArrayList<String>) nodo.get("Equipamiento"),
                            (ArrayList<String>) nodo.get("Personal"),
                            (ArrayList<String>) nodo.get("Vehiculos")
                    );

                    if (OpsID.decodeID(garaje.getId())==null)
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

    public static ArrayList<Generic> downloadPersonBackUp(){

        inicializar();

        //Tenemos que crear un iterable que sera la coleccion en la que estamos, y el cursos sera la posicion dentro del iterable
        FindIterable<Document> findIterable = collectionPerson.find();
        MongoCursor<Document> cursor = findIterable.iterator();
        ArrayList<Generic> people = new ArrayList<>();

        while (cursor.hasNext()) {

            Document nodo = cursor.next();

            switch (nodo.getString("Tipo")) {
                case "Paciente":

                    Patient patient = new Patient(
                            nodo.getString("idPersona"),
                            nodo.getString("Nombre"),
                            nodo.getString("Apellido"),
                            nodo.getString("Estado"),
                            nodo.getBoolean("VisitasPermitidas"),
                            nodo.getString("idHabitacion"),
                            (ArrayList<String>) nodo.get("Registro")
                    );

                    if (OpsID.decodeID(patient.getId())==null)
                        people.add(patient);

                    break;

                case "Empleado":
                    Employee employee = new Employee(
                            nodo.getString("idPersona"),
                            nodo.getString("Nombre"),
                            nodo.getString("Apellido"),
                            nodo.getString("Estado"),
                            nodo.getString("Departamento"),
                            nodo.getString("Jornada"),
                            nodo.getInteger("Salario"),
                            nodo.getString("Puesto")
                    );

                    if (OpsID.decodeID(employee.getId())==null)
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

    public static ArrayList<Generic> downloadProviderBackUp(){

        inicializar();

        //Tenemos que crear un iterable que sera la coleccion en la que estamos, y el cursos sera la posicion dentro del iterable
        FindIterable<Document> findIterable = collectionProvider.find();
        MongoCursor<Document> cursor = findIterable.iterator();
        ArrayList<Generic> providers = new ArrayList<>();

        while (cursor.hasNext()){

            Document nodo = cursor.next();

            if (OpsID.decodeID(nodo.getString("idProveedor"))==null) {
                providers.add(new Provider(
                        nodo.getString("idProveedor"),
                        nodo.getString("Nombre"),
                        nodo.getString("IBAN")
                ));
            }
        }

        cursor.close();
        return providers;
    }

    public static ArrayList<Generic> downloadTransportBackUp(){

        inicializar();

        //Tenemos que crear un iterable que sera la coleccion en la que estamos, y el cursos sera la posicion dentro del iterable
        FindIterable<Document> findIterable = collectionTransportSystem.find();
        MongoCursor<Document> cursor = findIterable.iterator();

        //Arraylist de retorno
        ArrayList<Generic> Trps = new ArrayList<>();

        while (cursor.hasNext()) {

            Document nodoTrp = cursor.next();

            switch (nodoTrp.getString("Tipo")) {
                case "Ayuda Movil":
                    MovementAid nuevoAM = new MovementAid(
                            nodoTrp.getString("idTransporte"),
                            nodoTrp.getString("Estado"),
                            nodoTrp.getString("Nombre"),
                            nodoTrp.getString("idArea"),
                            nodoTrp.getString("idPaciente")
                    );

                    if (OpsID.decodeID(nuevoAM.getId())==null)
                        Trps.add(nuevoAM);
                    break;

                case "Ambulancia":
                    Ambulance nuevoAmbu = new Ambulance(
                            nodoTrp.getString("idTransporte"),
                            nodoTrp.getString("Nombre"),
                            nodoTrp.getString("Status"),
                            nodoTrp.getInteger("Gasolina"),
                            nodoTrp.getString("Marca"),
                            nodoTrp.getString("Modelo"),
                            (ArrayList<String>) nodoTrp.get("Personal"),
                            (ArrayList<String>) nodoTrp.get("Equipamiento")

                    );

                    if (OpsID.decodeID(nuevoAmbu.getId())==null)
                        Trps.add(nuevoAmbu);
                    break;

                case "CocheCorporativo":
                    CompanyCar nuevoCC = new CompanyCar(
                            nodoTrp.getString("idTransporte"),
                            nodoTrp.getString("Nombre"),
                            nodoTrp.getString("Status"),
                            nodoTrp.getInteger("Gasolina"),
                            nodoTrp.getString("Marca"),
                            nodoTrp.getString("Modelo"),
                            nodoTrp.getString("idPersona")
                    );

                    if (OpsID.decodeID(nuevoCC.getId())==null)
                        Trps.add(nuevoCC);
                    break;
            }
        }
        //ADIOS TFG :)
        //Cerramos el cursor para que no de problemas por no dejarle vacio
        cursor.close();
        return Trps;
    }



    public static ArrayList<Generic> downloadProductBackUp(){

        inicializar();

        //Tenemos que crear un iterable que sera la coleccion en la que estamos, y el cursos sera la posicion dentro del iterable
        FindIterable<Document> findIterable = collectionProduct.find();
        MongoCursor<Document> cursor = findIterable.iterator();

        //Arraylist de retorno
        ArrayList<Generic> Trps = new ArrayList<>();

        while (cursor.hasNext()) {

            Document nodoProd = cursor.next();

            switch (nodoProd.getString("Tipo")) {
                case "MaterialSanitario":
                    SanitationMaterials nuevoProd = new SanitationMaterials(
                            nodoProd.getString("idProducto"),
                            nodoProd.getString("Nombre"),
                            nodoProd.getString("Area"),
                            nodoProd.getString("Estado"),
                            nodoProd.getString("FechaDeCompra"),
                            nodoProd.getInteger("Cantidad"),
                            nodoProd.getString("MarcaModelo")
                    );
                    if (OpsID.decodeID(nuevoProd.getId())==null)
                        Trps.add(nuevoProd);
                    break;

                case "Maquinaria":
                    Machinery nuevaMach = new Machinery(
                            nodoProd.getString("idProducto"),
                            nodoProd.getString("Nombre"),
                            nodoProd.getString("Area"),
                            nodoProd.getString("Estado"),
                            nodoProd.getString("FechaDeCompra"),
                            nodoProd.getInteger("ConsumoElectrico"),
                            nodoProd.getInteger("Cantidad"),
                            nodoProd.getString("Marca")
                    );

                    if (OpsID.decodeID(nuevaMach.getId())==null)
                        Trps.add(nuevaMach);
                    break;

                case "EquipamientoDeLimpieza":
                    CleaningEquipment nuevoCE = new CleaningEquipment(
                            nodoProd.getString("idProducto"),
                            nodoProd.getString("Nombre"),
                            nodoProd.getString("Area"),
                            nodoProd.getString("Estado"),
                            nodoProd.getString("FechaDeCompra"),
                            nodoProd.getInteger("Cantidad"),
                            nodoProd.getInteger("GradoDeRiesgo")
                    );

                    if (OpsID.decodeID(nuevoCE.getId())==null)
                        Trps.add(nuevoCE);
                    break;

                case "ProductoDeLimpieza":
                    CleaningProducts nuevoCP = new CleaningProducts(
                            nodoProd.getString("idProducto"),
                            nodoProd.getString("Nombre"),
                            nodoProd.getString("Area"),
                            nodoProd.getString("Estado"),
                            nodoProd.getString("FechaDeCompra"),
                            nodoProd.getInteger("Cantidad"),
                            nodoProd.getBoolean("Toxico"),
                            nodoProd.getString("Marca")
                    );

                    if (OpsID.decodeID(nuevoCP.getId())==null)
                    Trps.add(nuevoCP);
                    break;

                case "Medicinas":
                    Medicine nuevaM = new Medicine(
                            nodoProd.getString("idProducto"),
                            nodoProd.getString("Nombre"),
                            nodoProd.getString("Area"),
                            nodoProd.getString("Estado"),
                            nodoProd.getString("FechaDeCompra"),
                            nodoProd.getInteger("Cantidad"),
                            nodoProd.getBoolean("Toxico"),
                            (ArrayList<String>) nodoProd.get("RiesgosAlergicos"),
                            nodoProd.getString("FechaDeCaducidad"),
                            nodoProd.getString("ViaDeAdministracion")
                    );
                    if (OpsID.decodeID(nuevaM.getId())==null)
                        Trps.add(nuevaM);
                    break;

                case "Comida":
                    FoodMenu nuevaF = new FoodMenu(
                            nodoProd.getString("idProducto"),
                            nodoProd.getString("Nombre"),
                            nodoProd.getString("Area"),
                            nodoProd.getString("Estado"),
                            nodoProd.getString("FechaDeCompra"),
                            nodoProd.getInteger("Cantidad"),
                            nodoProd.getBoolean("Toxico"),
                            (ArrayList<String>) nodoProd.get("RiesgosAlergicos"),
                            nodoProd.getString("FechaDeCaducidad"),
                            nodoProd.getString("Proveedor")
                    );

                    if (OpsID.decodeID(nuevaF.getId())==null)
                        Trps.add(nuevaF);
                    break;
            }
        }

        //Cerramos el cursor para que no de problemas por no dejarle vacio
        cursor.close();
        return Trps;
    }
}



