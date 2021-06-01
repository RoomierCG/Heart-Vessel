package objects.area.areas;

import objects.area.Area;
import java.util.ArrayList;

public class HabitableRoom extends Area {

    /////////////////////////////////////////////////////ATTRIB/////////////////////////////////////////////////////////
    private String idPatient; //Paciente que habita la habitacion

    /////////////////////////////////////////////////////CONSTR/////////////////////////////////////////////////////////
    public HabitableRoom(String idArea, String name, String status, int floor, String risk, String idPatient, ArrayList<String> equipment, ArrayList<String> personal) {
        super(idArea, name, status, floor, risk, equipment, personal);
        this.idPatient = idPatient;
    }

    public HabitableRoom() {

    }


    /////////////////////////////////////////////////////METHOD/////////////////////////////////////////////////////////
    public ArrayList<String> gatherInfo() {
        ArrayList<String> s = super.gatherInfo();
        s.add(idPatient);
        return s;
    }

    public ArrayList<ArrayList<String>> gatherListedInfo() {
        return super.gatherListedInfo();
    }


    /////////////////////////////////////////////////////ATTRIB/////////////////////////////////////////////////////////
    public String getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(String idPatient) {
        this.idPatient = idPatient;
    }
}

