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
//        AuxDB.ArrLarea = downloadAreasBackUp();
       


        rellenarTest();

        updateAreasBackUp();
        updateProviderBackUp();
        updateTransportSystemBackUp();
        updateProductBackUp();
        updatePeopleBackUp();
    }



    //En arreglo
    public static void rellenarTest() {

        ArrayList<String> log = new ArrayList<>();
        log.add("16:43 | Ingresado");
        log.add("16:50 | Examinacion");
        log.add("17:30 | Inicio Tratamiento Reduccion Zerguna con Fanatazil ");
        log.add("19:34 | Transportado listaPersonal habitacion 01 para estancia nocturna");

        Employee aPE = new Employee("PEE#04", "Peter", "Yajodeh", "Working", "Medico", "Diurno", 12500, "Cirujano");
        Employee aPq = new Employee("PEE#01", "Juan", "Tuhzree", "Working", "Medico", "Nocturno", 7000, "Enfermero");
        Employee aPu = new Employee("PEE#02", "Mario", "Jeepetas", "Working", "Limpieza", "Diurno", 5000, "Limpieza de suelos");

        Patient pac1 = new Patient("PEP#01", "Edgar", "Aiurense", "Sin Pilones",true, "ARH#01",log);
        Patient pac2 = new Patient("PEP#02", "Eldon", "Calletano", "Buscando Hilos");
        log.clear();
        log.add("12:34 | Se murio");
        log.add("12:35 | F en el chat");
        Patient pac3 = new Patient("PEP#03", "Lkoraz", "Ondeya", "Muerto", false, "ARH#05", log);


        CleaningEquipment ave = new CleaningEquipment("PRE#02", "Fregona", "ARR#01", "Usado", "10/10/1000",0);
        CleaningEquipment aver = new CleaningEquipment("PRE#02", "Aspiradora", "ARR#01", "Cyka-Blyat", "10/10/1000",0);
        CleaningEquipment avegetal = new CleaningEquipment("PRE#03", "Escoba", "ARR#01", "Vacia", "10/10/1000",0);

        ArrayList<String> listaEquipamiento = new ArrayList<>();

        ArrayList<String> listaPersonal = new ArrayList<String>(){
            {
                add(aPE.getPersonId());
                add(aPq.getPersonId());
                add(aPu.getPersonId());
            }
        };

        listaEquipamiento.add(avegetal.getEquipmentId());
        HabitableRoom room = new HabitableRoom("ARH#01", "Habitacion 032", "Ocupado", 1,2, "#PEP#01", listaEquipamiento, listaPersonal);
        listaEquipamiento.add(ave.getEquipmentId());
        HabitableRoom room2 = new HabitableRoom("ARH#02", "Habitacion 033", "Ocupado", 1,2, "#PEP#02", listaEquipamiento, listaPersonal);
        listaEquipamiento.add(aver.getEquipmentId());


        Ambulance uno = new Ambulance("TVA#01", "Aparcado", "Tercera Edad", 24,listaEquipamiento , listaPersonal);
        Ambulance dos = new Ambulance("TVA#02", "En patrulla", "Accidentes Traumas y Golpes",24 , listaEquipamiento,listaPersonal);
        Ambulance tres = new Ambulance("TVA#03", "En ruta listaPersonal llamada de auxilio", "Toxicos", 24, listaEquipamiento, listaPersonal);

        ArrayList<String> listaAmbulancias = new ArrayList<String>(){
            {
                add(uno.getTransportId());
                add(dos.getTransportId());
                add(tres.getTransportId());
            }
        };


        Area aasd = new Area("ARR#01", "Almacen","Limpiado", 0,0, listaEquipamiento, listaPersonal);


        Garaje uff = new Garaje("ARG#01", "Kachow", "En llamas", 1, 0,listaPersonal,listaEquipamiento,listaAmbulancias);

        ArrayList<String> ingreds = new ArrayList<String>(){
            {
                add("Ingrediente 1");
                add("Ingrediente 2");
                add("Ingrediente 3");
            }
        };

        FoodMenu peshcao = new FoodMenu("PRC#01", "Menu Pescado", "ARR#01", "Congelado", "10/10/2010","20/10/2020", false,"Solido","PVP#01",ingreds);
        Medicine coca = new Medicine("PRD#01", "Morfina", "ARR#01", "En Preparacion", "10/10/2010","20/10/2020" ,false , "Liquido","Oral",ingreds);

        CleaningProducts Fairy = new CleaningProducts("PRL#01", "Jabon Multi Usos", "ARR#01", "Recibido", "10/10/2010", false, "Gel","Fairy");
        CleaningProducts Lejia = new CleaningProducts("PRL#02", "Lejia", "ARR#01", "Recibido", "10/10/2010", true,"Liquido", "Lagarto");

        CleaningEquipment Fregona = new CleaningEquipment("PRL#03", "Fregona", "ARR#01", "Semi-nuevo", "15/04/2015",0);
        CleaningEquipment Guantes = new CleaningEquipment("PRL#04", "Guantes", "ARR#01", "Nuevos", "15/04/2015",0);

        MovementAid muletas = new MovementAid("TAM#01", "Adultos", null, "ARR#01");

        Machinery xRay = new Machinery("PRM#01", "Maquina Rayos X", "ARR#01", "En uso", "17/05/2005", 3000, "Aiur");
        listaEquipamiento.clear();

        listaEquipamiento.add(xRay.getEquipmentId());
        listaEquipamiento.add(coca.getEquipmentId());
        listaEquipamiento.add(Fairy.getEquipmentId());

        Area xrayRoom = new Area("ARR#02", "Sala Rayos X", "ocupado", 3, 3,listaEquipamiento,listaPersonal);

        SanitationMaterials vendas = new SanitationMaterials("PRS#01", "Vendas", "ARR#01", "Nuevo", "09/09/2009","Sanitas","Tela");

        Provider profesionalVerdor = new Provider("PVP#01", "VerdorInc", "545855");

        CompanyCar Elbuga = new CompanyCar("TVC#01", "Semi-nuevo", "Manual", 30, "Murcielago", "Bugatti", "PEE#04");

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
            AuxDB.ArrlPerson.add(aPE);
            AuxDB.ArrlPerson.add(aPq);
            AuxDB.ArrlPerson.add(aPu);

            AuxDB.ArrlPerson.add(pac1);
            AuxDB.ArrlPerson.add(pac2);
            AuxDB.ArrlPerson.add(pac3);

            AuxDB.ArrlProduct.add(ave);
            AuxDB.ArrlProduct.add(aver);
            AuxDB.ArrlProduct.add(avegetal);

            AuxDB.ArrlTransport.add(uno);
            AuxDB.ArrlTransport.add(dos);
            AuxDB.ArrlTransport.add(tres);
            AuxDB.ArrlTransport.add(Elbuga);
            AuxDB.ArrlTransport.add(muletas);

            AuxDB.ArrLarea.add(room);
            AuxDB.ArrLarea.add(aasd);
            AuxDB.ArrLarea.add(uff);
            AuxDB.ArrLarea.add(xrayRoom);

            AuxDB.ArrlProduct.add(peshcao);
            AuxDB.ArrlProduct.add(coca);
            AuxDB.ArrlProduct.add(Fairy);
            AuxDB.ArrlProduct.add(Lejia);
            AuxDB.ArrlProduct.add(Fregona);
            AuxDB.ArrlProduct.add(Guantes);
            AuxDB.ArrlProduct.add(xRay);
            AuxDB.ArrlProduct.add(vendas);


            AuxDB.ArrlProvider.add(profesionalVerdor);


        }

    }

    public static void updateAreasBackUp() {

        //Borra todos los datos de la coleccion, por pruebas
        collectionArea.drop();

        for (Area area : AuxDB.ArrLarea) {

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

            }else {
                newArea.append("Tipo", "Area");
            }

            collectionArea.insertOne(newArea);
        }
    }

    public static void updateProviderBackUp(){

        //Borra todos los datos de la coleccion, por pruebas
        collectionProvider.drop();

        for (Provider provider: AuxDB.ArrlProvider) {

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

        for (Transport transport: AuxDB.ArrlTransport) {

            Document newTranport = new Document()
                    .append("idTransporte", transport.getTransportId())
                    .append("Estado", transport.getStatus());

            if (transport instanceof MovementAid){
                newTranport.append("Tipo","Ayuda Movil")
                            .append("idArea",((MovementAid) transport).getIdArea())
                            .append("idPaciente", ((MovementAid) transport).getPatient());

            }else if (transport instanceof Ambulance){
                newTranport.append("Personal", ((Ambulance) transport).getPersonal())
                            .append("Productos", ((Ambulance) transport).getEquipment())
                            .append("Gasolina", ((Ambulance) transport).getGasTank())
                            .append("Especialidad", ((Ambulance) transport).getType())
                            .append("Tipo", "Ambulancia");

            }else if (transport instanceof CompanyCar){
                newTranport.append("Modelo", ((CompanyCar) transport).getModel())
                            .append("Marca", ((CompanyCar) transport).getMake())
                            .append("Gasolina", ((CompanyCar) transport).getGasTank())
                            .append("Especialidad", ((CompanyCar) transport).getType())
                            .append("Dueño", ((CompanyCar) transport).getIdPersona())
                            .append("Tipo", "Vehiculo");

            }

            collectionTransportSystem.insertOne(newTranport);
        }
    }

    public static void updateProductBackUp() {

        //Borra todos los datos de la coleccion, por pruebas
        collectionProduct.drop();

        for (Product product: AuxDB.ArrlProduct) {

            Document newProduct = new Document()
                    .append("idProducto", product.getEquipmentId())
                    .append("Nombre", product.getName())
                    .append("Area", product.getAreaId())
                    .append("Estado", product.getStatus())
                    .append("FechaDeCompra", product.getBuyDate());

            if (product instanceof SanitationMaterials){
                newProduct.append("MarcaModelo", ((SanitationMaterials) product).getModel())
                            .append("Uso", ((SanitationMaterials) product).getType())
                            .append("Tipo","MaterialSanitario");

            }else if (product instanceof Machinery){
                newProduct.append("ConsumoElectrico", ((Machinery) product).getElectricityConsumption())
                            .append("Modelo", ((Machinery) product).getModel())
                            .append("Tipo", "Maquinaria");

            }else if (product instanceof CleaningEquipment){
                newProduct.append("GradoDeRiesgo", ((CleaningEquipment) product).getRiskFactor())
                            .append("Tipo","EquipamientoDeLimpieza");

            }else if (product instanceof CleaningProducts){
                newProduct.append("Marca", ((CleaningProducts) product).getMake())
                            .append("Toxico", ((CleaningProducts) product).isToxic())
                            .append("Uso",((CleaningProducts) product).getType())
                            .append("Tipo", "ProductoDeLimpieza");

            }else if (product instanceof Medicine){
                newProduct.append("Toxico", ((Medicine) product).isToxic())
                            .append("RiesgosAlergicos", ((Medicine) product).getAllergyRiskIngredients())
                            .append("FechaDeCaducidad", ((Medicine) product).getExpirationDate())
                            .append("ViaDeAdministracion", ((Medicine) product).getAdministered())
                            .append("Uso",((Medicine) product).getType())
                            .append("Tipo", "Medicinas");


            }else if (product instanceof FoodMenu){
                newProduct.append("Toxico", ((FoodMenu) product).isToxic())
                        .append("RiesgosAlergicos", ((FoodMenu) product).getAllergyRiskIngredients())
                        .append("FechaDeCaducidad", ((FoodMenu) product).getExpirationDate())
                        .append("Estado", ((FoodMenu) product).getType())
                        .append("Proveedor", ((FoodMenu) product).getProvider())
                        .append("Uso",((FoodMenu) product).getType())
                        .append("Tipo", "Comida");
            }

            collectionProduct.insertOne(newProduct);
        }
    }

    public static void updatePeopleBackUp() {
        //Borra todos los datos de la coleccion, por pruebas
        collectionPerson.drop();

        for (Person person: AuxDB.ArrlPerson) {

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
                newPerson.append("Departamento", ((Employee) person).getType())
                        .append("Puesto", ((Employee) person).getJob())
                        .append("Salario", ((Employee) person).getSalary())
                        .append("Jornada", ((Employee) person).getShift())
                        .append("Tipo", "Empleado");

            }

            collectionPerson.insertOne(newPerson);
        }
    }
}

