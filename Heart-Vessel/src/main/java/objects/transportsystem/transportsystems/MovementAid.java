package objects.transportsystem.transportsystems;


import objects.people.Person;
import objects.transportsystem.Transport;

import java.util.ArrayList;

public class MovementAid extends Transport {
    private String patient;// -1 significa que no esta asignado a un paciente sino que esta en un area y viceversa
    private String idArea;

    public MovementAid(String transportId, String transportName, String status, String patient, String idArea) {
        super(transportId,transportName,status);
        this.patient = patient;
        this.idArea = idArea;
    }

    public ArrayList<String> gatherInfo() {
        return null;
    }

    @Override
    public ArrayList<ArrayList<String>> gatherListedInfo() {
        return null;
    }


    public MovementAid() {
        super();
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public String getIdArea() {
        return idArea;
    }

    public void setIdArea(String idArea) {
        this.idArea = idArea;
    }
}
