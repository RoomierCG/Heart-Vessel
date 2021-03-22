package test.java;

import database_management.AuxDB;
import objects.Generic;
import service.data_manager.DataFunctions;
import visualInterfaces.Constants;

import javax.xml.crypto.Data;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class retestingPrintall {
    public static void printAll(ArrayList<String> atribs, String type) {
        ArrayList<ArrayList<String>> DataPacks = new ArrayList<>();
        ArrayList<ArrayList<ArrayList<String>>> DataListPacks = new ArrayList<>();
        ArrayList<String> Header = new ArrayList<>();
        ArrayList<String> HeaderListed = new ArrayList<>();

        ArrayList<Integer> atributePos = new ArrayList<>();
        //////////////////////////////////////////////////
        if (type.length() == 4) {
            if (type.startsWith("#")) {
                type = type.substring(1);
            }
        }
        //////////////////////////////////////////////////


        switch (type.length()) {
            case 2:
                ArrayList<String> children = DataFunctions.prefixDescendant(type);
                for (String child : children) {
                    System.out.println(Constants.separtator + "\n" + DataFunctions.decodePrefix(child) + "\n" + Constants.separtator);
                    printAll(atribs, child);
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
                                    for (String s : HeaderListed) {
                                        DataListPacks.get(dealtAtrs).add(g.gatherListedInfo().get(atributePos.get(dealtAtrs)));
                                        dealtAtrs++;
                                    }
                                }
                            }
                            for (int i = 0; i < DataPacks.get(0).size(); i++) {
                                String pL = "";

                                int cap = 0;
                                for (ArrayList<ArrayList<String>> listed : DataListPacks) {
                                    if (cap < listed.get(i).size()) {
                                        cap = listed.get(i).size();
                                    }
                                }
                                for (int j = 0; j < cap; j++) {
                                    if (j == 0) {
                                        for (ArrayList<String> genericAtr : DataPacks) {
                                            pL = pL + String.format("%-30.30s", "- " + genericAtr.get(i));
                                        }
                                    } else {
                                        for (ArrayList<String> genericAtr : DataPacks) {
                                            pL = pL + String.format("%-30.30s", "- " + "- ");

                                        }
                                        for (ArrayList<ArrayList<String>> listed : DataListPacks) {
                                            try {
                                                pL = pL + String.format("%-30.30s", listed.get(i).get(j));
                                            } catch (Exception e) {
                                                pL = pL + String.format("%-30.30s", "- " + "- ");
                                            }
                                        }
                                    }

                                }
                                System.out.println(pL);
                            }
                        }
                    }
                }
        }
    }
}






