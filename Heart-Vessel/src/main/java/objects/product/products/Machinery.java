package objects.product.products;

import objects.inventory.Inventory;
import objects.product.Product;

import java.util.Date;

public class Machinery extends Product {
    private int electricityConsumption;
    private String model;




    public Machinery(int equipmentId, String name, int quantity, Inventory location, String status, Date buyDate) {
        super(equipmentId, name, quantity, location, status, buyDate);
    }

    public Machinery(int equipmentId, String name, int quantity, Inventory location, String status, Date buyDate, int electricityConsumption, String model) {
        super(equipmentId, name, quantity, location, status, buyDate);
        this.electricityConsumption = electricityConsumption;
        this.model = model;
    }

    public int getElectricityConsumption() {
        return electricityConsumption;
    }

    public void setElectricityConsumption(int electricityConsumption) {
        this.electricityConsumption = electricityConsumption;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}