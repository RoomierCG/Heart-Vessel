package service.utility;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class UserInteractions {

    static Scanner sc = new Scanner(System.in);

    public void printSPACE(){
        System.out.println(":)");
    }

    public static int numRequest(String prompt,int min, int max){
        int number = 0;

        System.out.println(prompt + " El valor debe estar entre " + min + " y " + max);

        try{
            number = sc.nextInt();
        }catch (Exception e){
            System.out.println("formato incorrecto");
            numRequest(prompt,max, min);
        }

        if (number < min || number > max){
            return numRequest(prompt,max, min);
        }

        return number;
    }

    public static String strRequest(String prompt){
        String string;

        System.out.println(prompt);
        string = sc.nextLine();

        return string;
    }

    public static String dateRequest(){

        int cDay = Integer.parseInt(getCurrentDate().substring(0,2));
        int cMonth = Integer.parseInt(getCurrentDate().substring(3,5));
        int cYear = Integer.parseInt(getCurrentDate().substring(6,10));

        //Declaraciones
        int [] months = {31,28,31,30,31,30,31,31,30,31,30,31};

        int month = numRequest("Introduzca el mes.",1,12);
        int year = numRequest(" elIntroduzca año.",0,cYear);
        int day;

        if(cYear == year && cMonth == month){
            day = numRequest("Introduca el dia. ",1,cDay);
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

    ///////////////////////////////////Passive/////////////////////////////////////

    private static String getCurrentDate() {//0-2,3-5,6-10 == dd/mm/yyyy
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        return (dtf.format(now));
    }

}
