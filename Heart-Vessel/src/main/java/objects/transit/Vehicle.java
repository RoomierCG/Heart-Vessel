package objects.transit;

import objects.people.Person;

import java.util.ArrayList;

public abstract class Vehicle extends Transport{
    protected String type;
    protected ArrayList<Person> personal;
    protected int gasTank;

}
