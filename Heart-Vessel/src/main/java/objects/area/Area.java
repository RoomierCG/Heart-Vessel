package objects.area;

import java.util.ArrayList;

import objects.Generic;
import org.apache.catalina.User;
import service.utility.OpsID;
import service.utility.UserInteractions;
import visualInterfaces.Constants;

public class Area extends Generic {


    public Area() {
    }

    private ArrayList<String> personal; //Personas que estan en ese area
    private String status; //Ocupdo, No Ocupada, Desinfectando etc.
    private ArrayList<String> equipment; //inventario que tiene asignado
    private int floor; //En que planta se ubica
    private String risk; //Como de arriesgado es
    
    

    public Area(String id, String name, String status, int floor, String risk, ArrayList<String> equipment,ArrayList<String> personal) {
        super(id,name);
        this.personal = personal;
        this.status = status;
        this.equipment = equipment;
        this.floor = floor;
        this.risk = risk;
    }


    public ArrayList<String> gatherInfo(){
        return new ArrayList<String>(){{
            add(Area.super.getId());
            add(Area.super.getName());
            add(status);
            add(String.valueOf(floor));
            add(risk);
            }
        };
    }

    public ArrayList<ArrayList<String>> gatherListedInfo(){
        return new ArrayList<ArrayList<String>>(){{
            add(personal);
            add(equipment);
        }
        };
    }

    public ArrayList<String> getEquipment() {
        return equipment;
    }

    public void setEquipment(ArrayList<String> equipment) {
        this.equipment = equipment;
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

    public String getRisk() {
        return risk;
    }

    public void setRisk(String risk) {
        this.risk = risk;
    }

    public void initArea(){
        super.setId(OpsID.generateID("ARR"));
        super.setName(UserInteractions.strRequest("Introduzca el nombre del area"));
        ArrayList<String> atribList = new ArrayList<>();
        int cont = 0;
        //System.out.println("Introduzca \"/exit\" para terminar.");
        do{
            atribList.add(UserInteractions.idRequest("PEE#",true));
            cont++;
        }while(cont<Constants.personellLimit && !(atribList.get(cont).endsWith("-1")));
        this.setPersonal(atribList);
        cont = 0;
        do{
            atribList.add(UserInteractions.idRequest("PR",true));
            cont++;
        }while(cont<Constants.equipmentLimit && !(atribList.get(cont).endsWith("-1")));
        this.setEquipment(atribList);
        this.risk = UserInteractions.pickFrom(Constants.riesgos);

    }




}
