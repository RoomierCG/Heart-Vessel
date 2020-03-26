package objects.transportsystem.transportsystems.vehicle;

import objects.person.Person;
import objects.transportsystem.Transport;

import java.util.ArrayList;

public abstract class Vehicle extends Transport {
    protected String type;
    protected ArrayList<Person> personal;
    protected int gasTank;

}
