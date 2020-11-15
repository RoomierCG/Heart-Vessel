package objects.product.products;

import objects.product.Product;

import java.util.Date;

public class CleaningEquipment extends Product {
    private int riskFactor; //Grado de riesgo que puede producir, como de arriesgado es vs pacientes con problemas de immunidad etc.
     //Liquido, solido, polvo, etc.


    public CleaningEquipment(String equipmentId, String name, String location, String status, String buyDate) {
        super(equipmentId, name, location, status, buyDate);
    }

    public CleaningEquipment(String equipmentId, String name, String location, String status, String buyDate, int riskFactor) {
        super(equipmentId, name, location, status, buyDate);
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
