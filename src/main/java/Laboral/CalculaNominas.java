package Laboral;

import Laboral.BBDD.ModificarEmpleado;
import Laboral.BBDD.EmpleadoDAO;
import Laboral.BBDD.SalarioEmpleado;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.sql.SQLException;
import java.util.Scanner;

public class CalculaNominas{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        menu();
    }

    private static void menu(){
        Scanner scan = new Scanner(System.in);
        System.out.println("------------------------");
        int opcion;
        do{
            System.out.println("Menu Partes:\n 0-Salir \n 1-Parte 1 \n 2-Parte 2");
            opcion = scan.nextInt();
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
                    break;
            }
        }while (opcion!=0);
    }
    private static void parte1(){
        Empleado empleado1 = new Empleado("James Cosling","32000032G",'M',4,7);

        Empleado empleado2 = new Empleado("Ada Lovelace","32000031R",'F');
        System.out.println("Mostrar info ambos empleados");
        System.out.println("--------------------------------");
        System.out.println("Empleado 1");
        escribe(empleado1);
        System.out.println("-----------------------------");
        System.out.println("Empleado 2");
        escribe(empleado2);

        System.out.println("-------------------------");
        System.out.println("Incrementar años trabajados del segundo empleado");
        empleado2.incrAnyo();
        System.out.println("Cambiar categoria segundo empleado a 9");
        empleado1.setCategoria(9);
        System.out.println("---------------------------");
        System.out.println("Empleado 1");
        escribe(empleado1);
        System.out.println("-----------------------------");
        System.out.println("Empleado 2");
        escribe(empleado2);
        System.out.println("---------------------------");

    }
    private static void parte2(){
        System.out.println("Parte 2 en preparacion");
        System.out.println("-----------------------------------");
        try{
            Scanner scanner = new Scanner(System.in);
            int opcion;
            String dniEmpleado;
            do{
                System.out.println("Menu de Opciones");
                System.out.println("0-Salir");
                System.out.println("1-Alta de empleado");
                System.out.println("2-Mostar Informacion de empleados");
                System.out.println("3-Mostrar salario de un empleado por dni");
                System.out.println("4-Modificar Datos de un empleado");
                System.out.println("5-Recalcular y actualizar sueldo empleado");
                System.out.println("6-Recalcular y actualizar el sueldo de todos los empleados");
                System.out.println("7-Realizar copia de seguridad de la  base de datos en un fichero");
                opcion = scanner.nextInt();
                switch (opcion) {
                    case 0:
                        System.out.println("Saliendooooo...");
                        break;
                    case 1:
                        System.out.println("Alta Empleado");
                        System.out.println("1-Alta empleado por fichero");
                        System.out.println("2-Alta empleado por datos");
                        int newOpcion = scanner.nextInt();
                        if(newOpcion==1){
                            System.out.println("Alta empleado por fichero en proceso");
                            BufferedReader br = new BufferedReader(new FileReader("src/main/java/Laboral/BBDD/empleadosNuevos.txt"));
                            String line;
                            while ((line = br.readLine()) != null) {
                                String[] datos = line.split(",");
                                String dni = datos[0];
                                String nombre = datos[1];
                                char sexo = datos[2].charAt(0);
                                int categoria = Integer.parseInt(datos[3]);
                                int anyos = Integer.parseInt(datos[4]);
                                Empleado empleado = new Empleado(nombre,dni,sexo,categoria,anyos);
                                EmpleadoDAO empleadoDAO = new EmpleadoDAO();
                                empleadoDAO.altaEmpleado(empleado);

                            }
                        }else{
                            System.out.println("Dime dni");
                            String dni = scanner.nextLine();
                            System.out.println("Dime nombre");
                            String nombre = scanner.nextLine();
                            System.out.println("Dime sexo");
                            String sexo = scanner.nextLine();
                            System.out.println("Dime categoria");
                            int categoria = scanner.nextInt();
                            System.out.println("Dime anyos de antiguedad");
                            int anyos = scanner.nextInt();
                            Empleado empleado = new Empleado(nombre,dni,sexo.charAt(0),categoria,anyos);
                            EmpleadoDAO empleadoDAO = new EmpleadoDAO();
                            empleadoDAO.altaEmpleado(empleado);
                        }
                        break;
                    case 2:
                        System.out.println("Mostrar Informacion del empleado");
                        EmpleadoDAO e1 = new EmpleadoDAO();
                        e1.mostrarEmpleados();
                        break;
                    case 3:
                        System.out.println("Mostrar salario empleado especifico");
                        SalarioEmpleado salarioEmpleado = new SalarioEmpleado();
                        System.out.println("Dime el dni del empleado que desea buscar");
                        scanner.nextLine();
                        dniEmpleado = scanner.nextLine();
                        salarioEmpleado.mostrarSalarioEmpleado(dniEmpleado);
                        break;

                    case 4:
                        subMenu2();
                        break;
                    case 5:
                        System.out.println("Recalculando y actualizar sueldo empleado especifico");
                        System.out.println("Dime el dni del empleado que desea buscar");
                        scanner.nextLine();
                        dniEmpleado = scanner.nextLine();
                        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
                        Empleado empleado = empleadoDAO.mostrarEmpleado(dniEmpleado);
                        Nomina nomina = new Nomina();
                        int sueldo = nomina.sueldo(empleado);
                        System.out.println("El sueldo del empleado "+empleado.getNombre()+" con dni "+empleado.getDni()+" es: "+sueldo);
                        System.out.println("Actualizando sueldo en la base de datos");
                        empleadoDAO.actualizarSueldoEmpleado(dniEmpleado,sueldo);
                        break;
                    case 6:
                        System.out.println("Recalculando y actualizando sueldo de todos los empleados");
                        EmpleadoDAO empleadoDAO1 = new EmpleadoDAO();
                        empleadoDAO1.actualizarSueldoTodosEmpleados();
                        break;
                    case 7:
                        System.out.println("Realizando copia de seguridad en archivo copiaEmpleados");
                        break;
                    default:
                        System.out.println("Elige bien el numero");
                }
            }while (opcion!=0);

        }catch (SQLException | IOException e){
            System.out.println(e.getMessage());
        }

    }

    private static void subMenu2() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        ModificarEmpleado empleado = new ModificarEmpleado();
        System.out.println("Dime el dni del empleado");
        scanner.nextLine();
        String dniEmpleado = scanner.nextLine();
        System.out.println("1-Modificar Nombre");
        System.out.println("2-Modificar DNI");
        System.out.println("3-Modificar sexo");
        System.out.println("4-Modificar categoria");
        System.out.println("5-Modificar anyos");
        int opcion = scanner.nextInt();
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
    }

    private static void escribe(Empleado e) {
        Nomina calcularNomina = new Nomina();
        e.imprime();
        calcularNomina.sueldo(e);

    }
}


