package objects.area;

import java.util.ArrayList;

import objects.Generic;
import service.utility.OpsID;
import service.utility.UserInteractions;
import visualInterfaces.Constants;

public class Area extends Generic {


    public Area() {
    }


    /////////////////////////////////////////////////////ATTRIB/////////////////////////////////////////////////////////
    private ArrayList<String> staff; //Personas que estan en ese area
    private String status; //Ocupdo, No Ocupada, Desinfectando etc.
    private ArrayList<String> equipment; //inventario que tiene asignado
    private int floor; //En que planta se ubica
    private String risk; //Como de arriesgado es


    /////////////////////////////////////////////////////CONSTR/////////////////////////////////////////////////////////
    public Area(String id, String name, String status, int floor, String risk, ArrayList<String> equipment,ArrayList<String> staff) {
        super(id,name);
        this.staff = staff;
        this.status = status;
        this.equipment = equipment;
        this.floor = floor;
        if(!Constants.riesgos.contains(risk)){
            throw new IllegalArgumentException("Riesgo no valido");
        }
        this.risk = risk;
    }

    /////////////////////////////////////////////////////METHOD/////////////////////////////////////////////////////////


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
            add(staff);
            add(equipment);
        }
        };
    }

    public void modifyMe(ArrayList<String> atribMod) {
        super.modifyMe(atribMod);
        if(atribMod.contains("Estado")){
            this.setStatus(UserInteractions.strRequest("Introduzca el estado"));
        }
        if(atribMod.contains("Planta")){
            this.setFloor(Integer.parseInt(UserInteractions.strRequest("Introduzca la planta")));
        }
        if(atribMod.contains("Riesgo")){
            this.setRisk(UserInteractions.pickFrom(Constants.riesgos,"Seleccione una categirio de riesgo nuevo"));
        }
        if(atribMod.contains("Staff")){
            this.setStaff(UserInteractions.formIDList(this.staff,"PEE"));
        }
        if(atribMod.contains("Equipamiento")){
            this.setStaff(UserInteractions.formIDList(this.equipment,"PR"));
        }

    }

    /*public void initArea(){
        super.setId(OpsID.generateID("ARR"));
        super.setName(UserInteractions.strRequest("Introduzca el nombre del area"));
        ArrayList<String> atribList = new ArrayList<>();
        int cont = 0;
        //System.out.println("Introduzca \"/exit\" para terminar.");
        do{
            atribList.add(UserInteractions.idRequest("PEE#",true));
            cont++;
        }while(cont<Constants.personellLimit && !(atribList.get(cont).endsWith("-1")));
        this.setStaff(atribList);
        cont = 0;
        do{
            atribList.add(UserInteractions.idRequest("PR",true));
            cont++;
        }while(cont<Constants.equipmentLimit && !(atribList.get(cont).endsWith("-1")));
        this.setEquipment(atribList);
        this.risk = UserInteractions.pickFrom(Constants.riesgos,null);

    }*/


    /////////////////////////////////////////////////////AUTOGEN////////////////////////////////////////////////////////

    public ArrayList<String> getEquipment() {
        return equipment;
    }

    public void setEquipment(ArrayList<String> equipment) {
        this.equipment = equipment;
    }

    public ArrayList<String> getStaff() {
        return staff;
    }

    public void setStaff(ArrayList<String> staff) {
        this.staff = staff;
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






}
