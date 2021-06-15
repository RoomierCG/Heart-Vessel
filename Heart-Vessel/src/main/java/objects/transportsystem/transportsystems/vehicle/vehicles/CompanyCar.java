package objects.transportsystem.transportsystems.vehicle.vehicles;

import objects.transportsystem.transportsystems.vehicle.Vehicle;
import service.utility.UserInteractions;

import java.util.ArrayList;

public class CompanyCar extends Vehicle {
    /////////////////////////////////////////////////////ATTRIB/////////////////////////////////////////////////////////

    private String idPersona;//Dueño

    /////////////////////////////////////////////////////CONSTR/////////////////////////////////////////////////////////

    public CompanyCar(String transportId, String transportName, String status, int gasTank, String make, String model, String idPersona) {
        super(transportId, transportName, status, gasTank, make, model);
        this.idPersona = idPersona;
    }

    public CompanyCar(String idPersona) {
        this.idPersona = idPersona;
    }

    public CompanyCar() {
        super();
    }

    /////////////////////////////////////////////////////METHOD/////////////////////////////////////////////////////////

    public ArrayList<String> gatherInfo() {
        ArrayList<String> s = super.gatherInfo();
        s.add(idPersona);

        return s;
    }

    public ArrayList<ArrayList<String>> gatherListedInfo() {
        return super.gatherListedInfo();
    }

    public void modifyMe(ArrayList<String> atribMod) {
        if (atribMod.contains("Dueño")) {
            this.setIdPersona(UserInteractions.idRequest("PEE",true));
        }
    }

    /////////////////////////////////////////////////////AUTOGEN////////////////////////////////////////////////////////

    public String getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }
}
