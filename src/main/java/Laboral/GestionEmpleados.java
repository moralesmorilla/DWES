package Laboral;

import Laboral.BBDD.ConexionBD;

import java.io.*;
import java.nio.Buffer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GestionEmpleados {
    public GestionEmpleados() {
    }

    public void altaEmpleado(Empleado empleado) throws SQLException {
        Nomina calcularNominas = new Nomina();
        Connection conexion = ConexionBD.conectar();


        String insertarEmpleado = "INSERT INTO empleado(nombre,dni,sexo,categoria,anyos) VALUES(?,?,?,?,?)";
        PreparedStatement psi = conexion.prepareStatement(insertarEmpleado);

        psi.setString(1, empleado.getNombre());
        psi.setString(2, empleado.getDni());
        psi.setString(3, String.valueOf(empleado.getSexo()));
        psi.setInt(4, empleado.getCategoria());
        psi.setInt(5, empleado.getAnyos());

        int filas = psi.executeUpdate();

        if(filas==1){
            System.out.println("Empleado Insertado");
        }else{
            System.out.println("No se ha podido insertar el empleado");
        }


        int sueldo = calcularNominas.sueldo(empleado);
        System.out.println(sueldo);

        String insertarNomina = "INSERT INTO nomina(dni,sueldo) VALUES(?,?)";
        PreparedStatement ps = conexion.prepareStatement(insertarNomina);
        ps.setString(1,empleado.getDni());
        ps.setInt(2,sueldo);
        int filasNominas = ps.executeUpdate();
        if(filasNominas==1){
            System.out.println("Nomina insertada correctamente");
        }else{
            System.out.println("Ha ocurrido un error al insertar nomina");
        }

        conexion.close();
    }
    public List<Empleado> leerArchivo(String ruta) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(ruta));
        String linea;
        String nombre,dni;
        char sexo;
        int categoria,anyos;
        List<Empleado> empleados = new ArrayList<>();
        while ((linea = br.readLine()) != null){
            String[] datos = linea.split(",");
            nombre=datos[0];
            dni=datos[1];
            sexo = datos[2].charAt(0);
            if(datos.length==3){
                empleados.add(new Empleado(nombre,dni,sexo));
            }else{
                categoria = Integer.parseInt(datos[3]);
                anyos = Integer.parseInt(datos[4]);
                empleados.add(new Empleado(nombre,dni,sexo,categoria,anyos));
            }

        }
        br.close();
        return empleados;

    }

    public void altaEmpleado(List<Empleado> empleados) throws SQLException {
        for(Empleado empleado : empleados){
            altaEmpleado(empleado);
        }
    }
}
