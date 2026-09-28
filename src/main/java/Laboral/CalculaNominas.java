package Laboral;

import Laboral.BBDD.ConexionBD;
import Laboral.BBDD.ModificarEmpleado;
import Laboral.BBDD.MostrarEmpleado;
import Laboral.BBDD.SalarioEmpleado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class CalculaNominas{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try{
            menu();
        }catch (SQLException e){
            System.out.println(e);
        }
//        try
//
////            GestionEmpleados gestionEmpleados = new GestionEmpleados();
////            Empleado empleado = new Empleado(
////                    "Carlos García",
////                    "45678923D",
////                    'M',
////                    4,
////                    6
////            );
//
////            gestionEmpleados.altaEmpleado(empleado);
//        }catch (SQLException e){
//            System.out.println(e);
//        }

    }


    private static void menu() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        String dniEmpleado;
        do{
            System.out.println("Menu de Opciones");
            System.out.println("1-Mostar Informacion de empleados");
            System.out.println("2-Mostrar salario de un empleado por dni");
            System.out.println("3-Modificar Datos de un empleado");
            System.out.println("4-Salir");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Mostrar Informacion del empleado");
                    MostrarEmpleado e1 = new MostrarEmpleado();
                    e1.mostrarEmpleados();
                    break;
                case 2:
                    System.out.println("Mostrar salario empleado especifico");
                    SalarioEmpleado salarioEmpleado = new SalarioEmpleado();
                    System.out.println("Dime el dni del empleado que desea buscar");
                    scanner.nextLine();
                    dniEmpleado = scanner.nextLine();
                    salarioEmpleado.mostrarSalarioEmpleado(dniEmpleado);
                    break;

                case 3:
                    ModificarEmpleado empleado = new ModificarEmpleado();
                    System.out.println("Dime el dni del empleado");
                    scanner.nextLine();
                    dniEmpleado = scanner.nextLine();
                    System.out.println("1-Modificar Nombre");
                    System.out.println("2-Modificar DNI");
                    System.out.println("3-Modificar sexo");
                    System.out.println("4-Modificar categoria");
                    System.out.println("5-Modificar anyos");
                    opcion = scanner.nextInt();
                    switch (opcion) {
                        case 1:
                            System.out.println("Modificar nombre");
                            System.out.println("Dime el nombre");
                            scanner.nextLine();
                            String nombre = scanner.nextLine();
                            empleado.editarNombre(nombre,dniEmpleado);
                            break;
                        case 2:
                            System.out.println("Modificar dni");
                            System.out.println("Dime el dni");
                            scanner.nextLine();
                            String dni = scanner.nextLine();
                            empleado.editarDni(dni,dniEmpleado);
                            break;
                        case 3:
                            System.out.println("Modificar sexo");
                            System.out.println("Dime el dni");
                            scanner.nextLine();
                            String sexo = scanner.nextLine();
                            empleado.editarSexo(sexo,dniEmpleado);
                            break;
                        case 4:
                            System.out.println("Modificar categoria");
                            System.out.println("Dime el dni");
                            scanner.nextLine();
                            int categoria = scanner.nextInt();
                            empleado.editarCategoria(categoria,dniEmpleado);
                            break;
                        case 5:
                            System.out.println("Modificar amyos");
                            System.out.println("Dime el dni");
                            scanner.nextLine();
                            int anyos = scanner.nextInt();
                            empleado.editarAnyos(anyos,dniEmpleado);
                            break;
                        default:
                            System.out.println("Opcion no valida");
                    }
                    break;
                case 4:
                    System.out.println("Saliendo");
                    break;
                default:
                    System.out.println("Elige bien el numero");
            }
        }while (opcion!=4);

    }
    private static void escribe(Empleado e) {
        Nomina calcularNomina = new Nomina();
        e.imprime();
        calcularNomina.sueldo(e);

    }
}


