package Laboral.BBDD;

import Laboral.Empleado;

import java.sql.*;
import java.util.ResourceBundle;

public class MostrarEmpleado {
    public MostrarEmpleado() {
    }

    public void mostrarEmpleados() throws SQLException {
        Connection conexion = ConexionBD.conectar();
        String sql = "SELECT * FROM empleado";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()){
            String dni = rs.getString("dni");
            String nombre = rs.getString("nombre");
            String sexo = rs.getString("sexo");
            int categoria = rs.getInt("categoria");
            int anyos = rs.getInt("anyos");
            System.out.println("Empleado");
            System.out.println(nombre+" con dni-"+dni+" "+sexo+" \n Categoria "+categoria+" "+anyos+" años trabajados");
        }



        conexion.close();
    }
    public Empleado mostrarEmpleado(String dniEmpleado) throws SQLException {
        Connection conexion = ConexionBD.conectar();
        String sql = "SELECT * FROM empleado WHERE dni=?";
        PreparedStatement st = conexion.prepareStatement(sql);
        st.setString(1,dniEmpleado);
        ResultSet rs = st.executeQuery();
        Empleado empleado = new Empleado();
        while (rs.next()){
            String dni = rs.getString("dni");
            String nombre = rs.getString("nombre");
            char sexo = rs.getString("sexo").charAt(0);
            int categoria = rs.getInt("categoria");
            int anyos = rs.getInt("anyos");
            System.out.println("Empleado");
            System.out.println(nombre+" con dni-"+dni+" "+sexo+" \n Categoria "+categoria+" "+anyos+" años trabajados");
            empleado= new Empleado(nombre,dni,sexo,categoria,anyos);
        }
        conexion.close();
        return empleado;

    }
}
