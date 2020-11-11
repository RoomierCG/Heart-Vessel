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
//      updateProviderBackUp();
        updateTransportSystemBackUp();
//      updatePeopleBackUp();

    }

    public static void rellenarTest() {

        ArrayList<String> log = new ArrayList<>();
        log.add("16:43 | Ingresado");
        log.add("16:50 | Examinacion");
        log.add("17:30 | Inicio Tratamiento Anti-Zergling de Fanatazil ");
        log.add("19:34 | Transportado a habitacion 100001 para estancia nocturna");

        Employee aPE = new Employee(101, "Peter", "Sayon", "Working", "Medico", "Diurno", 12500, "Cirujano");
        Employee aPq = new Employee(202, "Juan", "Tuhzree", "Working", "Medico", "Nocturno", 7000, "Enfermero");
        Employee aPu = new Employee(303, "Mario", "Jeepetas", "Working", "Limpieza", "Diurno", 5000, "Limpieza de suelos");

        Patient pac1 = new Patient(303, "Edgar", "Aiurense", "Sin Pilones");
        Patient pac2 = new Patient(303, "Eldon", "Calletano", "Buscando Hilos");
        Patient pac3 = new Patient(303, "Lkoraz", "Ondeya", "Muerto", true, log, 100001);


        CleaningEquipment ave = new CleaningEquipment(100443, "Fregona", 1, 101000, "Usado", "10/10/1000");
        CleaningEquipment aver = new CleaningEquipment(101243, "AK-47", 10, 101000, "Cyka-Blyat", "10/10/1000");
        CleaningEquipment avegetal = new CleaningEquipment(104043, "La billetera", 1, 101000, "Vacia", "10/10/1000");
        ArrayList<Product> baia = new ArrayList<>();

        ArrayList<Person> a = new ArrayList<>();
        a.add(aPE);
        a.add(aPq);
        a.add(aPu);

        baia.add(avegetal);
        HabitableRoom room = new HabitableRoom(100001, "Hcamilla", a, "ocupado", baia, 1, 0, 2);
        baia.add(ave);
        baia.add(aver);


        Ambulance uno = new Ambulance(45, "Aparcado", "Tercera Edad", a, 24, baia);
        Ambulance dos = new Ambulance(55, "En patrulla", "Accidentes Traumas y Golpes", a, 24, baia);
        Ambulance tres = new Ambulance(35, "En ruta a llamada de auxilio", "Toxicos", a, 24, baia);

        ArrayList<Vehicle> listaAmbulancias = new ArrayList<>();
        listaAmbulancias.add(uno);
        listaAmbulancias.add(dos);
        listaAmbulancias.add(tres);


        Area aasd = new Area(200002, "Almacen", a, "vacio", baia, 2, 1);


        Garaje uff = new Garaje(101000, a, "Kachow", "En llamas", baia, 1, 3, listaAmbulancias);

        FoodMenu peshcao = new FoodMenu(40404, "Menu Pescado", 503, 200002, "Limpio", "10/10/2010", false, null, "20/10/2020");
        Medicine coca = new Medicine(43404, "Morfina", 20, 200002, "Recibido", "10/10/2010", false, null, "20/10/2020");

        CleaningProducts Fairy = new CleaningProducts(50404, "Jabon Multi Usos", 5, 200002, "Recibido", "10/10/2010", false, "Fairy");
        CleaningProducts Lejia = new CleaningProducts(50304, "Lejia", 10, 200002, "Recibido", "10/10/2010", true, "Lagarto");

        CleaningEquipment Fregona = new CleaningEquipment(60404, "Fregona", 10, 20002, "Semi-nuevo", "15/04/2015");
        CleaningEquipment Guantes = new CleaningEquipment(60402, "Guantes", 56, 20002, "Nuevos", "15/04/2015");

        MovementAid muletas = new MovementAid(403033, "Largos", -1, 200002);

        Machinery xRay = new Machinery(70030, "Maquina Rayos X", 1, 12, "En uso", "17/05/2005", 3003, "Aiur");
        baia.clear();

        baia.add(xRay);
        baia.add(coca);
        baia.add(Fairy);

        Area xrayRoom = new Area(300302, "Sala Rayos X", a, "ocupado", baia, 3, 3);

        SanitationMaterials vendas = new SanitationMaterials(70034, "Vendas", 500, 200002, "Nuevo", "09/09/2009");

        Provider profesionalVerdor = new Provider(205343, "VerdorInc", "545855");

        CompanyCar Elbuga = new CompanyCar(80349, "Semi-nuevo", "2x4", 30, "Murcielago", "Bugatti", 202);

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
        + 1 Movement Aid
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
            ArrlTransport.add(muletas);

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

        for (Area area : ArrLarea) {

            //Declaracion de interables para los Arrayslists
            Document setData = new Document();
            Document setDataChild = new Document();
            Document setDataAux = new Document();

            setDataChild.put("Nombre", area.getName());

            for (Person person : area.getPersonal()) {

                Document setPersonalDataAux = new Document();


                //Todas las invididuales
                setPersonalDataAux.put("ID Persona", person.getPersonId());
                setPersonalDataAux.put("Nombre", person.getName());
                setPersonalDataAux.put("Apellido", person.getLastName());

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
            setDataChild.put("Riesgo", area.getRisk());


            Document setDataVehicle = new Document();

            if (area instanceof Garaje) {
                for (Vehicle vehicle : ((Garaje) area).getVehicles()) {

                    Document setDataVehicleAux = new Document();


                    setDataVehicleAux.put("TransportID", vehicle.getTransportId());
                    setDataVehicleAux.put("Gasolina", vehicle.getGasTank());
                    setDataVehicleAux.put("Tipo", vehicle.getType());
                    setDataVehicleAux.put("Estado", vehicle.getStatus());


                    if (vehicle instanceof Ambulance) {

                        setDataVehicleAux.put("Tipo", "Amblancia");

                        Document setDataVehicleInfo = new Document();

                        for (Product product : ((Ambulance) vehicle).getEquipment()) {

                            Document setDataVehicleInfoAux = new Document();

                            setDataVehicleInfoAux.put("Nombre", product.getName());
                            setDataVehicleInfoAux.put("Cantidad", product.getQuantity());
                            setDataVehicleInfoAux.put("Estado", product.getStatus());

                            setDataVehicleInfo.put("Producto@"+product.getEquipmentId(),setDataVehicleInfoAux);
                        }

                        setDataVehicleAux.put("Equipamiento", setDataVehicleInfo);
                    }

                    setDataVehicle.put("Ambulancia@" + vehicle.getTransportId(), setDataVehicleAux);
                }

                setDataChild.put("Vehiculos", setDataVehicle);
            } else if (area instanceof HabitableRoom) {

                setDataChild.put("Nº Paciente", ((HabitableRoom) area).getIdPatient());

            }

            setData.put("Area@" + area.getIdArea(), setDataChild);
            collectionArea.insertOne(setData);
        }
    }

    public static void updateProviderBackUp() {

        //Borra todos los datos de la coleccion, por pruebas
        collectionProvider.drop();

        //Declaracion de interables para los Arrayslists
        Document setData = new Document();

        for (Provider provider : ArrlProvider) {

            Document setDataChild = new Document();

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


        for (Transport transport : ArrlTransport) {

            //Declaracion de interables para los Arrayslists
            Document setData = new Document();
            Document setDataChild = new Document();

            String VehicleType = "Error";

            if (transport instanceof MovementAid) {

                VehicleType = "Ayuda de movilidad";

                setDataChild.put("Id transporte", transport.getTransportId());
                setDataChild.put("Estado", transport.getStatus());
                if (((MovementAid) transport).getPatient() >= 0) {
                    setDataChild.put("Id de paciente", (((MovementAid) transport).getPatient()));
                } else {
                    setDataChild.put("Id de paciente", "<Disponible>");
                }

            } else if (transport instanceof Ambulance) {

                VehicleType = "Ambulancia";

                setDataChild.put("Tipo", ((Ambulance) transport).getType());
                setDataChild.put("Id del transporte", transport.getTransportId());
                setDataChild.put("Estado", transport.getStatus());
                setDataChild.put("Gasolina", ((Ambulance) transport).getGasTank() + "L");

                Document setDataPerson = new Document();

                for (Person person : ((Ambulance) transport).getPersonal()) {

                    Document setDataPersonAux = new Document();

                    //Todas las invididuales
                    setDataPersonAux.put("ID Persona", person.getPersonId());
                    setDataPersonAux.put("Nombre", person.getName());
                    setDataPersonAux.put("Apellido", person.getLastName());

                    if (person instanceof Employee) {
                        setDataPerson.put(("Empleado@" + person.getPersonId()), setDataPersonAux);
                    } else {
                        setDataPerson.put(("Paciente@" + person.getPersonId()), setDataPersonAux);
                    }
                }
                setDataChild.put("Personas", setDataPerson);

                Document setDataAux = new Document();

                for (Product product : ((Ambulance) transport).getEquipment()) {

                    Document setDataProduct = new Document();

                    setDataProduct.put("Id del producto", product.getEquipmentId());
                    setDataProduct.put("Nombre", product.getName());
                    setDataProduct.put("Cantidad", product.getQuantity());
                    setDataProduct.put("Fecha de compra", product.getBuyDate());
                    setDataProduct.put("Estado", product.getStatus());
                    setDataProduct.put("Id del area", product.getIdArea());

                    setDataAux.put("Producto@" + product.getEquipmentId(), setDataProduct);
                }

                setDataChild.put("Productos", setDataAux);

            } else if (transport instanceof CompanyCar) {

                VehicleType = "Coche de compañia";

                setDataChild.put("tipo", "Coche de la compañia");
                setDataChild.put("Id de transporte", transport.getTransportId());
                setDataChild.put("Estado", transport.getStatus());
                setDataChild.put("Marca", ((CompanyCar) transport).getMake());
                setDataChild.put("Modelo", ((CompanyCar) transport).getModel());
                setDataChild.put("Gasolina", ((CompanyCar) transport).getGasTank() + "L");
                setDataChild.put("Tipo", ((CompanyCar) transport).getType());

            } else {
                setDataChild.put("Estas jugando a ser DIOS?", "Aquí tendrian que haber datos");
            }

            setData.put(VehicleType + "@" + transport.getTransportId(), setDataChild);
            collectionTransportSystem.insertOne(setData);
        }

    }

    public static void updatePeopleBackUp() {
        //Borra todos los datos de la coleccion, por pruebas
        collectionPerson.drop();

        for (Person person : ArrlPerson) {

            //Limpiamos buffer para añadirlo a mongo
            Document setData = new Document();
            Document setDataChild = new Document();
            String type = "Error";

            setDataChild.put("Nombre", person.getName());
            setDataChild.put("Apellido", person.getLastName());
            setDataChild.put("Estado", person.getStatus());

            if (person instanceof Employee) {
                type = "Empleado";
                Document setDataEmployee = new Document();
                setDataEmployee.put("Tipo", ((Employee) person).getType());
                setDataEmployee.put("Sueldo", ((Employee) person).getSalary());
                setDataEmployee.put("Jornada", ((Employee) person).getShift());
                setDataEmployee.put("Puesto", ((Employee) person).getJob());
                setDataChild.put("Datos Laborales", setDataEmployee);

            } else if (person instanceof Patient) {

                type = "Paciente";
                Document setDataPacient = new Document();

                if (((Patient) person).isAllowVisitors()) {
                    setDataChild.put("Permite Visitas:", "SI");
                } else {
                    setDataChild.put("Permite Visitas:", "NO");
                }
                if (((Patient) person).getRoomId() != -1) {
                    setDataChild.put("Habitacion:", ((Patient) person).getRoomId());
                }
                if (((Patient) person).getRegistry().size() > 0) {

                    for (String a : ((Patient) person).getRegistry()) {
                        setDataPacient.put(a.substring(0, 7), a.substring(8));
                    }
                    setDataChild.put("Registro", setDataPacient);
                }
            }
            setData.put(type + "@" + person.getPersonId(), setDataChild);
            collectionPerson.insertOne(setData);
        }

    }


}

