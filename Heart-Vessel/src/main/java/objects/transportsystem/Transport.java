package objects.transportsystem;

import objects.Generic;
import service.utility.UserInteractions;
import visualInterfaces.Constants;

import java.util.ArrayList;

public abstract class Transport extends Generic {

    /////////////////////////////////////////////////////ATTRIB/////////////////////////////////////////////////////////

    protected String status;

    /////////////////////////////////////////////////////CONSTR/////////////////////////////////////////////////////////

    public Transport(String transportId, String nombre, String status) {
        super(transportId, nombre);
        this.status = status;
    }

    public Transport() {
    }

    /////////////////////////////////////////////////////METHOD/////////////////////////////////////////////////////////

    public ArrayList<String> gatherInfo() {
        ArrayList<String> s = super.gatherInfo();
        s.add(status);

        return s;
    }

    public ArrayList<ArrayList<String>> gatherListedInfo() {
        return new ArrayList<ArrayList<String>>();
    }

    public void modifyMe(ArrayList<String> atribMod) {
        if (atribMod.contains("Estado")|| atribMod.contains("*")) {
            this.setStatus(UserInteractions.pickFrom(Constants.estadosVehiculos, "Seleccione un estado de vehiculo"));
        }
    }

    /////////////////////////////////////////////////////AUTOGEN////////////////////////////////////////////////////////

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
