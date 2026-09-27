package Laboral;

import Laboral.BBDD.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CalculaNominas{
    public static void main(String[] args) {

        try {
            GestionEmpleados gestionEmpleados = new GestionEmpleados();
            Empleado empleado = new Empleado(
                    "Carlos García",
                    "45678923D",
                    'M',
                    4,
                    6
            );

            gestionEmpleados.altaEmpleado(empleado);
        }catch (SQLException e){
            System.out.println(e);
        }

    }




    private static void escribe(Empleado e) {
        Nomina calcularNomina = new Nomina();
        e.imprime();
        calcularNomina.sueldo(e);

    }
}


