package turistas;

import java.time.LocalDate;
/**
 * Write a description of class Nino here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
