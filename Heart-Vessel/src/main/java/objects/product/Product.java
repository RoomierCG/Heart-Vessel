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

    /////////////////////////////////////////////////////CONSTR/////////////////////////////////////////////////////////

    public Product(String equipmentId, String name, String areaId, String status, String buyDate) {
        super(equipmentId,name);
        this.areaId = areaId;
        this.status = status;
        this.buyDate = buyDate;
    }


    public Product() {

    }

    /////////////////////////////////////////////////////METHOD/////////////////////////////////////////////////////////

    public ArrayList<String> gatherInfo() {
        ArrayList<String> s = super.gatherInfo();
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
        if (atribMod.contains("idArea")) {
            this.setId(UserInteractions.idRequest("AR", true));
        }
        if (atribMod.contains("Estado")) {
            this.setStatus(UserInteractions.pickFrom(Constants.estadosProducto, "Seleccione una categirio de riesgo nuevo"));
        }
        if (atribMod.contains("FechaDeCompra")) {
            this.setBuyDate(UserInteractions.dateRequest());
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



}

