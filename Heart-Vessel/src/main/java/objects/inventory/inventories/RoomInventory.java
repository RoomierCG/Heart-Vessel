package objects.inventory.inventories;

import objects.area.Area;
import objects.inventory.Inventory;
import objects.product.Product;

import java.util.ArrayList;

public class RoomInventory extends Inventory {

    private Area area;  //Area donde se ubica el inventario
    private ArrayList<Product> products;  //Lista de objetos en dicho inventario

    public RoomInventory(int idInventory) {
        super(idInventory);
    }

    public RoomInventory(int idInventory, Area area, ArrayList<Product> products) {
        super(idInventory);
        this.area = area;
        this.products = products;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

}
