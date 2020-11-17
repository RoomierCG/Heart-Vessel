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

    public static ArrayList<ID> MaxIDs = new ArrayList<ID>(){
        {
            add(new ID(0,"PEE"));
            add(new ID(0,"PEP"));
            add(new ID(0,"PRS"));
            add(new ID(0,"PRM"));
            add(new ID(0,"PRE"));
            add(new ID(0,"PRL"));
            add(new ID(0,"PRD"));
            add(new ID(0,"PRC"));
            add(new ID(0,"PVP"));
            add(new ID(0,"TRM"));
            add(new ID(0,"TRA"));
            add(new ID(0,"TRC"));
            add(new ID(0,"ARR"));
            add(new ID(0,"ARG"));
            add(new ID(0,"ARH"));

        }
    };


}
