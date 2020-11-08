package objects.product;


import service.utility.UserInteractions;

import java.util.Date;

public abstract class Product {
    protected int equipmentId;  //Identificador
    protected String name;   //Nombre
    protected int quantity;  //Cantidad que tenemos
    //TODO: Revisar validez de existencia de variable location, fumarnos otro porro
    protected int location;
    protected String status; //Variable dependiendo de hijo
    protected String buyDate; //Fecha de compra


    public Product(int equipmentId, String name, int quantity, int location, String status, String buyDate) {
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

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(String buyDate) {
        this.buyDate = buyDate;
    }

    public void askProduct() {
        this.equipmentId = 0;
        this.name = UserInteractions.strRequest("Introduzca el nombre del producto");
        this.quantity = UserInteractions.numRequest("Introduzca la cantidad del producto");
        this.status = UserInteractions.strRequest("Introduzca el estado del producto");
        this.buyDate = UserInteractions.dateRequest();
    }

}


