package trabajadores;
/**
 * Write a description of class TAtencionCliente here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
