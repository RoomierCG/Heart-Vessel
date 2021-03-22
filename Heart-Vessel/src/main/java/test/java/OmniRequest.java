package test.java;

import database_management.AuxDB;
import objects.area.Area;
import visualInterfaces.Constants;

import java.util.ArrayList;

public class OmniRequest {
    public static void main(String[] args) {

        String[][][][] o = Constants.Omniclase;


        String param = "PEE#";
        for(String[][][] category: o){
            for(String[][] subcategory : category){
                if(param.substring(0,3).equals(subcategory[1][0])){
                   for(String a : subcategory[2]){
                       System.out.println(a);
                   }
                }
            }
        }
        ArrayList<String> singles = new ArrayList<>();
        ArrayList<ArrayList<String>> multis = new ArrayList<>();

       //for(int i=0;i<o[0].length);


    }

    static boolean stop(boolean status){
        return status;
    }
}
