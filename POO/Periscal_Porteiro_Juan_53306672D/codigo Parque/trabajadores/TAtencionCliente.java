package trabajadores;
/**
 * Clase que hereda de <code>Trabajador</code>.
 * @author Periscal Porteiro, Juan
 * @version 17/05/2019
 */
public class TAtencionCliente extends Trabajador
{
    /**
     * Constructor for objects of class TAtencionCliente
     */
    public TAtencionCliente(String nombre, String apellidos){
        super(nombre,apellidos,TAyudanteAtr.SUELDOBASE*110/100);
    }
}
