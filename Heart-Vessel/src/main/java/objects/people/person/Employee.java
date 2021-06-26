package objects.people.person;

import objects.people.Person;
import service.background_sim.SimulatorThread;
import service.utility.UserInteractions;
import visualInterfaces.Constants;

import java.util.ArrayList;

public class Employee extends Person {

    /////////////////////////////////////////////////////ATTRIB/////////////////////////////////////////////////////////
    //Status = Trabajando, En descanso, de vacaciones etc?
    private String department; //Medicina, Limpieza, Admin?, Conductores, +?
    private String shift; //Dia, noche
    private int salary; //Cuanto cobra
    private String job; //Cirujano, anestesista, medico de cabecera, etc.  --- Mas especifico

    /////////////////////////////////////////////////////CONSTR/////////////////////////////////////////////////////////


    public Employee(String personId, String name, String lastName, String status, String department, String shift, int salary, String job) {
        super(personId, name, lastName, status);
        this.department = department;
        this.shift = shift;
        this.salary = salary;
        this.job = job;
    }

    public Employee() {
        super();
    }

    /////////////////////////////////////////////////////METHOD/////////////////////////////////////////////////////////
    @Override
    public void genMe(String ID) {
        super.genMe(ID);
        this.department = Constants.departamentos.get(SimulatorThread.randomNum(0,Constants.departamentos.size()));
        this.job = Constants.puestosTrabajo.get(SimulatorThread.randomNum(0,Constants.puestosTrabajo.size()));
        if(this.job.equals("Medico")){
            this.shift = "Guardia";
            this.salary = 1500;
        }else{
            this.shift = (SimulatorThread.randomNum(0,1) == 0) ? "Dia" : "Noche";
        }
        this.salary += SimulatorThread.randomNum(1000,1500);

    }
    public ArrayList<String> gatherInfo() {
        ArrayList<String> s = super.gatherInfo();
        s.add(department);
        s.add(job);
        s.add(String.valueOf(salary));
        s.add(shift);
        return s;
    }

    public ArrayList<ArrayList<String>> gatherListedInfo() {
        return new ArrayList<>();
    }

    public void modifyMe(ArrayList<String> atribMod) {
        super.modifyMe(atribMod);
        if (atribMod.contains("Departamento")|| atribMod.contains("*")) {
            this.setDepartment(UserInteractions.pickFrom(Constants.departamentos, "Seleccione un departamento nuevo"));
        }
        if (atribMod.contains("Jornada")|| atribMod.contains("*")) {
            this.setShift(UserInteractions.pickFrom(Constants.jornada, "Seleccione la jornada del empleado"));
        }
        if (atribMod.contains("Salario")|| atribMod.contains("*")) {
            this.setSalary(UserInteractions.numRequest("Introduzca el salario del empleado"));
        }
        if (atribMod.contains("Puesto")|| atribMod.contains("*")) {
            this.setJob(UserInteractions.pickFrom(Constants.puestosTrabajo, "Seleccione el puesto del empleado"));
        }
        if (atribMod.contains("Estado")|| atribMod.contains("*")) {
            this.setStatus(UserInteractions.pickFrom(Constants.estadosEmpleado, "Seleccione el estado del empleado"));
        }

    }




    /////////////////////////////////////////////////////AUTOGEN////////////////////////////////////////////////////////

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
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
