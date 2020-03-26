package objects.transportsystem.transportsystems.vehicle.vehicles;

import objects.people.Person;
import objects.product.Product;
import objects.transportsystem.transportsystems.vehicle.Vehicle;

import java.util.ArrayList;

public class Ambulance extends Vehicle {
    private ArrayList<Product> equipment;

    public Ambulance(int transportId, String status, String type, ArrayList<Person> personal, int gasTank) {
        super(transportId, status, type, personal, gasTank);
    }

    public Ambulance(int transportId, String status, String type, ArrayList<Person> personal, int gasTank, ArrayList<Product> equipment) {
        super(transportId, status, type, personal, gasTank);
        this.equipment = equipment;
    }

    public ArrayList<Product> getEquipment() {
        return equipment;
    }

    public void setEquipment(ArrayList<Product> equipment) {
        this.equipment = equipment;
    }
}
