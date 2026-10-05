package Laboral.BBDD;

import Laboral.Empleado;
import Laboral.Nomina;

import java.sql.*;

public class EmpleadoDAO {
    public EmpleadoDAO() {
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

    public Empleado altaEmpleado(Empleado empleado) throws SQLException{
        Connection connection = ConexionBD.conectar();
        String sql = "INSERT INTO empleado (dni, nombre, sexo, categoria, anyos) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,empleado.getDni());
        preparedStatement.setString(2,empleado.getNombre());
        preparedStatement.setString(3,String.valueOf(empleado.getSexo()));
        preparedStatement.setInt(4,empleado.getCategoria());
        preparedStatement.setInt(5,empleado.getAnyos());

        int num = preparedStatement.executeUpdate();
        if(num==0){
            System.out.println("No se ha podido realizar el alta del empleado "+empleado.getNombre());
        }else{
            System.out.println("Se ha realizado el alta del empleado con exito");
            Empleado empleado1 = new Empleado(empleado.getNombre(),empleado.getDni(),empleado.getSexo(),empleado.getCategoria(),empleado.getAnyos());
            Nomina nomina = new Nomina();
            int sueldo = nomina.sueldo(empleado1);
            System.out.println("El sueldo del empleado es: "+sueldo);
            sql = "INSERT INTO nomina (dni, sueldo) VALUES (?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,empleado.getDni());
            preparedStatement.setInt(2,sueldo);
            num = preparedStatement.executeUpdate();
            if(num==0){
                System.out.println("No se ha podido realizar el alta de la nomina del empleado "+empleado.getNombre());
            }else{
                System.out.println("Se ha realizado el alta de la nomina del empleado con exito");
            }
        }
        connection.close();
        return empleado;

        }
    }

