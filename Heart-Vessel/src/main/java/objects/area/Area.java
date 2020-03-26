package objects.area;

import objects.people.Person;

import java.util.ArrayList;

public class Area {

    private int idArea;
    private ArrayList<Person> personal;
    private String status;
    private int inventory;
    private int floor;
    private String airFlow;
    private int risk;

    public Area(int idArea, ArrayList<Person> personal, String status, int inventory, int floor, String airFlow, int risk) {
        this.idArea = idArea;
        this.personal = personal;
        this.status = status;
        this.inventory = inventory;
        this.floor = floor;
        this.airFlow = airFlow;
        this.risk = risk;
    }

    public Area() {}

    public int getIdArea() {
        return idArea;
    }

    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }

    public ArrayList<Person> getPersonal() {
        return personal;
    }

    public void setPersonal(ArrayList<Person> personal) {
        this.personal = personal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getAirFlow() {
        return airFlow;
    }

    public void setAirFlow(String airFlow) {
        this.airFlow = airFlow;
    }

    public int getRisk() {
        return risk;
    }

    public void setRisk(int risk) {
        this.risk = risk;
    }

}
