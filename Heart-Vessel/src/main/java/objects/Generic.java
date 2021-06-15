package objects;

import service.utility.UserInteractions;

import java.util.ArrayList;

public abstract class Generic {
    String id;
    String Name;


    public Generic() {
    }

    public ArrayList<String> gatherInfo() {
        return new ArrayList<String>() {
            {
                add(id);
                add(Name);
            }
        };
    }

    public ArrayList<ArrayList<String>> gatherListedInfo() {
        return null;
    }

    public Generic(String id, String name) {
        this.id = id;
        Name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public void modifyMe(ArrayList<String> atribMod) {
        if (atribMod.contains("Nombre")) {
            this.setName(UserInteractions.strRequest("Introduzca el nuevo nombre"));
        }

    }
}
