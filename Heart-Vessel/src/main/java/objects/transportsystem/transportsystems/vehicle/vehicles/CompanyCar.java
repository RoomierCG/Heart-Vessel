package objects.transportsystem.transportsystems.vehicle.vehicles;

import objects.people.Person;
import objects.transportsystem.transportsystems.vehicle.Vehicle;

import java.util.ArrayList;

public class CompanyCar extends Vehicle {
    private String model;
    private String make;

    public CompanyCar(int transportId, String status, String type, ArrayList<Person> personal, int gasTank) {
        super(transportId, status, type, personal, gasTank);
    }

    public CompanyCar(int transportId, String status, String type, ArrayList<Person> personal, int gasTank, String model, String make) {
        super(transportId, status, type, personal, gasTank);
        this.model = model;
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }
}
