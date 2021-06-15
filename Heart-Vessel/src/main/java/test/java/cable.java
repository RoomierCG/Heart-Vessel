package test.java;

import database_management.AuxDB;
import database_management.mongo.QueryDB;
import objects.area.Area;
import org.apache.catalina.User;
import service.data_manager.DataFunctions;
import service.utility.UserInteractions;
import visualInterfaces.Constants;

import java.util.ArrayList;


/* Proceso
        Añadir ModifyMe [ Crear metodos de modificar en cada clase, heredando de las clases padres. Reciben lista (String) de parametros a cambiar
        Añadir GatherInfo/GatherListedInfo a las clases que falten para poder imprimirlo bien
 */
public class cable {
    public static void main(String[] args) {
        //AuxDB.Complete.remove(null);


        QueryDB.rellenarTest();
        /*for (String[][][] Class : Constants.Omniclase) {
            for (String[][] Sub : Class) {
                if (Sub[1][0].startsWith("AR")) {
                    System.out.println(Sub[0][0]);
                }
            }
        }*/

        ArrayList<String> atr = new ArrayList<String>() {
            {
                add("*");

            }
        };

        //System.out.println(UserInteractions.pickFrom(atr));
        DataFunctions.printAllRemaster(atr, "PVP");


    }
}





