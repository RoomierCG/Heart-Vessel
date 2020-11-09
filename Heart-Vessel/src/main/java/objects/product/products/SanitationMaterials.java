package objects.product.products;

import objects.product.Product;

import java.util.Date;

public class SanitationMaterials extends Product {
    private String model; //Marca/modelo del objeto
    private String type;  //Herramiento, Consumible (eg. escarpelo vs vendas)

    public SanitationMaterials(int equipmentId, String name, int quantity, int location, String status, String buyDate) {
        super(equipmentId, name, quantity, location, status, buyDate);
    }

    public SanitationMaterials(int equipmentId, String name, int quantity, int location, String status, String buyDate, String model, String type) {
        super(equipmentId, name, quantity, location, status, buyDate);
        this.model = model;
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
