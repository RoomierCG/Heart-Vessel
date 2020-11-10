package database_management.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import database_management.AuxDB;
import objects.area.Area;
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
import objects.transportsystem.transportsystems.vehicle.Vehicle;
import objects.transportsystem.transportsystems.vehicle.vehicles.Ambulance;
import objects.transportsystem.transportsystems.vehicle.vehicles.CompanyCar;
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

        //Inializacion de ArrayLists
        ArrLarea = AuxDB.ArrLarea;
        ArrlPerson = AuxDB.ArrlPerson;
        ArrlProduct = AuxDB.ArrlProduct;
        ArrlProvider = AuxDB.ArrlProvider;
        ArrlTransport = AuxDB.ArrlTransport;

        rellenarTest();

//      updateAreasBackUp();
//        updateProviderBackUp();
        updateTransportSystemBackUp();

    }

    public static void rellenarTest(){

        Employee aPE = new Employee(101,"Peter","s","Working","Surgeon", "Day",5000, "Yes");
        Employee aPq = new Employee(202,"Juan","GUA","Working","Surgeon", "Day",5000, "Yes");
        Employee aPu = new Employee(303,"asdfasd","Mario","Working","Surgeon", "Day",5000, "Yes");

        Patient pac1 = new Patient(303,"Edgar","Aiurense","Sin Pilones");
        Patient pac2 = new Patient(303,"Eldon","Calletano","Buscando Hilos");
        Patient pac3 = new Patient(303,"Lkoraz","Ondeya","Muerto");

        ArrayList<Person> a = new ArrayList<>();
        a.add(aPE);
        a.add(aPq);
        a.add(aPu);

        CleaningEquipment ave = new CleaningEquipment(100443,"Fregona",1,101000,"Usado","10/10/1000");
        CleaningEquipment aver = new CleaningEquipment(100443,"AK-47",10,101000,"Cyka-Blyat","10/10/1000");
        CleaningEquipment avegetal = new CleaningEquipment(100443,"La billetera",1,101000,"Vacia","10/10/1000");
        ArrayList<Product> baia = new ArrayList<>();



        baia.add(avegetal);
        HabitableRoom room = new HabitableRoom(100001,"Hcamilla",a,"ocupado",baia,1,0,2);
        baia.add(ave);
        baia.add(aver);



        Ambulance uno = new Ambulance(45,"maaas","asdasdasd",a,24,baia);
        Ambulance dos = new Ambulance(55,"maaas","asdasdasd",a,24,baia);
        Ambulance tres = new Ambulance(35,"maaas","asdasdasd",a,24,baia);

        ArrayList<Vehicle> bulbul = new ArrayList<>();
        bulbul.add(uno);
        bulbul.add(dos);
        bulbul.add(tres);


        Area aasd = new Area(200002,"Almacen",a,"vacio",baia,2,1);


        Garaje uff = new Garaje(101000,a,"Kachow","En llamas",baia,1,3,bulbul);

        FoodMenu peshcao = new FoodMenu(40404,"Menu Pescado",503,200002,"Limpio","10/10/2010",false,null,"20/10/2020");
        Medicine coca = new Medicine(43404,"Morfina",20,200002,"Recibido","10/10/2010",false,null,"20/10/2020");

        CleaningProducts Fairy = new CleaningProducts(50404,"Jabon Multi Usos",5,200002,"Recibido","10/10/2010",false,"Fairy");
        CleaningProducts Lejia = new CleaningProducts(50304,"Lejia",10,200002,"Recibido","10/10/2010",true,"Lagarto");

        CleaningEquipment Fregona = new CleaningEquipment(60404,"Fregona",10,20002,"Semi-nuevo","15/04/2015");
        CleaningEquipment Guantes = new CleaningEquipment(60402,"Guantes",56,20002,"Nuevos","15/04/2015");



        Machinery xRay = new Machinery(70030,"Maquina Rayos X",1,12,"En uso","17/05/2005",3003,"Aiur");
        baia.clear();
        baia.add(xRay);
        baia.add(coca);
        baia.add(Fairy);
        Area xrayRoom = new Area(300302,"Sala Rayos X",a,"ocupado",baia,3,3);

        SanitationMaterials vendas = new SanitationMaterials(70034,"Vendas",500,200002,"Nuevo","09/09/2009");

        Provider profesionalVerdor = new Provider(205343,"VerdorInc","545855");

        CompanyCar Elbuga = new CompanyCar(80349,"Semi-nuevo","2x4",30,"Murcielago","Bugatti",202);

         /*
        + 3 Empleados
        + 3 Paciente
        + 3 Cleaning Equipment
        + 1 Inventario de Vehiculo
        + 3 Ambulancias
        + 1 Habitacion Habitable
        + 1 Garaje
        + 2 Area no-generica
        + 1 FoodMenu
        + 1 Medicina
        + 2 Cleaning Products
        + 1 Machinery
        + 1 Sanitation Materials
        + 1 Proveedor
         */
        {
            ArrlPerson.add(aPE);
            ArrlPerson.add(aPq);
            ArrlPerson.add(aPu);

            ArrlPerson.add(pac1);
            ArrlPerson.add(pac2);
            ArrlPerson.add(pac3);

            ArrlProduct.add(ave);
            ArrlProduct.add(aver);
            ArrlProduct.add(avegetal);

            ArrlTransport.add(uno);
            ArrlTransport.add(dos);
            ArrlTransport.add(tres);
            ArrlTransport.add(Elbuga);

            ArrLarea.add(room);
            ArrLarea.add(aasd);
            ArrLarea.add(uff);
            ArrLarea.add(xrayRoom);

            ArrlProduct.add(peshcao);
            ArrlProduct.add(coca);
            ArrlProduct.add(Fairy);
            ArrlProduct.add(Lejia);
            ArrlProduct.add(Fregona);
            ArrlProduct.add(Guantes);
            ArrlProduct.add(xRay);
            ArrlProduct.add(vendas);


            ArrlProvider.add(profesionalVerdor);


        }

    }

    public static void updateAreasBackUp() {

        //Borra todos los datos de la coleccion, por pruebas
        collectionArea.drop();

        //Declaracion de interables para los Arrayslists
        Document setData = new Document();
        Document setDataChild = new Document();
        Document setDataAux = new Document();

        for (Area area : ArrLarea) {

            //Limpiamos buffer para añadirlo a mongo
            setData.clear();
            setDataChild.clear();
            setDataAux.clear();

            setDataChild.put("name", area.getName());

            Document setPersonalDataAux = new Document();
            for (Person person : area.getPersonal()) {

                setPersonalDataAux.clear();

                //Todas las invididuales
                setPersonalDataAux.put("personaId", person.getPersonId());
                setPersonalDataAux.put("nombre", person.getName());
                setPersonalDataAux.put("apellido", person.getLastName());

                if (person instanceof Employee) {
                    setPersonalDataAux.put("Tipo:", "Empleado");
                } else {
                    setPersonalDataAux.put("Tipo:", "Paciente");
                }
                setDataAux.put((person.getName() + "@" + person.getPersonId()), setPersonalDataAux);
            }

            setDataChild.put("Personal", setDataAux);
            setDataChild.put("Estado", area.getStatus());
            setDataChild.put("Planta", area.getFloor());
            setDataChild.put("riesgo", area.getRisk());


            Document prueba1 = new Document();

            if (area instanceof Garaje) {

                Document setDataVehicle = new Document();
                prueba1.clear();

                for (Vehicle vehicle : ((Garaje) area).getVehicles()) {

                    setDataVehicle.clear();

                    setDataVehicle.put("TransportID", vehicle.getTransportId());
                    setDataVehicle.put("Gasolina", vehicle.getGasTank());
                    setDataVehicle.put("Tipo", vehicle.getType());
                    setDataVehicle.put("Estado", vehicle.getStatus());

                    Document setDataVehicleEq = new Document();

                    if (vehicle instanceof Ambulance) {
                        setDataVehicle.put("Tipo", "Amblancia");
                        for (Product product : ((Ambulance) vehicle).getEquipment()) {

                            setDataVehicleEq.clear();

                            setDataVehicleEq.put("Nombre", product.getName());
                            setDataVehicleEq.put("Cantidad", product.getQuantity());
                            setDataVehicleEq.put("Estado", product.getStatus());
                        }

                        setDataVehicle.put("Equipamiento", setDataVehicleEq);
                    }

                    prueba1.put("Ambulancia@" + vehicle.getTransportId(), setDataVehicle);
                }

                setDataChild.put("vehiculos", prueba1);
            } else if (area instanceof HabitableRoom) {

                setDataChild.put("paciente Nº", ((HabitableRoom) area).getIdPatient());

            } else {
                System.out.println("F en la terminal");
            }

            setData.put("Area@" + Integer.toString(area.getIdArea()), setDataChild);
            collectionArea.insertOne(setData);
        }

    }

    public static void updateProviderBackUp() {

        //Borra todos los datos de la coleccion, por pruebas
        collectionProvider.drop();

        //Declaracion de interables para los Arrayslists
        Document setData = new Document();
        Document setDataChild = new Document();

        for (Provider provider : ArrlProvider) {

            setData.clear();
            setDataChild.clear();

            setDataChild.put("Id del proveedor", provider.getIdProvider());
            setDataChild.put("Empresa", provider.getName());
            setDataChild.put("ISBN", provider.getAccount());

            setData.put("Proveedor " + provider.getIdProvider(), setDataChild);
            collectionProvider.insertOne(setData);
        }

    }

    public static void updateTransportSystemBackUp() {

        //Borra todos los datos de la coleccion, por pruebas
        collectionTransportSystem.drop();

        //Declaracion de interables para los Arrayslists
        Document setData = new Document();
        Document setDataChild = new Document();

        for (Transport transport : ArrlTransport) {

            setData.clear();
            setDataChild.clear();

            if (transport instanceof MovementAid) {

                setDataChild = new Document();

                setDataChild.put("Id transporte", transport.getTransportId());
                setDataChild.put("estado", transport.getStatus());
                setDataChild.put("Id de paciente", (((MovementAid) transport).getPatient()));

            } else if (transport instanceof Ambulance) {

                Document setDataAux = new Document();
                Document setDataProduct = new Document();
                setDataAux.clear();

                setDataChild.put("tipo","ambulancia");

                for (Product product : ((Ambulance) transport).getEquipment()) {

                    setDataProduct.clear();

                    setDataProduct.put("Id del producto", product.getEquipmentId());
                    setDataProduct.put("Nombre",product.getName());
                    setDataProduct.put("Cantidad",product.getQuantity());
                    setDataProduct.put("Fecha de compra",product.getBuyDate());
                    setDataProduct.put("Estado",product.getStatus());
                    setDataProduct.put("Id del area",product.getIdArea());

                    setDataAux.put("Producto@"+product.getEquipmentId(),setDataProduct);
                }
                setDataChild.put("Productos", setDataAux);

            } else if (transport instanceof CompanyCar) {

            } else {
                setDataChild.put("Estas jugando a ser DIOS?", "Aquí tendrian que haber datos");
            }

            setData.put("Transporte@" + transport.getTransportId(), setDataChild);
            collectionTransportSystem.insertOne(setData);
        }

    }

}

