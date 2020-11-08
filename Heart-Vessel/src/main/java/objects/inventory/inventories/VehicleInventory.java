package objects.inventory.inventories;

import objects.inventory.Inventory;
import objects.product.Product;
import objects.transportsystem.transportsystems.vehicle.Vehicle;

import java.util.ArrayList;

public class VehicleInventory extends Inventory {

    private int vehicle;  //Vehiculo en cuestion
    private ArrayList<Product> products;  //Lista de objetos que tiene en su "inventario"

    public VehicleInventory(int idInventory) {
        super(idInventory);
    }

    public VehicleInventory(int idInventory, int vehicle, ArrayList<Product> products) {
        super(idInventory);
        this.vehicle = vehicle;
        this.products = products;
    }

    public int getVehicle() {
        return vehicle;
    }

    public void setVehicle(int vehicle) {
        this.vehicle = vehicle;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

}
