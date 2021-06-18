package objects.people;

import objects.Generic;
import objects.area.Area;
import service.background_sim.Simulator;
import service.utility.UserInteractions;
import visualInterfaces.Constants;

import java.util.ArrayList;

public abstract class Person extends Generic {
    ///////////////////////SIM///////////////////////
    private ArrayList<String> nombresR = new ArrayList<String>(){{add("Juan");add("Pepe");add("Julian");add("Elena");add("Sofia");add("Carmen");}};
    private ArrayList<String> apellidosR = new ArrayList<String>(){{add("Mendoza");add("Herrero");add("Carpintero");add("Torres");add("Lopez");add("Garcia");}};
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
    public void genMe(String ID){
        super.setName(nombresR.get(Simulator.randomNum(0,nombresR.size())));
        this.setLastName(apellidosR.get(Simulator.randomNum(0,apellidosR.size())));
        this.setStatus(Constants.estadosPaciente.get(Simulator.randomNum(0,Constants.estadosPaciente.size())));
    }
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
        return new ArrayList<>();
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
