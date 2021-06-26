package service.utility;


import database_management.AuxDB;
import objects.Generic;
import service.data_manager.DataFunctions;
import visualInterfaces.Constants;

import javax.xml.crypto.Data;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UserInteractions {
    /*User interactions contiene todos los metodos que interactuan directamente con el usuario
     * Prompt = Lo usamos para enviar un mensaje relevante en la pedida
     *
     *
     *
     */
    static Scanner sc = new Scanner(System.in);

    public static int numRequest(String prompt) {//Pedida de numero, sin restricciones
        int number;
        System.out.println(prompt);
        try {
            number = sc.nextInt();
        } catch (Exception e) {//Comprobamos que el format sea numerico, es decir solo contiene digitos
            System.out.println("formato incorrecto");
            sc.nextLine();
            number = numRequest(prompt);//En caso de que no introduzca un numero entramos en un bucle recursivo
        }
        return number;
    }

    public static int numRequest(String prompt, int min, int max) {//Pedida de un numero dentro de un rango
        int number;
        if(min>max){
            return 0;
        }
        //Utilizamos la pedida normal para verificar el formato de nuevo, sin re-usar codigo.
        number = numRequest(prompt + "\nEl valor debe estar entre " + min + " y " + max);
        //Comprobamos que el numero esta dentro de nuestros rangos
        if (number < min || number > max) {
            System.out.println("Valor no dentro de limites especificados (" + min + " y " + max + ")");
            return numRequest(prompt, min, max);
        }
        return number;
    }

    public static int numRequest(String prompt, ArrayList<Integer> ops) {//Pedida de un numero dentro de unas opciones fijas
        int response;
        boolean valido = false;
        /*Entramos en un bucle do-while donde se ira comparando lo que seleccione el usuario con las opciones disponibles
         * hasta que elija una valida.
         */
        do {
            response = numRequest(prompt);//Como siempre, usamos la pedida de numero regular para asegurar formato valido
            for (Integer i : ops) {
                if (i == response) {
                    valido = true;
                    break;
                }
            }
        } while (!valido);
        return response;
    }

    public static String strRequest(String prompt) {//Pedimos un string cualquiera.
        System.out.println(prompt);
        sc.nextLine();
        String result = sc.nextLine();
        return result;
    }

    public static String strRequest(String prompt, int size) {//Pedimos un string de longitud exacta
        String output;
        System.out.println(prompt + "\nDebe ser exactamente " + size + " caracteres en longitud");
        output = sc.nextLine();
        if (!(output.length() == size)) {
            System.out.println("El valor tiene que ser exactamente de longitud: " + size);
            output = strRequest(prompt, size);
        }
        return output;
    }

    public static boolean boolRequest(String prompt) {//Pedida que devuelve un Si o No, usando la pedida de numero anterior
        return numRequest(prompt, 1, 2) == 1;
    }

    /* Pedida de String con restricion leve.
     * Podemos usar un numero negativo en ambos parametros para ignorarlo y solo restringir el otro.
     * Sino etablecera un minimo y maximo de caracteres donde debe encontrarse la longitud del string introducido
     *
     */
    public static String strRequest(String prompt, int min, int max) {
        String output;
        if (min < 0 && max < 0) {
            return null;
        }
        if (min < 0 && max > 0) {//Caso de minimo negativo, solo limitamos la longitud
            output = strRequest(prompt + "\nIntroduzca hasta un maximo de " + max + " caracteres.");
            if (output.length() > max) {
                System.out.println("Valor demasiado grande");
                output = strRequest(prompt, min, max);
            }
        } else if (max < 0 && min > 0) {//Caso de maximo negativo, solo pedimos un minimo de longitud
            output = strRequest(prompt + "\nIntroduzca un minimo de " + min + " caracteres.");
            if (output.length() > min) {
                System.out.println("Valor demasiado pequeño");
                output = strRequest(prompt, min, max);
            }
        } else {//Caso de ambos positivos donde pedimos un minimo de longitud pero limitamos la longitud maxima.
            output = strRequest(prompt + "\nIntroduzca un minimo de " + min + " y un maximo de " + max + " caracteres.");
            if (output.length() > min) {
                System.out.println("Valor demasiado pequeño");
                output = strRequest(prompt, min, max);
            }
            if (output.length() > max) {
                System.out.println("Valor demasiado grande");
                output = strRequest(prompt, min, max);
            }
        }

        return output;

    }

    public static ArrayList<String> ConfirmStringList(ArrayList<String> old, ArrayList<String> nuev) {
        /*
         * Una vez termina de editar el usuario se muestran ambas lista en paralelo
         */
        int contx = 0, conty = 0;//Estos contadores indican cuantas entradas hemos impreso de la lista nueva (x) y antigua (y)
        StringBuilder confirmation = new StringBuilder();
        confirmation.append("|| Lista Sin Cambios   ||    Lista Nueva     || ");
        int choice;
        do {
            confirmation.append("\n|| ");
            //Usamos el try catch ya que asumimos que las listas no seran del mismo tamaño
            try {
                String entrada = old.get(conty);
                /*Aqui usamos unas simples mates para formatear la entrada a un tamaño de 20 centralizado
                 * Basicamente le restamos la longiutd de la entrada a nuestra longitud deseada (20)
                 * Luego dividimos ese resultado entre 2 (mitad a la derecha y mitad a la izquierda)
                 * En caso de que sobrepase 20 de longitud una entrada solo mostraremos los primeros 20 caracteres
                 */
                confirmation.append(String.format("%-20s", String.format("%" + (entrada.length() + (20 - entrada.length()) / 2) + "s", entrada))).append("||");
                conty++;
            } catch (IndexOutOfBoundsException e) {//En el caso de que no haya mas entradas en este punto imprimimos un vacio
                confirmation.append("   - - - - - - -    ||");
            }
            try {
                String entrada = nuev.get(contx);
                confirmation.append(String.format("%-20s", String.format("%" + (entrada.length() + (20 - entrada.length()) / 2) + "s", entrada))).append("||");

                contx++;
            } catch (IndexOutOfBoundsException e) {
                confirmation.append("   - - - - - - -    ||");

            }

            /* El bucle continua hasta que ambos contadores sean igual al tamaño de su lista. Como solo incrementamos
             * sus contadores respectivos cuando se imprime una entrada los contadores paran de incrementar una vez
             * alcanzan el valor igual al tamaño de su lista correspondiente.
             */
        } while (contx < nuev.size() || conty < old.size());
        System.out.println(confirmation);
        switch (UserInteractions.numRequest("Introduzca 1 para confirmar los cambios, 2 para descartarlos o 3 para seguir editando.")) {
            case 1:
                return nuev;
            case 2:
                return old;
        }
        return null;

    }


    /*Form List nos permite formar una lista nueva en base a una existente a voluntad del usuario, proporcionado ambas
     * opciones de modificacion de una lista (añadir & eliminar) ademas de una muestra de la lista si lo desea.
     * Ademas guardamos la lista original por si el usuario desea descartar los cambios que ha hecho a la lista.
     */

    public static ArrayList<String> formList(ArrayList<String> actual) {
        ArrayList<String> copia = new ArrayList<>(actual);//Copiamos la lista por si se descartan los cambios

        int choice;
        while (true) {
            do {//Bucle + Switch para manejar el uso del Menu, utilizando la pedida de numero de rango 0-3
                choice = UserInteractions.numRequest("Como deaseas modificar la lista:\n1. Añadir\n2. Eliminar\n3. MostrarLista\n0. Terminado", 0, 3);
                switch (choice) {
                    case 1:
                        actual.add(UserInteractions.strRequest("Introduzca el nuevo elemento de la lista"));
                        break;
                    case 2:
                        if (actual.size() == 0) {//No se podra borrar una entrada de la lista si no quedan
                            System.out.println("La lista ya esta vacia");
                        } else {
                            String del = UserInteractions.pickFrom(actual, "Elige que elemento eliminar");
                            actual.remove(del);
                            break;
                        }

                    case 3:
                        for (String id : actual) {
                            System.out.println("| - " + id);
                        }
                        break;
                }
            } while (choice != 0);
            ArrayList<String> result = ConfirmStringList(copia, actual);
            if (result != null) {
                return result;
            }
        }

    }

    //Ya que hemos optado por guardar solo los IDs en varias listas de nuestras clases usamos esto para modificarlas
    //Es muy similar a la lista anterior pero mas restrictiva ya que solo trabajamos con IDs.
    public static ArrayList<String> formIDList(ArrayList<String> actual, String type,int maxLength) {
        ArrayList<String> copia;
        if(actual != null) {
            copia = new ArrayList<>(actual);
        }else{
            copia = new ArrayList<>();
            actual = new ArrayList<>();
        }
        int choice;
        while (true) {
            try {
                type = DataFunctions.formalisePrefix(type);
            } catch (IllegalArgumentException e) {
                System.out.println("Prefijo invalido para modificacion de lista");
            }
            do {
                choice = UserInteractions.numRequest("Como deaseas modificar la lista:\n1. Añadir\n2. Eliminar\n3. MostrarLista\n4. Purgar lista de duplicas e IDs invalidos\n0. Terminado", 0, 4);

                switch (choice) {
                    case 1:
                        if(!(actual.size()==maxLength) && maxLength!=0) {
                            String tempID = UserInteractions.idRequest(type, true);
                            try {
                                OpsID.decodeID(tempID);
                                actual.add(tempID);
                            } catch (NullPointerException e) {
                                System.out.println("El ID " + tempID + " no coincide con ninguno existente.");
                            }
                        }else{
                            System.out.println("Has llegado ya a la capacidad maxima");
                        }

                        break;
                    case 2:
                        String del = UserInteractions.pickFrom(actual, "Elige que ID eliminar");
                        actual.remove(del);
                        break;

                    case 3:
                        if(actual.size()==0){
                            System.out.println("\n\nLa lista esta vacia\n\n");
                        }
                        for (String id : actual) {
                            System.out.println(id);
                        }
                        break;
                    case 4:
                        /*Usamos.distinct para sacar todos los valores unicos del .stream que hacemos de actual.
                         Luego lo recogemos con un collector que lo convierte en una lista que podemos usar para crear
                         nuestra arrayList nueva.
                         */
                        actual = new ArrayList<>((actual.stream().distinct().collect(Collectors.toList())));
                        actual.removeIf(purging -> OpsID.decodeID(purging) == null);
                        /*
                         * Aqui estamos usando una lambda simple, la cual comprime un iterador de la lista que hemos recogido
                         * y borra todos los IDs los cuales decodeID devuelva como nulo
                         */


                }
            } while (choice != 0);
             return ConfirmStringList(copia, actual);//Aqui confirmamos los cambios
            
        }

    }


    //Pickfrom nos permite restringir el usuario a elegir un valor de una lista especifica de strings
    public static String pickFrom(ArrayList<String> list, String prompt) {
        int cont = 1;
        System.out.println(prompt);

        for (String op : list) {//Mostramos las opciones
            System.out.println(cont + ". " + op);
            cont++;
        }
        int numresp = UserInteractions.numRequest("Introduzca la opcion deseada de la lista anterior", 1, list.size());
        return list.get(numresp - 1);

    }

    public static String pickFrom(String[] list, String prompt) {//Esto hace lo mismo que en el caso superior, lo unico que admite un array
        ArrayList<String> temporal = new ArrayList<>();
        Collections.addAll(temporal, list);//Cogemos los valores del array en una lista y lo añadimos a temporal
        return pickFrom(temporal, prompt);
    }

    //ID request nos permite pedirle al usuario un ID, con parametro de si es necesario que exista o no
    //Esta parte esencialmente se ocupe de crear la primera parte (el prefijo) del ID.
    public static String idRequest(boolean exists) {
        String prefijoID = "";
        //Aprovechamos que tenemos una lista de IDS maximos para usarlo como referencia de que opciones darle al usuario
        int TamMax = AuxDB.MaxIDs.size();
        for (int i = 0; i < TamMax; i += 2) {
            if (i == TamMax - 1 && (TamMax % 2 == 1)) {//Esto nos imprime el ultimo valor de la lista en caso de que sea impar
                System.out.print((i + 1) + ". " + AuxDB.MaxIDs.get(i).getVisualType());
            } else {
                //Aqui formateamos dos opciones del usuario juntas en dos campos de 30 espacios cada uno
                System.out.printf("%-30.30s  %-30.30s%n", ((i + 1) + ". " + AuxDB.MaxIDs.get(i).getVisualType()), ((i + 2) + ". " + AuxDB.MaxIDs.get(i + 1).getVisualType()));
            }
        }
        //Le pedimos despues que elija la clase que desea (restando uno porque ofrecemos del 1 al x pero el arrayL empieza en 0
        ID claseSelec = AuxDB.MaxIDs.get(numRequest("\n\nSeleccione el tipo deseado", 1, TamMax) - 1);
        prefijoID = prefijoID + claseSelec.getType() + "#";
        return idRequest(prefijoID, exists);
    }

    public static String idRequest(String forceType, boolean exists) {
        String prefijoID = forceType;

        if (forceType.length() == 2) {
            ArrayList<String> typeOp = new ArrayList<>();

            for (String[][][] i : Constants.Omniclase) {
                for (String[][] strings : i) {
                    if (strings[1][0].substring(0, 2).equals(forceType)) {
                        for (String[][] value : i) {
                            typeOp.add(value[1][0]);
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
        if (prefijoID.length() == 3) {
            prefijoID += "#";
        }
        String save = prefijoID;
        if(exists) {
            do {
                prefijoID = save;
                prefijoID = prefijoID + numRequest("Introduzca el valor numerico del ID o -1 para salir");//o -1 si desea salir¿
                System.out.println(prefijoID);
                if (OpsID.decodeID(prefijoID) == null) {
                    System.out.println("El ID que has introducido no existe, se requiere uno existente.");
                }
                /*
                 * Consideramos incluir un "Desea ver todos los IDs disponibles", pero alfinal decidimos en contra de ello
                 * Si quisiesemos hacerlo seria simple:
                 * ArrayList<ArrayList<String>> datos = DataFunctions.getData(new ArrayList<String>(){{add("id");add("nombre) [Esto opcional]}};
                 * for(int i = 0; i< datos[0].size() ; i++){
                 * sout(datos[0][i] + " | " +datos[1][i];
                 * y nos imprimiria una lista de ids (y nombres si lo incluimos)
                 */
            } while (((OpsID.decodeID(prefijoID) == null) && !(prefijoID.substring(4).equals("-1"))));
        }
        return prefijoID;
    }

    public static String dateRequest(int futureLimit) {

        //Aqui recogemos el dia, mes y año actual y lo guardamos en variables propias
        String actual = getCurrentDate();
        int cDay = Integer.parseInt(actual.substring(0, 2)); 
        int cMonth = Integer.parseInt(actual.substring(3, 5));
        int cYear = Integer.parseInt(actual.substring(6, 10));

        int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};//Esto establece los dias maximos de cada mes

        int month = numRequest("Introduzca el mes.", 1, 12);//Pedimos el mes
        int year = numRequest("Introduzca el año.", 0, cYear+futureLimit);//Pedimos el año
        int day;

        if (cYear == year && cMonth == month && futureLimit == 0) {//Si nos ubicamos en el mes y año actual la fecha limite es la de hoy
            day = numRequest("Introduzca el dia. ", 1, cDay);
        } else {
            if (month == 2) {//Si el mes es febrero hacemos una comprobacion de si es visiesto para proporcionar un dia addicional
                if (year % 4 == 0) {
                    day = numRequest("Introduca el dia. ", 1, 29);
                } else {
                    day = numRequest("Introduca el dia. ", 1, 28);
                }
            } else {
                day = numRequest("Introduca el dia. ", 1, months[month - 1]);//Sino pedimos el dia de forma normal
            }
        }
        return day + "/" + month + "/" + year;
    }

    private static String getCurrentDate() {//0-2,3-5,6-10 == dd/mm/yyyy
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        return (dtf.format(now));
    }


}
