package test.java;

import database_management.AuxDB;
import database_management.mongo.QueryDB;
import objects.area.Area;
import org.apache.catalina.User;
import org.apache.tomcat.util.bcel.Const;
import service.data_manager.DataFunctions;
import service.utility.OpsID;
import service.utility.UserInteractions;
import visualInterfaces.Constants;

import javax.xml.crypto.Data;
import java.util.ArrayList;


/* Proceso
        Añadir ModifyMe [ Crear metodos de modificar en cada clase, heredando de las clases padres. Reciben lista (String) de parametros a cambiar
        Añadir GatherInfo/GatherListedInfo a las clases que falten para poder imprimirlo bien
 */
public class cable {
    public static void main(String[] args) {
        //AuxDB.Complete.remove(null);


        QueryDB.rellenarTest();
        ArrayList<String> atr = new ArrayList<String>() {
            {
                add("*");
                add("id");
                add("fantasma");

            }
        };

        DataFunctions.printAllRemaster(atr,"PEP");
        UserInteractions.formIDList(atr,"PEP");
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





