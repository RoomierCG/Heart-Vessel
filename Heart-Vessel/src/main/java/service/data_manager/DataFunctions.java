package service.data_manager;

import database_management.AuxDB;
import database_management.mongo.QueryDB;
import objects.area.Area;
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

    static boolean delete() {

        Object deleteObject = OpsID.decodeID(UserInteractions.strRequest("Ingrese el ID de lo que quiera eliminar"));

        if (deleteObject instanceof Area){
            AuxDB.ArrLarea.remove(deleteObject);

        }else if(deleteObject instanceof Person){
            AuxDB.ArrlPerson.remove(deleteObject);

        } else if(deleteObject instanceof Product){
            AuxDB.ArrlProduct.remove(deleteObject);

        }else  if (deleteObject instanceof Provider){
            AuxDB.ArrlProvider.remove(deleteObject);

        }else if(deleteObject instanceof Transport){
            AuxDB.ArrlTransport.remove(deleteObject);

        }

        return false;
    }

}
