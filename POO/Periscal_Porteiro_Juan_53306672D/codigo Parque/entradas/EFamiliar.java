package entradas;

import turistas.Turista;
import java.time.LocalDateTime;
/**
 * Clase que hereda de <code>Entrada</code>.
 * 
 * @author Periscal Porteiro, Juan
 * @version 17/05/2019
 */
public class EFamiliar extends Entrada
{ 	
	/**
     * Constructor for objects of class EFamiliar
     */
    public EFamiliar(Turista p, LocalDateTime fecha,boolean vip){
        super(p,fecha,vip);
    }
}
