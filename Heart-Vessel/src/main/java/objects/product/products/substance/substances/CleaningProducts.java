package objects.product.products.substance.substances;

import objects.product.products.substance.Substance;


public class CleaningProducts extends Substance {
    private String make; //Marca del producto

    public CleaningProducts(String make) {
        this.make = make;
    }

    public CleaningProducts(String equipmentId, String name, String areaName, String status, String buyDate, boolean toxic, String type, String make) {
        super(equipmentId, name, areaName, status, buyDate, toxic, type);
        this.make = make;
    }

    public CleaningProducts(boolean toxic, String type, String make) {
        super(toxic, type);
        this.make = make;
    }



    public CleaningProducts() {

    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

}
