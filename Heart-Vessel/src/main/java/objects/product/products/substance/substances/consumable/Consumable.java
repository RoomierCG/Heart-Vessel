package objects.product.products.substance.substances.consumable;

import objects.inventory.Inventory;
import objects.product.products.substance.Substance;

import java.util.ArrayList;
import java.util.Date;

public abstract class Consumable extends Substance {
    private ArrayList<String> allergyRiskIngredients;
    private Date expirationDate;


    public Consumable(int equipmentId, String name, int quantity, Inventory location, String status, Date buyDate, boolean toxic, ArrayList<String> allergyRiskIngredients, Date expirationDate) {
        super(equipmentId, name, quantity, location, status, buyDate, toxic);
        this.allergyRiskIngredients = allergyRiskIngredients;
        this.expirationDate = expirationDate;
    }

    public ArrayList<String> getAllergyRiskIngredients() {
        return allergyRiskIngredients;
    }

    public void setAllergyRiskIngredients(ArrayList<String> allergyRiskIngredients) {
        this.allergyRiskIngredients = allergyRiskIngredients;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

}
