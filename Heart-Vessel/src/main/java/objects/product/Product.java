package objects.product;


import service.utility.UserInteractions;

public abstract class Product {

    protected String equipmentId;  //Identificador
    protected String name;   //Nombre
    //TODO: Revisar validez de existencia de variable location, fumarnos otro porro, another one
    protected String areaId;
    protected String status; //Variable dependiendo de hijo
    protected String buyDate; //Fecha de compra


    public Product(String equipmentId, String name, String areaId, String status, String buyDate) {
        this.equipmentId = equipmentId;
        this.name = name;
        this.areaId = areaId;
        this.status = status;
        this.buyDate = buyDate;
    }

    public Product() {

    }


    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
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
        this.name = UserInteractions.strRequest("Introduzca el nombre del producto");
        this.status = UserInteractions.strRequest("Introduzca el estado del producto");
        this.buyDate = UserInteractions.dateRequest();
    }

}


