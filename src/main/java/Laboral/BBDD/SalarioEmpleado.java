package Laboral.BBDD;

import java.sql.*;

public class SalarioEmpleado {
    public SalarioEmpleado() {
    }

    public void mostrarSalarioEmpleado(String dni) throws SQLException {
        System.out.println(dni);
        Connection conexion = ConexionBD.conectar();
        String sql = "SELECT * FROM nomina e JOIN nomina n ON n.dni=e.dni WHERE e.dni = ?";
        PreparedStatement st = conexion.prepareStatement(sql);
        st.setString(1,dni);
        ResultSet rs = st.executeQuery();

        while (rs.next()){
            String dniMostrar = rs.getString("dni");
            int sueldo = rs.getInt("sueldo");
            System.out.println("Empleado "+dni+ " sueldo: "+sueldo);

        }



        conexion.close();
    }
}
