/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Laboral;

/**
 *
 * @author usuario26
 */
public class CalculaNominas {
    
    public static void main(String[] args) {
        //Creamos ambos empleados
        try {
            Empleado James = new Empleado("", "32000032G", 'M', 4, 7);
            Empleado Ada = new Empleado("Ada Lovelace", "32000031R", 'F');



            //Llamamos al metodo privado escribe para ver dicha información
            escribe(James);
            System.out.println("------------------------");
            escribe(Ada);
            //Incrementamos los anios trabajado del segundo empleado
            System.out.println("---------------------");
            Ada.incrAnyo();
            System.out.println("Incrementamos anios");
            System.out.println("---------------------");
            //Categoria del primero lo ponemos en 9
            System.out.println("---------------------");
            System.out.println("Cambio de categoria");
            James.setCategoria(9);
            System.out.println("------------------------");
            escribe(James);
            escribe(Ada);

        }catch (Error e){
            System.out.println(e.getMessage());
        }

    }
    private static void escribe(Empleado e) {
        Nomina calcularNomina = new Nomina();
        e.imprime();
        calcularNomina.sueldo(e);
    }


}
