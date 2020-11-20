package visualInterfaces;

public class Constants {

    public static String[][][] Omniclase = new String[][][]{

            //[Clase][InfoDeClase][Posicion en case de Lista//Default 0]
            //Info clase: 0 = Nombre de clase, 1 = Prefijo de clase, 2 = Lista de atributos

            {
                //Sección de Area
                {"Area"},{"ARR"},{"idArea", "Estado", "Personal","Equipamiento","Estado","Planta","Riesgo"}},
                {{"Garaje"},{"ARG"},{"idArea", "Estado", "Personal","Equipamiento","Estado","Planta","Riesgo", "Vehiculos"}},
                {{"Habitacion"},{"ARH"},{"idArea", "Estado", "Personal","Equipamiento","Estado","Planta","Riesgo","idPaciente"}},

                //Sección de People
                {{"Paciente"},{"PEP"},{"idPersona","Nombre", "Apellido", "Estado", "VisitasPermitidas", "Registro", "idHabitacion"}},
                {{"Empleado"},{"PEE"},{"idPersona","Nombre", "Apellido", "Estado", "Departamento", "Puesto", "Salario", "Jornada"}},

                //Sección de Provider
                {{"Proveedor"},{"PVP"},{"idProveedor", "Nombre", "IBAN"}},

                //Sección de TransportSystem
                {{"AyudaMovil"},{"TRM"},{"idTransporte", "Estado", "idArea", "idPaciente"}},
                {{"Ambulancia"},{"TRA"},{"idTransporte", "Estado", "Personal", "Productos", "Gasolina", "Especialidad"}},
                {{"CocheCompañia"},{"TRC"},{"idTransporte", "Estado", "Modelo", "Marca", "Gasolina", "Especialidad", "Dueño"}},

                //Sección de Producto
                {{"MaterialSanitario"},{"PRS"},{"idProducto", "Nombre", "Area", "Estado", "FechaDeCompra", "MarcaModelo", "Uso"}},
                {{"Maquinaria"},{"PRM"},{"idProducto", "Nombre", "Area", "Estado", "FechaDeCompra", "ConsumoElectrico", "Modelo"}},
                {{"EquipamientoLimpieza"},{"PRE"},{"idProducto", "Nombre", "Area", "Estado", "FechaDeCompra", "GradoDeRiesgo"}},
                {{"ProductoLimpieza"},{"PRL"},{"idProducto", "Nombre", "Area", "Estado", "FechaDeCompra", "Marca","Toxico","Uso"}},
                {{"Medicamento"},{"PRD"},{"idProducto", "Nombre", "Area", "Estado", "FechaDeCompra", "Toxico","RiesgosAlergicos","FechaDeCaducidad", "ViaDeAdministracion","Uso"}},
                {{"Comida"},{"PRC"},{"idProducto", "Nombre", "Area", "Estado", "FechaDeCompra", "Toxico","RiesgosAlergicos", "FechaDeCaducidad", "Estado","Proveedor","Uso"}
                }
    };

}
