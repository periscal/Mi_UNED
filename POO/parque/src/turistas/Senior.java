package turistas;

import java.time.LocalDate;
/**
 * Write a description of class Senior here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Senior extends Adulto
{
    /**
     * Constructor for objects of class Senior
     */
    public Senior(String nombre, String apellidos, LocalDate nacimiento){
        super(nombre,apellidos,nacimiento);
        descTipoTurista=35;
    }
}
