package objects.product.products.substance;

import objects.product.Product;


public abstract class Substance extends Product {
    private boolean toxic; //Si es toxico o no

    public Substance(String equipmentId, String name, String location, String status, String buyDate, boolean toxic) {
        super(equipmentId, name, location, status, buyDate);
        this.toxic = toxic;
    }

    public Substance() {
        super();
    }

    public boolean isToxic() {
        return toxic;
    }

    public void setToxic(boolean toxic) {
        this.toxic = toxic;
    }
}
