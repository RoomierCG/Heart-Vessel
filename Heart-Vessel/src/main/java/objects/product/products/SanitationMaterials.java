package objects.product.products;

import objects.inventory.Inventory;
import objects.product.Product;

import java.util.Date;

public class SanitationMaterials extends Product {
    private String model;
    private String type;

    public SanitationMaterials(int equipmentId, String name, int quantity, Inventory location, String status, Date buyDate) {
        super(equipmentId, name, quantity, location, status, buyDate);
    }

    public SanitationMaterials(int equipmentId, String name, int quantity, Inventory location, String status, Date buyDate, String model, String type) {
        super(equipmentId, name, quantity, location, status, buyDate);
        this.model = model;
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
