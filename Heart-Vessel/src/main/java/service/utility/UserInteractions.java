package service.utility;


import database_management.AuxDB;
import objects.Generic;
import service.data_manager.DataFunctions;
import visualInterfaces.Constants;

import javax.xml.crypto.Data;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInteractions {

    static Scanner sc = new Scanner(System.in);

    public static int numRequest(String prompt) {
        int number;
        if (!(prompt.length() == 0)) {
            System.out.println(prompt);
        }
        try {
            number = sc.nextInt();
        } catch (Exception e) {
            System.out.println("formato incorrecto");
            sc.nextLine();
            number = numRequest(prompt);
        }
        return number;
    }

    public static int numRequest(String prompt, int min, int max) {
        int number;
        number = numRequest(prompt + "\nEl valor debe estar entre " + min + " y " + max);
        if (number < min || number > max) {
            System.out.println("Valor no dentro de limites especificados (" + min + " y " + max + ")");
            return numRequest(prompt, min, max);
        }
        return number;
    }

    public static int numRequest(String prompt, ArrayList<Integer> ops) {
        int response;
        boolean valido = false;
        do {
            response = numRequest(prompt);
            for (Integer i : ops) {
                if (i == response) {
                    valido = true;
                    break;
                }
            }
        } while (!valido);
        return response;
    }


    public static String strRequest(String prompt) {
        String output;
        System.out.println(prompt);
        //sc.nextLine();
        output = sc.nextLine();

        return output;
    }

    public static String strRequest(String prompt, int size) {
        String output;
        System.out.println(prompt + "\nDebe ser exactamente " + size + " caracteres en longitud");
        output = strRequest(prompt);
        if (!(output.length() == size)) {
            System.out.println("El valor tiene que ser exactamente de longitud: " + size);
            output = strRequest(prompt, size);
        }
        return output;
    }

    public static String strRequest(String prompt, int min, int max) {
        String output;
        if (min < 0 && max > 0) {
            output = strRequest(prompt + "\nIntroduzca hasta un maximo de " + max + " caracteres.");
            if (output.length() > max) {
                System.out.println("Valor demasiado grande");
                output = strRequest(prompt, min, max);
            }
        } else if (max < 0 && min > 0) {
            output = strRequest(prompt + "\nIntroduzca un minimo de " + min + " caracteres.");
            if (output.length() > min) {
                System.out.println("Valor demasiado pequeño");
                output = strRequest(prompt, min, max);
            }
        } else {
            output = strRequest("Prompt");
        }

        return output;

    }


    public static ArrayList<String> formIDList(ArrayList<String> original, String type) {
        ArrayList<String> backup = original;
        int choice;
        do {
            try {
                type = DataFunctions.formalisePrefix(type);
            } catch (IllegalArgumentException e) {
                System.out.println("Prefijo invalido para modificacion de lista");
            }
            do {
                choice = UserInteractions.numRequest("Como deaseas modificar la lista:\n1. Añadir\n2. Eliminar\n3. MostrarLista\n0. Terminado", DataFunctions.NumListCreator(0, 3));
                switch (choice) {
                    case 1:
                        String tempID = UserInteractions.idRequest(type,true);
                        try{
                            OpsID.decodeID(tempID).equals(null);
                            original.add(tempID);
                        }catch (NullPointerException e){
                            System.out.println("El ID " + tempID + " no coincide con ninguno existente.");
                        }

                        break;
                    case 2:
                        String del = UserInteractions.pickFrom(original, "Elige que ID eliminar");
                        original.remove(del);
                        break;

                    case 3:
                        for (String id : original) {
                            System.out.println(id);
                        }
                        break;
                }
            } while (choice != 0);
            int contx = 0, conty = 0;
            StringBuilder confirmation = new StringBuilder();
            confirmation.append("|| Lista Sin Cambios  || Lista Nueva || ");
            do {
                confirmation.append("\n|| ");
                try {
                    confirmation.append(original.get(contx));
                    contx++;
                } catch (NullPointerException e) {
                    confirmation.append(" - - - -");
                }
                confirmation.append("       ||");
                try {
                    confirmation.append(backup.get(conty));
                    conty++;
                } catch (NullPointerException e) {
                    confirmation.append(" - - - -");
                }
                confirmation.append("\n||" + original.get(contx) + " || " + backup.get(conty) + "||");
            } while (contx != original.size() && conty != backup.size());
            choice = UserInteractions.numRequest("Introduzca 1 para confirmar los cambios, 2 para salir o 3 para seguir editando.");
        } while (choice == 3);
        if (choice == 1) {
            return original;
        } else {
            return backup;
        }
    }


        public static String pickFrom (ArrayList < String > list, String prompt){
            int cont = 1;
            if (!prompt.isEmpty()) {
                System.out.println(prompt);
            }
            for (String op : list) {
                System.out.println(cont + ". " + op);
                cont++;
            }
            int numresp;
            numresp = UserInteractions.numRequest("Introduzca la opcion deseada de la lista anterior", 1, list.size());
            return list.get(numresp - 1);

        }
        public static String pickFrom (String[]list){
            ArrayList<String> temporal = new ArrayList<>();
            for (String a : list) {
                temporal.add(a);
            }
            return pickFrom(temporal, null);
        }

        public static String idRequest ( boolean exists){
            String prefijoID = "";
            int TamMax = AuxDB.MaxIDs.size();
            for (int i = 0; i < TamMax; i += 2) {
                if (i == TamMax - 1 && (TamMax % 2 == 1)) {
                    System.out.print((i + 1) + ". " + AuxDB.MaxIDs.get(i).getVisualType());
                } else {
                    System.out.printf("%-30.30s  %-30.30s%n", ((i + 1) + ". " + AuxDB.MaxIDs.get(i).getVisualType()), ((i + 2) + ". " + AuxDB.MaxIDs.get(i + 1).getVisualType()));
                }
            }
            ID claseSelec = AuxDB.MaxIDs.get(numRequest("\n\nSeleccione el tipo deseado", 1, TamMax) - 1);
            prefijoID = prefijoID + claseSelec.getType() + "#";
            return idRequest(prefijoID, exists);
        }

        public static String idRequest (String forceType,boolean exists){
            String prefijoID = forceType;

            if (forceType.length() == 2) {
                ArrayList<String> typeOp = new ArrayList<>();

                for (String[][][] i : Constants.Omniclase) {
                    for (int j = 0; j < i.length; j++) {
                        if (i[j][1][0].substring(0, 2).equals(forceType)) {
                            for (int found = 0; found < i.length; found++) {
                                typeOp.add(i[found][1][0]);
                            }
                            break;
                        }
                    }
                }

                for (int i = 0; i < typeOp.size(); i++) {
                    System.out.println(typeOp.get(i) + "#" + (i + 1));
                }
                prefijoID = typeOp.get(UserInteractions.numRequest("Elige la subclase a la que pertenece el ID", 1, typeOp.size()) - 1) + "#";
            }
            String save = prefijoID;
            do {
                prefijoID = save;
                prefijoID = prefijoID + numRequest("Introduzca el valor numerico del ID o -1 para salir");//o -1 si desea salir¿
                System.out.println(prefijoID.substring(4));
            } while (((OpsID.decodeID(prefijoID) == null && exists) && !(prefijoID.substring(4).equals("-1"))));
            return prefijoID;
        }

        public static String dateRequest () {

            int cDay = Integer.parseInt(getCurrentDate().substring(0, 2));
            int cMonth = Integer.parseInt(getCurrentDate().substring(3, 5));
            int cYear = Integer.parseInt(getCurrentDate().substring(6, 10));

            int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

            int month = numRequest("Introduzca el mes.", 1, 12);
            int year = numRequest("Introduzca el año.", 0, cYear);
            int day;

            if (cYear == year && cMonth == month) {
                day = numRequest("Introduzca el dia. ", 1, cDay);
            } else {
                if (month == 2) {
                    if (year % 4 == 0) {
                        day = numRequest("Introduca el dia. ", 1, 29);
                    } else {
                        day = numRequest("Introduca el dia. ", 1, 28);
                    }
                } else {
                    day = numRequest("Introduca el dia. ", 1, months[month - 1]);
                }
            }
            return day + "/" + month + "/" + year;
        }

        private static String getCurrentDate () {//0-2,3-5,6-10 == dd/mm/yyyy
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDateTime now = LocalDateTime.now();
            return (dtf.format(now));
        }


    }
