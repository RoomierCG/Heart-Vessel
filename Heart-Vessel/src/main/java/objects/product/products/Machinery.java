package objects.product.products;

import objects.product.Product;


public class Machinery extends Product {
    private int electricityConsumption; //Cuanta electricidad consume
    private String model; //Marca o modelo de la maquina




    public Machinery(String equipmentId, String name, String location, String status, String buyDate) {
        super(equipmentId, name, location, status, buyDate);
    }

    public Machinery(String equipmentId, String name, String location, String status, String buyDate, int electricityConsumption, String model) {
        super(equipmentId, name, location, status, buyDate);
        this.electricityConsumption = electricityConsumption;
        this.model = model;
    }

    public Machinery() {

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
