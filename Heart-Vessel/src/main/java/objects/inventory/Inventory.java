package objects.inventory;

public abstract class Inventory {

    private int idInventory;

    public Inventory(int idInventory) {
        this.idInventory = idInventory;
    }

    public Inventory() {}

    public int getIdInventory() {
        return idInventory;
    }

    public void setIdInventory(int idInventory) {
        this.idInventory = idInventory;
    }

}
