package objects.product.products.substance.substances;

import objects.product.products.substance.Substance;


public class CleaningProducts extends Substance {
    private String make; //Marca del producto

    public CleaningProducts(int equipmentId, String name, int quantity, int location, String status, String buyDate, boolean toxic) {
        super(equipmentId, name, quantity, location, status, buyDate, toxic);
    }

    public CleaningProducts(int equipmentId, String name, int quantity, int location, String status, String buyDate, boolean toxic, String make) {
        super(equipmentId, name, quantity, location, status, buyDate, toxic);
        this.make = make;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

}
