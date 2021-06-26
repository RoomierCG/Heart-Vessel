package objects.product.products.substance.substances.consumable.consumables;

import objects.product.products.substance.substances.consumable.Consumable;
import objects.provider.Provider;
import service.utility.UserInteractions;

import java.util.ArrayList;

public class FoodMenu extends Consumable {
    /////////////////////////////////////////////////////ATTRIB/////////////////////////////////////////////////////////

    private String provider;

    /////////////////////////////////////////////////////CONSTR/////////////////////////////////////////////////////////


    public FoodMenu(String id, String name, String areaId, String status, String buyDate, int quantity, boolean toxic, ArrayList<String> allergyRiskIngredients, String expirationDate, String provider) {
        super(id, name, areaId, status, buyDate, quantity, toxic, allergyRiskIngredients, expirationDate);
        this.provider = provider;
    }

    public FoodMenu() {

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
        if (atribMod.contains("Proveedor")|| atribMod.contains("*")) {
            System.out.println("Introduzca el ID del proveedor de esta comida");
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
