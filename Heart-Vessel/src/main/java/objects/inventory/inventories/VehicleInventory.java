package objects.inventory.inventories;

import objects.inventory.Inventory;
import objects.product.Product;
import objects.transportsystem.transportsystems.vehicle.Vehicle;

import java.util.ArrayList;

public class VehicleInventory extends Inventory {

    private Vehicle vehicle;
    private ArrayList<Product> products;

    public VehicleInventory(int idInventory) {
        super(idInventory);
    }

    public VehicleInventory(int idInventory, Vehicle vehicle, ArrayList<Product> products) {
        super(idInventory);
        this.vehicle = vehicle;
        this.products = products;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

}
