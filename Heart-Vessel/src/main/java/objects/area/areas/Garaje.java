package objects.area.areas;

import objects.area.Area;

import java.util.ArrayList;

public class Garaje extends Area {

    private ArrayList<String> vehicles; //Los vehiculos que se ubican dentro del garaje en cuestion

    public Garaje(String idArea, String name, String status, int floor, int risk, ArrayList<String> equipment, ArrayList<String> personal, ArrayList<String> vehicles) {
        super(idArea, name, status, floor, risk, equipment, personal);
        this.vehicles = vehicles;
    }



    public Garaje() {

    }

    public ArrayList<String> getVehicles() {
        return vehicles;
    }

    public void setVehicles(ArrayList<String> vehicles) {
        this.vehicles = vehicles;
    }



    public void initArea() {
        super.initArea();

    }

}
