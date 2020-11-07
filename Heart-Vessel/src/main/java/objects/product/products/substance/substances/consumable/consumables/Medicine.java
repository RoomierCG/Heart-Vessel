package objects.product.products.substance.substances.consumable.consumables;

import objects.inventory.Inventory;
import objects.product.products.substance.substances.consumable.Consumable;

import java.util.ArrayList;
import java.util.Date;

public class Medicine extends Consumable {
    private String administered; //Via de administracion eg. oral, injeccion etc

    public Medicine(int equipmentId, String name, int quantity, Inventory location, String status, String buyDate, boolean toxic, ArrayList<String> allergyRiskIngredients, String expirationDate) {
        super(equipmentId, name, quantity, location, status, buyDate, toxic, allergyRiskIngredients, expirationDate);
    }

    public Medicine(int equipmentId, String name, int quantity, Inventory location, String status, String buyDate, boolean toxic, ArrayList<String> allergyRiskIngredients, String expirationDate, String administered) {
        super(equipmentId, name, quantity, location, status, buyDate, toxic, allergyRiskIngredients, expirationDate);
        this.administered = administered;
    }

    public String getAdministered() {
        return administered;
    }

    public void setAdministered(String administered) {
        this.administered = administered;
    }

}
