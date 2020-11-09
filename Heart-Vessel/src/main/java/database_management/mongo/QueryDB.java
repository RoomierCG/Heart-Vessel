package database_management.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import database_management.AuxDB;
import objects.area.Area;
import objects.inventory.Inventory;
import objects.inventory.inventories.VehicleInventory;
import objects.people.Person;
import objects.people.person.Employee;
import objects.product.Product;
import objects.product.products.CleaningEquipment;
import objects.provider.Provider;
import objects.transportsystem.Transport;
import objects.transportsystem.transportsystems.vehicle.Vehicle;
import objects.transportsystem.transportsystems.vehicle.vehicles.Ambulance;
import org.bson.Document;
import objects.area.areas.*;

import javax.print.Doc;
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

//      updateAreasBackUp();
        updateProviderBackUp();

    }

    public static void updateAreasBackUp(){

        //Borra todos los datos de la coleccion, por pruebas
        collectionArea.drop();

        //Declaracion de interables para los Arrayslists
        Document setData = new Document();
        Document setDataChild = new Document();
        Document setDataAux = new Document();

        Employee aPE = new Employee(101,"Peter","s","Working","Surgeon", "Day",5000, "Yes");
        Employee aPq = new Employee(202,"Juan","GUA","Working","Surgeon", "Day",5000, "Yes");
        Employee aPu = new Employee(303,"asdfasd","Mario","Working","Surgeon", "Day",5000, "Yes");
        ArrayList<Person> a = new ArrayList<>();
        a.add(aPE);
        a.add(aPq);
        a.add(aPu);

        CleaningEquipment ave = new CleaningEquipment(100443,"Fregona",1,101000,"Usado","10/10/1000");
        CleaningEquipment aver = new CleaningEquipment(100443,"AK-47",10,101000,"Cyka-Blyat","10/10/1000");
        CleaningEquipment avegetal = new CleaningEquipment(100443,"La billetera",1,101000,"Vacia","10/10/1000");
        ArrayList<Product> baia = new ArrayList<>();
        baia.add(ave);
        baia.add(aver);
        baia.add(avegetal);


        VehicleInventory baya = new VehicleInventory(11,223,baia);

        Ambulance uno = new Ambulance(45,"maaas","asdasdasd",a,24,baia);
        Ambulance dos = new Ambulance(55,"maaas","asdasdasd",a,24,baia);
        Ambulance tres = new Ambulance(35,"maaas","asdasdasd",a,24,baia);

        ArrayList<Vehicle> bulbul = new ArrayList<>();
        bulbul.add(uno);
        bulbul.add(dos);
        bulbul.add(tres);

        HabitableRoom room = new HabitableRoom(100001,"Hcamilla",a,"ocupado",4056,1,0,2);
        Area aasd = new Area(200002,"Tumadre",a,"ocupado",5056,2,3);
        Garaje uff = new Garaje(101000,a,"Kachow","En llamas",6,1,3,bulbul);
        ArrLarea.add(room);
        ArrLarea.add(aasd);
        ArrLarea.add(uff);


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


            Document prueba1 = new Document();

            if (area instanceof Garaje){

                Document setDataVehicle = new Document();
                prueba1.clear();

                for (Vehicle vehicle: ((Garaje) area).getVehicles()) {

                    setDataVehicle.clear();

                    setDataVehicle.put("TransportID",vehicle.getTransportId());
                    setDataVehicle.put("Gasolina",vehicle.getGasTank());
                    setDataVehicle.put("Tipo",vehicle.getType());
                    setDataVehicle.put("Estado",vehicle.getStatus());

                    Document setDataVehicleEq = new Document();

                    if(vehicle instanceof Ambulance){
                        setDataVehicle.put("Tipo","Amblancia");
                        for (Product product: ((Ambulance) vehicle).getEquipment() ){

                            setDataVehicleEq.clear();

                            setDataVehicleEq.put("Nombre",product.getName());
                            setDataVehicleEq.put("Cantidad",product.getQuantity());
                            setDataVehicleEq.put("Estado",product.getStatus());
                        }

                        setDataVehicle.put("Equipamiento",setDataVehicleEq);
                    }

                    prueba1.put("Ambulancia@"+vehicle.getTransportId(),setDataVehicle);
                }

                setDataChild.put("vehiculos", prueba1);
            }else if (area instanceof HabitableRoom){

                setDataChild.put("paciente Nº",((HabitableRoom) area).getIdPatient());

            }else{
                System.out.println("F en la terminal");
            }

            setData.put("Area@"+Integer.toString(area.getIdArea()),setDataChild);
            collectionArea.insertOne(setData);
        }

    }

    public static void updateProviderBackUp(){

        //Borra todos los datos de la coleccion, por pruebas
        collectionArea.drop();

        //Declaracion de interables para los Arrayslists
        Document setData = new Document();
        Document setDataChild = new Document();

        for (Provider provider: ArrlProvider) {

            setData.clear();
            setDataChild.clear();

            setDataChild.put("Id del proveedor",provider.getIdProvider());
            setDataChild.put("Empresa",provider.getName());
            setDataChild.put("ISBN",provider.getAccount());

            setData.put("Proveedor "+provider.getIdProvider(),setDataChild);
            collectionProvider.insertOne(setData);
        }

    }

}

