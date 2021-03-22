package objects;

import java.util.ArrayList;

public abstract class Generic {
    String id;
    String Name;


    public Generic() {
    }

    public abstract ArrayList<String> gatherInfo();
    public abstract ArrayList<ArrayList<String>> gatherListedInfo();

    public  Generic(String id, String name) {
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
}
