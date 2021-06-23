package objects.product.products.substance.substances.consumable.consumables;

import objects.product.products.substance.substances.consumable.Consumable;
import service.utility.UserInteractions;
import visualInterfaces.Constants;

import java.util.ArrayList;

public class Medicine extends Consumable {
    /////////////////////////////////////////////////////ATTRIB/////////////////////////////////////////////////////////
    private String administered; //Via de administracion eg. oral, injeccion etc

    /////////////////////////////////////////////////////CONSTR/////////////////////////////////////////////////////////
    public Medicine(String equipmentId, String name, String areaId, String status, String buyDate,int quantity, String expirationDates, boolean toxic, String type, String administered, ArrayList<String> allergyRiskIngredients) {
        super(equipmentId, name, areaId, status, buyDate,quantity, expirationDates, toxic, type, allergyRiskIngredients);
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
        if (atribMod.contains("ViaDeAdministracion")) {
            this.setAdministered(UserInteractions.pickFrom(Constants.viasDeAdministracion,"Elige la nueva via de administracion"));
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
