package objects.product.products.substance;

import objects.product.Product;
import service.utility.UserInteractions;
import visualInterfaces.Constants;

import java.util.ArrayList;


public abstract class Substance extends Product {
    /////////////////////////////////////////////////////ATTRIB/////////////////////////////////////////////////////////
    private boolean toxic; //Si es toxico o no
    private String type; //Solido.Liquido,Polvo etc

    /////////////////////////////////////////////////////CONSTR/////////////////////////////////////////////////////////
    public Substance() {
    }

    public Substance(String id, String name, String areaId, String status, String buyDate, int quantity, boolean toxic) {
        super(id, name, areaId, status, buyDate, quantity);
        this.toxic = toxic;
    }



    public Substance(boolean toxic, String type) {
        this.toxic = toxic;
        this.type = type;
    }

    /////////////////////////////////////////////////////METHOD/////////////////////////////////////////////////////////
    public ArrayList<String> gatherInfo() {
        ArrayList<String> s = super.gatherInfo();
        s.add(String.valueOf(this.isToxic()));
        s.add(type);
        return s;
    }

    public ArrayList<ArrayList<String>> gatherListedInfo(){
        ArrayList<ArrayList<String>> s = super.gatherListedInfo();
        return s;
    }

    public void modifyMe(ArrayList<String> atribMod) {
        super.modifyMe(atribMod);
        if (atribMod.contains("Toxico")|| atribMod.contains("*")) {
            this.setToxic(UserInteractions.boolRequest("El producto es toxico?"));
        }
        if (atribMod.contains("Tipo")|| atribMod.contains("*")) {
            this.setStatus(UserInteractions.pickFrom(Constants.tipoSustancia, "Seleccione una categiria de riesgo"));
        }

    }
    /////////////////////////////////////////////////////AUTOGEN////////////////////////////////////////////////////////

    public boolean isToxic() {
        return toxic;
    }

    public void setToxic(boolean toxic) {
        this.toxic = toxic;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
