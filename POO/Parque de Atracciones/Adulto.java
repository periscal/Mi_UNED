
/**
 * Write a description of class Adulto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Adulto extends Turista
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Adulto
     */
    public Adulto(String nombre, String apellido1, String apellido2, String nacimiento)
    {
        super(nombre,apellido1,apellido2,nacimiento);
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
}
