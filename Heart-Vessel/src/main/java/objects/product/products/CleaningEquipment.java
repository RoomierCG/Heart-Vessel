package objects.product.products;

import objects.product.Product;

import java.util.ArrayList;
import java.util.Date;

public class CleaningEquipment extends Product {
    private int riskFactor;

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

    public ArrayList<String> gatherInfo() {
        return null;
    }

    @Override
    public ArrayList<ArrayList<String>> gatherListedInfo() {
        return null;
    }
}
