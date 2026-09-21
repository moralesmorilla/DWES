/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Laboral;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author usuario26
 */
public class CalculaNominas {
    
    public static void main(String[] args) {
        Empleado empleado;
        String name ="";
        String dni="";
        char sexo=' ';
        int categoria;
        int anyos;
        //Creamos ambos empleados
            String ruta = "C:\\Users\\usuario26\\Documents\\NetBeansProjects\\DWES\\EvaluacionInicial\\src\\main\\resources\\empleados.txt";
            try(BufferedReader br = new BufferedReader(new FileReader(ruta))){
                String linea;
                while ((linea = br.readLine()) != null){

                    System.out.println(linea);
                    String[] datos = linea.split(";");
                    if(datos.length <= 3){
                        name = datos[0];
                        dni = datos[1];
                        sexo = datos[2].charAt(0);
                        categoria=1;
                        anyos=0;
                        empleado = new Empleado(name,dni,sexo);
                    }else{
                    name = datos[0];
                    dni = datos[1];
                    sexo = datos[2].charAt(0);
                    categoria = Integer.parseInt(datos[3]);
                    anyos = Integer.parseInt(datos[4]);
                    empleado = new Empleado(name,dni,sexo,categoria,anyos);

                    }
                    escribe(empleado);
                }

            }catch (IOException e){
                System.out.println(e);

//            //Llamamos al metodo privado escribe para ver dicha información
//            escribe(James);
//            System.out.println("------------------------");
//            escribe(Ada);
//            //Incrementamos los anios trabajado del segundo empleado
//            System.out.println("---------------------");
//            Ada.incrAnyo();
//            System.out.println("Incrementamos anios");
//            System.out.println("---------------------");
//            //Categoria del primero lo ponemos en 9
//            System.out.println("---------------------");
//            System.out.println("Cambio de categoria");
//            James.setCategoria(9);
//            System.out.println("------------------------");
//            escribe(James);
//            escribe(Ada);

}

    }
    private static void escribe(Empleado e) {
        Nomina calcularNomina = new Nomina();
        e.imprime();
        calcularNomina.sueldo(e);
    }
}
