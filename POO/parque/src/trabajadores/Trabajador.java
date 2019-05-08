package trabajadores;
import principal.*;
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
    public static List<Trabajador> trabajadores = new ArrayList<>();
    public static int contadorIdTrabajador=0;
    protected int  idTrabajador;
    protected float sueldo;
    /**
     */
    public Trabajador(){
        this.idTrabajador = contadorIdTrabajador++;
        trabajadores.add(this);
    }
    public Trabajador(String nombre, String apellidos, float sueldo){
        super(nombre,apellidos);
        this.idTrabajador = contadorIdTrabajador++;
        this.sueldo = sueldo;
        trabajadores.add(this);
    }
}
