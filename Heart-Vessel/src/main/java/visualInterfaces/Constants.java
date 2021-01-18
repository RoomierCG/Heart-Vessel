package visualInterfaces;

public class Constants {

    public static String separtator = "======================================================================================";

    public static int personellLimit = 10;

    public static int equipmentLimit = 50;

    public static String[][][][] Omniclase = new String[][][][]{

                //[Clase][InfoDeClase][Posicion en case de Lista//Default 0]
                //Info clase: 0 = Nombre de clase, 1 = Prefijo de clase, 2 = Lista de atributos

                {
                        //Sección de Area
                        {{"Area"}, {"ARR"}, {"idArea","Nombre", "Estado", "Planta", "Riesgo"},{"Personal", "Equipamiento"}},
                        {{"Garaje"}, {"ARG"}, {"idArea","Nombre", "Estado",  "Planta", "Riesgo"},{"Personal", "Equipamiento","Vehiculos"}},
                        {{"Habitacion"}, {"ARH"}, {"idArea", "Nombre","Estado", "Planta", "Riesgo", "idPaciente"},{"Personal", "Equipamiento"}}},

                //Sección de People
                {{{"Paciente"}, {"PEP"}, {"idPersona", "Nombre", "Apellido", "Estado", "VisitasPermitidas", "idHabitacion"},{"Registro"}},
                        {{"Empleado"}, {"PEE"}, {"idPersona", "Nombre", "Apellido", "Estado", "Departamento", "Puesto", "Salario", "Jornada"},{null}}},

                //Sección de Provider
                {{{"Proveedor"}, {"PVP"}, {"idProveedor", "Nombre", "IBAN"},{null}}},

                //Sección de TransportSystem
                {{{"AyudaMovil"}, {"TRM"}, {"idTransporte", "Estado", "idArea", "idPaciente"},{null}},
                        {{"Ambulancia"}, {"TRA"}, {"idTransporte", "Estado", "Gasolina", "Especialidad"},{"Personal","Equipamiento"}},
                        {{"CocheCompañia"}, {"TRC"}, {"idTransporte", "Estado", "Modelo", "Marca", "Gasolina", "Especialidad", "Dueño"},{null}}},

                //Sección de Producto
                {{{"MaterialSanitario"}, {"PRS"}, {"idProducto", "Nombre", "Area", "Estado", "FechaDeCompra", "MarcaModelo", "Uso"},{null}},
                        {{"Maquinaria"}, {"PRM"}, {"idProducto", "Nombre", "Area", "Estado", "FechaDeCompra", "ConsumoElectrico", "Modelo"},{null}},
                        {{"EquipamientoLimpieza"}, {"PRE"}, {"idProducto", "Nombre", "Area", "Estado", "FechaDeCompra", "GradoDeRiesgo"},{null}},
                        {{"ProductoLimpieza"}, {"PRL"}, {"idProducto", "Nombre", "Area", "Estado", "FechaDeCompra", "Marca", "Toxico", "Uso"},{null}},
                        {{"Medicamento"}, {"PRD"}, {"idProducto", "Nombre", "Area", "Estado", "FechaDeCompra", "Toxico", "FechaDeCaducidad", "ViaDeAdministracion", "Uso"},{"RiesgosAlergicos"}},
                        {{"Comida"}, {"PRC"}, {"idProducto", "Nombre", "Area", "Estado", "FechaDeCompra", "Toxico", "FechaDeCaducidad", "Estado", "Proveedor", "Uso"},{"RiesgosAlergicos"}
                        }}
        };

    }


