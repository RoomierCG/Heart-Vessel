package objects.product.products.substance.substances.consumable.consumables;

import objects.product.products.substance.substances.consumable.Consumable;
import objects.provider.Provider;
import service.utility.UserInteractions;

import java.util.ArrayList;

public class FoodMenu extends Consumable {
    /////////////////////////////////////////////////////ATTRIB/////////////////////////////////////////////////////////

    private String provider;

    /////////////////////////////////////////////////////CONSTR/////////////////////////////////////////////////////////
    public FoodMenu(String equipmentId, String name, String areaId, String status, String buyDate, int quantity,String expirationDates, boolean toxic, String type, String provider, ArrayList<String> allergyRiskIngredients) {
        super(equipmentId, name, areaId, status, buyDate,quantity,expirationDates, toxic, type, allergyRiskIngredients);
        this.provider = provider;
    }

    /////////////////////////////////////////////////////METHOD/////////////////////////////////////////////////////////
    public ArrayList<String> gatherInfo() {
        ArrayList<String> s = super.gatherInfo();
        s.add(provider);
        return s;
    }

    public ArrayList<ArrayList<String>> gatherListedInfo(){
        ArrayList<ArrayList<String>> s = super.gatherListedInfo();
        return s;
    }

    public void modifyMe(ArrayList<String> atribMod) {
        super.modifyMe(atribMod);
        if (atribMod.contains("Proveedor")) {
            this.setProvider(UserInteractions.idRequest("PVP", true));
        }


    }
    /////////////////////////////////////////////////////AUTOGEN/////////////////////////////////////////////////////////

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }
}
