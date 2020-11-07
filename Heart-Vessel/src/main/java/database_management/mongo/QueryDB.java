package database_management.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import database_management.AuxDB;
import objects.area.Area;
import objects.inventory.Inventory;
import objects.people.Person;
import objects.people.person.Employee;
import objects.product.Product;
import objects.provider.Provider;
import objects.transportsystem.Transport;
import objects.transportsystem.transportsystems.vehicle.Vehicle;
import org.bson.Document;
import objects.area.areas.*;

import java.util.ArrayList;

public class QueryDB {

    //Declaracion de Conexion a BD
    private static MongoClient mongoClient;
    private static MongoDatabase db;

    //Declaracion de colecciones mongo
    private static MongoCollection<Document> collectionArea;
    private static MongoCollection<Document> collectionTransportSystem;
    private static MongoCollection<Document> collectionInventory;
    private static MongoCollection<Document> collectionPerson;
    private static MongoCollection<Document> collectionProduct;
    private static MongoCollection<Document> collectionProvider;

    //Declaracion de ArrayLists
    private static ArrayList<Area> ArrLarea;
    private static ArrayList<Inventory> ArrlInventories;
    private static ArrayList<Person> ArrlPerson;
    private static ArrayList<Product> ArrlProduct;
    private static ArrayList<Provider> ArrlProvider;
    private static ArrayList<Transport> ArrlTransport;

    //Declaracion de interables para los Arrayslists
    private static Document setDataChild = new Document();
    private static Document setData = new Document();
    private static Document setDataAux = new Document();

    public static void main(String[] args) {

        //Inicializacion de conexion BD
        mongoClient = new MongoClient("localhost",27017);
        db = mongoClient.getDatabase("vessel");

        //Inializacion de colecciones mongo
        collectionArea = db.getCollection("area");
        collectionTransportSystem = db.getCollection("inventory");
        collectionInventory = db.getCollection("person");
        collectionPerson = db.getCollection("product");
        collectionProduct = db.getCollection("provider");
        collectionProvider = db.getCollection("transportSystem");

        //Inializacion de ArrayLists
        ArrLarea = AuxDB.ArrLarea;
        ArrlInventories = AuxDB.ArrlInventories;
        ArrlPerson = AuxDB.ArrlPerson;
        ArrlProduct = AuxDB.ArrlProduct;
        ArrlProvider = AuxDB.ArrlProvider;
        ArrlTransport = AuxDB.ArrlTransport;

        updateAreasBackUp();


    }

    public static void updateAreasBackUp(){
        Employee aPE = new Employee(01,"Peter","s","Working","Surgeon", "Day",5000, "Yes");
        Employee aPq = new Employee(02,"Juan","GUA","Working","Surgeon", "Day",5000, "Yes");
        Employee aPu = new Employee(03,"asdfasd","Mario","Working","Surgeon", "Day",5000, "Yes");
        ArrayList<Person> a = new ArrayList<>();
        a.add(aPE);
        a.add(aPq);
        a.add(aPu);

        HabitableRoom room = new HabitableRoom(100001,"Hcamilla",a,"ocupado",056,1,0,2);
        HabitableRoom aasd = new HabitableRoom(200002,"Tumadre",a,"ocupado",056,1,0,2);
        ArrLarea.add(room);
        ArrLarea.add(aasd);

        for (Area area: ArrLarea) {

            //Limpiamos buffer para añadirlo a mongo
            setData.clear();
            setDataChild.clear();
            setDataAux.clear();

            setDataChild.put("name", area.getName());

            Document setPersonalDataAux = new Document();
            for (Person person: area.getPersonal()) {

                setPersonalDataAux.clear();

                //Todas las invididuales
                setPersonalDataAux.put("personaId",person.getPersonId());
                setPersonalDataAux.put("nombre",person.getName());
                setPersonalDataAux.put("apellido",person.getLastName());

                if(person instanceof Employee){
                    setPersonalDataAux.put("Tipo:","Empleado");
                }else{
                    setPersonalDataAux.put("Tipo:","Paciente");
                }
                setDataAux.put((person.getName()+"@"+person.getPersonId()),setPersonalDataAux);
            }

            setDataChild.put("Personal", setDataAux);
            setDataChild.put("Estado", area.getStatus());
            setDataChild.put("Inventario", area.getIdInventory());
            setDataChild.put("Planta", area.getFloor());
            setDataChild.put("riesgo",area.getRisk());

            if (area instanceof Garaje){

                Document setDataVehicle = new Document();
                setDataAux.clear();

                for (Vehicle vehicle: ((Garaje) area).getVehicles()) {

                    //setDataVehicle.put("z", vehicle);
                }

                setDataChild.put("vehiculos", setDataAux);
            }

            setData.put(Integer.toString(area.getIdArea()),setDataChild);
            collectionArea.insertOne(setData);
        }

    }

}

