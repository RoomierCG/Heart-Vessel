package objects.people.person;

import objects.people.Person;

public class Patient extends Person {

    private boolean allowVisitors;
    private String Registry;
    private int roomId;

    public Patient(int personId, String name, String lastName, String status) {
        super(personId, name, lastName, status);
    }

    public Patient(int personId, String name, String lastName, String status, boolean allowVisitors, String registry, int roomId) {
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

    public String getRegistry() {
        return Registry;
    }

    public void setRegistry(String registry) {
        Registry = registry;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }
}
