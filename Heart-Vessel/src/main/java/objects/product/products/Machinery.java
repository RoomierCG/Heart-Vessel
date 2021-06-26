package objects.product.products;

import objects.product.Product;
import service.utility.UserInteractions;

import java.util.ArrayList;


public class Machinery extends Product {

    /////////////////////////////////////////////////////ATRIB//////////////////////////////////////////////////////////
    private int electricityConsumption; //Cuanta electricidad consume
    private String model; //Marca o modelo de la maquina


    /////////////////////////////////////////////////////Constr/////////////////////////////////////////////////////////


    public Machinery(String id, String name, String areaId, String status, String buyDate, int quantity, int electricityConsumption, String model) {
        super(id, name, areaId, status, buyDate, quantity);
        this.electricityConsumption = electricityConsumption;
        this.model = model;
    }

    public Machinery(int electricityConsumption, String model) {
        this.electricityConsumption = electricityConsumption;
        this.model = model;
    }

    public Machinery() {

    }

    /////////////////////////////////////////////////////METHOD/////////////////////////////////////////////////////////
    public ArrayList<String> gatherInfo() {
        ArrayList<String> s = super.gatherInfo();
        s.add(String.valueOf(this.electricityConsumption));
        s.add(model);
        return s;
    }

    public ArrayList<ArrayList<String>> gatherListedInfo(){
        ArrayList<ArrayList<String>> s = super.gatherListedInfo();
        return s;
    }

    public void modifyMe(ArrayList<String> atribMod) {
        super.modifyMe(atribMod);
        if (atribMod.contains("ConsumoElectrico")|| atribMod.contains("*")) {
            this.setElectricityConsumption(UserInteractions.numRequest("Introduzca el nivel de consumo"));
        }
        if (atribMod.contains("Modelo")|| atribMod.contains("*")) {
            this.setStatus(UserInteractions.strRequest("Introduzca el modelo"));
        }

    }
    /////////////////////////////////////////////////////AUTOGEN////////////////////////////////////////////////////////
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
