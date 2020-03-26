package objects.transportsystem.transportsystems;


import objects.people.Person;
import objects.transportsystem.Transport;

public class MovementAid extends Transport {
    private Person patient;

    public MovementAid(int transportId, String status) {
        super(transportId, status);
    }
}
