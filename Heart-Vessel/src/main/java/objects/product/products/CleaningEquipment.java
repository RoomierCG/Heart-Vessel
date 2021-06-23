package objects.product.products;

import objects.product.Product;
import service.utility.UserInteractions;
import visualInterfaces.Constants;

import java.util.ArrayList;
import java.util.Date;

public class CleaningEquipment extends Product {
    /////////////////////////////////////////////////////ATTRIB/////////////////////////////////////////////////////////
    private int riskFactor;

    /////////////////////////////////////////////////////CONSTR/////////////////////////////////////////////////////////
    public CleaningEquipment(String equipmentId, String name, String areaId, String status, String buyDate,int quantity, int riskFactor) {
        super(equipmentId, name, areaId, status, buyDate,quantity);
        this.riskFactor = riskFactor;
    }

    public CleaningEquipment() {

    }
    /////////////////////////////////////////////////////METHOD/////////////////////////////////////////////////////////
    public ArrayList<String> gatherInfo() {
        ArrayList<String> s = super.gatherInfo();
        s.add(String.valueOf(riskFactor));
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

    public int getRiskFactor() {
        return riskFactor;
    }

    public void setRiskFactor(int riskFactor) {
        this.riskFactor = riskFactor;
    }


}
