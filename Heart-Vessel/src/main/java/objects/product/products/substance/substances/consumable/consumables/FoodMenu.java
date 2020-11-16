package objects.product.products.substance.substances.consumable.consumables;

import objects.product.products.substance.substances.consumable.Consumable;
import objects.provider.Provider;

import java.util.ArrayList;

public class FoodMenu extends Consumable {

    private String provider;

    public FoodMenu(String equipmentId, String name, String areaName, String status, String buyDate, String expirationDates, boolean toxic, String type, String provider, ArrayList<String> allergyRiskIngredients) {
        super(equipmentId, name, areaName, status, buyDate, expirationDates, toxic, type, allergyRiskIngredients);
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
