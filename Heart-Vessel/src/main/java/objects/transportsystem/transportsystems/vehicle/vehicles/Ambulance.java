package objects.transportsystem.transportsystems.vehicle.vehicles;

import objects.people.Person;
import objects.product.Product;
import objects.transportsystem.transportsystems.vehicle.Vehicle;

import java.util.ArrayList;

public class Ambulance extends Vehicle {
    private ArrayList<Product> equipment;
    private ArrayList<Person> personal;

    public Ambulance(int transportId, String status, String type, int gasTank) {
        super(transportId, status, type, gasTank);
    }

    public Ambulance(int transportId, String status, String type, ArrayList<Person> personal, int gasTank, ArrayList<Product> equipment) {
        super(transportId, status, type, gasTank);
        this.equipment = equipment;
    }

    public ArrayList<Person> getPersonal() {
        return personal;
    }

    public void setPersonal(ArrayList<Person> personal) {
        this.personal = personal;
    }

    public ArrayList<Product> getEquipment() {
        return equipment;
    }

    public void setEquipment(ArrayList<Product> equipment) {
        this.equipment = equipment;
    }
}
