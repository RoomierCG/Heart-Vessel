package objects.product.products.substance.substances.consumable.consumables;

import objects.product.products.substance.substances.consumable.Consumable;
import objects.provider.Provider;

import java.util.ArrayList;

public class FoodMenu extends Consumable {

    private String provider;

    public FoodMenu(String equipmentId, String name, String areaName, String status, String buyDate, boolean toxic, String type, String expirationDate, ArrayList<String> allergyRiskIngredients, String provider) {
        super(equipmentId, name, areaName, status, buyDate, toxic, type, expirationDate, allergyRiskIngredients);
        this.provider = provider;
    }

    public FoodMenu() {
        super();
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }
}
