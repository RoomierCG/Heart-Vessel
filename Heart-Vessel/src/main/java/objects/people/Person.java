package objects.people;

import objects.Generic;

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
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /////////////////////////////////////////////////////AUTOGEN////////////////////////////////////////////////////////
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


}
