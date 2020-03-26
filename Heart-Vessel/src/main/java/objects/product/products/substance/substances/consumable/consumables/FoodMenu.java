package objects.product.products.substance.substances.consumable.consumables;

import objects.inventory.Inventory;
import objects.product.products.substance.substances.consumable.Consumable;
import objects.provider.Provider;

import java.util.ArrayList;
import java.util.Date;

public class FoodMenu extends Consumable {
    private Date expirationDate;
    private String type;
    private Provider provider;

    public FoodMenu(int equipmentId, String name, int quantity, Inventory location, String status, Date buyDate, boolean toxic, ArrayList<String> allergyRiskIngredients) {
        super(equipmentId, name, quantity, location, status, buyDate, toxic, allergyRiskIngredients);
    }

    public FoodMenu(int equipmentId, String name, int quantity, Inventory location, String status, Date buyDate, boolean toxic, ArrayList<String> allergyRiskIngredients, Date expirationDate, String type, Provider provider) {
        super(equipmentId, name, quantity, location, status, buyDate, toxic, allergyRiskIngredients);
        this.expirationDate = expirationDate;
        this.type = type;
        this.provider = provider;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
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