import java.util.List;
import java.util.ArrayList;
/**
 * Abstract class Turista - write a description of the class here
 * 
 * @author: 
 * Date: 
 */
public abstract class Turista extends Persona
{
    // instance variables - replace the example below with your own
    public static List<Turista> turistas = new ArrayList<>();
    public static long contadorIdTurista=0;
    protected int nacimiento;
    protected long  idTurista;   
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y    a sample parameter for a method
     * @return        the sum of x and y 
     */
    public Turista(String nombre, String apellido1, String apellido2, String nacimiento){
        super(nombre,apellido1,apellido2);
        this.idTurista = contadorIdTurista++;
    }
   
}
