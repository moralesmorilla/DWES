/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Laboral;

/**
 *
 * @author usuario26
 */
public class Nomina {

    public Nomina() {
    }

    private static final int sueldoBase[]
            = {50000, 70000, 90000, 110000, 130000,
                150000, 170000, 190000, 210000, 230000};
    
    public void sueldo(Empleado e) {
        int sueldo;
        if(e.getCategoria()>10){
            sueldo=sueldoBase[9];
        }else{
            sueldo = sueldoBase[e.getCategoria()];
        }
        System.out.println(sueldo + 5000 * e.getAnyos());

    }
    
}
