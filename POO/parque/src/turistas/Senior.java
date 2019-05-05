package turistas;
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
    public Senior(String nombre, String apellido1, String apellido2, String nacimiento){
        super(nombre,apellido1,apellido2,nacimiento);
        descTipoTurista=35;
    }
}
