package service.utility;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class UserInteractions {

    Scanner sc = new Scanner(System.in);

    public void printSPACE(){
        System.out.println(":)");
    }

    public int numRequest(String prompt,int min, int max){
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

    public String strRequest(String prompt){
        String string;

        System.out.println("Introduzca " + prompt);
        string = sc.nextLine();

        return string;
    }

    public String dateRequest(){

        //Declaraciones
        int [] months = {31,28,31,30,31,30,31,31,30,31,30,31};

        int month = numRequest("Introduzca el mes.",1,12);
        int year = numRequest("Introduzca el año.",0,2019);
        int day;

        if (month == 2 ){
            if (year % 4 == 0){
                day = numRequest("Introduca el dia. ",1,29);
            }else{
                day = numRequest("Introduca el dia. ",1,28);
            }
        }else{
            day = numRequest("Introduca el dia. ",1,months[month-1]);
        }

        //TODO Que no viajen al futuro en 2020 ni antes que jesucristo
        return day+"/"+month+"/"+year ;
    }

    public static void main(String[] args) {
        System.out.println("falg");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));

    }
}
