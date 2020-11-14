package objects.transportsystem.transportsystems.vehicle.vehicles;

import objects.people.Person;
import objects.product.Product;
import objects.transportsystem.transportsystems.vehicle.Vehicle;

import java.util.ArrayList;

public class Ambulance extends Vehicle {

    private ArrayList<String> equipment;
    private ArrayList<String> personal;

    public Ambulance(String transportId, String status, String type, int gasTank) {
        super(transportId, status, type, gasTank);
    }

    public Ambulance(String transportId, String status, String type, ArrayList<String> personal, int gasTank, ArrayList<String> equipment) {
        super(transportId, status, type, gasTank);
        this.equipment = equipment;
        this.personal = personal;
    }

    public ArrayList<String> getPersonal() {
        return personal;
    }

    public void setPersonal(ArrayList<String> personal) {
        this.personal = personal;
    }

    public ArrayList<String> getEquipment() {
        return equipment;
    }

    public void setEquipment(ArrayList<String> equipment) {
        this.equipment = equipment;

    }

}
