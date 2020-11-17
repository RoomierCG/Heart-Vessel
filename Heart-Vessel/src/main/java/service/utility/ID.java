package service.utility;

public class ID {
    private int numVal;
    private String type;

    public int getNumVal() {
        return numVal;
    }
    public String getType() {
        return type;
    }

    public ID(int numVal, String type) {
        this.numVal = numVal;
        this.type = type;
    }

    public void increment(){
        this.numVal++;
    }
}
