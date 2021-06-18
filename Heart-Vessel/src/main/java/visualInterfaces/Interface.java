package visualInterfaces;

import database_management.AuxDB;
import database_management.mongo.QueryDB;
import service.data_manager.DataFunctions;
import service.utility.UserInteractions;


import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;


public class Interface {

    public static void main(String[] args) {
        int opcion = 0;
        String[] textInicio = {"Inicializando", ".", ".", ".", ".", ".", ".", "."};

        QueryDB.rellenarTest();

        for (String s : textInicio) {
            try {
                System.out.print(s);
                TimeUnit.MILLISECONDS.sleep(100);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        do {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

            opcion = UserInteractions.numRequest("" +
                            "\n\t --- Bienvenido a Heart-vessel ---\n\n" +
                            "\t\tQue accion desea realizar\n\n" +
                            "\t\t1º Crear\n" +
                            "\t\t2º Borrar\n" +
                            "\t\t3º Modificar\n" +
                            "\t\t4º Interacciones con la BD\n" +
                            "\t\t5º Mostrar estado del hospital\n" +
                            "\t\t6º Salir\n\n",
                    1, 6);

            switch (opcion) {
                case 1:
                    System.out.println("Work in progress");
                    break;

                case 2:
                    System.out.println("======Seleccione que tipo desea BORRAR====\n");
                    DataFunctions.delete();
                    break;
                case 3:
                    System.out.println("======Seleccione que tipo desea MODIFICAR====\n");
                    DataFunctions.modifyGeneric();
                    break;
                case 4:
                    MongoDB();
                    break;
                case 5:
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    printAllCall();
                    break;

            }

        } while (opcion != 6);

    }

    private static void MongoDB() {
        int opcion = 0;

        do {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            opcion = UserInteractions.numRequest("" +
                    "\n\t --- Que accion quieres realizar ---\n\n" +
                    "\t1º Descargar\n" +
                    "\t2º Guardar\n" +
                    "\t3º Salir");

        } while (opcion != 3);

        //TODO que mongodb funcione de verdad
    }

    private static void printAllCall(){
        int opcion = 0;
        ArrayList<String> list = new ArrayList<String>();

        do {
            opcion = UserInteractions.numRequest("" +
                    "\n\t --- Que accion quieres realizar ---\n\n" +
                    "\t1º Consultar toda la lista\n" +
                    "\t2º Consultar una especifica\n" +
                    "\t3º Salir", 1,3);

            if (opcion == 1) {
                list.add("*");
                for (String[][][] category : Constants.Omniclase) {
                    for (String[][] subcategory : category) {
                        System.out.println(Constants.separtator+"\t\t\t\t"+subcategory[0][0]+Constants.separtator);
                        DataFunctions.printAllRemaster(list, subcategory[1][0]);
                    }
                }
            }

            if (opcion == 2){
                DataFunctions.printSpecifObject();
            }

        }while(opcion != 3);
    }
}