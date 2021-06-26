package objects.product;


import objects.Generic;
import objects.area.Area;
import objects.people.Person;
import service.utility.UserInteractions;
import visualInterfaces.Constants;

import java.util.ArrayList;

public abstract class Product extends Generic {

    /////////////////////////////////////////////////////ATTRIB/////////////////////////////////////////////////////////
    protected String areaId;
    protected String status; //Variable dependiendo de hijo
    protected String buyDate; //Fecha de compra
    protected int quantity;

    /////////////////////////////////////////////////////CONSTR/////////////////////////////////////////////////////////


    public Product(String id, String name, String areaId, String status, String buyDate, int quantity) {
        super(id, name);
        this.areaId = areaId;
        this.status = status;
        this.buyDate = buyDate;
        this.quantity = quantity;
    }

    public Product() {

    }

     /////////////////////////////////////////////////////METHOD/////////////////////////////////////////////////////////

    public ArrayList<String> gatherInfo() {
        ArrayList<String> s = super.gatherInfo();
        s.add(String.valueOf(quantity));
        s.add(areaId);
        s.add(status);
        s.add(buyDate);
        return s;
    }

    public ArrayList<ArrayList<String>> gatherListedInfo(){
        ArrayList<ArrayList<String>> s = super.gatherListedInfo();
        return s;
    }

    public void modifyMe(ArrayList<String> atribMod) {
        super.modifyMe(atribMod);
        if (atribMod.contains("idArea")|| atribMod.contains("*")) {
            System.out.println("Introduzca el area donde se almacenan existencias del producto");
            this.setId(UserInteractions.idRequest("ARR", true));
        }
        if (atribMod.contains("Cantidad")|| atribMod.contains("*")) {
            this.setQuantity(UserInteractions.numRequest("Introduzca la nueva cantidad del producto"));
        }
        if (atribMod.contains("Estado")|| atribMod.contains("*")) {
            this.setStatus(UserInteractions.pickFrom(Constants.estadosProducto, "Seleccione una categirio de riesgo nuevo"));
        }
        if (atribMod.contains("FechaDeCompra")|| atribMod.contains("*")) {
            System.out.println("Introduzca la fecha de compra");
            this.setBuyDate(UserInteractions.dateRequest(0));
        }
    }

    /////////////////////////////////////////////////////AUTOGEN////////////////////////////////////////////////////////


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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

