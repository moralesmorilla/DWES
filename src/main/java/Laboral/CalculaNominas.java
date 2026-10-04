package Laboral;

import Laboral.BBDD.ConexionBD;
import Laboral.BBDD.ModificarEmpleado;
import Laboral.BBDD.MostrarEmpleado;
import Laboral.BBDD.SalarioEmpleado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class CalculaNominas{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        menuPartes();
//        try{
//            menu();
//        }catch (SQLException e){
//            System.out.println(e);
//        }

    }

    private static void menuPartes(){
        Scanner scan = new Scanner(System.in);
        System.out.println("------------------------");
        System.out.println("Menu Partes:\n 0-Salir \n 1-Parte 1 \n 2-Parte 2");
        int opcion = scan.nextInt();
        switch (opcion){
            case 0:
                System.out.println("Saliendoooo");
                break;
            case 1:
                parte1();
                break;
            case 2:
                parte2();
                break;
            default:
                System.out.println("Opcion no valida");
        }
    }
    private static void parte2(){
        System.out.println("Parte 2 en preparacion");
        try{
            menuParte2();
        }catch (SQLException e){
            System.out.println(e);
        }

    }

    private static void menuParte2() throws SQLException {
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
    private static void parte1(){
        Empleado empleado1 = new Empleado("James Cosling","32000032G",'M',4,7);

        Empleado empleado2 = new Empleado("Ada Lovelace","32000031R",'F');
        System.out.println("Mostrar info ambos empleados");
        System.out.println("Empleado 1");
        escribe(empleado1);
        System.out.println("Empleado 2");
        escribe(empleado2);

        System.out.println("-------------------------");
        System.out.println("Incrementar años trabajados del segundo empleado");
        empleado2.incrAnyo();
        System.out.println("Cambiar categoria segundo empleado a 9");
        empleado1.setCategoria(9);

    }
    private static void escribe(Empleado e) {
        Nomina calcularNomina = new Nomina();
        e.imprime();
        calcularNomina.sueldo(e);

    }
}


