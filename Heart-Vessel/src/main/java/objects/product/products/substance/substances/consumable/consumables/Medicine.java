package objects.product.products.substance.substances.consumable.consumables;

import objects.inventory.Inventory;
import objects.product.products.substance.Substance;

import java.util.Date;

public class Medicine extends Substance {
    private String administered;

    public Medicine(int equipmentId, String name, int quantity, Inventory location, String status, Date buyDate, boolean toxic) {
        super(equipmentId, name, quantity, location, status, buyDate, toxic);
    }

    public Medicine(int equipmentId, String name, int quantity, Inventory location, String status, Date buyDate, boolean toxic, String administered) {
        super(equipmentId, name, quantity, location, status, buyDate, toxic);
        this.administered = administered;
    }

    public String getAdministered() {
        return administered;
    }

    public void setAdministered(String administered) {
        this.administered = administered;
    }
}
