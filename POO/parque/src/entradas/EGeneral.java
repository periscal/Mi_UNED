package entradas;

import turistas.Turista;
import java.time.LocalDateTime;
/**
 * Write a description of class EGeneral here.
 * 
 * @author Periscal Porteiro, Juan
 * @version 17/05/2019
 */
public class EGeneral extends Entrada
{
    /**
     * Constructor for objects of class EGeneral
     */
    public EGeneral(Turista p, LocalDateTime fecha,boolean vip){
        super(p,fecha,vip);
    }
}
