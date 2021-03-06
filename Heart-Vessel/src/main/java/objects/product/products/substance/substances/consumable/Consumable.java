package objects.product.products.substance.substances.consumable;


import objects.product.products.substance.Substance;

import java.util.ArrayList;

public abstract class Consumable extends Substance {
    private ArrayList<String> allergyRiskIngredients;  //Lista de ingredientes que pueden causar allergia
    private String expirationDate;  //Fecha de caducidad


    public Consumable(String equipmentId, String name, String areaId, String status, String buyDate, String expirationDate, boolean toxic, String type,ArrayList<String> allergyRiskIngredients) {
        super(equipmentId, name, areaId, status, buyDate, toxic, type);
        this.allergyRiskIngredients = allergyRiskIngredients;
        this.expirationDate = expirationDate;
    }



    public Consumable() {
        super();
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
