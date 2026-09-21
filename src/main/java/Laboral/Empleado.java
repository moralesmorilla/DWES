/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Laboral;

/**
 *
 * @author usuario26
 */
public class Empleado implements Persona {
    private String nombre,dni;
    private Character sexo;
    private int categoria;
    private int anyos;

    public Empleado() {
    }

    public Empleado (String nombre, String dni, Character sexo, int categoria, int anyos) {
        if (categoria < 0 || categoria > 10) {
            this.categoria = 1;
        } else {
            this.categoria = categoria;
        }

        if (anyos < 0) {
            this.anyos = 0;
        } else {
            this.anyos = anyos;
        }
        if(nombre.isEmpty() || nombre==null){
            throw new  DatosNoCorrectosException("Datos no correctos");
        }
        if(dni.isEmpty() || dni==null){
            throw new DatosNoCorrectosException("Datos no correctos");
        }
        if(sexo == null){
            throw new DatosNoCorrectosException("Datos no correctos");
        }
        this.nombre = nombre;
        this.dni = dni;
        this.sexo = sexo;
    }

    public Empleado ( String nombre, String dni, Character sexo) {
        if(nombre.isEmpty() || nombre==null){
            throw new  DatosNoCorrectosException("Datos no correctos");
        }
        if(dni.isEmpty() || dni==null){
            throw new DatosNoCorrectosException("Datos no correctos");
        }
        if(sexo == null){
            throw new DatosNoCorrectosException("Datos no correctos");
        }

        this.nombre = nombre;
        this.dni = dni;
        this.sexo = sexo;
        this.categoria=1;
        this.anyos=0;
    }

    public void setCategoria (int categoria) {
        this.categoria = categoria;
    }

    public int getCategoria () {
        return this.categoria;
    }

    public void incrAnyo () {
        this.anyos ++;
    }
    public int getAnyos(){
        return anyos;
    }



    @Override
    public void setDni(String dni) {
        this.dni=dni;
    }

    @Override
    public void imprime () {
        System.out.println("Nombre: " + this.nombre +
                           "\nDNI: " + this.dni + 
                           "\nSexo: " + this.sexo + 
                           "\nCategoria: " + this.categoria + 
                           "\nAnyos trabajados: " + this.anyos
        );
    }
    
    
    
}
