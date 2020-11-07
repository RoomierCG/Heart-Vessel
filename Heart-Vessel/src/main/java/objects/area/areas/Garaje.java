package objects.area.areas;

import objects.area.Area;
import objects.people.Person;
import objects.transportsystem.transportsystems.vehicle.Vehicle;

import java.util.ArrayList;

public class Garaje extends Area {

    private ArrayList<Vehicle> vehicles; //Los vehiculos que se ubican dentro del garaje en cuestion

    public Garaje(int idArea, ArrayList<Person> personal, String name, String status, int inventory, int floor, int risk, ArrayList<Vehicle> vehicles) {
        super(idArea, name, personal, status, inventory, floor, risk);
        this.vehicles = vehicles;
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public void askGaraje(){
        super.askArea();
        this.vehicles = null;
    }

}
