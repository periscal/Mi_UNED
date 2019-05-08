package trabajadores;
/**
 * Write a description of class TResponsableAtr here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TResponsableAtr extends Trabajador
{
    /**
     * Constructor for objects of class TResponsableAtr
     */
    public TResponsableAtr(String nombre, String apellidos){
        super(nombre,apellidos,TAyudanteAtr.sueldoBase*115/100);
    }
}
