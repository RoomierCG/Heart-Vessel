package objects.product;


import objects.Generic;
import service.utility.UserInteractions;

public abstract class Product extends Generic {

/////////////////////////////////////////////////////ATTRIB/////////////////////////////////////////////////////////
    protected String areaId;
    protected String status; //Variable dependiendo de hijo
    protected String buyDate; //Fecha de compra


    public Product(String equipmentId, String name, String areaId, String status, String buyDate) {
        super(equipmentId,name);
        this.areaId = areaId;
        this.status = status;
        this.buyDate = buyDate;
    }

    public Product() {

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



}


