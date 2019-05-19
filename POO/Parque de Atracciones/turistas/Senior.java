package turistas;

import java.time.LocalDate;
/**
 * Clase que hereda de <code>Adulto</code>.
 * @author Periscal Porteiro, Juan
 * @version 17/05/2019
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
