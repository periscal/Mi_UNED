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
    public static int contadorIdTurista=0;
    
    //Atributos para cada Turista
    protected LocalDate nacimiento;
    protected int  idTurista; 
    protected float descTipoTurista;
    /**
     */
    public Turista(){
        this.idTurista = contadorIdTurista++;
        turistas.add(this);
    }
    public Turista(String nombre, String apellidos, LocalDate nacimiento){
        super(nombre, apellidos);
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.nacimiento = nacimiento;//LocalDate.parse(nacimiento, formatter);
        
        this.idTurista = contadorIdTurista++;
        turistas.add(this);
    }
    
    public float getDescuentoTipoTurista() {return descTipoTurista;}
}
