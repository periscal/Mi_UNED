package trabajadores;
/**
 * Clase que hereda de <code>Trabajador</code>.
 * @author Periscal Porteiro, Juan
 * @version 17/05/2019
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
