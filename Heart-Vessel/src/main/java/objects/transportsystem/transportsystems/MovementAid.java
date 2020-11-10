package objects.transportsystem.transportsystems;


import objects.people.Person;
import objects.transportsystem.Transport;

public class MovementAid extends Transport {
    private int patient;// -1 significa que no esta asignado a un paciente sino que esta en un area y viceversa
    private int idArea;

    public MovementAid(int transportId, String status, int patient, int idArea) {
        super(transportId, status);
        this.patient = patient;
        this.idArea = idArea;
    }

    public int getPatient() {
        return patient;
    }

    public void setPatient(int patient) {
        this.patient = patient;
    }

    public int getIdArea() {
        return idArea;
    }

    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }
}
