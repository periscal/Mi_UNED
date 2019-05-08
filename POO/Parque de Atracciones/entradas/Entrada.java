package entradas;

import turistas.Turista;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
/**
 * Abstract class Entrada - write a description of the class here
 * 
 * @author: 
 * Date: 
 */
public abstract class Entrada
{
    // Valores estaticos, iguales para todos las instancias de tipo "Entrada"
    public static List<Entrada> entradas = new ArrayList<>();
    public static float precioBase = 60;
    public static float costeVIP = 50;
    public static float porcenMinimo = 10;
    public static float precioMinimo = precioBase*porcenMinimo/100;
    
    //Valores para cada Entrada
    protected LocalDateTime fechaEntrada;
    protected float precioEntrada;
    protected boolean sumplementoVIP;

    public Entrada(Turista p, LocalDateTime fecha, boolean vip){
        this.fechaEntrada=fecha;
        this.precioEntrada = precioBase;
        if(vip) this.precioEntrada += p.getDescuentoTipoTurista()*costeVIP/100;
        entradas.add(this);
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
    public float precioEntrada() {return precioEntrada;}
    public LocalDateTime fechaEntrada() {return fechaEntrada;}
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
