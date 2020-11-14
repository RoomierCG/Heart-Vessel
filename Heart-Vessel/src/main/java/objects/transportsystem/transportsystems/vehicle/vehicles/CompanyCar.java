package objects.transportsystem.transportsystems.vehicle.vehicles;

import objects.people.Person;
import objects.transportsystem.transportsystems.vehicle.Vehicle;

import java.util.ArrayList;

public class CompanyCar extends Vehicle {

    private String model;
    private String make;
    private String idPersona;//Dueño

    public CompanyCar(String transportId, String status, String type,  int gasTank) {
        super(transportId, status, type, gasTank);
    }

    public CompanyCar(String transportId, String status, String type, int gasTank, String model, String make,String idPersona) {
        super(transportId, status, type, gasTank);
        this.model = model;
        this.make = make;
        this.idPersona = idPersona;
    }

    public CompanyCar() {
        super();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }
}
