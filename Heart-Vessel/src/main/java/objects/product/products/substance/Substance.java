package objects.product.products.substance;

import objects.product.Product;


public abstract class Substance extends Product {
    private boolean toxic; //Si es toxico o no
    private String type; //Solido.Liquido,Polvo etc

    public Substance() {
    }

    public boolean isToxic() {
        return toxic;
    }

    public void setToxic(boolean toxic) {
        this.toxic = toxic;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Substance(String equipmentId, String name, String areaName, String status, String buyDate, boolean toxic, String type) {
        super(equipmentId, name, areaName, status, buyDate);
        this.toxic = toxic;
        this.type = type;
    }

    public Substance(boolean toxic, String type) {
        this.toxic = toxic;
        this.type = type;
    }
}
