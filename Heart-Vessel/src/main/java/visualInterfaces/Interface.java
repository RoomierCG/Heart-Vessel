package visualInterfaces;


import database_management.AuxDB;
import database_management.mongo.DownloadBD;
import database_management.mongo.QueryDB;
import objects.Generic;
import service.background_sim.SimulatorThread;
import service.data_manager.DataFunctions;
import service.utility.OpsID;
import service.utility.UserInteractions;


import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;


public class Interface {

    public static void main(String[] args) {
        int opcion;
        String[] textInicio = {"Inicializando", ".", ".", ".", ".", ".", ".", "."};

        QueryDB.rellenarTest(); //Cambiar en un futuro
        AuxDB.initMaxID();
        SimulatorThread sim = new SimulatorThread();
        sim.start();

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
                            "\t\t5º Mostrar informacion\n" +
                            "\t\t6º Mostrar actividad del hospital\n" +
                            "\t\t7º Salir\n\n",
                    1, 7);

            switch (opcion) {
                case 1:
                    System.out.println("||||||||||||||||||Que quieres crear?||||||||||||||||||\n");
                    String prefix = UserInteractions.idRequest(false);
                    Generic g = DataFunctions.determineGeneration(prefix);
                    g.setId(OpsID.generateID(prefix));
                    g.modifyMe(new ArrayList<String>(){{add("*");}});
                    AuxDB.Complete.add(g);
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
                    DataFunctions.printAllCall();
                    break;
                case 6:
                    sim.showActivity();
                    UserInteractions.strRequest("Pulse enter para continuar");
                    break;

            }

        } while (opcion != 7);

    }

    private static void MongoDB() {
        int opcion;

        do {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            opcion = UserInteractions.numRequest("" +
                    "\n\t --- Que accion quieres realizar ---\n\n" +
                    "\t1º Descargar\n" +
                    "\t2º Guardar\n" +
                    "\t3º Salir");

            if (opcion == 1) {
                DownloadBD.descargar();
            }
            if (opcion == 2) {
                QueryDB.guardar();
            }

        } while (opcion != 3);

        //TODO que mongodb funcione de verdad
    }


}