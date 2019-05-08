package entradas;

import turistas.Turista;
import java.time.LocalDateTime;
/**
 * Write a description of class EDiaLaborable here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EDiaLaborable extends Entrada
{
    /**
     * Constructor for objects of class EDiaLaborable
     */
    public EDiaLaborable(Turista p, LocalDateTime fecha,boolean vip){
        super(p,fecha,vip);
    }
    
    public void aplicarVIP(){
    }
}
