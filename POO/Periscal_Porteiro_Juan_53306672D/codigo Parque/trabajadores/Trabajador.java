package trabajadores;
import principal.*;
import java.util.Map;
import java.util.HashMap;
/**
 * <p> Clase que representa a un trabajador en el parque de atracciones</p>
 * <p> Las características que se tienen en cuenta para definir todo trabajador
 *  son su nombre y apellidos, y su sueldo</p>
 * <p> Para dar cuenta de todas los trabajadores, se dispone como atributos de clase un HashMap que
 *  almacena todos los trabajadores del parque, además de un contador del total de los mismos</p>
 * @author Periscal Porteiro, Juan
 * @version 17/05/2019
 */
public abstract class Trabajador extends Persona
{
    // instance variables - replace the example below with your own
    public static Map<Integer,Trabajador> trabajadores = new HashMap<>();
    public static int contadorIdTrabajador=0;
    public static final float SUELDOBASE = 950;
    
    protected int  idTrabajador;
    protected float sueldo;
    
	/**
	 * <h1><i>Trabajador</i></h1>
	 * <p><code>public Trabajador(String nombre, String apellidos, float sueldo)</code></p>
	 * <p> Construye un objeto Trabajador </p>
	 * @param nombre - nombre del trabajador
	 * @param apellidos - apellidos trabajador
	 * @param sueldo - sueldo trabajador
	 */
    public Trabajador(String nombre, String apellidos, float sueldo){
        super(nombre,apellidos);
        this.idTrabajador = contadorIdTrabajador++;
        this.sueldo = sueldo;
        trabajadores.put(idTrabajador,this);
    }
    
    public float getSueldo() {return sueldo;}
}
