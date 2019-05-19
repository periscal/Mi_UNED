package turistas;

import java.time.LocalDate;
/**
 * Clase que hereda de <code>Turista</code>.
 * @author Periscal Porteiro, Juan
 * @version 17/05/2019
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
