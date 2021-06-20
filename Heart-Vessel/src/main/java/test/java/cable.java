package test.java;

import database_management.AuxDB;
import database_management.mongo.QueryDB;
import objects.area.Area;
import objects.people.person.Employee;
import objects.people.person.Patient;
import org.apache.catalina.User;
import org.apache.tomcat.util.bcel.Const;
import service.data_manager.DataFunctions;
import service.utility.OpsID;
import service.utility.UserInteractions;
import visualInterfaces.Constants;

import javax.xml.crypto.Data;
import java.util.ArrayList;

import static service.background_sim.Simulator.randomNum;


/* Proceso
        Añadir ModifyMe [ Crear metodos de modificar en cada clase, heredando de las clases padres. Reciben lista (String) de parametros a cambiar
        Añadir GatherInfo/GatherListedInfo a las clases que falten para poder imprimirlo bien
 */
public class cable {
    public static void main(String[] args) {/*
        //AuxDB.Complete.remove(null);


        QueryDB.rellenarTest();
        ArrayList<String> atr = new ArrayList<String>() {
            {
                add("id");
                add("Salario");

            }
        };

        DataFunctions.printAllRemaster(atr,"PEE");
        ArrayList<ArrayList<String>> temporal = DataFunctions.getData(new ArrayList<String>(){{add("id");}},"PEE");

        Employee elim = (Employee) OpsID.decodeID(temporal.get(0).get(randomNum(0,temporal.get(0).size())));

        elim.setSalary(9999);
        for(String hab : temporal.get(0)){
            Employee wip = (Employee) OpsID.decodeID(hab);
            System.out.println(wip.getName());
        }

        DataFunctions.printAllRemaster(atr,"PEE");*/


        //UserInteractions.formIDList(atr,"PEP");
        /*for(ArrayList<String> h : DataFunctions.getData(atr,"ARH")){
            System.out.println("$");
            for(String x : h){
                System.out.println(x);
            }
        }*/


        /*for (String[][][] Class : Constants.Omniclase) {
            for (String[][] Sub : Class) {
                if (Sub[1][0].startsWith("AR")) {
                    System.out.println(Sub[0][0]);
                }
            }
        }*/

        /*ArrayList<String> atr = new ArrayList<String>() {
            {
                add("*");

            }
        };

        //System.out.println(UserInteractions.pickFrom(atr));
        DataFunctions.printAllRemaster(atr, "PVP");*/


    }
}





