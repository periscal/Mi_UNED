package trabajadores;
/**
 * Clase que hereda de <code>Trabajador</code>.
 * @author Periscal Porteiro, Juan
 * @version 17/05/2019
 */
public class TResponsableAtr extends Trabajador
{
    /**
     * Constructor for objects of class TResponsableAtr
     */
    public TResponsableAtr(String nombre, String apellidos){
        super(nombre,apellidos,Trabajador.SUELDOBASE*115/100);
    }
}
