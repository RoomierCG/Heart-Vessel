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
import objects.transportsystem.transportsystems.vehicle.vehicles.Ambulance;
import objects.transportsystem.transportsystems.vehicle.vehicles.CompanyCar;
import org.bson.Document;
import objects.area.areas.*;

import javax.crypto.Mac;
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
        Employee e = (Employee) traducir("PEE#01");
        /*
        updateAreasBackUp();
        updateProviderBackUp();
        updateTransportSystemBackUp();
        updatePeopleBackUp();
         */

    }

    public static Object traducir(String id) {
        String inicial = id.substring(0, 3);
        Object resultado = null;
        switch (inicial.substring(0, 2)) {
            case "PE":
                if (inicial.equals("PEE")) {
                    resultado = new Employee();
                } else if (inicial.equals("PEP")) {
                    resultado = new Patient();
                }
                for (Person person : ArrlPerson) {
                    if (person.getPersonId().equals(id)) {
                        resultado = person;
                    }
                    return resultado;
                }
                return null;

            case "PR":
                if (inicial.equals("PRC")) {
                    resultado = new FoodMenu();
                } else if (inicial.equals("PRE")) {
                    resultado = new CleaningEquipment();
                } else if (inicial.equals("PRL")) {
                    resultado = new CleaningProducts();
                } else if (inicial.equals("PRD")) {
                    resultado = new Medicine();
                } else if (inicial.equals("PRS")) {
                    resultado = new SanitationMaterials();
                } else if (inicial.equals("PRM")) {
                    resultado = new Machinery();
                }
                for (Product iterator : ArrlProduct) {
                    if (iterator.getEquipmentId().equals(id)) {
                        resultado = iterator;
                    }
                    return resultado;
                }
                return null;

            case "TR":
                if (inicial.equals("TRM")) {
                    resultado = new MovementAid();
                } else if (inicial.equals("TRA")) {
                    resultado = new Ambulance();
                } else if (inicial.equals("TRC")) {
                    resultado = new CompanyCar();
                }
                for (Transport iterator : ArrlTransport) {
                    if (iterator.getTransportId().equals(id)) {
                        resultado = iterator;
                    }
                    return resultado;
                }
                return null;

            case "PV":
                if (inicial.equals("TRM")) {
                    resultado = new Provider();
                }
                for (Provider iterator : ArrlProvider) {
                    if (iterator.getIdProvider().equals(id)) {
                        resultado = iterator;
                    }
                    return resultado;
                }
                return null;
            case "AR":
                if (inicial.equals("ARR")) {
                    resultado = new Area();
                } else if (inicial.equals("ARG")) {
                    resultado = new Garaje();
                } else if (inicial.equals("ARH")) {
                    resultado = new HabitableRoom();
                }
                for (Area iterator : ArrLarea) {
                    if (iterator.getIdArea().equals(id)) {
                        resultado = iterator;
                    }
                    return resultado;
                }
                return null;

            default:
                System.out.println("Caso no encontrado");
                break;

        }
        return Object.class;
    }

    public static void rellenarTest() {

        ArrayList<String> log = new ArrayList<>();
        log.add("16:43 | Ingresado");
        log.add("16:50 | Examinacion");
        log.add("17:30 | Inicio Tratamiento Anti-Zergling de Fanatazil ");
        log.add("19:34 | Transportado a habitacion 100001 para estancia nocturna");

        Employee aPE = new Employee("PEE#04", "Peter", "Yajodeh", "Working", "Medico", "Diurno", 12500, "Cirujano");
        Employee aPq = new Employee("PEE#01", "Juan", "Tuhzree", "Working", "Medico", "Nocturno", 7000, "Enfermero");
        Employee aPu = new Employee("PEE#02", "Mario", "Jeepetas", "Working", "Limpieza", "Diurno", 5000, "Limpieza de suelos");

        Patient pac1 = new Patient("PEP#01", "Edgar", "Aiurense", "Sin Pilones");
        Patient pac2 = new Patient("PEP#02", "Eldon", "Calletano", "Buscando Hilos");
        Patient pac3 = new Patient("PEP#03", "Lkoraz", "Ondeya", "Muerto", true, log, 100001);


        CleaningEquipment ave = new CleaningEquipment("PRE#02", "Fregona", "ARR#01", "Usado", "10/10/1000");
        CleaningEquipment aver = new CleaningEquipment("PRE#02", "Aspiradora", "ARR#01", "Cyka-Blyat", "10/10/1000");
        CleaningEquipment avegetal = new CleaningEquipment("PRE#03", "Escoba", "ARR#01", "Vacia", "10/10/1000");

        ArrayList<String> baia = new ArrayList<>();

        ArrayList<String> a = new ArrayList<>();
        a.add(aPE.getPersonId());
        a.add(aPq.getPersonId());
        a.add(aPu.getPersonId());

        baia.add(avegetal.getEquipmentId());
        HabitableRoom room = new HabitableRoom("ARH#01", "Habitacion 032", a, "ocupado", baia, 1, 0, 2);
        baia.add(ave.getEquipmentId());
        baia.add(aver.getEquipmentId());


        Ambulance uno = new Ambulance("TVA#01", "Aparcado", "Tercera Edad", a, 24, baia);
        Ambulance dos = new Ambulance("TVA#02", "En patrulla", "Accidentes Traumas y Golpes", a, 24, baia);
        Ambulance tres = new Ambulance("TVA#03", "En ruta a llamada de auxilio", "Toxicos", a, 24, baia);

        ArrayList<String> listaAmbulancias = new ArrayList<>();
        listaAmbulancias.add(uno.getTransportId());
        listaAmbulancias.add(dos.getTransportId());
        listaAmbulancias.add(tres.getTransportId());


        Area aasd = new Area("ARR#01", "Almacen", a, "vacio", baia, 2, 1);


        Garaje uff = new Garaje("ARG", a, "Kachow", "En llamas", baia, 1, 3, listaAmbulancias);

        FoodMenu peshcao = new FoodMenu("PRC#01", "Menu Pescado", "Almacen", "Limpio", "10/10/2010", false, null, "20/10/2020");
        Medicine coca = new Medicine("PRD#01", "Morfina", "Almacen", "Recibido", "10/10/2010", false, null, "20/10/2020");

        CleaningProducts Fairy = new CleaningProducts("PRL#01", "Jabon Multi Usos", "Almacen", "Recibido", "10/10/2010", false, "Fairy");
        CleaningProducts Lejia = new CleaningProducts("PRL#02", "Lejia", "Almacen", "Recibido", "10/10/2010", true, "Lagarto");

        CleaningEquipment Fregona = new CleaningEquipment("PRL#03", "Fregona", "Almacen", "Semi-nuevo", "15/04/2015");
        CleaningEquipment Guantes = new CleaningEquipment("PRL#04", "Guantes", "Almacen", "Nuevos", "15/04/2015");

        MovementAid muletas = new MovementAid("TAM#01", "Adultos", null, "ARR#01");

        Machinery xRay = new Machinery("PRM#01", "Maquina Rayos X", "Almacen", "En uso", "17/05/2005", 3000, "Aiur");
        baia.clear();

        baia.add(xRay.getEquipmentId());
        baia.add(coca.getEquipmentId());
        baia.add(Fairy.getEquipmentId());

        Area xrayRoom = new Area("ARR#02", "Sala Rayos X", a, "ocupado", baia, 3, 3);

        SanitationMaterials vendas = new SanitationMaterials("PRS#01", "Vendas", "Almacen", "Nuevo", "09/09/2009");

        Provider profesionalVerdor = new Provider("PVP#01", "VerdorInc", "545855");

        CompanyCar Elbuga = new CompanyCar("TVC#01", "Semi-nuevo", "2x4", 30, "Murcielago", "Bugatti", "PEE#04");

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
    /*
    public static void updateAreasBackUp() {

        //Borra todos los datos de la coleccion, por pruebas
        collectionArea.drop();

        for (Area area : ArrLarea) {

            //Declaracion de interables para los Arrayslists
            Document setData = new Document();
            Document setDataChild = new Document();
            Document setDataAux = new Document();

            setDataChild.put("Nombre", area.getName());

            for (String person : area.getPersonal()) {

                Document setPersonalDataAux = new Document();


                //Todas las invididuales
                setPersonalDataAux.put("ID Persona", person);
                setPersonalDataAux.put("Nombre", );
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

                            setDataVehicleInfo.put("Producto@" + product.getEquipmentId(), setDataVehicleInfoAux);
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

    public static void updateProductBackUp() {

        //Borra todos los datos de la coleccion, por pruebas
        collectionProduct.drop();

        //Declaracion de interables para los Arrayslists
        Document setData = new Document();

        for (Product product : ArrlProduct) {

            Document setDataChild = new Document();

            setDataChild.put("Id Producto", product.getEquipmentId());
            setDataChild.put("Nombre", product.getName());
            setDataChild.put("Cantidad", product.getQuantity()+" unidad/es.");
            Document ubicacion = new Document();

            setDataChild.put("Cantidad", product.getQuantity()+" unidad/es.");
            setDataChild.put("Cantidad", product.getQuantity()+" unidad/es.");


            collectionProvider.insertOne(setData);
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
    */

}

