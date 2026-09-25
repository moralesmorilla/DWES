package Laboral;

import java.sql.Connection;
import java.sql.SQLException;

public class CalculaNominas{
    public static void main(String[] args) {

        try {
            Connection conexion = ConexionBD.conectar();
            if(conexion!=null){
                System.out.println("Conexion realizada con exito");
            }
            conexion.close();
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


