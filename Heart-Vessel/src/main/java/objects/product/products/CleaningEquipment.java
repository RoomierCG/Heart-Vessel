package objects.product.products;

import objects.product.Product;

import java.util.Date;

public class CleaningEquipment extends Product {
    private int riskFactor; //Grado de riesgo que puede producir, como de arriesgado es vs pacientes con problemas de immunidad etc.
    private String type;   //Liquido, solido, polvo, etc.


    public CleaningEquipment(int equipmentId, String name, int quantity, int location, String status, String buyDate) {
        super(equipmentId, name, quantity, location, status, buyDate);
    }

    public CleaningEquipment(int equipmentId, String name, int quantity, int location, String status, String buyDate, int riskFactor, String type) {
        super(equipmentId, name, quantity, location, status, buyDate);
        this.riskFactor = riskFactor;
        this.type = type;
    }

    public int getRiskFactor() {
        return riskFactor;
    }

    public void setRiskFactor(int riskFactor) {
        this.riskFactor = riskFactor;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
