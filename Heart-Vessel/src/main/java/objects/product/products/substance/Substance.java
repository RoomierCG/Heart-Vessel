package objects.product.products.substance;

import objects.inventory.Inventory;
import objects.product.Product;

import java.util.Date;

public abstract class Substance extends Product {
    private boolean toxic; //Si es toxico o no

    public Substance(int equipmentId, String name, int quantity, int location, String status, String buyDate, boolean toxic) {
        super(equipmentId, name, quantity, location, status, buyDate);
        this.toxic = toxic;
    }

    public boolean isToxic() {
        return toxic;
    }

    public void setToxic(boolean toxic) {
        this.toxic = toxic;
    }
}
