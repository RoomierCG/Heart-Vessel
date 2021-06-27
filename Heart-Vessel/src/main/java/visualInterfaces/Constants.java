package visualInterfaces;

import java.util.ArrayList;

public class Constants {
    //=============================
    public static final String separtator = "\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n";



    public static final int garageVehicleLimit = 20;
    public static final int personellLimitAMB = 10;
    public static final int equipmentLimitAMB = 50;
    public static final int SimSpeedMS = 5000;//Velocidad del simulador en milisegundos (cada x tiempo actividad nueva)

    public static final ArrayList<String> estadosPaciente = new ArrayList<String>() {{
        add("Sin Diagnosticar");
        add("Urgencia");
        add("Diagnosticado - Recuperandose");
        add("Diagnosticado - Enfermo");
        add("Diagnosticado - Terminal");

    }};
    public static final ArrayList<String> estadosVehiculos = new ArrayList<String>() {{
        add("Listo Para Salir");
        add("Averiado");
        add("En Transito");
    }};
    public static final ArrayList<String> estadosEmpleado = new ArrayList<String>() {{
        add("Trabajando");
        add("En Espera");
        add("En Descanso");
    }};
    public static final ArrayList<String> estadosArea = new ArrayList<String>() {{
        add("Limpiando");
        add("Ocupado");
        add("Disponible");
    }};
    public static final ArrayList<String> departamentos = new ArrayList<String>() {{
        add("Medico");
        add("Enfermero");
        add("Especialista");
        add("Dietista");
        add("Optico");
        add("Auxiliar");
        add("Biomedico");
        add("Fisioterapeuta");
    }};
    public static final ArrayList<String> jornada = new ArrayList<String>() {{
        add("Ordinaria - Diurna");
        add("Ordinaria - Nocturna");
        add("Complementaria");
        add("Especial");
    }};
    public static final ArrayList<String> puestosTrabajo = new ArrayList<String>() {{
        add("Pedagologia");
        add("Hematologia");
        add("CuidadoIntensivo");
        add("Farmacia");
        add("Dermatologia");
        add("Oftalmologia");
        add("Ginecologia Y Obstetricia");
    }};
    public static final ArrayList<String> riesgos = new ArrayList<String>() {{
        add("Sin Riesgo");
        add("No Critico");
        add("Semicritico");
        add("Critico");
    }};
    public static final ArrayList<String> viasDeAdministracion = new ArrayList<String>() {{
        add("Via_Oral");
        add("Via_Nasal");
        add("Via_Sanguinea");
    }};
    public static final ArrayList<String> estadosProducto = new ArrayList<String>() {{
        add("PerfectoEstado");
        add("Usable");
        add("RequiereCambio");
    }};
    public static final ArrayList<String> tipoSustancia = new ArrayList<String>() {{
        add("Polvo");
        add("Liquido");
        add("Pastilla");
        add("Gas");
        add("Capsula");
    }};

    public static final String RegistryFormat = "%-80.80s";
    public static final String LargeFormat = "%-45.45s";
    public static final String MediumFormat = "%-20.20s";
    public static final int HalfSizer = 44;




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
                    {{"Ambulancia"}, {"TRA"}, {"id", "Nombre", "Estado", "Gasolina", "Especialidad"}, {"Personal", "Equipamiento"}},
                    {{"CocheCompañia"}, {"TRC"}, {"id", "Nombre", "Estado", "Modelo", "Marca", "Gasolina", "Dueño"}, {null}}},

            //Sección de Producto
            {
                    {{"MaterialSanitario"}, {"PRS"}, {"id", "Nombre","Cantidad", "Area", "Estado", "FechaDeCompra", "MarcaModelo", "Uso"}, {null}},
                    {{"Maquinaria"}, {"PRM"}, {"id", "Nombre","Cantidad", "Area", "Estado", "FechaDeCompra", "ConsumoElectrico", "Modelo"}, {null}},
                    {{"EquipamientoLimpieza"}, {"PRE"}, {"id", "Nombre","Cantidad", "Area", "Estado", "FechaDeCompra", "GradoDeRiesgo"}, {null}},
                    {{"ProductoLimpieza"}, {"PRL"}, {"id", "Nombre","Cantidad", "Area", "Estado", "FechaDeCompra", "Toxico", "Tipo", "Marca"}, {null}},
                    {{"Medicamento"}, {"PRD"}, {"id", "Nombre", "Cantidad","Area", "Estado", "FechaDeCompra", "Toxico", "Tipo", "FechaDeCaducidad", "ViaDeAdministracion"}, {"RiesgosAlergicos"}},
                    {{"Comida"}, {"PRC"}, {"id", "Nombre", "Cantidad","Area", "Estado", "FechaDeCompra", "Toxico", "Tipo", "FechaDeCaducidad", "Proveedor"}, {"RiesgosAlergicos"}
                    }}
    };

}


