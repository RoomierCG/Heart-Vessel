package objects.product.products.substance.substances.consumable.consumables;

import objects.product.products.substance.substances.consumable.Consumable;

import java.util.ArrayList;

public class Medicine extends Consumable {
    private String administered; //Via de administracion eg. oral, injeccion etc

    public Medicine(String equipmentId, String name, String areaName, String status, String buyDate, boolean toxic, String type, ArrayList<String> allergyRiskIngredients, String expirationDate, String administered) {
        super(equipmentId, name, areaName, status, buyDate, toxic, type, allergyRiskIngredients, expirationDate);
        this.administered = administered;
    }



    public Medicine() {

    }

    public String getAdministered() {
        return administered;
    }

    public void setAdministered(String administered) {
        this.administered = administered;
    }

}
