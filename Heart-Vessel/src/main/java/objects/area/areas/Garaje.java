package objects.area.areas;

import objects.area.Area;
import objects.people.Person;
import objects.transportsystem.transportsystems.vehicle.Vehicle;

import java.util.ArrayList;

public class Garaje extends Area {

    private ArrayList<Vehicle> vehicles;

    public Garaje(int idArea, ArrayList<Person> personal, String status, int inventory, int floor, String airFlow, int risk, ArrayList<Vehicle> vehicles) {
        super(idArea, personal, status, inventory, floor, airFlow, risk);
        this.vehicles = vehicles;
    }

    public Garaje(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public Garaje() {}

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
