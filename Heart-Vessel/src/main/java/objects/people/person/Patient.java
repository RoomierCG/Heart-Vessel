package objects.people.person;

import objects.people.Person;

import java.util.ArrayList;

public class Patient extends Person {

    //Status = Enfermo, recuperando, muerto
    private boolean allowVisitors; //Si se permiten visitas
    private ArrayList<String> Registry; //Log de paciente
    private int roomId; //Habitacion donde esta habitando el paciente (debe existir dentro de la lista de habitaciones)

    public Patient(int personId, String name, String lastName, String status) {
        super(personId, name, lastName, status);
        roomId = -1;//Negativo significa que no tiene habitacion
    }

    public Patient(int personId, String name, String lastName, String status, boolean allowVisitors, ArrayList<String> registry, int roomId) {
        super(personId, name, lastName, status);
        this.allowVisitors = allowVisitors;
        Registry = registry;
        this.roomId = roomId;
    }

    public boolean isAllowVisitors() {
        return allowVisitors;
    }

    public void setAllowVisitors(boolean allowVisitors) {
        this.allowVisitors = allowVisitors;
    }

    public ArrayList<String> getRegistry() {
        return Registry;
    }

    public void setRegistry(ArrayList<String> registry) {
        Registry = registry;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public void askAllowVisitors(){}

}
