import java.util.List;
import java.util.ArrayList;
/**
 * Abstract class Trabajador - write a description of the class here
 * 
 * @author: 
 * Date: 
 */
public abstract class Trabajador extends Persona
{
    // instance variables - replace the example below with your own
    public static List<Turista> turistas = new ArrayList<>();
    public static long contadorIdTrabajador=0;
    protected long  idTrabajador;

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y    a sample parameter for a method
     * @return        the sum of x and y 
     */
    public Trabajador(String nombre, String apellido1, String apellido2){
        super(nombre,apellido1,apellido2);
        this.idTrabajador = contadorIdTrabajador++;
    }
}
