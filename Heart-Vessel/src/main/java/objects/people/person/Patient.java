package objects.people.person;

import objects.people.Person;

import java.util.ArrayList;

public class Patient extends Person {

    //Status = Enfermo, recuperando, muerto
    private boolean allowVisitors; //Si se permiten visitas
    private ArrayList<String> registry; //Log de paciente
    private String roomId; //Habitacion donde esta habitando el paciente (debe existir dentro de la lista de habitaciones)

    public Patient(String personId, String name, String lastName, String status) {
        super(personId, name, lastName, status);
        this.registry = new ArrayList<>();
    }

    public Patient(String personId, String name, String lastName, String status, boolean allowVisitors, String roomId, ArrayList<String> registry) {
        super(personId, name, lastName, status);
        this.allowVisitors = allowVisitors;
        this.registry = registry;
        this.roomId = roomId;
    }

    public Patient() {

    }

    public boolean isAllowedVisitors() {
        return allowVisitors;
    }

    public void setAllowVisitors(boolean allowVisitors) {
        this.allowVisitors = allowVisitors;
    }

    public ArrayList<String> getRegistry() {
        return registry;
    }

    public void setRegistry(ArrayList<String> registry) {
        this.registry = registry;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public void askAllowVisitors(){}

    @Override
    public String[] gatherInfo() {
        String visit = (isAllowedVisitors()) ? "Si" : "No";
        return new String[]{super.getId(),super.getName(),super.getLastName(),super.getStatus(),visit,roomId, registry.size()+" entradas"};
    }
}
