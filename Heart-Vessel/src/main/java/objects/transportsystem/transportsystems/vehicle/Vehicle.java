package objects.transportsystem.transportsystems.vehicle;

import objects.people.Person;
import objects.transportsystem.Transport;

import java.util.ArrayList;

public abstract class Vehicle extends Transport {

    protected String type;
    protected int gasTank;

    public Vehicle(String transportId, String status, String type, int gasTank) {
        super(transportId, status);
        this.type = type;
        this.gasTank = gasTank;
    }

    public Vehicle() {

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getGasTank() {
        return gasTank;
    }

    public void setGasTank(int gasTank) {
        this.gasTank = gasTank;
    }
}
