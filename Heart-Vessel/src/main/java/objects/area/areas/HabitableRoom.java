package objects.area.areas;

import objects.area.Area;
import objects.people.Person;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;

public class HabitableRoom extends Area {

    private int idPatient; //Paciente que habita la habitacion

    public HabitableRoom(int idArea,String name ,ArrayList<Person> personal, String status, int inventory, int floor, int risk, int idPatient) {
        super(idArea, name,personal, status, inventory, floor, risk);
        this.idPatient = idPatient;
    }

    public int getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
    }

    public void askHabitableRoom(){
        super.askArea();
    }

}

