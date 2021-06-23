package objects.product.products.substance.substances.consumable;


import objects.product.products.substance.Substance;
import service.utility.UserInteractions;
import visualInterfaces.Constants;

import java.util.ArrayList;

public abstract class Consumable extends Substance {
    private ArrayList<String> allergyRiskIngredients;  //Lista de ingredientes que pueden causar allergia
    private String expirationDate;  //Fecha de caducidad


    public Consumable(String equipmentId, String name, String areaId, String status, String buyDate, int quantity,String expirationDate, boolean toxic, String type,ArrayList<String> allergyRiskIngredients) {
        super(equipmentId, name, areaId, status, buyDate, quantity, toxic, type);
        this.allergyRiskIngredients = allergyRiskIngredients;
        this.expirationDate = expirationDate;
    }

    public ArrayList<String> gatherInfo() {
        ArrayList<String> s = super.gatherInfo();
        s.add(expirationDate);
        return s;
    }

    public ArrayList<ArrayList<String>> gatherListedInfo(){
        ArrayList<ArrayList<String>> s = super.gatherListedInfo();
        s.add(allergyRiskIngredients);
        return s;
    }

    public void modifyMe(ArrayList<String> atribMod) {
        super.modifyMe(atribMod);
        if (atribMod.contains("FechaDeCaducidad")) {
            System.out.println("Introduzca la fecha de caducidad");
            this.setExpirationDate(UserInteractions.dateRequest());
        }
        if (atribMod.contains("RiesgosAlergicos")) {
            this.setAllergyRiskIngredients(UserInteractions.formList(this.allergyRiskIngredients));
        }

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
