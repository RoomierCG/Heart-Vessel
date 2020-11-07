package objects.product.products.substance.substances.consumable;

import objects.inventory.Inventory;
import objects.product.products.substance.Substance;

import java.util.ArrayList;
import java.util.Date;

public abstract class Consumable extends Substance {
    private ArrayList<String> allergyRiskIngredients;  //Lista de ingredientes que pueden causar allergia
    private String expirationDate;  //Fecha de caducidad


    public Consumable(int equipmentId, String name, int quantity, Inventory location, String status, String buyDate, boolean toxic, ArrayList<String> allergyRiskIngredients, String expirationDate) {
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

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

}
