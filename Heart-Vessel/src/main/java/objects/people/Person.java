package objects.people;

public abstract class Person {

    protected int personId; //Identificador
    protected String name; //Nombre
    protected String lastName; //Apellido
    protected String status;  //Variable dependiendo de hijo

    public Person(int personId, String name, String lastName, String status) {
        this.personId = personId;
        this.name = name;
        this.lastName = lastName;
        this.status = status;
    }


    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
