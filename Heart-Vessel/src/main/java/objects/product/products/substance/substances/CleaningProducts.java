package objects.product.products.substance.substances;

import objects.product.products.substance.Substance;
import service.utility.UserInteractions;
import visualInterfaces.Constants;

import java.util.ArrayList;


public class CleaningProducts extends Substance {
    /////////////////////////////////////////////////////ATTRIB/////////////////////////////////////////////////////////
    private String make; //Marca del producto
    /////////////////////////////////////////////////////CONSTR/////////////////////////////////////////////////////////

    public CleaningProducts(String equipmentId, String name, String areaId, String status, String buyDate,int quantity, boolean toxic, String type, String make) {
        super(equipmentId, name, areaId, status, buyDate,quantity,  toxic, type);
        this.make = make;
    }

    public CleaningProducts() {


    }

    /////////////////////////////////////////////////////METHOD/////////////////////////////////////////////////////////
    public ArrayList<String> gatherInfo() {
        ArrayList<String> s = super.gatherInfo();
        s.add(make);
        return s;
    }

    public ArrayList<ArrayList<String>> gatherListedInfo(){
        ArrayList<ArrayList<String>> s = super.gatherListedInfo();
        return s;
    }

    public void modifyMe(ArrayList<String> atribMod) {
        super.modifyMe(atribMod);
        if (atribMod.contains("Marca")) {
            this.setId(UserInteractions.strRequest("Introduzca la marca del producto"));
        }
    }
    /////////////////////////////////////////////////////AUTOGEN/////////////////////////////////////////////////////////

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }


}
