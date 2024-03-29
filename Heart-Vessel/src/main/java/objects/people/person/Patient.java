package objects.people.person;

import database_management.AuxDB;
import objects.area.areas.HabitableRoom;
import objects.people.Person;
import service.background_sim.SimulatorThread;
import service.data_manager.DataFunctions;
import service.utility.OpsID;
import service.utility.UserInteractions;
import visualInterfaces.Constants;

import java.util.ArrayList;

public class Patient extends Person {
    ///////////////////////SIM///////////////////////
    /////////////////////////////////////////////////////ATTRIB/////////////////////////////////////////////////////////
    //Status = Enfermo, recuperando, muerto
    private boolean allowVisitors; //Si se permiten visitas
    private ArrayList<String> registry; //Log de paciente
    private String roomId; //Habitacion donde esta habitando el paciente (debe existir dentro de la lista de habitaciones)

    /////////////////////////////////////////////////////CONSTR/////////////////////////////////////////////////////////
    public Patient(String personId, String name, String lastName, String status) {
        super(personId, name, lastName, status);
        this.registry = new ArrayList<>();
    }

    public Patient(String personId, String name, String lastName, String status, boolean allowVisitors, String roomId, ArrayList<String> registry) {
        super(personId, name, lastName, status);
        this.allowVisitors = allowVisitors;
        this.registry = registry;
        this.roomId = roomId;
    }

    public Patient() {}


    /////////////////////////////////////////////////////METHOD/////////////////////////////////////////////////////////


    @Override
    public void genMe(String ID) {
        super.genMe(ID);
        this.allowVisitors = SimulatorThread.randomNum(0, 1) != 0;
        this.registry = new ArrayList<String>(){{add(String.valueOf(java.time.LocalTime.now()).substring(0, 8)+ "| Fue ingresado en el hospital.");}};
        ArrayList<ArrayList<String>> habitaciones = DataFunctions.getData(new ArrayList<String>(){{add("id");add("idPaciente");}},"ARH");
        this.setStatus(Constants.estadosPaciente.get(SimulatorThread.randomNum(0,Constants.estadosPaciente.size())));
        for(int i = 0;i<habitaciones.get(0).size();i++) {
            if (habitaciones.get(1).get(i) == null) {
                int ubica = AuxDB.Complete.indexOf(OpsID.decodeID(habitaciones.get(0).get(i)));
                HabitableRoom temp = (HabitableRoom) AuxDB.Complete.get(ubica);
                temp.setIdPatient(this.getId());
                AuxDB.Complete.set(ubica, temp);
                this.roomId = habitaciones.get(0).get(i);
            }
        }
        if(this.roomId == null){
            this.roomId = "Sin Habitacion";
        }

    }

    public ArrayList<String> gatherInfo() {
        ArrayList<String> s = super.gatherInfo();
        s.add(String.valueOf(allowVisitors));
        s.add(roomId);
        return s;
    }

    public ArrayList<ArrayList<String>> gatherListedInfo() {
        ArrayList<ArrayList<String>> s = super.gatherListedInfo();
        s.add(registry);
        return s;
    }

    public void modifyMe(ArrayList<String> atribMod) {
        super.modifyMe(atribMod);
        if (atribMod.contains("Visitas")|| atribMod.contains("*")) {
            this.setAllowVisitors(UserInteractions.boolRequest("Se le permiten visitas?"));
        }
        if (atribMod.contains("Estado")|| atribMod.contains("*")) {
            this.setStatus(UserInteractions.pickFrom(Constants.estadosPaciente, "Seleccione un estado"));
        }
        if (atribMod.contains("idHabitacion")|| atribMod.contains("*")) {
            if(UserInteractions.boolRequest("Tiene una habitacion designada")) {
                this.setRoomId(UserInteractions.idRequest("ARH", true));
            }else{
                this.setRoomId(null);
            }
        }
    }





    /////////////////////////////////////////////////////AUTOGEN////////////////////////////////////////////////////////

    public boolean isAllowedVisitors() {
        return allowVisitors;
    }

    public boolean isAllowVisitors() {
        return allowVisitors;
    }

    public void setAllowVisitors(boolean allowVisitors) {
        this.allowVisitors = allowVisitors;
    }

    public ArrayList<String> getRegistry() {
        return registry;
    }

    public void setRegistry(ArrayList<String> registry) {
        this.registry = registry;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }
}
