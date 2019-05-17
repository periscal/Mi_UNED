package entradas;

import turistas.Turista;
import java.time.LocalDateTime;
/**
 * Write a description of class ETarde here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
