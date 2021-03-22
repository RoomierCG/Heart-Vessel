package objects.area.areas;

import objects.area.Area;
import objects.transportsystem.transportsystems.vehicle.Vehicle;
import objects.transportsystem.transportsystems.vehicle.vehicles.Ambulance;
import org.thymeleaf.util.ArrayUtils;
import service.data_manager.DataFunctions;
import service.utility.OpsID;
import service.utility.UserInteractions;

import javax.xml.crypto.Data;
import java.util.ArrayList;

public class Garaje extends Area {

    private ArrayList<String> vehicles; //Los vehiculos que se ubican dentro del garaje en cuestion

    public Garaje(String idArea, String name, String status, int floor, String risk, ArrayList<String> equipment, ArrayList<String> personal, ArrayList<String> vehicles) {
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


    public ArrayList<String> gatherInfo() {
        return super.gatherInfo();
    }

    public ArrayList<ArrayList<String>> gatherListedInfo() {
        ArrayList<ArrayList<String>> s = super.gatherListedInfo();
        s.add(vehicles);
        return s;
    }

    public void initArea() {
        super.initArea();
        String resp;
        do{
            resp = UserInteractions.strRequest("Introduzca el ID de un vehiculo que desea añadir, o \"exit\" para continuar");
            if(!resp.equals("exit")){
                OpsID.decodeID(resp);
            }
        }while(true);
    }

}
