package entradas;

import turistas.Turista;
import java.time.LocalDateTime;
/**
 * Write a description of class EFamiliar here.
 * 
 * @author Periscal Porteiro, Juan
 * @version 17/05/2019
 */
public class EFamiliar extends Entrada
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class EFamiliar
     */
    public EFamiliar(Turista p, LocalDateTime fecha,boolean vip){
        super(p,fecha,vip);
    }
}
