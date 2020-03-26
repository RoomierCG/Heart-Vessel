package objects.product.products.substance.substances;

import objects.inventory.Inventory;
import objects.product.Product;

import java.util.Date;

public class CleaningProducts extends Product {
    private String make;


    public CleaningProducts(int equipmentId, String name, int quantity, Inventory location, String status, Date buyDate) {
        super(equipmentId, name, quantity, location, status, buyDate);
    }

    public CleaningProducts(int equipmentId, String name, int quantity, Inventory location, String status, Date buyDate, String make) {
        super(equipmentId, name, quantity, location, status, buyDate);
        this.make = make;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }
}
