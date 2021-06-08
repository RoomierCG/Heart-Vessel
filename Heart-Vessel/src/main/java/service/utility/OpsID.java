package service.utility;

import database_management.AuxDB;
import objects.Generic;
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
import visualInterfaces.Constants;

import java.util.ArrayList;

import static database_management.AuxDB.*;


public class OpsID {
    public static Generic decodeID(String id){
        for(Generic generic : Complete){
            if(generic.getId().equals(id)){
                return generic;
            }
        }
        return null;
    }
    public static int retrieveIDValue(String id) {
        int result = 0;
        try {
            result = Integer.parseInt(id.substring(4));
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return result;
    }

    public static String generateID(String prefix) {

        for (ID a : EmptyIDs) {
            if (a.getType().equals(prefix)) {
                EmptyIDs.remove(a);
                return prefix+"#" + a.getNumVal();
            }
        }
        for (ID max : MaxIDs) {
            if (max.getType().equals(prefix)) {
                max.increment();
                return prefix +"#"+ max.getNumVal();
            }
        }
        return prefix + "#1";
    }




}
