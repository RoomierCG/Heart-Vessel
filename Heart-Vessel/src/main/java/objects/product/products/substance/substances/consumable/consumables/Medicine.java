package objects.product.products.substance.substances.consumable.consumables;

import objects.product.products.substance.substances.consumable.Consumable;

import java.util.ArrayList;

public class Medicine extends Consumable {
    private String administered; //Via de administracion eg. oral, injeccion etc

    public Medicine(String equipmentId, String name, String areaId, String status, String buyDate, String expirationDates, boolean toxic, String type, String administered, ArrayList<String> allergyRiskIngredients) {
        super(equipmentId, name, areaId, status, buyDate, expirationDates, toxic, type, allergyRiskIngredients);
        this.administered = administered;
    }

    public Medicine() {

    }


    public ArrayList<String> gatherInfo() {
        return null;
    }

    @Override
    public ArrayList<ArrayList<String>> gatherListedInfo() {
        return null;
    }

    public String getAdministered() {
        return administered;
    }

    public void setAdministered(String administered) {
        this.administered = administered;
    }

}
