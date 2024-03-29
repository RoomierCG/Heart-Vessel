package objects.product.products;

import objects.product.Product;
import service.utility.UserInteractions;

import java.util.ArrayList;

public class SanitationMaterials extends Product {
    /////////////////////////////////////////////////////ATTRIB/////////////////////////////////////////////////////////
    private String model; //Marca/modelo del objeto
    private String use;  //Herramiento, Consumible (eg. escarpelo vs vendas)

/////////////////////////////////////////////////////Construc/////////////////////////////////////////////////////////


    public SanitationMaterials(String id, String name, String areaId, String status, String buyDate, int quantity, String model) {
        super(id, name, areaId, status, buyDate, quantity);
        this.model = model;
    }

    public SanitationMaterials(String model) {
        this.model = model;
    }

    public SanitationMaterials() {

    }
    /////////////////////////////////////////////////////METHOD/////////////////////////////////////////////////////////
    public ArrayList<String> gatherInfo() {
        ArrayList<String> s = super.gatherInfo();
        s.add(model);
        s.add(use);
        return s;
    }

    public ArrayList<ArrayList<String>> gatherListedInfo(){
        ArrayList<ArrayList<String>> s = super.gatherListedInfo();
        return s;
    }

    public void modifyMe(ArrayList<String> atribMod) {
        super.modifyMe(atribMod);
        if (atribMod.contains("MarcaModelo")|| atribMod.contains("*")) {
            this.setModel(UserInteractions.strRequest("Introduzca el modelo"));
        }
        if (atribMod.contains("Uso")|| atribMod.contains("*")) {
            this.setModel(UserInteractions.strRequest("Introduzca el uso"));
        }
    }
    /////////////////////////////////////////////////////AUTOGEN////////////////////////////////////////////////////////

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getUse() {
        return use;
    }

    public void setUse(String use) {
        this.use = use;
    }

}
