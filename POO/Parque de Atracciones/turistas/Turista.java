package turistas;

import principal.Persona;
import java.util.Map;
import java.util.HashMap;
import java.time.LocalDate;
/**
 * Abstract class Turista - write a description of the class here
 * 
 * @author Periscal Porteiro, Juan
 * @version 17/05/2019
 */
public abstract class Turista extends Persona
{
    // Valores estaticos, iguales para todos las instancias de tipo "Turista"
    public static Map<Integer, Turista> turistas = new HashMap<>();
    public static int contadorIdTurista=0;
    
    //Atributos para cada Turista
    protected LocalDate nacimiento;
    protected int  idTurista; 
    protected float descTipoTurista;
    /**
     */
    public Turista(){
        this.idTurista = contadorIdTurista++;
        turistas.put(idTurista,this);
    }
    public Turista(String nombre, String apellidos, LocalDate nacimiento){
        super(nombre, apellidos);
        this.nacimiento = nacimiento;
        this.idTurista = contadorIdTurista++;
        turistas.put(idTurista,this);
    }
    
    public float getDescuentoTipoTurista() {return descTipoTurista;}
    
    public static Turista altaTurista (String nombre, String apellidos, LocalDate nacimiento, LocalDate ahora) {
    	Turista t =null;
    	int edad = nacimiento.until(ahora).getYears();
    	
    	if(edad<=12) t = new Nino(nombre,apellidos,nacimiento);
    	else if(edad > 12 && edad<65) t = new Adulto(nombre,apellidos,nacimiento);
    	else if (edad >=65) t = new Senior(nombre,apellidos,nacimiento);
    	
		return t;
    }
}
