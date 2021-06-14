package objects.transportsystem.transportsystems;


import objects.people.Person;
import objects.transportsystem.Transport;
import service.utility.UserInteractions;
import visualInterfaces.Constants;

import java.util.ArrayList;

public class MovementAid extends Transport {

    /////////////////////////////////////////////////////ATTRIB/////////////////////////////////////////////////////////

    private String patient;// -1 significa que no esta asignado a un paciente sino que esta en un area y viceversa
    private String idArea;

    /////////////////////////////////////////////////////CONSTR/////////////////////////////////////////////////////////

    public MovementAid(String transportId, String transportName, String status, String patient, String idArea) {
        super(transportId,transportName,status);
        this.patient = patient;
        this.idArea = idArea;
    }

    public MovementAid() {
        super();
    }

    /////////////////////////////////////////////////////METHOD/////////////////////////////////////////////////////////

    public ArrayList<String> gatherInfo() {
        ArrayList<String> s = super.gatherInfo();
        s.add(idArea);
        s.add(patient);

        return s;
    }

    public ArrayList<ArrayList<String>> gatherListedInfo() {
        return null;
    }

    public void modifyMe(ArrayList<String> atribMod) {
        if (atribMod.contains("idArea")) {
            this.setIdArea(UserInteractions.idRequest("AR",true));
        }
        if (atribMod.contains("idPaciente")) {
            this.setPatient(UserInteractions.idRequest("PEP",true));
        }
    }

    /////////////////////////////////////////////////////AUTOGEN////////////////////////////////////////////////////////

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
