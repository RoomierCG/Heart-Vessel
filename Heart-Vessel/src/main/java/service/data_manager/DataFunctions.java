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

public class DataFunctions implements Operations {

    public static void main(String[] args) {

        QueryDB.rellenarTest();
        modifyMain();
//        System.out.println(OpsID.decodeID("ARR#1"));
    }

    public static boolean delete() {

        Object deleteObject = OpsID.decodeID(UserInteractions.strRequest("Ingrese el ID de lo que quiera eliminar"));

        if (deleteObject instanceof Area) {
            AuxDB.ArrLarea.remove(deleteObject);
            return true;

        } else if (deleteObject instanceof Person) {
            AuxDB.ArrlPerson.remove(deleteObject);
            return true;

        } else if (deleteObject instanceof Product) {
            AuxDB.ArrlProduct.remove(deleteObject);
            return true;

        } else if (deleteObject instanceof Provider) {
            AuxDB.ArrlProvider.remove(deleteObject);
            return true;

        } else if (deleteObject instanceof Transport) {
            AuxDB.ArrlTransport.remove(deleteObject);
            return true;

        } else {
            return false;
        }
    }

    public static boolean modifyMain() {

        Object modifyObject = OpsID.decodeID(UserInteractions.idRequest(true));

        if (modifyObject instanceof Area) {
            return modifyArea((modifyObject));

        } else if (modifyObject instanceof Person) {

        } else if (modifyObject instanceof Product) {

        } else if (modifyObject instanceof Provider) {

        } else if (modifyObject instanceof Transport) {

        } else {
        }

        return false;
    }

    public static boolean modifyArea(Object modifyObject) {

        ArrayList<Integer> options;
        ArrayList<Integer> optionsSelected = new ArrayList<>();
        String idModifyObject = (((Area) modifyObject).getIdArea());


        int tipo, opcion;//Le quite el menos 1, por si te da problemas luego

        //inicializacion de la lista de opciones a elegir
        if (modifyObject instanceof Garaje) {
            options = NumListCreator(Constants.Omniclase[0][1][2].length);
            tipo = 1;
        } else if (modifyObject instanceof HabitableRoom) {
            options = NumListCreator(Constants.Omniclase[0][2][2].length);
            tipo = 2;
        } else {
            options = NumListCreator(Constants.Omniclase[0][0][2].length);
            tipo = 0;
        }

        //No queremos permitir que modifiquen el id por eos borramos 0
        do {
            String prompt = "";
            for (int i = 1; i < Constants.Omniclase[0][tipo][2].length; i++) {
                if (options.contains(i)) {
                    prompt += "- " + i + "º " + Constants.Omniclase[0][tipo][2][i] + "\n";
                }
            }

            opcion = UserInteractions.numRequest(prompt + "=== 0  Salir de las opciones ===", options);
            optionsSelected.add(opcion);
            options.remove(options.indexOf(opcion));

        } while (opcion != 0);


        Collections.sort(optionsSelected);
        for (Integer opio : optionsSelected) {
            switch (opio) {
                case 1:
                    AuxDB.ArrLarea.get(AuxDB.ArrLarea.indexOf(OpsID.decodeID(idModifyObject))).setName(UserInteractions.strRequest("Ingrese el nuevo Nombre"));
                    break;
                case 2:
                    AuxDB.ArrLarea.get(AuxDB.ArrLarea.indexOf(OpsID.decodeID(idModifyObject))).setStatus(UserInteractions.strRequest("Ingrese el nuevo Estado"));
                    break;
                case 3:
                    AuxDB.ArrLarea.get(AuxDB.ArrLarea.indexOf(OpsID.decodeID(idModifyObject))).setPersonal(EditList(AuxDB.ArrLarea.get(AuxDB.ArrLarea.indexOf(OpsID.decodeID(idModifyObject))).getPersonal(), "PEE#"));
                    break;
                case 4:
                    AuxDB.ArrLarea.get(AuxDB.ArrLarea.indexOf(OpsID.decodeID(idModifyObject))).setEquipment(EditList(AuxDB.ArrLarea.get(AuxDB.ArrLarea.indexOf(OpsID.decodeID(idModifyObject))).getEquipment(), "PR"));
                    break;
                case 5:
                    AuxDB.ArrLarea.get(AuxDB.ArrLarea.indexOf(OpsID.decodeID(idModifyObject))).setFloor(Integer.parseInt(UserInteractions.strRequest("Ingrese la planta a la que se ha movido el area")));
                    break;
                case 6:
                    AuxDB.ArrLarea.get(AuxDB.ArrLarea.indexOf(OpsID.decodeID(idModifyObject))).setRisk(Integer.parseInt(UserInteractions.strRequest("Ingresa el nuevo código de riego")));
                    break;
                case 7:
                    if (AuxDB.ArrLarea.get(AuxDB.ArrLarea.indexOf(OpsID.decodeID(idModifyObject))) instanceof HabitableRoom) {
                        ((HabitableRoom) AuxDB.ArrLarea.get(AuxDB.ArrLarea.indexOf(OpsID.decodeID(idModifyObject)))).setIdPatient(UserInteractions.strRequest("Ingrese el nuevo Id del paciente"));
                    } else {
                        ((Garaje) AuxDB.ArrLarea.get(AuxDB.ArrLarea.indexOf(OpsID.decodeID(idModifyObject)))).setVehicles(EditList(((Garaje) AuxDB.ArrLarea.get(AuxDB.ArrLarea.indexOf(OpsID.decodeID(idModifyObject)))).getVehicles(), "TR"));
                    }
                    break;
            }
        }

        return false;
    }

    public static ArrayList<String> EditList(ArrayList<String> originList, String originType) {
        switch (UserInteractions.numRequest("\n1. Añadir\n2. Eliminar\n3. Mostrar Lista\n0. Salir", 0, 3)) {
            case 1:
                String newId = UserInteractions.idRequest(originType,true);
                if (OpsID.decodeID(newId) == null) {
                    System.out.println("Este id no existe");
                } else {
                    originList.add(newId);
                }
                originList = EditList(originList, originType);
                break;

            case 2:
                String delId = UserInteractions.idRequest(originType,true);
                if (!originList.contains(delId)) {
                    System.out.println("Este id no existe");
                } else {
                    originList.remove(delId);
                }
                originList = EditList(originList, originType);
                break;

            case 3:
                System.out.println("===== Lista siendo editada =====");
                for (String a : originList) {
                    System.out.println("      " + a);
                }
                originList = EditList(originList, originType);

        }
        return originList;
    }

    public static ArrayList<Integer> NumListCreator(int max) {
        ArrayList<Integer> newNumList = new ArrayList<>();
        for (int i = 0; i < max; i++) {
            newNumList.add(i);
        }

        return newNumList;
    }

    public static String[][] append(String[][] a, String[][] b) {
        String[][] result = new String[a.length + b.length][];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        return result;
    }

    public static void printAll(ArrayList<String> atribs, String type) {
        if(atribs.size()>6){
            do{
                ArrayList<String> reduced = new ArrayList<>();
                int cont = 0;
                do{
                    reduced.add(atribs.get(0));
                    System.out.println(atribs.get(0));
                    atribs.remove(0);
                    cont++;
                }while(cont<6 && !atribs.isEmpty());
                printAll(reduced,type);
            }while(!atribs.isEmpty());
        }
        ArrayList<String> responses = new ArrayList<>();
        //ArrayList<String> listResponse = new ArrayList<>();
        String[] Header = new String[atribs.size()];
        int HCount = 0;

        switch (type.substring(0, 2)) {//TODO REVISAR
            case "AR":
                for (Area a : AuxDB.ArrLarea) {
                    if (a.getIdArea().startsWith(type)) {
                        for (int numAtri = 0; numAtri < Constants.Omniclase[0][0][2].length; numAtri++) {
                            /*if (numAtri == 3 && atribs.contains(Constants.Omniclase[0][0][2][numAtri])) {
                                responses.add(a.gatherInfo()[numAtri][0]);
                                if (HCount != atribs.size()) {
                                    Header[HCount] = Constants.Omniclase[0][0][2][numAtri];
                                    HCount++;
                                }
                            } else if (numAtri == 4 && atribs.contains(Constants.Omniclase[0][0][2][numAtri])) {
                                responses.add(a.gatherInfo()[numAtri][0]);
                                if (HCount != atribs.size()) {
                                    Header[HCount] = Constants.Omniclase[0][0][2][numAtri];
                                    HCount++;
                                }
                            } else */if (atribs.contains(Constants.Omniclase[0][0][2][numAtri])) {
                                responses.add(a.gatherInfo()[numAtri]);
                                if (HCount < atribs.size()) {
                                    Header[HCount] = Constants.Omniclase[0][0][2][numAtri];
                                    HCount++;

                                }
                            }
                        }
                        if (type.equals("ARG#") && atribs.contains(Constants.Omniclase[0][1][2][7])) {
                            responses.add(a.gatherInfo()[7]);
                            if (HCount != atribs.size()) {
                                Header[HCount] = Constants.Omniclase[0][1][2][7];
                                HCount++;
                            }
                        }
                    }
                }


                switch (atribs.size()) {
                    case 1:
                        System.out.printf("%-30.30s\n", Header[0]);

                        System.out.printf("%-30.30s\n", Constants.separtator);
                        for (String resp : responses) {
                            System.out.printf("%-30.30s\n", resp);
                        }
                        break;
                    case 2:
                        System.out.printf("%-30.30s %-30.30s\n", Header[0], Header[1]);

                        System.out.printf("%-30.30s %-30.30s\n", Constants.separtator, Constants.separtator);
                        for (int i = 0; i < responses.size(); i += 2) {
                            System.out.printf("%-30.30s %-30.30s\n", responses.get(i), responses.get(i + 1));
                        }
                        break;
                    case 3:
                        System.out.printf("%-30.30s %-30.30s %-30.30s\n", Header[0], Header[1], Header[2]);

                        System.out.printf("%-30.30s %-30.30s %-30.30s\n", Constants.separtator, Constants.separtator, Constants.separtator);
                        for (int i = 0; i < responses.size(); i += 3) {
                            System.out.printf("%-30.30s %-30.30s %-30.30s\n", responses.get(i), responses.get(i + 1), responses.get(i + 2));
                        }
                        break;
                    case 4:
                        System.out.printf("%-30.30s %-30.30s %-30.30s %-30.30s\n", Header[0], Header[1], Header[2],Header[3]);

                        System.out.printf("%-30.30s %-30.30s %-30.30s %-30.30s\n", Constants.separtator, Constants.separtator, Constants.separtator, Constants.separtator);
                        for (int i = 0; i < responses.size(); i += 4) {
                            System.out.printf("%-30.30s %-30.30s %-30.30s %-30.30s\n", responses.get(i), responses.get(i + 1), responses.get(i + 2),responses.get(i+3));
                        }
                        break;
                    case 5:
                        System.out.printf("%-30.30s %-30.30s %-30.30s %-30.30s\n", Header[0], Header[1], Header[2],Header[3],Header[4]);

                        System.out.printf("%-30.30s %-30.30s %-30.30s %-30.30s %-30.30s\n", Constants.separtator, Constants.separtator,Constants.separtator, Constants.separtator, Constants.separtator);
                        for (int i = 0; i < responses.size(); i += 5) {
                            System.out.printf("%-30.30s %-30.30s %-30.30s %-30.30s %-30.30s\n", responses.get(i), responses.get(i + 1), responses.get(i + 2),responses.get(i+3),responses.get(i+4));
                        }
                        break;
                    case 6:
                        System.out.printf("%-30.30s %-30.30s %-30.30s %-30.30s  %-30.30s %-30.30s\n", Header[0], Header[1], Header[2],Header[3],Header[4],Header[5]);

                        System.out.printf("%-30.30s %-30.30s %-30.30s %-30.30s %-30.30s %-30.30s\n", Constants.separtator, Constants.separtator,Constants.separtator,Constants.separtator, Constants.separtator, Constants.separtator);
                        for (int i = 0; i < responses.size(); i += 6) {
                            System.out.printf("%-30.30s %-30.30s %-30.30s %-30.30s %-30.30s %-30.30s\n", responses.get(i), responses.get(i + 1), responses.get(i + 2),responses.get(i+3),responses.get(i+4),responses.get(i+5));
                        }
                        break;


                }
        }
    }

}
