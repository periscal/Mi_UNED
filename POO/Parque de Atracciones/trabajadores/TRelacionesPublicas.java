package trabajadores;
/**
 * Write a description of class TRelacionesPublicas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TRelacionesPublicas extends Trabajador
{
    /**
     * Constructor for objects of class TRelacionesPublicas
     */
    public TRelacionesPublicas(String nombre, String apellidos){
        super(nombre,apellidos,TAyudanteAtr.SUELDOBASE*120/100);
    }
}
