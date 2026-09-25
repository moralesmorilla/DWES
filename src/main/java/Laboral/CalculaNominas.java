/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Laboral;

import java.io.*;

/**
 *
 * @author usuario26
 */
public class CalculaNominas {
    
    public static void main(String[] args) {

        int categoria;
        int anyos;
        //Creamos ambos empleados
            String nombreArchivo="empleados";
            String ruta = "D:\\DAW2\\DWES\\DWES\\src\\main\\java\\Laboral\\"+nombreArchivo+".txt";

        try{
            BufferedReader br = new BufferedReader(new FileReader(ruta));
            StringBuilder contenido = new StringBuilder();
            String linea;

                while ((linea = br.readLine()) != null){

                    String[] datos = linea.split(";");
                    String name = datos[0];
                    String dni = datos[1];
                    char sexo = datos[2].charAt(0);
                    Empleado empleado;
                    if(datos.length <= 3){
                        empleado = new Empleado(name,dni,sexo);

                    }else{
                    categoria = Integer.parseInt(datos[3]);
                    anyos = Integer.parseInt(datos[4]);
                    empleado = new Empleado(name,dni,sexo,categoria,anyos);
                    }
                    escribe(empleado);
                    contenido.append(name)
                            .append(";")
                            .append(dni)
                            .append(";")
                            .append(sexo)
                            .append(";")
                            .append(empleado.getCategoria())
                            .append(";")
                            .append(empleado.getAnyos())
                            .append("\n");
                }
                br.close();

                BufferedWriter bw = new BufferedWriter(new FileWriter(ruta));
                bw.write(contenido.toString());
                bw.close();

            }catch (IOException e){
                System.out.println(e);



}

    }
    private static void escribe(Empleado e) {
        Nomina calcularNomina = new Nomina();
        e.imprime();
        calcularNomina.sueldo(e);
    }
}
