package test.java;

import database_management.AuxDB;
import database_management.mongo.QueryDB;
import service.data_manager.DataFunctions;
import service.utility.OpsID;
import visualInterfaces.Constants;

import java.util.ArrayList;

public class cable {
    public static void main(String[] args) {
        QueryDB.rellenarTest();/*
        for (String[][][] Class : Constants.Omniclase) {
            for (String[][] Sub : Class) {
                if (Sub[1][0].startsWith("AR")) {
                    System.out.println(Sub[0][0]);
                }
            }*/

            ArrayList<String> atr = new ArrayList<String>() {
                {
                    add("id");
                    add("Nombre");
                    add("Personal");
                    add("Equipamiento");
                    add("Vehiculos");
                }
            };
            DataFunctions.printAllRemaster(atr, "AR");


        }
    }




