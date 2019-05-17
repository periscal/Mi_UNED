package turistas;

import java.time.LocalDate;
/**
 * Write a description of class Nino here.
 * 
 * @author Periscal Porteiro, Juan
 * @version 17/05/2019
 */
public class Nino extends Turista{
    /**
     * Constructor for objects of class Nino
     */
    public Nino(String nombre, String apellidos, LocalDate nacimiento){
        super(nombre,apellidos,nacimiento);
        descTipoTurista=50;
    }
}
