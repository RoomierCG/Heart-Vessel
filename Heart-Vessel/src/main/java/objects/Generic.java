package objects;

public abstract class Generic {
    String id;
    String Name;


    public Generic() {
    }

    public abstract String[] gatherInfo();

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
