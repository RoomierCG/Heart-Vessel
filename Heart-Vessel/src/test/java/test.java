import database_management.mongo.QueryDB;
import service.data_manager.DataFunctions;
import service.utility.OpsID;
import service.utility.UserInteractions;
import visualInterfaces.Constants;

import javax.xml.crypto.Data;
import java.util.ArrayList;

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

    public static void main(String[] args) {

        QueryDB.rellenarTest();
        ArrayList<String> atrib = new ArrayList<String>(){
            {
                add("Nombre");
                add("Personal");
                add("Estado");
                add("idArea");
                add("Vehiculos");
                add("Equipamiento");
                add("Riesgo");
                add("Planta");
            }
        };
        DataFunctions.modifyMain();

    }
}
