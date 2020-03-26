package objects.product.products;

import objects.inventory.Inventory;
import objects.product.Product;

import java.util.Date;

public class CleaningEquipment extends Product {
    private int riskFactor;
    private String type;


    public CleaningEquipment(int equipmentId, String name, int quantity, Inventory location, String status, Date buyDate) {
        super(equipmentId, name, quantity, location, status, buyDate);
    }

    public CleaningEquipment(int equipmentId, String name, int quantity, Inventory location, String status, Date buyDate, int riskFactor, String type) {
        super(equipmentId, name, quantity, location, status, buyDate);
        this.riskFactor = riskFactor;
        this.type = type;
    }
}
