package objects.people;

import objects.Generic;
import objects.area.Area;
import service.utility.UserInteractions;
import visualInterfaces.Constants;

import java.util.ArrayList;

public abstract class Person extends Generic {
    /////////////////////////////////////////////////////ATTRIB/////////////////////////////////////////////////////////
    protected String lastName; //Apellido
    protected String status;  //Variable dependiendo de hijo

    /////////////////////////////////////////////////////CONSTR/////////////////////////////////////////////////////////
    public Person(String personId, String name, String lastName, String status) {
        super(personId,name);
        this.lastName = lastName;
        this.status = status;
    }

    public Person() {

    }

    /////////////////////////////////////////////////////METHOD/////////////////////////////////////////////////////////
    public ArrayList<String> gatherInfo(){
        return new ArrayList<String>(){{
            add(Person.super.getId());
            add(Person.super.getName());
            add(lastName);
            add(status);
        }
        };
    }

    public ArrayList<ArrayList<String>> gatherListedInfo(){
        return new ArrayList<ArrayList<String>>(){{
        }
        };
    }

    public void modifyMe(ArrayList<String> atribMod) {
        super.modifyMe(atribMod);
        if(atribMod.contains("Apellido")){
            this.setLastName(UserInteractions.strRequest("Introduzca el apellido nuevo"));
        }
        if(atribMod.contains("Estado")){
            this.setStatus(UserInteractions.pickFrom(Constants.estadosPaciente,null));
        }


    }
    /////////////////////////////////////////////////////AUTOGEN////////////////////////////////////////////////////////
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


}
