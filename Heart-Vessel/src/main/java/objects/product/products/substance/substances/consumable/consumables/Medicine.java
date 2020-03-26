package objects.product.products.substance.substances.consumable.consumables;

import objects.inventory.Inventory;
import objects.product.products.substance.substances.consumable.Consumable;

import java.util.ArrayList;
import java.util.Date;

public class Medicine extends Consumable {
    private String administered;

    public Medicine(int equipmentId, String name, int quantity, Inventory location, String status, Date buyDate, boolean toxic, ArrayList<String> allergyRiskIngredients, Date expirationDate) {
        super(equipmentId, name, quantity, location, status, buyDate, toxic, allergyRiskIngredients, expirationDate);
    }

    public Medicine(int equipmentId, String name, int quantity, Inventory location, String status, Date buyDate, boolean toxic, ArrayList<String> allergyRiskIngredients, Date expirationDate, String administered) {
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
