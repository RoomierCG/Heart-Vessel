package service.utility;

import database_management.AuxDB;
import objects.area.Area;
import objects.area.areas.Garaje;
import objects.area.areas.HabitableRoom;
import objects.people.Person;
import objects.people.person.Employee;
import objects.people.person.Patient;
import objects.product.Product;
import objects.product.products.CleaningEquipment;
import objects.product.products.Machinery;
import objects.product.products.SanitationMaterials;
import objects.product.products.substance.substances.CleaningProducts;
import objects.product.products.substance.substances.consumable.consumables.FoodMenu;
import objects.product.products.substance.substances.consumable.consumables.Medicine;
import objects.provider.Provider;
import objects.transportsystem.Transport;
import objects.transportsystem.transportsystems.MovementAid;
import objects.transportsystem.transportsystems.vehicle.vehicles.Ambulance;
import objects.transportsystem.transportsystems.vehicle.vehicles.CompanyCar;

import java.util.ArrayList;

import static database_management.AuxDB.*;


public class OpsID {


    public static Object decodeID(String id) {
        if (id.length() < 4) {
            //ID no valido
            return null;
        } else {
            String inicial = id.substring(0, 3);
            Object resultado = null;
            switch (inicial.substring(0, 2)) {
                case "PE":
                    if (inicial.equals("PEE")) {
                        resultado = new Employee();
                    } else if (inicial.equals("PEP")) {
                        resultado = new Patient();
                    }
                    for (Person person : ArrlPerson) {
                        if (person.getPersonId().equals(id)) {
                            resultado = person;
                        }
                        return resultado;
                    }
                    return null;

                case "PR":
                    if (inicial.equals("PRC")) {
                        resultado = new FoodMenu();
                    } else if (inicial.equals("PRE")) {
                        resultado = new CleaningEquipment();
                    } else if (inicial.equals("PRL")) {
                        resultado = new CleaningProducts();
                    } else if (inicial.equals("PRD")) {
                        resultado = new Medicine();
                    } else if (inicial.equals("PRS")) {
                        resultado = new SanitationMaterials();
                    } else if (inicial.equals("PRM")) {
                        resultado = new Machinery();
                    }
                    for (Product iterator : ArrlProduct) {
                        if (iterator.getEquipmentId().equals(id)) {
                            resultado = iterator;
                        }
                        return resultado;
                    }
                    return null;

                case "TR":
                    if (inicial.equals("TRM")) {
                        resultado = new MovementAid();
                    } else if (inicial.equals("TRA")) {
                        resultado = new Ambulance();
                    } else if (inicial.equals("TRC")) {
                        resultado = new CompanyCar();
                    }
                    for (Transport iterator : ArrlTransport) {
                        if (iterator.getTransportId().equals(id)) {
                            resultado = iterator;
                        }
                        return resultado;
                    }
                    return null;

                case "PV":
                    if (inicial.equals("TRM")) {
                        resultado = new Provider();
                    }
                    for (Provider iterator : ArrlProvider) {
                        if (iterator.getIdProvider().equals(id)) {
                            resultado = iterator;
                        }
                        return resultado;
                    }
                    return null;
                case "AR":
                    if (inicial.equals("ARR")) {
                        resultado = new Area();
                    } else if (inicial.equals("ARG")) {
                        resultado = new Garaje();
                    } else if (inicial.equals("ARH")) {
                        resultado = new HabitableRoom();
                    }
                    for (Area iterator : ArrLarea) {
                        if (iterator.getIdArea().equals(id)) {
                            resultado = iterator;
                        }
                        return resultado;
                    }
                    return null;

                default:
                    System.out.println("Caso no encontrado");
                    break;

            }
            return Object.class;
        }
    }

    public static int retrieveIDValue(String id) {
        int result = 0;
        try {
            result = Integer.parseInt(id.substring(4));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String generateID(String prefix) {

        for (ID a : EmptyIDs) {
            if (a.getType().equals(prefix)) {
                EmptyIDs.remove(a);
                return prefix + a.getNumVal();
            }
        }
        for (ID max : MaxIDs) {
            if (max.getType().equals(prefix)) {
                max.increment();
                return prefix + max.getNumVal();
            }
        }
        return prefix + "1";
    }
}
