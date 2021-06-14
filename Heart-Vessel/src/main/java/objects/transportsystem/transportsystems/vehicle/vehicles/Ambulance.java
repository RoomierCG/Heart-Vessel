package objects.transportsystem.transportsystems.vehicle.vehicles;

import objects.people.Person;
import objects.product.Product;
import objects.transportsystem.transportsystems.vehicle.Vehicle;
import org.apache.catalina.User;
import service.utility.UserInteractions;

import java.util.ArrayList;

public class Ambulance extends Vehicle {

    /////////////////////////////////////////////////////ATTRIB/////////////////////////////////////////////////////////

    private ArrayList<String> equipment;
    private ArrayList<String> personal;

    /////////////////////////////////////////////////////CONSTR/////////////////////////////////////////////////////////

    public Ambulance(String transportId, String transportName, String status, int gasTank, String make, String model, ArrayList<String> equipment, ArrayList<String> personal) {
        super(transportId, transportName, status, gasTank, make, model);
        this.equipment = equipment;
        this.personal = personal;
    }

    public Ambulance(ArrayList<String> equipment, ArrayList<String> personal) {
        this.equipment = equipment;
        this.personal = personal;
    }

    public Ambulance() {
    }

    /////////////////////////////////////////////////////METHOD/////////////////////////////////////////////////////////

    public ArrayList<String> gatherInfo() {
        return super.gatherInfo();
    }

    public ArrayList<ArrayList<String>> gatherListedInfo() {
        ArrayList<ArrayList<String>> s = super.gatherListedInfo();
        s.add(personal);
        s.add(equipment);

        return s;
    }

    public void modifyMe(ArrayList<String> atribMod) {
        if (atribMod.contains("Equipamiento")) {
            this.setEquipment(UserInteractions.formIDList(this.equipment, "PR"));
        }
        if (atribMod.contains("Personal")) {
            this.setPersonal(UserInteractions.formIDList(this.personal, "PEE"));
        }
    }

    /////////////////////////////////////////////////////AUTOGEN////////////////////////////////////////////////////////

    public ArrayList<String> getPersonal() {
        return personal;
    }

    public void setPersonal(ArrayList<String> personal) {
        this.personal = personal;
    }

    public ArrayList<String> getEquipment() {
        return equipment;
    }

    public void setEquipment(ArrayList<String> equipment) {
        this.equipment = equipment;
    }

}
