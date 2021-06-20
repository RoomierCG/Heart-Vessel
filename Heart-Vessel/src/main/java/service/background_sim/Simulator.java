package service.background_sim;

import database_management.AuxDB;
import objects.Generic;
import objects.area.areas.HabitableRoom;
import objects.people.person.Employee;
import objects.people.person.Patient;
import objects.product.Product;
import objects.product.products.substance.substances.consumable.consumables.Medicine;
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
                case 1://Genera Nuevo Paciente
                    Patient newPat = new Patient();
                    newPat.genMe(OpsID.generateID("PEP"));
                    AuxDB.Complete.add(newPat);
                    log.add(String.format("%60.60s","|| Paciente : "+newPat.getId()+" ingresado. || ")+String.valueOf(java.time.LocalTime.now()).substring(0,8));
                    break;
                case 2://Genera Nuevo Empleado
                    Employee newEmple = new Employee();
                    newEmple.genMe(OpsID.generateID("PEE"));
                    AuxDB.Complete.add(newEmple);
                    log.add(String.format("%60.60s","|| Empleado : "+newEmple.getId()+" contratado. || ")+String.valueOf(java.time.LocalTime.now()).substring(0,8));
                    break;
                case 3://Cambios de Paciente/Empleado
                    if(randomNum(0,1)==0){
                        temporal = DataFunctions.getData(new ArrayList<String>(){{add("id");}},"PEE");
                        Employee emple = (Employee) OpsID.decodeID(temporal.get(0).get(randomNum(0,temporal.get(0).size())));
                        int dif = emple.getSalary()*(randomNum(1,20)/10);
                        if(randomNum(0,1)==0){
                            emple.setSalary(emple.getSalary()+dif);
                            log.add(String.format("%60.60s","|| Empleado : "+emple.getId()+" incremento de salario en "+dif+ "euros. || ")+String.valueOf(java.time.LocalTime.now()).substring(0,8));
                        }else{
                            emple.setSalary(emple.getSalary()+dif);
                            log.add(String.format("%60.60s","|| Empleado : "+emple.getId()+" decremento de salario en "+dif+ "euros. || ")+String.valueOf(java.time.LocalTime.now()).substring(0,8));
                        }
                    }else{
                        temporal = DataFunctions.getData(new ArrayList<String>(){{add("id");}},"PEP");
                        Patient paci = (Patient) OpsID.decodeID(temporal.get(0).get(randomNum(0,temporal.get(0).size())));
                        if(randomNum(0,1)==0){

                            if(paci.getRoomId().startsWith("ARH")){
                                HabitableRoom hab = (HabitableRoom) OpsID.decodeID(paci.getRoomId());
                                log.add(String.format("%60.60s","|| Paciente : "+paci.getId()+" ha sido atendida por los medicos. || ")+String.valueOf(java.time.LocalTime.now()).substring(0,8));
                                if(randomNum(0,3)==0){

                                    Medicine prod = (Medicine) OpsID.decodeID(hab.getEquipment().get(randomNum(0,temporal.get(0).size())));
                                    prod.setQuantity(prod.getQuantity()-10);
                                    if(prod.getQuantity()<30){
                                        log.add(String.format("%60.60s","|| Aviso de escasez imminente de "+prod.getName()+" | Actualmente: "+prod.getQuantity())+String.valueOf(java.time.LocalTime.now()).substring(0,8));
                                    }
                                }
                                paci.getRegistry().add(String.valueOf(java.time.LocalTime.now()).substring(0,8)+" : Parece estar recuperandose");
                            }else{
                                temporal = DataFunctions.getData(new ArrayList<String>(){{add("id");}},"ARH");
                                HabitableRoom nuevaHabit = null;
                                for(String habId : temporal.get(0)){
                                    HabitableRoom hab = (HabitableRoom) OpsID.decodeID(habId);
                                    if(hab.isEmpty()){
                                        nuevaHabit = hab;
                                    }
                                }
                                if(nuevaHabit == null){
                                    log.add(String.format("%60.60s","|| Paciente : "+paci.getId()+" ha sido transportada a otro hospital for falta de habitaciones. || ")+String.valueOf(java.time.LocalTime.now()).substring(0,8));
                                    AuxDB.Complete.remove(paci);
                                }else{
                                    log.add(String.format("%60.60s","|| Paciente : "+paci.getId()+" ha sido trasladada a la habitacion " +nuevaHabit.getId()+ " || ")+String.valueOf(java.time.LocalTime.now()).substring(0,8));
                                    paci.setRoomId(nuevaHabit.getId());
                                }
                            }
                        }
                    }
                    break;
                case 4://Despido/Muerte/Recuperacion *********WOIP*************
                    if(randomNum(0,1)==0){
                        temporal = DataFunctions.getData(new ArrayList<String>(){{add("id");}},"PEE");
                        String elim = temporal.get(0).get(randomNum(0,temporal.get(0).size()));
                        log.add(String.valueOf(java.time.LocalTime.now()).substring(0,8)+"|| Empleado : "+elim+" despedido");
                        AuxDB.Complete.remove(OpsID.decodeID(elim));
                    }else{
                        temporal = DataFunctions.getData(new ArrayList<String>(){{add("id");}},"PEP");
                        String elim = temporal.get(0).get(randomNum(0,temporal.get(0).size()));
                        if(true)
                        log.add(String.valueOf(java.time.LocalTime.now()).substring(0,8)+"|| Empleado : "+elim+" despedido");
                        AuxDB.Complete.remove(OpsID.decodeID(elim));
                    }

            }
        }while(true);
    }
}
