package objects.area;

import objects.people.Person;

import java.util.ArrayList;

import objects.product.Product;
import service.utility.OpsID;
import service.utility.UserInteractions;
import visualInterfaces.Constants;

public class Area {

    private String idArea; //Identificador
    private String name;
    private ArrayList<String> personal; //Personas que estan en ese area
    private String status; //Ocupdo, No Ocupada, Desinfectando etc.
    private ArrayList<String> equipment; //inventario que tiene asignado
    private int floor; //En que planta se ubica
    private int risk; //Como de arriesgado es

    public Area(String idArea, String name, String status, int floor, int risk, ArrayList<String> equipment,ArrayList<String> personal) {
        this.idArea = idArea;
        this.name = name;
        this.personal = personal;
        this.status = status;
        this.equipment = equipment;
        this.floor = floor;
        this.risk = risk;
    }
    public String[][] getAll(){
        return new String[][]{{idArea},{name},{status},{null},{null}, {String.valueOf(floor)}, {String.valueOf(risk)}};
    }
    public Area() {}

    public ArrayList<String> getEquipment() {
        return equipment;
    }

    public void setEquipment(ArrayList<String> equipment) {
        this.equipment = equipment;
    }

    public String getIdArea() {
        return idArea;
    }

    public void setIdArea(String idArea) {
        this.idArea = idArea;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getPersonal() {
        return personal;
    }

    public void setPersonal(ArrayList<String> personal) {
        this.personal = personal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getRisk() {
        return risk;
    }

    public void setRisk(int risk) {
        this.risk = risk;
    }

    public static Area askArea(){
        Area newArea = new Area();
        newArea.setIdArea(OpsID.generateID("ARR"));
        newArea.setName(UserInteractions.strRequest("Introduzca el nombre del area"));
        ArrayList<String> personalNuevo = new ArrayList<>();

        return null;
    }



    public static void main(String[] args) {
        askArea();
    }

}
