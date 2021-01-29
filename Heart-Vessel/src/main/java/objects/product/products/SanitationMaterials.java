package objects.product.products;

import objects.product.Product;

import java.util.Date;

public class SanitationMaterials extends Product {
    private String model; //Marca/modelo del objeto
    private String type;  //Herramiento, Consumible (eg. escarpelo vs vendas)




    public SanitationMaterials(String equipmentId, String name, String areaId, String status, String buyDate, String model, String type) {
        super(equipmentId, name, areaId, status, buyDate);
        this.model = model;
        this.type = type;
    }

    public SanitationMaterials() {

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


    public String[] gatherInfo() {
        return new String[]{super.getId(),super.getName(),super.getAreaId(),super.getStatus(),super.getBuyDate(),model,type};
    }
}
