package visualInterfaces;

import java.util.ArrayList;

public class Constants {
    //=============================
    public static final String separtator = "=====================================================================================================================================================";

    public static final int personellLimit = 10;

    public static final int equipmentLimit = 50;

    public static final ArrayList<String> estadosPaciente = new ArrayList<String>() {{
        add("Estado1");
        add("Estado2");
    }};
    public static final ArrayList<String> estadosVehiculos = new ArrayList<String>() {{
        add("En llamas");
        add("Sin gasolina");
        add("En el paro");
    }};
    public static final ArrayList<String> estados2 = new ArrayList<String>() {{
        add("Estado1");
        add("Estado2");
    }};
    public static final ArrayList<String> departamentos = new ArrayList<String>() {{
        add("Dep1");
        add("Dep2");
    }};
    public static final ArrayList<String> riesgos = new ArrayList<String>() {{
        add("Sin Riesgo");
        add("No Critico");
        add("Semicritico");
        add("Critico");
    }};

    public static final String[][][][] Omniclase = new String[][][][]{

            //[Clase][InfoDeClase][Posicion en case de Lista//Default 0]
            //Info clase: 0 = Nombre de clase, 1 = Prefijo de clase, 2 = Lista de atributos

            {
                    //Sección de Area
                    {{"Area"}, {"ARR"}, {"id", "Nombre", "Estado", "Planta", "Riesgo"}, {"Personal", "Equipamiento"}},
                    {{"Garaje"}, {"ARG"}, {"id", "Nombre", "Estado", "Planta", "Riesgo"}, {"Personal", "Equipamiento", "Vehiculos"}},
                    {{"Habitacion"}, {"ARH"}, {"id", "Nombre", "Estado", "Planta", "Riesgo", "idPaciente"}, {"Personal", "Equipamiento"}}},

            //Sección de People
            {
                    {{"Paciente"}, {"PEP"}, {"id", "Nombre", "Apellido", "Estado", "VisitasPermitidas", "idHabitacion"}, {"Registro"}},
                    {{"Empleado"}, {"PEE"}, {"id", "Nombre", "Apellido", "Estado", "Departamento", "Puesto", "Salario", "Jornada"}, {null}}},

            //Sección de Provider
            {
                    {{"Proveedor"}, {"PVP"}, {"id", "Nombre", "IBAN"}, {null}}},

            //Sección de TransportSystem
            {
                    {{"AyudaMovil"}, {"TRM"}, {"id", "Nombre", "Estado", "idArea", "idPaciente"}, {null}},
                    {{"Ambulancia"}, {"TRA"}, {"id", "Nombre", "Estado", "Gasolina", "Marca", "Modelo"}, {"Personal", "Equipamiento"}},
                    {{"CocheCompañia"}, {"TRC"}, {"id", "Nombre", "Estado", "Gasolina","Marca", "Modelo", "Dueño"}, {null}}},

            //Sección de Producto
            {
                    {{"MaterialSanitario"}, {"PRS"}, {"id", "Nombre", "Area", "Estado", "FechaDeCompra", "MarcaModelo", "Uso"}, {null}},
                    {{"Maquinaria"}, {"PRM"}, {"id", "Nombre", "Area", "Estado", "FechaDeCompra", "ConsumoElectrico", "Modelo"}, {null}},
                    {{"EquipamientoLimpieza"}, {"PRE"}, {"id", "Nombre", "Area", "Estado", "FechaDeCompra", "GradoDeRiesgo"}, {null}},
                    {{"ProductoLimpieza"}, {"PRL"}, {"id", "Nombre", "Area", "Estado", "FechaDeCompra", "Marca", "Toxico", "Uso"}, {null}},
                    {{"Medicamento"}, {"PRD"}, {"id", "Nombre", "Area", "Estado", "FechaDeCompra", "Toxico", "FechaDeCaducidad", "ViaDeAdministracion", "Uso"}, {"RiesgosAlergicos"}},
                    {{"Comida"}, {"PRC"}, {"id", "Nombre", "Area", "Estado", "FechaDeCompra", "Toxico", "FechaDeCaducidad", "Proveedor", "Uso"}, {"RiesgosAlergicos"}
                    }}
    };

}


