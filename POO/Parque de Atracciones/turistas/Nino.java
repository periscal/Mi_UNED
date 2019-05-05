package turistas;

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
    public Nino(String nombre, String apellido1, String apellido2, String nacimiento){
        super(nombre,apellido1,apellido2,nacimiento);
        descTipoTurista=50;
    }
}
