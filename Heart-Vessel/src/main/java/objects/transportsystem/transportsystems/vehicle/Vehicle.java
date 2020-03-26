package objects.transportsystem.transportsystems.vehicle;

import objects.people.Person;
import objects.transportsystem.Transport;

import java.util.ArrayList;

public abstract class Vehicle extends Transport {
    protected String type;
    protected ArrayList<Person> personal;
    protected int gasTank;

    public Vehicle(int transportId, String status, String type, ArrayList<Person> personal, int gasTank) {
        super(transportId, status);
        this.type = type;
        this.personal = personal;
        this.gasTank = gasTank;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<Person> getPersonal() {
        return personal;
    }

    public void setPersonal(ArrayList<Person> personal) {
        this.personal = personal;
    }

    public int getGasTank() {
        return gasTank;
    }

    public void setGasTank(int gasTank) {
        this.gasTank = gasTank;
    }
}
