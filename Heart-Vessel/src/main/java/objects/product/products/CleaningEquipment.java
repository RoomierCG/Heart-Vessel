package objects.product.products;

import objects.product.Product;

import java.util.Date;

public class CleaningEquipment extends Product {
    private int riskFactor;
    //TODO: Buscar un atributo que vale

    public CleaningEquipment(String equipmentId, String name, String areaId, String status, String buyDate, int riskFactor) {
        super(equipmentId, name, areaId, status, buyDate);
        this.riskFactor = riskFactor;
    }

    public CleaningEquipment() {

    }

    public int getRiskFactor() {
        return riskFactor;
    }

    public void setRiskFactor(int riskFactor) {
        this.riskFactor = riskFactor;
    }


}
