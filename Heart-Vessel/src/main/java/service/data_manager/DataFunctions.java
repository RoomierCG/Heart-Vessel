package service.data_manager;

import database_management.AuxDB;
import database_management.mongo.QueryDB;
import objects.area.Area;
import objects.area.areas.Garaje;
import objects.area.areas.HabitableRoom;
import objects.people.Person;
import objects.product.Product;
import objects.provider.Provider;
import objects.transportsystem.Transport;
import service.utility.OpsID;
import service.utility.UserInteractions;
import visualInterfaces.Constants;

import java.util.ArrayList;
import java.util.Collections;

public class DataFunctions implements Operations{

    public static void main(String[] args) {
        QueryDB.rellenarTest();

        modifyMain();

    }

    public static boolean delete() {

        Object deleteObject = OpsID.decodeID(UserInteractions.strRequest("Ingrese el ID de lo que quiera eliminar"));

        if (deleteObject instanceof Area){
            AuxDB.ArrLarea.remove(deleteObject);
            return true;

        }else if(deleteObject instanceof Person){
            AuxDB.ArrlPerson.remove(deleteObject);
            return true;

        } else if(deleteObject instanceof Product){
            AuxDB.ArrlProduct.remove(deleteObject);
            return true;

        }else  if (deleteObject instanceof Provider){
            AuxDB.ArrlProvider.remove(deleteObject);
            return true;

        }else if(deleteObject instanceof Transport){
            AuxDB.ArrlTransport.remove(deleteObject);
            return true;

        }else{
            return false;
        }
    }

    public static boolean modifyMain() {

        Object modifyObject = OpsID.decodeID(UserInteractions.idRequest());

        if (modifyObject instanceof Area){
            return modifyArea((modifyObject));

        }else if(modifyObject instanceof Person){

        } else if(modifyObject instanceof Product){

        }else  if (modifyObject instanceof Provider){

        }else if(modifyObject instanceof Transport){

        }else{
        }

        return false;
    }

    //TODO Resolver modify problemas de asignacion de valores
    public static boolean modifyArea(Object modifyObject){

        ArrayList<Integer> options = new ArrayList<>();
        ArrayList<Integer> optionsSelected = new ArrayList<>();
        String idModifyObject = (((Area) modifyObject).getIdArea());


        int tipo,opcion = -1;

        //inicializacion de la lista de opciones a elegir
        if (modifyObject instanceof Garaje){
            options = NumListCreator(Constants.Omniclase[0][1][2].length);
            tipo = 1;
        }else if (modifyObject instanceof HabitableRoom){
            options = NumListCreator(Constants.Omniclase[0][2][2].length);
            tipo = 2;
        }else{
            options = NumListCreator(Constants.Omniclase[0][0][2].length);
            tipo = 0;
        }

        //No queremos permitir que modifiquen el id por eos borramos 0
        do {
            String prompt = "";
            for (int i = 1; i < Constants.Omniclase[0][tipo][2].length; i++){
                if (options.indexOf(i) != -1){
                    prompt = prompt+"- "+i+ "º "+Constants.Omniclase[0][tipo][2][i]+"\n";
                }
            }

            opcion = UserInteractions.numRequest(prompt+"=== 0  Salir de las opciones ===",options);
            optionsSelected.add(opcion);
            options.remove(opcion);

        }while (opcion != 0);

        Collections.sort(optionsSelected);
        for (Integer opio:optionsSelected) {
            switch (opio){
                case 1:
                    AuxDB.ArrLarea.get(AuxDB.ArrLarea.indexOf(OpsID.decodeID(idModifyObject))).setStatus(UserInteractions.strRequest("Ingrese el nuevo Estado"));
                    break;
                case 2:
//                    AuxDB.ArrLarea.get(AuxDB.ArrLarea.indexOf(OpsID.decodeID(idModifyObject))).setPersonal();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
            }
        }

        return false;
    }

    public static ArrayList<Integer> NumListCreator(int tope){
        ArrayList<Integer> Aiur= new ArrayList<>();
        for(int pilones = 0;pilones<tope;pilones++){
            Aiur.add(pilones);
        }

        return Aiur;
    }
}
