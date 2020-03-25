package objects.transit;

import objects.persona.Persona;

import java.util.ArrayList;

public abstract class Vehicle extends Transport{
    protected String type;
    protected ArrayList<Persona> personal;
    protected int gasTank;

}
