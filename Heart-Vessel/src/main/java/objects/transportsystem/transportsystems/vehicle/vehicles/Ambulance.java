package objects.transportsystem.transportsystems.vehicle.vehicles;

import objects.people.Person;
import objects.product.Product;
import objects.transportsystem.transportsystems.vehicle.Vehicle;

import java.util.ArrayList;

public class Ambulance extends Vehicle {

    private ArrayList<String> equipment;
    private ArrayList<String> personal;



    public Ambulance(String transportId,String transportName, String status, String type, int gasTank,ArrayList<String> personal, ArrayList<String> equipment) {
        super(transportId, transportName,status, type, gasTank);
        this.equipment = equipment;
        this.personal = personal;
    }

    public Ambulance() {
        super();
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


    public ArrayList<String> gatherInfo() {
        return null;
    }

    @Override
    public ArrayList<ArrayList<String>> gatherListedInfo() {
        return null;
    }
}
