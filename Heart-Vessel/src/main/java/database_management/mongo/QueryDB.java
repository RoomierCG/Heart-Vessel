package database_management.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import database_management.AuxDB;
import objects.Generic;
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
import visualInterfaces.Constants;

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
//        AuxDB.Complete = downloadAreasBackUp();

        rellenarTest();
    }

    public static void  guardar(){
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

        Employee aPE = new Employee("PEE#4", "Peter", "Yajodeh", "Working", "Medico", "Diurno", 12500, "Cirujano");
        Employee aPq = new Employee("PEE#1", "Juan", "Tuhzree", "Working", "Medico", "Nocturno", 7000, "Enfermero");
        Employee aPu = new Employee("PEE#2", "Mario", "Jeepetas", "Working", "Limpieza", "Diurno", 5000, "Limpieza de suelos");

        Patient pac1 = new Patient("PEP#1", "Edgar", "Aiurense", "Sin Pilones", true, "ARH#1", log);
        Patient pac2 = new Patient("PEP#2", "Eldon", "Calletano", "Buscando Hilos");
        log.clear();
        log.add("12:34 | Se murio");
        log.add("12:35 | F en el chat");
        Patient pac3 = new Patient("PEP#3", "Lkoraz", "Ondeya", "Muerto", false, "ARH#2", log);


        CleaningEquipment ave = new CleaningEquipment("PRE#1", "Fregona", "ARR#1", "Usado", "10/10/1000", 1, 0);
        CleaningEquipment aver = new CleaningEquipment("PRE#2", "Aspiradora", "ARR#1", "Cyka-Blyat", "10/10/1000", 1, 0);
        CleaningEquipment avegetal = new CleaningEquipment("PRE#3", "Escoba", "ARR#1", "Vacia", "10/10/1000", 1, 0);

        ArrayList<String> listaEquipamiento = new ArrayList<>();

        ArrayList<String> listaPersonal = new ArrayList<String>() {
            {
                add(aPE.getId() + " | " + aPE.getName());
                add(aPq.getId());
                add(aPu.getId());
            }
        };

        listaEquipamiento.add(avegetal.getId());
        HabitableRoom room = new HabitableRoom("ARH#1", "Habitacion 032", "Ocupado", 1, Constants.riesgos.get(2), "#PEP#1", listaEquipamiento, listaPersonal);
        listaEquipamiento.add(ave.getId());
        HabitableRoom room2 = new HabitableRoom("ARH#2", "Habitacion 033", "Ocupado", 1, Constants.riesgos.get(1), "#PEP#2", listaEquipamiento, listaPersonal);
        listaEquipamiento.add(aver.getId());


        Ambulance uno = new Ambulance("TRA#1", "Colectiva", "Aparcado", 54, "Mercedes-Benz", "Sprinter319", listaEquipamiento, listaPersonal);
        Ambulance dos = new Ambulance("TRA#2", "Colectiva", "Aparcado", 12, "Mercedes-Benz", "Sprinter319", listaEquipamiento, listaPersonal);
        Ambulance tres = new Ambulance("TRA#3", "Personal", "En Ruta", 100, "Fiat", "Ducato A&E", listaEquipamiento, listaPersonal);

        ArrayList<String> listaAmbulancias = new ArrayList<String>() {
            {
                add(uno.getId());
                add(dos.getId());
                add(tres.getId());
            }
        };

        Area aasd = new Area("ARR#1", "Almacen", "Limpiado", 0, Constants.riesgos.get(0), listaEquipamiento, listaPersonal);
        Garaje uff = new Garaje("ARG#1", "Kachow", "En llamas", 1, Constants.riesgos.get(0), listaPersonal, listaEquipamiento, listaAmbulancias);

        ArrayList<String> ingreds = new ArrayList<String>() {
            {
                add("Ingrediente 1");
                add("Ingrediente 2");
                add("Ingrediente 3");
            }
        };

        FoodMenu peshcao = new FoodMenu("PRC#1", "Menu Pescado", "ARR#1", "Congelado", "10/10/2010", 1, "20/10/2020", false, "Solido", "PVP#1", ingreds);
        Medicine coca = new Medicine("PRD#1", "Morfina", "ARR#1", "En Preparacion", "10/10/2010", 1, "20/10/2020", false, "Liquido", "Oral", ingreds);

        CleaningProducts Fairy = new CleaningProducts("PRL#1", "Jabon Multi Usos", "ARR#1", "Recibido", "10/10/2010", 1, false, "Gel", "Fairy");
        CleaningProducts Lejia = new CleaningProducts("PRL#2", "Lejia", "ARR#1", "Recibido", "10/10/2010", 1, true, "Liquido", "Lagarto");


        MovementAid muletas = new MovementAid("TRM#1", "Muletdas", "Adultos", null, "ARR#1");

        Machinery xRay = new Machinery("PRM#1", "Maquina Rayos X", "ARR#1", "En uso", "17/05/2005", 1, 3000, "Aiur");
        listaEquipamiento.clear();

        listaEquipamiento.add(xRay.getId());
        listaEquipamiento.add(coca.getId());
        listaEquipamiento.add(Fairy.getId());

        Area xrayRoom = new Area("ARR#2", "Sala Rayos X", "ocupado", 3, Constants.riesgos.get(2), listaEquipamiento, listaPersonal);

        SanitationMaterials vendas = new SanitationMaterials("PRS#1", "Vendas", "ARR#1", "Nuevo", "09/09/2009", 1, "Sanitas", "Tela");

        Provider profesionalVerdor = new Provider("PVP#1", "VerdorInc", "545855");

        CompanyCar Elbuga = new CompanyCar("TRC#1", "Automatico", "Semi-nuevo", 30, "Ford", "Fiesta", "PEE#4");

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
            AuxDB.Complete.add(aPq);
            AuxDB.Complete.add(aPE);
            AuxDB.Complete.add(aPu);

            AuxDB.Complete.add(pac1);
            AuxDB.Complete.add(pac2);
            AuxDB.Complete.add(pac3);

            AuxDB.Complete.add(ave);
            AuxDB.Complete.add(aver);
            AuxDB.Complete.add(avegetal);

            AuxDB.Complete.add(uno);
            AuxDB.Complete.add(dos);
            AuxDB.Complete.add(tres);
            AuxDB.Complete.add(Elbuga);
            AuxDB.Complete.add(muletas);

            AuxDB.Complete.add(room);
            AuxDB.Complete.add(room2);
            AuxDB.Complete.add(aasd);
            AuxDB.Complete.add(uff);
            AuxDB.Complete.add(xrayRoom);

            AuxDB.Complete.add(peshcao);
            AuxDB.Complete.add(coca);
            AuxDB.Complete.add(Fairy);
            AuxDB.Complete.add(Lejia);
            AuxDB.Complete.add(xRay);
            AuxDB.Complete.add(vendas);


            AuxDB.Complete.add(profesionalVerdor);


        }

    }

    public static void updateAreasBackUp() {

        //Borra todos los datos de la coleccion, por pruebas
        collectionArea.drop();

        for (Generic area : AuxDB.Complete) {
            if (area instanceof Area) {
                Document newArea = new Document()
                        .append("idArea", area.getId())
                        .append("Nombre", area.getName())
                        .append("Personal", ((Area) area).getStaff())
                        .append("Equipamiento", ((Area) area).getEquipment())
                        .append("Estado", ((Area) area).getStatus())
                        .append("Planta", ((Area) area).getFloor())
                        .append("Riesgo", ((Area) area).getRisk());

                if (area instanceof Garaje) {
                    newArea.append("Tipo", "Garaje")
                            .append("Vehiculos", ((Garaje) area).getVehicles());

                } else if (area instanceof HabitableRoom) {
                    newArea.append("Tipo", "Habitacion")
                            .append("idPaciente", ((HabitableRoom) area).getIdPatient());

                } else {
                    newArea.append("Tipo", "Area");
                }

                collectionArea.insertOne(newArea);
            }

        }
    }

    public static void updateProviderBackUp() {

        //Borra todos los datos de la coleccion, por pruebas
        collectionProvider.drop();

        for (Generic prov : AuxDB.Complete) {
            if (prov instanceof Provider) {
                collectionProvider.insertOne(new Document()
                        .append("idProveedor", prov.getId())
                        .append("Nombre", prov.getName())
                        .append("IBAN", ((Provider) prov).getAccount())
                );
            }
        }


    }

    public static void updateTransportSystemBackUp() {

        //Borra todos los datos de la coleccion, por pruebas
        collectionTransportSystem.drop();

        for (Generic transport : AuxDB.Complete) {
            if (transport instanceof Transport) {
                Document newTranport = new Document()
                        .append("idTransporte", transport.getId())
                        .append("Estado", ((Transport) transport).getStatus())
                        .append("Nombre", ((Transport) transport).getName());

                if (transport instanceof MovementAid) {
                    newTranport.append("idArea", ((MovementAid) transport).getIdArea())
                            .append("idPaciente", ((MovementAid) transport).getPatient())
                            .append("Tipo", "Ayuda Movil");

                } else if (transport instanceof Ambulance) {
                    newTranport.append("Status", ((Ambulance) transport).getStatus())
                            .append("Gasolina", ((Ambulance) transport).getGasTank())
                            .append("Marca", ((Ambulance) transport).getMake())
                            .append("Modelo", ((Ambulance) transport).getModel())
                            .append("Equipamiento", ((Ambulance) transport).getEquipment())
                            .append("Personal", ((Ambulance) transport).getPersonal())
                            .append("Tipo", "Ambulancia");

                } else if (transport instanceof CompanyCar) {
                    newTranport.append("Status", ((CompanyCar) transport).getStatus())
                            .append("Gasolina", ((CompanyCar) transport).getGasTank())
                            .append("Marca", ((CompanyCar) transport).getMake())
                            .append("Modelo", ((CompanyCar) transport).getModel())
                            .append("idPersona", ((CompanyCar) transport).getIdPersona())
                            .append("Tipo", "CocheCorporativo");

                }

                collectionTransportSystem.insertOne(newTranport);
            }
        }
    }

    public static void updateProductBackUp() {

        //Borra todos los datos de la coleccion, por pruebas
        collectionProduct.drop();

        for (Generic product : AuxDB.Complete) {
            if (product instanceof Product) {
                Document newProduct = new Document()
                        .append("idProducto", product.getId())
                        .append("Nombre", product.getName())
                        .append("Area", ((Product) product).getAreaId())
                        .append("Estado", ((Product) product).getStatus())
                        .append("FechaDeCompra", ((Product) product).getBuyDate())
                        .append("Cantidad", ((Product) product).getQuantity());

                if (product instanceof SanitationMaterials) {
                    newProduct.append("MarcaModelo", ((SanitationMaterials) product).getModel())
                            .append("Uso", ((SanitationMaterials) product).getUse())
                            .append("Tipo", "MaterialSanitario");

                } else if (product instanceof Machinery) {
                    newProduct.append("ConsumoElectrico", ((Machinery) product).getElectricityConsumption())
                            .append("Modelo", ((Machinery) product).getModel())
                            .append("Tipo", "Maquinaria");

                } else if (product instanceof CleaningEquipment) {
                    newProduct.append("GradoDeRiesgo", ((CleaningEquipment) product).getRiskFactor())
                            .append("Tipo", "EquipamientoDeLimpieza");

                } else if (product instanceof CleaningProducts) {
                    newProduct.append("Marca", ((CleaningProducts) product).getMake())
                            .append("Toxico", ((CleaningProducts) product).isToxic())
                            .append("Uso", ((CleaningProducts) product).getType())
                            .append("Tipo", "ProductoDeLimpieza");

                } else if (product instanceof Medicine) {
                    newProduct.append("Toxico", ((Medicine) product).isToxic())
                            .append("RiesgosAlergicos", ((Medicine) product).getAllergyRiskIngredients())
                            .append("FechaDeCaducidad", ((Medicine) product).getExpirationDate())
                            .append("ViaDeAdministracion", ((Medicine) product).getAdministered())
                            .append("Uso", ((Medicine) product).getType())
                            .append("Tipo", "Medicinas");


                } else if (product instanceof FoodMenu) {
                    newProduct.append("Toxico", ((FoodMenu) product).isToxic())
                            .append("RiesgosAlergicos", ((FoodMenu) product).getAllergyRiskIngredients())
                            .append("FechaDeCaducidad", ((FoodMenu) product).getExpirationDate())
                            .append("Estado", ((FoodMenu) product).getType())
                            .append("Proveedor", ((FoodMenu) product).getProvider())
                            .append("Uso", ((FoodMenu) product).getType())
                            .append("Tipo", "Comida");
                }

                collectionProduct.insertOne(newProduct);
            }
        }
    }

    public static void updatePeopleBackUp() {
        //Borra todos los datos de la coleccion, por pruebas
        collectionPerson.drop();

        for (Generic person : AuxDB.Complete) {
            if (person instanceof Person) {
                Document newPerson = new Document()
                        .append("idPersona", person.getId())
                        .append("Nombre", person.getName())
                        .append("Apellido", ((Person) person).getLastName())
                        .append("Estado", ((Person) person).getStatus());

                if (person instanceof Patient) {
                    newPerson.append("VisitasPermitidas", ((Patient) person).isAllowedVisitors())
                            .append("Registro", ((Patient) person).getRegistry())
                            .append("idHabitacion", ((Patient) person).getRoomId())
                            .append("Tipo", "Paciente");

                } else if (person instanceof Employee) {
                    newPerson.append("Departamento", ((Employee) person).getDepartment())
                            .append("Puesto", ((Employee) person).getJob())
                            .append("Salario", ((Employee) person).getSalary())
                            .append("Jornada", ((Employee) person).getShift())
                            .append("Tipo", "Empleado");

                }

                collectionPerson.insertOne(newPerson);
            }
        }
    }
}

