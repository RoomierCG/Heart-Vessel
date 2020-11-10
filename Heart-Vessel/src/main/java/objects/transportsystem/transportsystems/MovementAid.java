package objects.transportsystem.transportsystems;


import objects.people.Person;
import objects.transportsystem.Transport;

public class MovementAid extends Transport {
    private int patient;

    public MovementAid(int transportId, String status, int patient) {
        super(transportId, status);
        this.patient = patient;
    }

    public int getPatient() {
        return patient;
    }

    public void setPatient(int patient) {
        this.patient = patient;
    }
}
