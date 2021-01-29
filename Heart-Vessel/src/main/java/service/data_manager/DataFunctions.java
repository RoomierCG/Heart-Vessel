package service.data_manager;

import database_management.AuxDB;
import database_management.mongo.QueryDB;
import objects.Generic;
import objects.area.Area;
import objects.area.areas.Garaje;
import objects.area.areas.HabitableRoom;
import objects.people.Person;
import objects.product.Product;
import objects.provider.Provider;
import objects.transportsystem.Transport;
import service.utility.OpsID;
import service.utility.UserInteractions;
import visualInterfaces.Constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class DataFunctions implements Operations {

    public static void main(String[] args) {

        QueryDB.rellenarTest();
//        System.out.println(OpsID.decodeID("ARR#1"));
    }

    public static boolean delete() {

        Object deleteObject = OpsID.decodeID(UserInteractions.strRequest("Ingrese el ID de lo que quiera eliminar"));

        if (deleteObject instanceof Area) {
            AuxDB.Complete.remove(deleteObject);
            return true;

        } else if (deleteObject instanceof Person) {
            AuxDB.Complete.remove(deleteObject);
            return true;

        } else if (deleteObject instanceof Product) {
            AuxDB.Complete.remove(deleteObject);
            return true;

        } else if (deleteObject instanceof Provider) {
            AuxDB.Complete.remove(deleteObject);
            return true;

        } else if (deleteObject instanceof Transport) {
            AuxDB.Complete.remove(deleteObject);
            return true;

        } else {
            return false;
        }
    }

    public static boolean modifyGeneric() {

        int opcion;//Le quite el menos 1, por si te da problemas luego
        String param = "";
        ArrayList<String> options = new ArrayList<>();
        ArrayList<Integer> optionsSelected = new ArrayList<>();
        ArrayList<Integer> numOptions;


        String idModifyObject = UserInteractions.idRequest(true);
        Object modifyObject = OpsID.decodeID(idModifyObject);

//        System.out.println(idModifyObject.substring(0,3));

        //Recorremos el array para que funcione la lista de opciones para el numlist
        for (String[][][] category : Constants.Omniclase) {
            for (String[][] subcategory : category) {
                if (idModifyObject.substring(0, 3).equals(subcategory[1][0])) {
                    options.addAll(Arrays.asList(subcategory[2]));
                    options.addAll(Arrays.asList(subcategory[3]));
                }
            }
        }
        numOptions = NumListCreator(0, options.size());
        do {
            String prompt = "";
            for (int i = 0; i < options.size(); i++) {
                if (numOptions.contains(i + 1))
                    prompt += "- " + (1 + i) + "º " + options.get(i) + "\n";
            }
            opcion = UserInteractions.numRequest(prompt + "=== 0  Salir de las opciones ===", numOptions);
            optionsSelected.add(opcion);
            numOptions.remove(numOptions.indexOf(opcion));

        } while (opcion != 0);


        //No queremos permitir que modifiquen el id por eos borramos 0

        optionsSelected.remove(optionsSelected.size() - 1);
        Collections.sort(optionsSelected);
        System.out.println(optionsSelected);

        return false;
    }

    public static ArrayList<String> EditList(ArrayList<String> originList, String originType) {
        switch (UserInteractions.numRequest("\n1. Añadir\n2. Eliminar\n3. Mostrar Lista\n0. Salir", 0, 3)) {
            case 1:
                String newId = UserInteractions.idRequest(originType, true);
                if (OpsID.decodeID(newId) == null) {
                    System.out.println("Este id no existe");
                } else {
                    originList.add(newId);
                }
                originList = EditList(originList, originType);
                break;

            case 2:
                String delId = UserInteractions.idRequest(originType, true);
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

    public static ArrayList<Integer> NumListCreator(int min, int max) {
        ArrayList<Integer> newNumList = new ArrayList<>();
        for (int i = min; i < max; i++) {
            newNumList.add(i);
        }

        return newNumList;
    }

    public static String[][] append(String[][] a, String[][] b) {
        String[][] result = new String[a.length + b.length][];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        return result;
    }

    public static void printAll(ArrayList<String> atribs, String type) {
        ArrayList<ArrayList<String>> DataPacks = new ArrayList<>();
        ArrayList<String> Header = new ArrayList<>();

        for (int i = 0; i < atribs.size(); i += 6) {
            ArrayList<String> data = new ArrayList<>();
            DataPacks.add(data);
        }
        switch (type.length()) {
            case 2:

                break;
            case 3:
                for (String[][][] Class : Constants.Omniclase) {
                    for (String[][] Sub : Class) {
                        if (Sub[1][0].equals(type)) {
                            if (Sub[2] != null) {
                                for (int i = 0; i < Sub[2].length; i++) {
                                    if (atribs.contains(Sub[2][i])) {
                                        Header.add(Sub[2][i]);
                                    }
                                }
                            }
                            if (Sub[3] != null) {
                                for (int i = 0; i < Sub[3].length; i++) {

                                    if (atribs.contains(Sub[3][i])) {
                                        Header.add(Sub[3][i]);
                                    }
                                }
                            }
                            for (Generic g : AuxDB.Complete) {
                                int PackCount = 0;
                                if (g.getId().startsWith(type)) {

                                    int Hcount = 0;

                                    int Tlength = (Sub[3][0] == null) ? ((Sub[2][0] == null) ? 0 : Sub[2].length) : Sub[2].length + Sub[3].length;
                                    //System.out.println(Tlength+"||");
                                    for (int i = 0; i < Tlength; i++) {
                                        if (i < Sub[2].length) {
                                            if (atribs.contains(Sub[2][i])) {
                                                Hcount++;
                                                if (Hcount % 7 == 0) {
                                                    PackCount++;
                                                }

                                                (DataPacks.get(PackCount)).add((g.gatherInfo()[i]));

                                            }
                                        } else {
                                            if (atribs.contains(Sub[3][i - (Sub[2].length)])) {
                                                Hcount++;
                                                if (Hcount % 7 == 0) {
                                                    PackCount++;
                                                }
                                                (DataPacks.get(PackCount)).add((g.gatherInfo()[i]));

                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                break;
            default:
                System.out.println("Error");
        }
        for (ArrayList<String> printing : DataPacks) {
            String output = " ";
            boolean header = true;
            int remaining = 0;
            int current = 0;
            for (String response : printing) {
                if (header) {
                    if (Header.size() > 6) {
                        remaining = 6;
                        for (int i = 0; i < 6; i++) {
                            output += String.format("%-30.30s", Header.get(0));
                            Header.remove(0);

                        }

                    } else {
                        remaining = Header.size();
                        for (int i = 0; i < remaining; i++) {
                            output += String.format("%-30.30s", Header.get(0));
                            Header.remove(0);
                        }

                    }
                    output += "\n";
                    for (int space = 0; space < 29 * (remaining); space++) {
                        if (space % 29 == 0) {
                            output += "|";
                        }
                        output += "=";

                    }
                    output += "|\n";
                    header = false;
                }
                output += String.format("%-30.30s", response);
                current++;
                if (current % remaining == 0) {
                    output += "\n";
                }


            }
            System.out.println(output);
            System.out.println("\n");

        }
    }


}
