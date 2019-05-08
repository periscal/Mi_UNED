package trabajadores;
/**
 * Write a description of class TAyudanteAtr here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TAyudanteAtr extends Trabajador
{
    public static final float sueldoBase = 950;
    /**
     * Constructor for objects of class TAyudanteAtr
     */
    public TAyudanteAtr(String nombre, String apellidos){
        super(nombre,apellidos,sueldoBase);
    }
}
