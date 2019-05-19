package entradas;

import turistas.Turista;
import java.time.LocalDateTime;
/**
 * Clase que hereda de <code>Entrada</code>.
 * 
 * @author Periscal Porteiro, Juan
 * @version 17/05/2019
 */
public class ETarde extends Entrada
{
    /**
     * Constructor for objects of class ETarde
     */
    public ETarde(Turista p, LocalDateTime fecha,boolean vip){
        super(p,fecha,vip);
    }
}
