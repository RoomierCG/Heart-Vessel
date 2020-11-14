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

import javax.crypto.Mac;
import java.util.ArrayList;

import static java.util.Arrays.asList;

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

        updateAreasBackUp();
        updateProviderBackUp();
        updateTransportSystemBackUp();
        updateProductBackUp();
        updatePeopleBackUp();
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

    public static void updateAreasBackUp() {

        //Borra todos los datos de la coleccion, por pruebas
        collectionArea.drop();

        for (Area area : ArrLarea) {

            Document newArea = new Document()
                    .append("idArea", area.getIdArea())
                    .append("Nombre", area.getName())
                    .append("Personal", area.getPersonal())
                    .append("Equipamiento", area.getEquipment())
                    .append("Estado", area.getStatus())
                    .append("Planta", area.getFloor())
                    .append("Riesgo", area.getRisk());

            if (area instanceof Garaje) {
                newArea.append("Tipo", "Garaje")
                        .append("Vehiculos",((Garaje) area).getVehicles());

            } else if (area instanceof HabitableRoom) {
                newArea.append("Tipo","Habitacion")
                        .append("idPaciente", ((HabitableRoom) area).getIdPatient());

            }

            collectionArea.insertOne(newArea);
        }
    }

    public static void updateProviderBackUp(){

        //Borra todos los datos de la coleccion, por pruebas
        collectionProvider.drop();

        for (Provider provider: ArrlProvider) {

            collectionProvider.insertOne(new Document()
                    .append("idProveedor", provider.getIdProvider())
                    .append("Nombre" , provider.getName())
                    .append("IBAN", provider.getAccount())
            );
        }


    }

    public static void updateTransportSystemBackUp() {

        //Borra todos los datos de la coleccion, por pruebas
        collectionTransportSystem.drop();

        for (Transport transport: ArrlTransport) {

            Document newTranport = new Document()
                    .append("idTransporte", transport.getTransportId())
                    .append("Estado", transport.getStatus());

            if (transport instanceof MovementAid){
                newTranport.append("Tipo","Ayuda Movil")
                            .append("idArea",((MovementAid) transport).getIdArea())
                            .append("idPaciente", ((MovementAid) transport).getPatient());

            }else if (transport instanceof Ambulance){
                newTranport.append("Tipo", "Ambulancia")
                            .append("Personal", ((Ambulance) transport).getPersonal())
                            .append("Productos", ((Ambulance) transport).getEquipment())
                            .append("Gasolina", ((Ambulance) transport).getGasTank())
                            .append("Especialidad", ((Ambulance) transport).getType());

            }else if (transport instanceof CompanyCar){
                newTranport.append("Tipo", "Vehiculo")
                            .append("Modelo", ((CompanyCar) transport).getModel())
                            .append("Marca", ((CompanyCar) transport).getMake())
                            .append("Gasolina", ((CompanyCar) transport).getGasTank())
                            .append("Especialidad", ((CompanyCar) transport).getType())
                            .append("Dueño", ((CompanyCar) transport).getIdPersona());

            }

            collectionTransportSystem.insertOne(newTranport);
        }
    }

    //TODO Revisar los atributos Tipo()
    public static void updateProductBackUp() {

        //Borra todos los datos de la coleccion, por pruebas
        collectionProduct.drop();

        for (Product product: ArrlProduct) {

            Document newProduct = new Document()
                    .append("idProducto", product.getEquipmentId())
                    .append("Nombre", product.getName())
                    .append("Area", product.getIdArea())
                    .append("Estado", product.getStatus())
                    .append("FechaDeCompra", product.getBuyDate());

            if (product instanceof SanitationMaterials){
                newProduct.append("MarcaModelo", ((SanitationMaterials) product).getModel())
                            .append("Uso", ((SanitationMaterials) product).getType())
                            .append("Tipo","MaterialSanitario");

            }else if (product instanceof Machinery){
                newProduct.append("ConsumicionEnergetica", ((Machinery) product).getElectricityConsumption())
                            .append("Modelo", ((Machinery) product).getModel())
                            .append("Tipo", "Maquinaria");

            }else if (product instanceof CleaningEquipment){
                newProduct.append("GradoDeRiesgo", ((CleaningEquipment) product).getRiskFactor())
                            .append("Uso", ((CleaningEquipment) product).getType())
                            .append("Tipo","EquipamientoDeLimpieza");

            }else if (product instanceof CleaningProducts){
                newProduct.append("Marca", ((CleaningProducts) product).getMake())
                            .append("Toxicidad", ((CleaningProducts) product).isToxic())
                            .append("Tipo", "ProductoDeLimpieza");

            }else if (product instanceof Medicine){
                newProduct.append("Toxicidad", ((Medicine) product).isToxic())
                            .append("RiesgosAlergicos", ((Medicine) product).getAllergyRiskIngredients())
                            .append("FechaDeCaducidad", ((Medicine) product).getExpirationDate())
                            .append("ViaDeAdministracion", ((Medicine) product).getAdministered())
                            .append("Tipo", "Medicinas");

            }else if (product instanceof FoodMenu){
                newProduct.append("Toxicidad", ((FoodMenu) product).isToxic())
                        .append("RiesgosAlergicos", ((FoodMenu) product).getAllergyRiskIngredients())
                        .append("FechaDeCaducidad", ((FoodMenu) product).getExpirationDate())
                        .append("Uso", ((FoodMenu) product).getType())
                        .append("Proveedor", ((FoodMenu) product).getProvider())
                        .append("Tipo", "Comida");
            }

            collectionProduct.insertOne(newProduct);
        }
    }


    public static void updatePeopleBackUp() {
        //Borra todos los datos de la coleccion, por pruebas
        collectionPerson.drop();

        for (Person person: ArrlPerson) {

            Document newPerson = new Document()
                    .append("idPersona", person.getPersonId())
                    .append("Nombre", person.getName())
                    .append("Apellido", person.getLastName())
                    .append("Estado", person.getStatus());

            if (person instanceof Patient){
                newPerson.append("VisitasPermitidas", ((Patient) person).isAllowVisitors())
                        .append("Registro", ((Patient) person).getRegistry())
                        .append("idHabitacion", ((Patient) person).getRoomId())
                        .append("Tipo", "Paciente");

            }else if (person instanceof Employee){
                newPerson.append("Uso", ((Employee) person).getType())
                        .append("Puesto", ((Employee) person).getJob())
                        .append("Salario", ((Employee) person).getSalary())
                        .append("Jornada", ((Employee) person).getShift())
                        .append("Tipo", "Empleado");

            }

            collectionPerson.insertOne(newPerson);
        }
    }
}

