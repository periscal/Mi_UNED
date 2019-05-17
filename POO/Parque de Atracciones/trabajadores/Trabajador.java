package trabajadores;
import principal.*;
import java.util.Map;
import java.util.HashMap;
/**
 * Abstract class Trabajador - write a description of the class here
 * 
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
     */
    public Trabajador(){
        this.idTrabajador = contadorIdTrabajador++;
        trabajadores.put(idTrabajador,this);
    }
    public Trabajador(String nombre, String apellidos, float sueldo){
        super(nombre,apellidos);
        this.idTrabajador = contadorIdTrabajador++;
        this.sueldo = sueldo;
        trabajadores.put(idTrabajador,this);
    }
    
    public float getSueldo() {return sueldo;}
}
