package objects.product.products.substance.substances;

import objects.product.products.substance.Substance;


public class CleaningProducts extends Substance {
    private String make; //Marca del producto

    public CleaningProducts(String equipmentId, String name , String location, String status, String buyDate, boolean toxic) {
        super(equipmentId, name, location, status, buyDate, toxic);
    }

    public CleaningProducts(String equipmentId, String name , String location, String status, String buyDate, boolean toxic, String make) {
        super(equipmentId, name, location, status, buyDate, toxic);
        this.make = make;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

}
