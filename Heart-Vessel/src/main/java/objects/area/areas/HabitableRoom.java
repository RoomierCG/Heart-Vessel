package objects.area.areas;

import objects.area.Area;
import java.util.ArrayList;

public class HabitableRoom extends Area {

    private String idPatient; //Paciente que habita la habitacion

    public HabitableRoom(String idArea, String name , ArrayList<String> personal, String status, ArrayList<String> equipment, int floor, int risk, String idPatient) {
        super(idArea, name,personal, status, equipment, floor, risk);
        this.idPatient = idPatient;
    }

    public HabitableRoom(Area a){
        super(a.getIdArea(),a.getName(),a.getPersonal(),a.getStatus(),a.getEquipment(),a.getFloor(),a.getRisk());
    }

    public HabitableRoom() {

    }

    public String getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(String idPatient) {
        this.idPatient = idPatient;
    }

    public void askHabitableRoom(){
        super.askArea();
    }

}

