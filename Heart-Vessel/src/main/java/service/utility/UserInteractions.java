package service.utility;


import database_management.AuxDB;
import visualInterfaces.Constants;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInteractions {

    static Scanner sc = new Scanner(System.in);

    public static int numRequest(String prompt){
        int number = 0;
        if(!(prompt.length()==0)){
            System.out.println(prompt);
        }
        try{
            number = sc.nextInt();
        }catch (Exception e){
            System.out.println("formato incorrecto");
            sc.nextLine();
            numRequest(prompt);
        }
        return number;
    }
    public static int numRequest(String prompt,int min, int max){
        int number;
        number = numRequest(prompt + "\nEl valor debe estar entre " + min + " y " + max);
        if (number < min || number > max){
            System.out.println("Valor no dentro de limites especificados ("+min+" y "+max+")");
            return numRequest(prompt,min, max);
        }
        return number;
    }
    public static int numRequest(String prompt, ArrayList<Integer> ops){
        int response;
        boolean valido = false;
        do{
            response = numRequest(prompt);
            for(Integer i : ops){
                if (i == response){
                    valido = true;
                    break;
                }
            }
        }while(!valido);
        return response;
    }


    public static String strRequest(String prompt){
        String output;
        System.out.println(prompt);
        sc.nextLine();
        output = sc.nextLine();

        return output;
    }
    public static String strRequest(String prompt,int size){
        String output;
        System.out.println(prompt + "\nDebe ser exactamente "+size+" caracteres en longitud");
        output = strRequest(prompt);
            if(!(output.length()==size)){
                System.out.println("El valor tiene que ser exactamente de longitud: "+size);
                output = strRequest(prompt,size);
            }
        return output;
    }
    public static String strRequest(String prompt,int min,int max) {
        String output;
        if (min < 0 && max > 0) {
            output = strRequest(prompt + "\nIntroduzca hasta un maximo de " + max + " caracteres.");
            if (output.length() > max) {
                System.out.println("Valor demasiado grande");
                output = strRequest(prompt, min, max);
            }
        } else if (max < 0 && min > 0) {
            output = strRequest(prompt + "\nIntroduzca un minimo de " + min + " caracteres.");
            if (output.length() > min) {
                System.out.println("Valor demasiado pequeño");
                output = strRequest(prompt, min, max);
            }
        }else{
            output = strRequest("Prompt");
        }

        return output;

    }


    public static String idRequest(){
        String prefijoID = "";
        int TamMax = AuxDB.MaxIDs.size();
        for (int i = 0;i<TamMax;i+=2) {
            if(i==TamMax-1 && (TamMax%2 == 1)) {
                System.out.print((i + 1) + ". " + AuxDB.MaxIDs.get(i).getVisualType());
            }
            else{
                System.out.printf("%-30.30s  %-30.30s%n", ((i + 1) + ". " + AuxDB.MaxIDs.get(i).getVisualType()), ((i + 2) + ". " + AuxDB.MaxIDs.get(i + 1).getVisualType()));
            }
        }
        ID claseSelec = AuxDB.MaxIDs.get(numRequest("\n\nSeleccione el tipo deseado",1,TamMax)-1);
        prefijoID = prefijoID+claseSelec.getType()+"#";
        return idRequest(prefijoID);
    }

    public static String idRequest(String forceType){
        String prefijoID = forceType;

        if(forceType.length()==2){
            ArrayList<String> typeOp = new ArrayList<>();

            for(String[][][] i : Constants.Omniclase){
                for(int j = 0;j<i.length;j++){
                    if(i[j][1][0].substring(0,2).equals(forceType)){
                        for(int found = 0;found<i.length;found++){
                            typeOp.add(i[found][1][0]);
                        }
                        break;
                    }
                }
            }

            for(int i = 0;i<typeOp.size();i++){
                System.out.println(typeOp.get(i)+"#"+(i+1));
            }
            prefijoID = typeOp.get(UserInteractions.numRequest("Elige la subclase a la que pertenece el ID",1,typeOp.size())-1)+"#";
        }
        String save = prefijoID;
        do{
            prefijoID = save;
            prefijoID = prefijoID + numRequest("Introduzca el valor numerico del ID o -1 para salir");//o -1 si desea salir¿
        }while(OpsID.decodeID(prefijoID)==null && !(prefijoID.substring(4).equals("-1")));
        return prefijoID;
    }

    public static String dateRequest(){

        int cDay = Integer.parseInt(getCurrentDate().substring(0,2));
        int cMonth = Integer.parseInt(getCurrentDate().substring(3,5));
        int cYear = Integer.parseInt(getCurrentDate().substring(6,10));

        int [] months = {31,28,31,30,31,30,31,31,30,31,30,31};

        int month = numRequest("Introduzca el mes.",1,12);
        int year = numRequest("Introduzca el año.",0,cYear);
        int day;

        if(cYear == year && cMonth == month){
            day = numRequest("Introduzca el dia. ",1,cDay);
        }else {
            if (month == 2) {
                if (year % 4 == 0) {
                    day = numRequest("Introduca el dia. ", 1, 29);
                } else {
                    day = numRequest("Introduca el dia. ", 1, 28);
                }
            } else {
                day = numRequest("Introduca el dia. ", 1, months[month - 1]);
            }
        }
        return day + "/" + month + "/" + year;
    }

    private static String getCurrentDate() {//0-2,3-5,6-10 == dd/mm/yyyy
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        return (dtf.format(now));
    }

}
