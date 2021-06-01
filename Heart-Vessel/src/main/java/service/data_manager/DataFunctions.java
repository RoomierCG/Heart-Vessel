package service.data_manager;

import database_management.AuxDB;
import database_management.mongo.QueryDB;
import objects.Generic;
import objects.area.Area;
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


    //Nose si aun necesitamos esto
    /*public static String[][] append(String[][] a, String[][] b) {
        String[][] result = new String[a.length + b.length][];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        return result;
    }*/



    public static void printAllRemaster(ArrayList<String> atribs, String type) {
        ArrayList<ArrayList<String>> DataPacks = new ArrayList<>();
        ArrayList<ArrayList<ArrayList<String>>> DataListPacks = new ArrayList<>();
        ArrayList<String> Header = new ArrayList<>();
        ArrayList<String> HeaderListed = new ArrayList<>();

        ArrayList<Integer> atributePos = new ArrayList<>();
        //////////////////////////////////////////////////

            if (type.startsWith("#")) {
                type = type.substring(1);
            }

        //////////////////////////////////////////////////

        switch (type.length()) {
            case 2:
                ArrayList<String> children = DataFunctions.prefixDescendant(type);
                for (String child : children) {
                    System.out.println(Constants.separtator + "\n" + DataFunctions.decodePrefix(child) + "\n" + Constants.separtator);
                    printAllRemaster(atribs, child);
                }

                break;
            case 3:
                for (String[][][] Class : Constants.Omniclase) {
                    for (String[][] Sub : Class) {
                        if (Sub[1][0].equals(type)) {
                            if (Sub[2] != null) {
                                for (int i = 0; i < Sub[2].length; i++) {
                                    if (atribs.contains(Sub[2][i])) {
                                        Header.add(Sub[2][i]);
                                        ArrayList<String> head = new ArrayList<>();
                                        DataPacks.add(head);
                                        atributePos.add(i);
                                    }
                                }
                            }

                            if (Sub[3] != null) {
                                for (int i = 0; i < Sub[3].length; i++) {
                                    if (atribs.contains(Sub[3][i])) {
                                        HeaderListed.add(Sub[3][i]);
                                        ArrayList<ArrayList<String>> ListedAtr = new ArrayList<>();
                                        DataListPacks.add(ListedAtr);
                                        atributePos.add(i);
                                    }
                                }
                            }
                            for (Generic g : AuxDB.Complete) {
                                if (g.getId().startsWith(type)) {
                                    int dealtAtrs = 0;
                                    for (String s : Header) {
                                        DataPacks.get(dealtAtrs).add(g.gatherInfo().get(atributePos.get(dealtAtrs)));
                                        dealtAtrs++;
                                    }
                                    dealtAtrs = 0;
                                    for (String s : HeaderListed) {
                                        DataListPacks.get(dealtAtrs).add(g.gatherListedInfo().get(atributePos.get(dealtAtrs)));
                                        dealtAtrs++;
                                    }
                                }
                            }
                            /////////////////Print Head
                            String headers = "";
                            for (String header : Header) {
                                String replacement = "";
                                for(int left = 0;left<((29-header.length())/2);left++){
                                    replacement += " ";
                                }
                                replacement += header;
                                for(int left = 0;left<((29-header.length())/2);left++){
                                    replacement += " ";
                                }
                                headers += String.format("%-30.30s", " " +replacement);
                            }
                            for (String header : HeaderListed) {
                                String replacement = "";
                                for(int left = 0;left<((29-header.length())/2);left++){
                                    replacement += " ";
                                }
                                replacement += header;
                                for(int left = 0;left<((29-header.length())/2);left++){
                                    replacement += " ";
                                }
                                headers += String.format("%-30.30s"," " + replacement);
                            }
                            headers+="\n";
                            for (int space = 0; space < 29 * (Header.size()+HeaderListed.size()); space++) {
                                if (space % 29 == 0) {
                                    headers += "|";
                                }
                                headers += "=";

                            }
                            System.out.println(headers);

                            /////////////////////////////////Body
                            for (int i = 0; i < DataPacks.get(0).size(); i++) {
                                String pL = "";
                                int cap = 1;
                                for (ArrayList<ArrayList<String>> listed : DataListPacks) {
                                    if (cap < listed.get(i).size()) {
                                        cap = listed.get(i).size();
                                    }
                                }
                                /////////////////////Print
                                for (int j = 0; j < cap; j++) {
                                    if (j == 0) {
                                        for (ArrayList<String> genericAtr : DataPacks) {

                                            pL = pL + String.format("%-30.30s", "- " + genericAtr.get(i));
                                        }
                                    } else {
                                        for (ArrayList<String> genericAtr : DataPacks) {
                                            pL = pL + String.format("%-30.30s", "- " + "");

                                        }
                                    }

                                        for (ArrayList<ArrayList<String>> listed : DataListPacks) {
                                            try {
                                                pL = pL + String.format("%-30.30s","- "+ listed.get(i).get(j));
                                            } catch (Exception e) {
                                                pL = pL + String.format("%-30.30s", "- " + "");
                                            }
                                        }
                                        pL += "\n";




                                }
                                System.out.println(pL);
                            }
                        }
                    }
                }
        }
    }

    public static ArrayList<String> prefixDescendant(String prefix) {
        //Correcion de entrada humana
        if(prefix.startsWith("#")){
            prefix = prefix.substring(1);
        }
        prefix = prefix.toUpperCase();

        ArrayList<String> prefixDescendants = new ArrayList<>();
        for (String[][][] Class : Constants.Omniclase) {
            for (String[][] Sub : Class) {
                if(Sub[1][0].startsWith(prefix)){
                    prefixDescendants.add(Sub[1][0]);
                }
            }
        }
        return prefixDescendants;
    }

    public static String decodePrefix(String prefix) {
        for (String[][][] Class : Constants.Omniclase) {
            for (String[][] Sub : Class) {
                if(Sub[1][0].equals(prefix)){
                    return Sub[0][0];
                }
            }
        }
        return "Invalido";
    }


}
