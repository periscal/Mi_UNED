import java.time.LocalDateTime;
/**
 * Abstract class Entrada - write a description of the class here
 * 
 * @author: 
 * Date: 
 */
public abstract class Entrada
{
    // Valores estaticos, iguales para todos las instancias de tipo "Entrada"
    public static float precioBase = 60;
    public static float costeVIP = 50;
    public static float porcenMinimo = 10;
    public static float precioMinimo = precioBase*porcenMinimo/100;
    
    //Valores para cada Entrada
    protected LocalDateTime fecha;
    protected float precioEntrada;
    protected boolean sumplementoVIP;

    public Entrada(Persona p, LocalDateTime fecha){
        this.fecha=fecha;
        this.precioEntrada = precioBase;
    }
    
    /**
     * <h2><i> descontar </i></h2>
     * <p><code> public void descontar(float porcenDesc)</code></p>
     * <p>Aplica un descuento al precio de la entrada</p>
     * @param porcenDesc - porcentaje de descuento a aplicar al precio
     */
    public void descontar(float porcenDesc){
        float aux; 
        aux = precioEntrada*(1-porcenDesc);
        precioEntrada=(aux >= precioMinimo)? aux: precioMinimo; 
    }
    
    /**
     * <h2><i> aplicarVIP </i></h2>
     * <p><code> public void aplicarVIP()</code></p>
     * <p>Suma el coste asociado al suplemento VIP al precio de la entrada</p>
     */
    public abstract void aplicarVIP();
    
    /**
     * <h2><i> esVIP </i></h2>
     * <p><code> public boolean esVIP()</code></p>
     * <p>Indica si la entrada lleva asociado el 
     * suplemento VIP de "espera preferente".</p>
     * @return valor de suplementoVIP
     */
    public boolean esVIP(){
        return sumplementoVIP;
    }
}
