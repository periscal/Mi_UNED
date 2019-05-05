package turistas;
import principal.Persona;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    protected LocalDate nacimiento;
    protected long  idTurista; 
    protected float descTipoTurista;
    /**
     */
    public Turista(){
        this.idTurista = contadorIdTurista++;
    }
    public Turista(String nombre, String apellido1, String apellido2, String nacimiento){
        super(nombre, apellido1, apellido2);
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.nacimiento = LocalDate.parse(nacimiento, formatter);
        
        this.idTurista = contadorIdTurista++;
    }
   
}
