package test.java;

import database_management.AuxDB;
import database_management.mongo.QueryDB;
import service.utility.OpsID;
import service.utility.UserInteractions;
import visualInterfaces.Constants;

import java.util.ArrayList;
import java.util.Collections;

import static service.data_manager.DataFunctions.*;

public class test {
    public static ArrayList<String> EditList(ArrayList<String> originList, String originType) {
        switch (UserInteractions.numRequest("\n1. Añadir\n2. Eliminar\n3. Mostrar Lista\n0. Salir", 0, 4)) {
            case 1:
                String newId = UserInteractions.idRequest(originType,true);
                if (OpsID.decodeID(newId) == null) {
                    System.out.println("Este id no existe");
                } else {
                    originList.add(newId);
                }
                originList = EditList(originList, originType);
                break;

            case 2:
                String delId = UserInteractions.idRequest(originType,true);
                if (!originList.contains(delId)) {
                    System.out.println("Este id no existe");
                } else {
                    originList.remove(delId);
                }
                originList = EditList(originList, originType);
                break;

            case 3:
                System.out.println("===== Lista siendo editada =====");
                for (String a : originList) {
                    System.out.println("      " + a);
                }
                originList = EditList(originList, originType);

        }
        return originList;
    }


    /*
    * Garaje g = new Garaje();
        g.initArea();
        System.out.println(g.getName());
        System.out.println(Constants.Omniclase[3][0][3].);
     */



}
