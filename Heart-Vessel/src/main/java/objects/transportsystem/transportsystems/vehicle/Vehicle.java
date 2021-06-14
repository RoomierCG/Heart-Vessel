package objects.transportsystem.transportsystems.vehicle;

import objects.people.Person;
import objects.transportsystem.Transport;
import service.utility.UserInteractions;

import java.util.ArrayList;

public abstract class Vehicle extends Transport {

    /////////////////////////////////////////////////////ATTRIB/////////////////////////////////////////////////////////

    protected int gasTank;
    protected String make;
    protected String model;

    /////////////////////////////////////////////////////CONSTR/////////////////////////////////////////////////////////

    public Vehicle(String transportId, String transportName, String status, int gasTank, String make, String model) {
        super(transportId, transportName, status);
        this.gasTank = gasTank;
        this.make = make;
        this.model = model;
    }

    public Vehicle() {
    }

    /////////////////////////////////////////////////////METHOD/////////////////////////////////////////////////////////

    public ArrayList<String> gatherInfo() {
        ArrayList<String> s = super.gatherInfo();
        s.add(Integer.toString(gasTank));
        s.add(make);
        s.add(model);

        return s;
    }

    public ArrayList<ArrayList<String>> gatherListedInfo() {
        return null;
    }

    public void modifyMe(ArrayList<String> atribMod) {
        if (atribMod.contains("Gasolina")) {
            this.setGasTank(UserInteractions.numRequest("Seleccione nivel de gasolina"));
        }
        if (atribMod.contains("Marca")) {
            this.setMake(UserInteractions.strRequest("Seleccione el modelo del vehiculo"));
        }
        if (atribMod.contains("Modelo")) {
            this.setModel(UserInteractions.strRequest("Seleccione la marca del vehiculo"));
        }
    }

    /////////////////////////////////////////////////////AUTOGEN////////////////////////////////////////////////////////

    public int getGasTank() {
        return gasTank;
    }

    public void setGasTank(int gasTank) {
        this.gasTank = gasTank;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
