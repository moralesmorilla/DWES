package Laboral.BBDD;

import Laboral.Nomina;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ModificarEmpleado {
    public ModificarEmpleado() {
    }
    public void editarNombre(String nombre,String dni) throws SQLException {
        Connection conexion = ConexionBD.conectar();
        String sql = "UPDATE empleado SET nombre = ? WHERE dni = ?";
        PreparedStatement preparedStatement = conexion.prepareStatement(sql);

        preparedStatement.setString(1,nombre);
        preparedStatement.setString(2,dni);
        int filas = preparedStatement.executeUpdate();
        if (filas > 0) {
            System.out.println("Se actualizo con exito");
        }else{
            System.out.println("Hubo un problema y no se pudo cambiar");
        }
    }
    public void editarDni(String dniNuevo,String dni) throws SQLException {
        Connection conexion = ConexionBD.conectar();
        String sql = "UPDATE empleado SET dni = ? WHERE dni = ?";
        PreparedStatement preparedStatement = conexion.prepareStatement(sql);

        preparedStatement.setString(1,dniNuevo);
        preparedStatement.setString(2,dni);
        int filas = preparedStatement.executeUpdate();
        if (filas > 0) {
            System.out.println("Se actualizo con exito");
        }else{
            System.out.println("Hubo un problema y no se pudo cambiar");
        }
    }
    public void editarSexo(String sexo,String dni) throws SQLException {
        Connection conexion = ConexionBD.conectar();
        String sql = "UPDATE empleado SET sexo = ? WHERE dni = ?";
        PreparedStatement preparedStatement = conexion.prepareStatement(sql);

        preparedStatement.setString(1,sexo);
        preparedStatement.setString(2,dni);
        int filas = preparedStatement.executeUpdate();
        if (filas > 0) {
            System.out.println("Se actualizo con exito");
        }else{
            System.out.println("Hubo un problema y no se pudo cambiar");
        }
    }
    public void editarCategoria(int categoria,String dni) throws SQLException {
        Connection conexion = ConexionBD.conectar();
        String sql = "UPDATE empleado SET categoria = ? WHERE dni = ?";
        PreparedStatement preparedStatement = conexion.prepareStatement(sql);

        preparedStatement.setInt(1,categoria);
        preparedStatement.setString(2,dni);
        int filas = preparedStatement.executeUpdate();
        if (filas > 0) {
            System.out.println("Se actualizo con exito");
            MostrarEmpleado empleado = new MostrarEmpleado();
            Nomina nomina = new Nomina();
            int sueldo = nomina.sueldo(empleado.mostrarEmpleado(dni));
            String sqlUpdate = "UPDATE sueldo SET sueldo = ? WHERE dni = ?";
            PreparedStatement prst = conexion.prepareStatement(sqlUpdate);
            prst.setInt(1,sueldo);
            prst.setString(2,dni);
            int filas2= prst.executeUpdate();
            if(filas2>0){
                System.out.println("Sueldo actualizado con exito");
            }else{
                System.out.println("El sueldo no se pudo actulizar");
            }
        }else{
            System.out.println("Hubo un problema y no se pudo cambiar");
        }
    }
    public void editarAnyos(int anyos,String dni) throws SQLException {
        Connection conexion = ConexionBD.conectar();
        String sql = "UPDATE empleado SET categoria = ? WHERE dni = ?";
        PreparedStatement preparedStatement = conexion.prepareStatement(sql);

        preparedStatement.setInt(1,anyos);
        preparedStatement.setString(2,dni);
        int filas = preparedStatement.executeUpdate();
        if (filas > 0) {
            System.out.println("Se actualizo con exito");
            MostrarEmpleado empleado = new MostrarEmpleado();
            Nomina nomina = new Nomina();
            int sueldo = nomina.sueldo(empleado.mostrarEmpleado(dni));
            String sqlUpdate = "UPDATE sueldo SET sueldo = ? WHERE dni = ?";
            PreparedStatement prst = conexion.prepareStatement(sqlUpdate);
            prst.setInt(1,sueldo);
            prst.setString(2,dni);
            int filas2= prst.executeUpdate();
            if(filas2>0){
                System.out.println("Sueldo actualizado con exito");
            }else{
                System.out.println("El sueldo no se pudo actulizar");
            }
        }else{
            System.out.println("Hubo un problema y no se pudo cambiar");
        }
    }
}
