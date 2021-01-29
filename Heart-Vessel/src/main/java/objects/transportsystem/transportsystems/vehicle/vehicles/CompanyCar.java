package objects.transportsystem.transportsystems.vehicle.vehicles;

import objects.people.Person;
import objects.transportsystem.transportsystems.vehicle.Vehicle;

import java.util.ArrayList;

public class CompanyCar extends Vehicle {

    private String make;
    private String idPersona;//Dueño



    public CompanyCar(String transportId, String transportName, String status, String type,  int gasTank) {
        super(transportId, transportName,status, type, gasTank);
    }

    public CompanyCar(String transportId, String transportName,String status, String type, int gasTank, String make,String idPersona) {
        super(transportId, transportName,status, type, gasTank);
        this.make = make;
        this.idPersona = idPersona;
    }

    @Override
    public String[] gatherInfo() {
        return new String[]{super.getId(),super.getName(),super.getStatus(),super.getType(),make, String.valueOf(super.getGasTank()),idPersona};
    }

    public CompanyCar() {
        super();
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
