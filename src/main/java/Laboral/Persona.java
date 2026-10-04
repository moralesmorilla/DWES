/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Laboral;

/**
 *
 * @author usuario26
 */
public class Persona {
    public String nombre,dni;
    public Character sexo;

    public Persona(String nombre,String dni, Character sexo) {
        if(nombre.isEmpty() || nombre==null || dni.isEmpty() || dni==null || sexo == null){
            throw new  DatosNoCorrectosException("Datos no correctos");
        }
        this.nombre = nombre;
        this.dni = dni;
        this.sexo = sexo;
    }

    public Persona(String nombre,Character sexo) {
        this.nombre=nombre;
        this.sexo=sexo;
    }

    public Persona() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public  void setDni(String dni){
        this.dni=dni;
    }

    public void imprime () {
        System.out.println("Nombre: " + this.nombre +
                "\nDNI: " + this.dni +
                "\nSexo: " + this.sexo
        );
    }
    
}
