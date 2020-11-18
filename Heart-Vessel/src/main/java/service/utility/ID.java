package service.utility;

public class ID {
    private int numVal;
    private String type;
    private String visualType;

    public int getNumVal() {
        return numVal;
    }
    public String getType() {
        return type;
    }

    public ID(int numVal, String type,String visualType) {
        this.numVal = numVal;
        this.type = type;
        this.visualType = visualType;
    }

    public ID(int numVal, String type) {
        this.numVal = numVal;
        this.type = type;
    }

    public String getVisualType() {
        return visualType;
    }

    public void increment(){
        this.numVal++;
    }
}
