package turistas;

import principal.Persona;
import java.util.Map;
import java.util.HashMap;
import java.time.LocalDate;
/**
 * <p> Clase que representa a un tipo de turista (cliente) en el parque de atracciones</p>
 * <p> Las características que se tienen en cuenta para definir todo turista
 *  son su nombre y apellidos, y su fecha de nacimiento</p>
 * <p> Para dar cuenta de todas los turistas, se dispone como atributos de clase un HashMap que
 *  almacena todos los turistas que han visitado el parque, además de un contador del total de los mismos</p>
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
	 * <h1><i>Turista</i></h1>
	 * <p><code>public Turista(String nombre, String apellidos, LocalDate nacimiento)</code></p>
	 * <p> Construye un objeto Turista </p>
	 * @param nombre - nombre del turista
	 * @param apellidos - apellidos turista
	 * @param nacimiento - fecha nacimiento turista
	 */
	public Turista(String nombre, String apellidos, LocalDate nacimiento){
		super(nombre, apellidos);
		this.nacimiento = nacimiento;
		this.idTurista = contadorIdTurista++;
		turistas.put(idTurista,this);
	}

	/**
	 * <h1><i>getDescuentoTipoTurista</i></h1>
	 * <p><code>public float getDescuentoTipoTurista()</code></p>
	 * <p> Indica el tipo de descuento aplicado en función del tipo de turista</p>
	 * @return el porecentaje de descuento asociado al tipo de turista
	 */
	public float getDescuentoTipoTurista() {return descTipoTurista;}

	/**
	 * <h1><i>altaTurista</i></h1>
	 * <p><code>public static Turista altaTurista (String nombre, String apellidos, LocalDate nacimiento, LocalDate ahora)</code></p>
	 * <p> Crea y devuelve un objeto que hereda de turista, correspondiente a los parámetros introducidos.
	 * Este puede ser <code>Nino</code>, <code>Adulto</code> o <code>Senior</code></p>
	 * @param nombre - nombre del turista
	 * @param apellidos - apellidos turista
	 * @param nacimiento - fecha nacimiento turista
	 * @param ahora - momento en el que se realiza el alta del turista
	 * @return un objeto <code>Turista</code>
	 */
	public static Turista altaTurista (String nombre, String apellidos, LocalDate nacimiento, LocalDate ahora) {
		Turista t =null;
		int edad = nacimiento.until(ahora).getYears();

		if(edad<=12) t = new Nino(nombre,apellidos,nacimiento);
		else if(edad > 12 && edad<65) t = new Adulto(nombre,apellidos,nacimiento);
		else if (edad >=65) t = new Senior(nombre,apellidos,nacimiento);

		return t;
	}
}
