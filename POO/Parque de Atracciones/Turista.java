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
    // Valores estaticos, iguales para todos las instancias de tipo "Turista"
    public static List<Turista> turistas = new ArrayList<>();
    public static long contadorIdTurista=0;
    
    //Atributos para cada Turista
    protected int nacimiento;
    protected long  idTurista; 
    protected float descTipoTurista;
    /**
     */
    public Turista(String nombre, String apellido1, String apellido2, String nacimiento){
        super(nombre, apellido1, apellido2, null);
        this.idTurista = contadorIdTurista++;
    }
   
}
