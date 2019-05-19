package principal;
/**
 * Abstract class Persona - write a description of the class here
 * 
 * @author Periscal Porteiro, Juan
 * @version 17/05/2019
 */
public abstract class Persona
{
    protected String nombre;
    protected String apellidos;
    /**
     */
    public Persona(){}
    
    public Persona(String nombre, String apellidos)
    {
        this.nombre     = nombre;
        this.apellidos  = apellidos;
    }
    
	public String getNombre() {return nombre;}
	public String getApellidos() {return apellidos;} 
}
