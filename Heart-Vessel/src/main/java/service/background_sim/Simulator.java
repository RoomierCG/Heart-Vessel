package service.background_sim;

import database_management.AuxDB;
import objects.people.person.Employee;
import objects.people.person.Patient;
import service.data_manager.DataFunctions;
import service.utility.OpsID;

import java.util.ArrayList;
import java.util.Random;

public class Simulator implements Runnable {
    ArrayList<String> log = new ArrayList<>();

    public static int randomNum(int min, int max) {
        Random num = new Random();
        return num.nextInt((max - min)) + min;
    }

    public void run() {
        do{
            ArrayList<ArrayList<String>> temporal;
            switch (randomNum(0,8)){
                case 1://Genera Nueva Paciente
                    Patient newPat = new Patient();
                    newPat.genMe(OpsID.generateID("PEP"));
                    AuxDB.Complete.add(newPat);
                    log.add("Paciente : "+newPat.getId()+" ingresado");
                    break;
                case 2://Genera Nueva Empleado
                    Employee newEmple = new Employee();
                    newEmple.genMe(OpsID.generateID("PEE"));
                    AuxDB.Complete.add(newEmple);
                    log.add("Paciente : "+newEmple.getId()+" contratado");
                    break;
                case 3://Elimina un empleado/paciente
                    if(randomNum(0,1)==0){
                        temporal = DataFunctions.getData(new ArrayList<String>(){{add("id");}},"PEE");
                        String elim = temporal.get(0).get(randomNum(0,temporal.get(0).size()));
                        AuxDB.Complete.remove(OpsID.decodeID(elim));

                    }

            }
        }while(true);
    }
}
