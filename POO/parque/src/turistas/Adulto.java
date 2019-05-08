package turistas;

import java.time.LocalDate;
/**
 * Write a description of class Adulto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Adulto extends Turista
{
    /**
     * Constructor for objects of class Adulto
     */
    public Adulto(String nombre, String apellidos, LocalDate nacimiento){
        super(nombre,apellidos,nacimiento);
        descTipoTurista=0;
    }
}
