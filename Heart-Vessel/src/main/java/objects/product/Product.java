package objects.product;

import objects.inventory.Inventory;

import java.util.Date;

public abstract class Product {
    protected int equipmentId;
    protected String name;
    protected int quantity;
    protected Inventory location;
    protected String status;
    protected Date buyDate;


    public Product(int equipmentId, String name, int quantity, Inventory location, String status, Date buyDate) {
        this.equipmentId = equipmentId;
        this.name = name;
        this.quantity = quantity;
        this.location = location;
        this.status = status;
        this.buyDate = buyDate;
    }

    public int getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(int equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Inventory getLocation() {
        return location;
    }

    public void setLocation(Inventory location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }

}


