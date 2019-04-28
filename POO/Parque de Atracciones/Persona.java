/**
 * Abstract class Persona - write a description of the class here
 * 
 * @author: 
 * Date: 
 */
public abstract class Persona
{
    protected String nombre;
    protected String apellido1;
    protected String apellido2;
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y    a sample parameter for a method
     * @return        the sum of x and y 
     */
    public Persona(){
    }
    public Persona(String nombre, String apellido1, String apellido2)
    {
        this.nombre     = nombre;
        this.apellido1  = apellido1;
        this.apellido2  = apellido2;
    }
}
