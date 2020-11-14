package objects.people.person;

import objects.people.Person;

public class Employee extends Person {

    //Status = Trabajando, En descanso, de vacaciones etc?
    private String type; //Medicina, Limpieza, Admin?, Conductores, +?
    private String shift; //Dia, noche, guardia
    private int salary; //Cuanto cobra
    private String job; //Cirujano, anestesista, medico de cabecera, etc.  --- Mas especifico

    public Employee(String personId, String name, String lastName, String status) {
        super(personId, name, lastName, status);
    }

    public Employee(String personId, String name, String lastName, String status, String type, String shift, int salary, String job) {
        super(personId, name, lastName, status);
        this.type = type;
        this.shift = shift;
        this.salary = salary;
        this.job = job;
    }

    public Employee() {
        super();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
