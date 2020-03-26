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
}


