package objects.product.products.substance.substances.consumable.consumables;

import objects.product.products.substance.substances.consumable.Consumable;
import service.utility.UserInteractions;
import visualInterfaces.Constants;

import java.util.ArrayList;

public class Medicine extends Consumable {
    /////////////////////////////////////////////////////ATTRIB/////////////////////////////////////////////////////////
    private String administered; //Via de administracion eg. oral, injeccion etc

    /////////////////////////////////////////////////////CONSTR/////////////////////////////////////////////////////////


    public Medicine(String id, String name, String areaId, String status, String buyDate, int quantity, boolean toxic, ArrayList<String> allergyRiskIngredients, String expirationDate, String administered) {
        super(id, name, areaId, status, buyDate, quantity, toxic, allergyRiskIngredients, expirationDate);
        this.administered = administered;
    }

    public Medicine() {

    }


    /////////////////////////////////////////////////////METHOD/////////////////////////////////////////////////////////
    public ArrayList<String> gatherInfo() {
        ArrayList<String> s = super.gatherInfo();
        s.add(administered);
        return s;
    }

    public ArrayList<ArrayList<String>> gatherListedInfo(){
        ArrayList<ArrayList<String>> s = super.gatherListedInfo();
        return s;
    }

    public void modifyMe(ArrayList<String> atribMod) {
        super.modifyMe(atribMod);
        if (atribMod.contains("ViaDeAdministracion")|| atribMod.contains("*")) {
            this.setAdministered(UserInteractions.pickFrom(Constants.viasDeAdministracion,"Elige la via de administracion"));
        }

    }
    /////////////////////////////////////////////////////AUTOGEN////////////////////////////////////////////////////////

    public String getAdministered() {
        return administered;
    }
    public void setAdministered(String administered) {
        this.administered = administered;
    }

}
