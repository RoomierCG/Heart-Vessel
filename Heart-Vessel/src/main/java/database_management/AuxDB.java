package database_management;

import objects.area.Area;
import objects.area.areas.Garaje;
import objects.people.Person;
import objects.people.person.Employee;
import objects.product.Product;
import objects.provider.Provider;
import objects.transportsystem.Transport;
import service.utility.ID;

import java.util.ArrayList;

public class AuxDB {

    public static ArrayList<Area> ArrLarea = new ArrayList<>();

    public static ArrayList<Person> ArrlPerson = new ArrayList<>();

    public static ArrayList<Product> ArrlProduct = new ArrayList<>();

    public static ArrayList<Provider> ArrlProvider = new ArrayList<>();

    public static ArrayList<Transport> ArrlTransport = new ArrayList<>();

    public static ArrayList<ID> EmptyIDs = new ArrayList<>();

    public static ArrayList<ID> MaxIDs = new ArrayList<ID>(){
        {
            add(new ID(0,"PEE","Empleado"));
            add(new ID(0,"PEP","Paciente"));
            add(new ID(0,"PRS","Material Sanitario"));
            add(new ID(0,"PRM","Maquinaria"));
            add(new ID(0,"PRE","Equipamiento de Limpieza"));
            add(new ID(0,"PRL","Producto de Limpieza"));
            add(new ID(0,"PRD","Medicamento"));
            add(new ID(0,"PRC","Comida"));
            add(new ID(0,"PVP","Proveedor"));
            add(new ID(0,"TRM","Ayuda Movil"));
            add(new ID(0,"TRA","Ambulancia"));
            add(new ID(0,"TRC","Coche de Compañia"));
            add(new ID(0,"ARR","Area Generica"));
            add(new ID(0,"ARG","Garaje"));
            add(new ID(0,"ARH","Habitacion"));

        }
    };


}
