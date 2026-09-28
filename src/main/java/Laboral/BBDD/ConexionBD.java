package Laboral.BBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static final String url="jdbc:mysql://localhost:3306/empleados_nominas";
    private static final String nombre="root";
    private static final String password="usuario";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(url,nombre,password);
    }

}
