package objects.area.areas;

import objects.area.Area;
import objects.transportsystem.transportsystems.vehicle.Vehicle;
import objects.transportsystem.transportsystems.vehicle.vehicles.Ambulance;
import org.thymeleaf.util.ArrayUtils;
import service.data_manager.DataFunctions;
import service.utility.OpsID;
import service.utility.UserInteractions;
import visualInterfaces.Constants;

import javax.xml.crypto.Data;
import java.util.ArrayList;

public class Garaje extends Area {
    /////////////////////////////////////////////////////ATTRIB/////////////////////////////////////////////////////////
    private ArrayList<String> vehicles; //Los vehiculos que se ubican dentro del garaje en cuestion

    /////////////////////////////////////////////////////CONSTR/////////////////////////////////////////////////////////
    public Garaje(String idArea, String name, String status, int floor, String risk, ArrayList<String> equipment, ArrayList<String> personal, ArrayList<String> vehicles) {
        super(idArea, name, status, floor, risk, equipment, personal);
        this.vehicles = vehicles;
    }
    /////////////////////////////////////////////////////METHOD/////////////////////////////////////////////////////////
    public ArrayList<String> gatherInfo() {
        return super.gatherInfo();
    }

    public ArrayList<ArrayList<String>> gatherListedInfo() {
        ArrayList<ArrayList<String>> s = super.gatherListedInfo();
        s.add(vehicles);
        return s;
    }

    public void modifyMe(ArrayList<String> atribMod) {
        super.modifyMe(atribMod);
        if(atribMod.contains("Vehiculos")){
            this.setVehicles(UserInteractions.formIDList(this.vehicles,"TR"));
        }

    }

    /////////////////////////////////////////////////////AUTOGEN////////////////////////////////////////////////////////
    public ArrayList<String> getVehicles() {
        return vehicles;
    }

    public void setVehicles(ArrayList<String> vehicles) {
        this.vehicles = vehicles;
    }



}
