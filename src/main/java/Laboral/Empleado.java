/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Laboral;

/**
 *
 * @author usuario26
 */
public class Empleado extends Persona {
    private int categoria;
    private int anyos;

    public Empleado() {
        super();
    }

    public Empleado (String nombre, String dni, Character sexo, int categoria, int anyos) {
        super(nombre,dni,sexo);
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

    }
    public Empleado(String nombre,String dni,  Character sexo) {
        super(nombre,dni,sexo);
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

    public void setAnyos(int anyos) {
        this.anyos = anyos;
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
        System.out.println("Nombre: " + nombre +
                           "\nDNI: " + dni +
                           "\nSexo: " + sexo +
                           "\nCategoria: " + categoria +
                           "\nAnyos trabajados: " + anyos
        );
    }
    
    
    
}
