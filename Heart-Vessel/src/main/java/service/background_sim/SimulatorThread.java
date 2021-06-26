package service.background_sim;

import database_management.AuxDB;
import objects.Generic;
import objects.area.Area;
import objects.area.areas.HabitableRoom;
import objects.people.person.Employee;
import objects.people.person.Patient;
import objects.product.Product;
import objects.product.products.substance.Substance;
import objects.provider.Provider;
import objects.transportsystem.transportsystems.MovementAid;
import objects.transportsystem.transportsystems.vehicle.vehicles.Ambulance;
import org.apache.catalina.User;
import service.data_manager.DataFunctions;
import service.utility.OpsID;
import service.utility.UserInteractions;
import visualInterfaces.Constants;

import java.util.ArrayList;
import java.util.Random;

/*
QueryDB.rellenarTest();
        Thread t = new SimulatorThread();
        t.start();
        do{
            int g = UserInteractions.numRequest("asd");
            System.out.println("oh yea");
            t.sleep(500);
            ArrayList<String> logPrint = new ArrayList<>(SimulatorThread.log);
            System.out.println("yes");
            for(String r : logPrint){
                System.out.println(r);
            }
        }while (t.isAlive());
        System.out.println("End");
 */

public class SimulatorThread extends Thread implements Runnable {
    public static ArrayList<String> log = new ArrayList<>();

    public static int randomNum(int min, int max) {
        if (min == max) {
            return min;
        }
        Random num = new Random();
        return num.nextInt((max - min)) + min;
    }

    public void showActivity()  {
        int cap = log.size()-1;
        int quant = UserInteractions.numRequest("Introduzca cuantas entradas de actividad desea ver (nuevas iran primero)",1,cap+1);
        for(int i = 0;i<quant;i++){
            System.out.println(log.get(cap-i));
        }
    }


    public void run() {
        try {
            int last=0;
            int newNum;
            do {
                Thread.sleep(Constants.SimSpeedMS);
                ArrayList<ArrayList<String>> temporal;
                do{
                    newNum = randomNum(1,8);
                }while (newNum==last);
                last = newNum;
                switch (last) {
                    case 1://Genera Nuevo Paciente
                        Patient newPat = new Patient();
                        newPat.genMe(OpsID.generateID("PEP"));
                        AuxDB.Complete.add(newPat);
                        log.add(String.format(Constants.RegistryFormat, "Paciente  : " + newPat.getId() + " ingresado.   ") + String.valueOf(java.time.LocalTime.now()).substring(0, 8));
                        break;
                    case 2://Genera Nuevo Empleado
                        Employee newEmple = new Employee();
                        newEmple.genMe(OpsID.generateID("PEE"));
                        AuxDB.Complete.add(newEmple);
                        log.add(String.format(Constants.RegistryFormat, "Empleado  : " + newEmple.getId() + " contratado.   ") + String.valueOf(java.time.LocalTime.now()).substring(0, 8));
                        break;
                    case 3://Cambios de Paciente/Empleado
                        if (randomNum(0, 1) == 0) {
                            temporal = DataFunctions.getData(new ArrayList<String>() {{
                                add("id");
                            }}, "PEE");
                            Employee emple = (Employee) OpsID.decodeID(temporal.get(0).get(randomNum(0, temporal.get(0).size())));
                            int dif = emple.getSalary() * ((randomNum(1, 20)) / 10);
                            if (randomNum(0, 1) == 0) {
                                emple.setSalary(emple.getSalary() + dif);
                                log.add(String.format(Constants.RegistryFormat, "Empleado  : " + emple.getId() + " incremento de salario en " + dif + " euros.   ") + String.valueOf(java.time.LocalTime.now()).substring(0, 8));
                            } else {
                                emple.setSalary(emple.getSalary() + dif);
                                log.add(String.format(Constants.RegistryFormat, "Empleado  : " + emple.getId() + " decremento de salario en " + dif + " euros.   " ) + String.valueOf(java.time.LocalTime.now()).substring(0, 8));
                            }
                        } else {
                            temporal = DataFunctions.getData(new ArrayList<String>() {{
                                add("id");
                            }}, "PEP");
                            Patient paci = (Patient) OpsID.decodeID(temporal.get(0).get(randomNum(0, temporal.get(0).size())));
                            if (randomNum(0, 1) == 0) {

                                if (paci.getRoomId().startsWith("ARH")) {
                                    HabitableRoom hab = (HabitableRoom) OpsID.decodeID(paci.getRoomId());
                                    log.add(String.format(Constants.RegistryFormat, "Paciente  : " + paci.getId() + " ha sido atendida por los medicos.   ") + String.valueOf(java.time.LocalTime.now()).substring(0, 8));
                                    if (randomNum(0, 2) == 0) {
                                        if (!hab.getEquipment().isEmpty()) {
                                            Product prod = (Product) OpsID.decodeID(hab.getEquipment().get(randomNum(0, temporal.get(0).size())));
                                            prod.setQuantity(prod.getQuantity() - 10);
                                            if (prod.getQuantity() < 30 && prod.getQuantity() > 0) {
                                                log.add(String.format(Constants.RegistryFormat, "Aviso de escasez imminente de " + prod.getName() + " | Actualmente: " + prod.getQuantity()) + String.valueOf(java.time.LocalTime.now()).substring(0, 8));
                                            }
                                            if (prod.getQuantity() < 0) {
                                                hab.getEquipment().remove((prod.getId()));
                                                log.add(String.format(Constants.RegistryFormat, "El producto " + prod.getName() + " se ha agotado en la habitacion " + hab.getId()) + String.valueOf(java.time.LocalTime.now()).substring(0, 8));
                                            }
                                        }
                                    }
                                    paci.getRegistry().add(String.valueOf(java.time.LocalTime.now()).substring(0, 8) + " : Parece estar recuperandose");
                                } else {
                                    temporal = DataFunctions.getData(new ArrayList<String>() {{
                                        add("id");
                                    }}, "ARH");
                                    HabitableRoom nuevaHabit = null;
                                    for (String habId : temporal.get(0)) {
                                        HabitableRoom hab = (HabitableRoom) OpsID.decodeID(habId);
                                        if (hab.isEmpty()) {
                                            nuevaHabit = hab;
                                        }
                                    }
                                    if (nuevaHabit == null) {
                                        log.add(String.format(Constants.RegistryFormat, "Paciente  :  " + paci.getId() + " ha sido transportada a otro hospital for falta de habitaciones.   ") + String.valueOf(java.time.LocalTime.now()).substring(0, 8));
                                        AuxDB.Complete.remove(paci);
                                    } else {
                                        log.add(String.format(Constants.RegistryFormat, "Paciente  :  " + paci.getId() + " ha sido trasladada a la habitacion " + nuevaHabit.getId()  ) + String.valueOf(java.time.LocalTime.now()).substring(0, 8));
                                        paci.setRoomId(nuevaHabit.getId());
                                    }
                                }
                            }
                        }
                        break;
                    case 4://Despido/Muerte/Recuperacion
                        if (randomNum(0, 1) == 0) {
                            temporal = DataFunctions.getData(new ArrayList<String>() {{
                                add("id");
                            }}, "PEE");
                            if(temporal.size()>2) {
                                String elim = temporal.get(0).get(randomNum(0, temporal.get(0).size()));
                                log.add(String.format(Constants.RegistryFormat, "Empleado  : " + elim + " despedido.") + String.valueOf(java.time.LocalTime.now()).substring(0, 8));
                                AuxDB.Complete.remove(OpsID.decodeID(elim));
                            }
                        } else {
                            temporal = DataFunctions.getData(new ArrayList<String>() {{
                                add("id");
                            }}, "PEP");
                            if(temporal.size()>2) {
                                String elim = temporal.get(0).get(randomNum(0, temporal.get(0).size()));
                                if (randomNum(0, 1) == 0) {
                                    log.add(String.format(Constants.RegistryFormat, "Paciente  :  " + elim + " ha fallecido.   ") + String.valueOf(java.time.LocalTime.now()).substring(0, 8));
                                    AuxDB.Complete.remove(OpsID.decodeID(elim));
                                } else {
                                    log.add(String.format(Constants.RegistryFormat, "Paciente  :  " + elim + " ha sido dado de alta.   ") + String.valueOf(java.time.LocalTime.now()).substring(0, 8));
                                    AuxDB.Complete.remove(OpsID.decodeID(elim));
                                }
                            }
                        }

                        break;
                    case 5://Transporte
                        if (randomNum(0, 1) == 0) {
                            temporal = DataFunctions.getData(new ArrayList<String>() {{
                                add("id");
                            }}, "TRA");
                            Ambulance ambulancia = (Ambulance) OpsID.decodeID(temporal.get(0).get(randomNum(0, temporal.size())));
                            if (ambulancia.getStatus().equals("Averiado")) {
                                ambulancia.setStatus("Listo Para Salir");
                                log.add(String.format(Constants.RegistryFormat,"Ambulancia : " + ambulancia.getId() + " ha sido reparado.   "+String.valueOf(java.time.LocalTime.now()).substring(0, 8)));
                            } else {
                                if (ambulancia.getStatus().equals("En Transito")) {
                                    log.add(String.format(Constants.RegistryFormat,"Ambulancia : " + ambulancia.getId() + " ha regresado al hospital.")+String.valueOf(java.time.LocalTime.now()).substring(0, 8));
                                    ambulancia.setGasTank(ambulancia.getGasTank() - randomNum(5, 10));
                                    ambulancia.setStatus("Listo Para Salir");
                                    Patient pacienteAmbu = new Patient();
                                    pacienteAmbu.genMe(OpsID.generateID("PEP"));
                                    pacienteAmbu.getRegistry().clear();
                                    pacienteAmbu.getRegistry().add(String.valueOf(java.time.LocalTime.now()).substring(0, 8) + "   Ha llegado en malas condiciones de Ambulancia");
                                    AuxDB.Complete.add(pacienteAmbu);
                                    log.add(String.format(Constants.RegistryFormat, "Paciente  :  " + pacienteAmbu.getId() + " llega en Ambulancia.") + String.valueOf(java.time.LocalTime.now()).substring(0, 8));
                                    log.add(String.format(Constants.RegistryFormat,"Ambulancia : " + ambulancia.getId() + " ha regresado al hospital.")+String.valueOf(java.time.LocalTime.now()).substring(0, 8));
                                    if (ambulancia.getGasTank() < 5) {
                                        ambulancia.setGasTank(50);
                                        log.add(String.format(Constants.RegistryFormat,"Ambulancia : " + ambulancia.getId() + " fue rellenado de gasolina.   " ) +String.valueOf(java.time.LocalTime.now()).substring(0, 8));
                                    }
                                } else {
                                    ambulancia.setStatus("En Transito");
                                    log.add(String.format(Constants.RegistryFormat,"Ambulancia : " + ambulancia.getId() + " ha salido a recoger un paciente.   " ) +String.valueOf(java.time.LocalTime.now()).substring(0, 8));
                                }
                            }
                        } else {
                            temporal = DataFunctions.getData(new ArrayList<String>() {{
                                add("id");
                            }}, "TRM");
                            MovementAid ayum = (MovementAid) OpsID.decodeID(temporal.get(0).get(randomNum(0, temporal.size())));
                            if (ayum.getPatient().isEmpty()) {
                                temporal = DataFunctions.getData(new ArrayList<String>() {{
                                    add("id");
                                }}, "PEP");
                                ayum.setPatient(temporal.get(0).get(randomNum(0, temporal.size())));
                                log.add(String.format(Constants.RegistryFormat,"AyudaMovil : " + ayum.getId() + " ha sido asignado al paciente " + ayum.getPatient() + ".  " ) +String.valueOf(java.time.LocalTime.now()).substring(0, 8));
                            } else {
                                if (OpsID.decodeID(ayum.getPatient()) == null) {
                                    ayum.setPatient("");
                                    log.add(String.format(Constants.RegistryFormat,"AyudaMovil : " + ayum.getId() + " ha esta disponible para usar de nuevo.  " ) +String.valueOf(java.time.LocalTime.now()).substring(0, 8));
                                }
                            }
                        }
                        break;
                    case 6:
                        if (randomNum(0, 10) == 0) {
                            log.add(String.format(Constants.RegistryFormat,"Nos han llegado recursos de nuestros proveedores.   ") +String.valueOf(java.time.LocalTime.now()).substring(0, 8));
                            for (Generic g : AuxDB.Complete) {
                                if (g instanceof Substance) {
                                    ((Substance) g).setQuantity(((Substance) g).getQuantity() + 30);
                                    log.add(String.format(Constants.RegistryFormat," - - - "+g.getName()+" cantidad incrementada a "+((Substance) g).getQuantity()));

                                }
                            }

                        }
                        break;
                    case 7:
                        temporal = DataFunctions.getData(new ArrayList<String>() {{
                            add("id");
                        }}, "PVP");
                        Provider prov = (Provider) OpsID.decodeID(temporal.get(0).get(randomNum(0, temporal.size())));
                        prov.setAccount("ES");
                        do {
                            prov.setAccount(prov.getAccount() + randomNum(0, 9));
                        } while (prov.getAccount().length() < 24);
                        log.add(String.format(Constants.RegistryFormat,"Proveedor : " + prov.getId() + " se ha cambiado de cuenta a " + prov.getAccount())+String.valueOf(java.time.LocalTime.now()).substring(0, 8));
                        break;
                    case 8:
                        if (randomNum(0, 10) == 0) {
                            log.add(String.format(Constants.RegistryFormat,"Se ha detectado un virus pandemico.   " ) +String.valueOf(java.time.LocalTime.now()).substring(0, 8));
                            Area quarent = new Area(OpsID.generateID("ARR"), "ZonaPandemica", "En Cuarentena", 1, Constants.riesgos.get(Constants.riesgos.size()), null, null);
                            for (int i = 0; i < randomNum(0, 20); i++) {
                                Patient ingresadoPandemia = new Patient();
                                ingresadoPandemia.genMe(OpsID.generateID("PEP"));
                                ingresadoPandemia.getRegistry().clear();
                                ingresadoPandemia.getRegistry().add(String.valueOf(java.time.LocalTime.now()).substring(0, 8) + " | Se han confirmado simptomas del virus pandemico.");
                                ingresadoPandemia.setRoomId(quarent.getId());
                                ingresadoPandemia.getRegistry().add(String.valueOf(java.time.LocalTime.now()).substring(0, 8) + " | Trasladado al ala en cuarentena.");
                                AuxDB.Complete.add(ingresadoPandemia);
                                log.add(String.format(Constants.RegistryFormat, "Paciente  :  " + ingresadoPandemia.getId() + " tiene el virus pandemico.   ") + String.valueOf(java.time.LocalTime.now()).substring(0, 8));

                            }
                        }
                }
            } while (true);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
