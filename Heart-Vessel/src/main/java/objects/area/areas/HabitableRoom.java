package objects.area.areas;

import objects.area.Area;
import objects.people.Person;

import java.util.ArrayList;

public class HabitableRoom extends Area {

    private int idPatient;

    public HabitableRoom(int idArea, ArrayList<Person> personal, String status, int inventory, int floor, String airFlow, int risk, int idPatient) {
        super(idArea, personal, status, inventory, floor, airFlow, risk);
        this.idPatient = idPatient;
    }

    public HabitableRoom(int idPatient) {
        this.idPatient = idPatient;
    }

    public HabitableRoom() {}

    public int getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
    }

}
