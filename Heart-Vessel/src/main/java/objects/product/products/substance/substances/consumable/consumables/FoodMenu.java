package objects.product.products.substance.substances.consumable.consumables;

import objects.inventory.Inventory;
import objects.product.products.substance.substances.consumable.Consumable;
import objects.provider.Provider;

import java.util.ArrayList;
import java.util.Date;

public class FoodMenu extends Consumable {
    private String type;  //
    private Provider provider;

    public FoodMenu(int equipmentId, String name, int quantity, int location, String status, String buyDate, boolean toxic, ArrayList<String> allergyRiskIngredients, String expirationDate) {
        super(equipmentId, name, quantity, location, status, buyDate, toxic, allergyRiskIngredients, expirationDate);
    }

    public FoodMenu(int equipmentId, String name, int quantity, int location, String status, String buyDate, boolean toxic, ArrayList<String> allergyRiskIngredients, String expirationDate, String type, Provider provider) {
        super(equipmentId, name, quantity, location, status, buyDate, toxic, allergyRiskIngredients, expirationDate);
        this.type = type;
        this.provider = provider;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }
}
