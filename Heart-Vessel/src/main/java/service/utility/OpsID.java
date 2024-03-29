package service.utility;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
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
    public static Generic decodeID(String id){//Nos devuelve el objeto con el ID que le pasemos por parametro
        for(Generic generic : Complete){
            if(generic.getId().equals(id)){
                return generic;
            }
        }
        return null;
    }
    public static int retrieveIDValue(String id) {//Nos devuelve el valor numerico del ID sin su prefijo
        int result;
        try {
            result = Integer.parseInt(id.substring(4));
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return result;
    }

    public static String generateID(String prefix) {//Nos genera un ID que no este siendo utilizado/no exista
        //Para evitar la creacion de un ID invalido
        if(prefix.length()!=3){
            prefix = prefix.substring(0,3);
        }
        /*Solo en el caso de que queramos reciclar los IDs
        for (ID a : EmptyIDs) {
            if (a.getType().equals(prefix)) {
                EmptyIDs.remove(a);
                return prefix+"#" + a.getNumVal();
            }
        }*/
        //Tenemos guardado el id mas alto y lo incrementamos cada vez que creamos uno nuevo (asumiendo que no se recicla)
        for (ID max : MaxIDs) {
            if (max.getType().equals(prefix)) {
                max.increment();
                return prefix +"#"+ max.getNumVal();
            }
        }
        return prefix + "#1";
    }




}
