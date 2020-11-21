package objects.area.areas;

import objects.area.Area;
import objects.people.Person;
import objects.product.Product;
import objects.transportsystem.transportsystems.vehicle.Vehicle;
import service.data_manager.DataFunctions;

import java.util.ArrayList;

public class Garaje extends Area {

    private ArrayList<String> vehicles; //Los vehiculos que se ubican dentro del garaje en cuestion

    public Garaje(String idArea, String name, String status, int floor, int risk, ArrayList<String> equipment, ArrayList<String> personal, ArrayList<String> vehicles) {
        super(idArea, name, status, floor, risk, equipment, personal);
        this.vehicles = vehicles;
    }

    @Override
    public String[][] getAll() {
        String[][] arr = super.getAll();
        String[][] gar = new String[][]{{null}};
        return DataFunctions.append(arr,gar);
    }

    public Garaje() {

    }

    public ArrayList<String> getVehicles() {
        return vehicles;
    }

    public void setVehicles(ArrayList<String> vehicles) {
        this.vehicles = vehicles;
    }

    public void askGaraje(){
        //super.askArea();
        this.vehicles = null;
    }

}
