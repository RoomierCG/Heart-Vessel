package objects.area.areas;

import objects.area.Area;
import objects.people.Person;
import objects.product.Product;
import objects.transportsystem.transportsystems.vehicle.Vehicle;

import java.util.ArrayList;

public class Garaje extends Area {

    private ArrayList<String> vehicles; //Los vehiculos que se ubican dentro del garaje en cuestion

    public Garaje(String idArea, ArrayList<String> personal, String name, String status, ArrayList<String> equipment, int floor, int risk, ArrayList<String> vehicles) {
        super(idArea, name, personal, status, equipment, floor, risk);
        this.vehicles = vehicles;
    }

    public ArrayList<String> getVehicles() {
        return vehicles;
    }

    public void setVehicles(ArrayList<String> vehicles) {
        this.vehicles = vehicles;
    }

    public void askGaraje(){
        super.askArea();
        this.vehicles = null;
    }

}
