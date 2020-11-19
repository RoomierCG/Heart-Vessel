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

public class DataFunctions implements Operations{

    public static void main(String[] args) {
        QueryDB.rellenarTest();
        delete();
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

        Object modifyObject = OpsID.decodeID(UserInteractions.strRequest("Ingrese el ID de lo que quiera modificar"));

        if (modifyObject instanceof Area){
            return modifyArea(modifyObject);

        }else if(modifyObject instanceof Person){

        } else if(modifyObject instanceof Product){

        }else  if (modifyObject instanceof Provider){

        }else if(modifyObject instanceof Transport){

        }else{
        }

        return false;
    }

    public static boolean modifyArea(Object modifyObject){

        int option = -1;

        if (modifyObject instanceof Garaje){

            do {
                System.out.println("=== Que desea modificar ===" +
                        "-- 1º idGaraje --" +
                        "-- 2º Nombre --" +
                        "-- 3º Personal --" +
                        "-- 4º Equipamiento --" +
                        "-- 5º Estado --" +
                        "-- 6º Planta --" +
                        "-- 7º Riesgo --" +
                        "-- 8º Vehiculos --");



            }while (option != 0 && option > 8);

        }else if (modifyObject instanceof HabitableRoom){

        } else {

        }

        return false;
    }

}
