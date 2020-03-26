package objects.product.products.substance.substances.consumable;

import objects.inventory.Inventory;
import objects.product.products.substance.Substance;

import java.util.ArrayList;
import java.util.Date;

public abstract class Consumable extends Substance {
    private ArrayList<String> allergyRiskIngredients;

    public Consumable(int equipmentId, String name, int quantity, Inventory location, String status, Date buyDate, boolean toxic, ArrayList<String> allergyRiskIngredients) {
        super(equipmentId, name, quantity, location, status, buyDate, toxic);
        this.allergyRiskIngredients = allergyRiskIngredients;
    }

}
