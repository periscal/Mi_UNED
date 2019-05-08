package principal;
/**
 * Abstract class Persona - write a description of the class here
 * 
 * @author: 
 * Date: 
 */
public abstract class Persona
{
    protected String nombre;
    protected String apellidos;
    /**
     */
    public Persona(){
    }
    public Persona(String nombre, String apellidos)
    {
        this.nombre     = nombre;
        this.apellidos  = apellidos;
    }
}
