package objects.area;

import objects.people.Person;

import java.util.ArrayList;

import objects.product.Product;
import service.utility.UserInteractions;

public class Area {

    private int idArea; //Identificador
    private String name;
    private ArrayList<Person> personal; //Personas que estan en ese area
    private String status; //Ocupdo, No Ocupada, Desinfectando etc.
    private ArrayList<Product> equipment; //inventario que tiene asignado
    private int floor; //En que planta se ubica
    private int risk; //Como de arriesgado es

    public Area(int idArea, String name, ArrayList<Person> personal, String status, ArrayList<Product> equipment, int floor, int risk) {
        this.idArea = idArea;
        this.name = name;
        this.personal = personal;
        this.status = status;
        this.equipment = equipment;
        this.floor = floor;
        this.risk = risk;
    }

    public Area() {}

    public ArrayList<Product> getEquipment() {
        return equipment;
    }

    public void setEquipment(ArrayList<Product> equipment) {
        this.equipment = equipment;
    }

    public int getIdArea() {
        return idArea;
    }

    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public void askArea(){
        this.idArea = 0;
        this.personal = null;
        this.status = UserInteractions.strRequest("Introduzca el estado");
        this.equipment = null;
        this.floor = 0;
        //TODO Revisar la categoria de riesgos
        this.risk = UserInteractions.numRequest("Introduzca el numero de riesgo adecuado entre 1 y 10",1,10);

    }

}
