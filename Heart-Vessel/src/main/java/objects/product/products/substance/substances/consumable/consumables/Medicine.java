package objects.product.products.substance.substances.consumable.consumables;

import objects.product.products.substance.substances.consumable.Consumable;

import java.util.ArrayList;

public class Medicine extends Consumable {
    private String administered; //Via de administracion eg. oral, injeccion etc

    public Medicine(String equipmentId, String name, String areaId, String status, String buyDate, String expirationDates, boolean toxic, String type, String administered, ArrayList<String> allergyRiskIngredients) {
        super(equipmentId, name, areaId, status, buyDate, expirationDates, toxic, type, allergyRiskIngredients);
        this.administered = administered;
    }

    public Medicine() {

    }


    public String[] gatherInfo() {
        String toxic = (super.isToxic()) ? "Si" : "No";
        return new String[]{super.getId(),super.getName(),super.getAreaId(),super.getStatus(),super.getBuyDate(),toxic,super.getExpirationDate(),administered,super.getType(),getAllergyRiskIngredients().size()+" alérgenos"};
    }

    public String getAdministered() {
        return administered;
    }

    public void setAdministered(String administered) {
        this.administered = administered;
    }

}
