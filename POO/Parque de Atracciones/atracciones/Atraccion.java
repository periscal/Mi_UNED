package atracciones;

import java.util.List;
import java.util.ArrayList;
import trabajadores.*;
/**
 * Abstract class Atraccion - write a description of the class here
 * 
 * @author: 
 * Date: 
 */
public abstract class Atraccion
{
    // Valores estaticos, iguales para todos las instancias de tipo "Turista"
    public static List<Atraccion> atracciones = new ArrayList<>();
    public static int contadorIdAtraccion=0;
    protected int  idAtraccion;// Todas las atracciones tienen que disponer de un identificador
    protected boolean adultos; // Toda atraccion debe especificar si se permiten adultos
    protected boolean ninos; // Toda atraccion debe especificar si se permiten niños
    protected float alturaMin; // Altura minima requerida de la atraccion si la hay
    protected float alturaMax; // Altura maxima requerida de la atraccion si la hay
    protected boolean permiteVIP; //Toda atraccion de especificar si permite usuarios VIP o no
    protected TResponsableAtr responsable; //Toda atraccion tiene que disponer de un responsable
    protected List<TAyudanteAtr> listaAyudantes; // Toda atraccion tiene al menos un ayudante de atraccion
    protected int numAyudantes;
    /**
     */
    public Atraccion(boolean adultos, boolean ninos, boolean permiteVIP,int numAyudantes){
        this.adultos = adultos;
        this.ninos = ninos;
        this.permiteVIP = permiteVIP;
        this.numAyudantes = numAyudantes;
        this.idAtraccion = contadorIdAtraccion++;
        atracciones.add(this);
    }
    
    /**
     * <h1><i>setResponsable</i></h1>
     * <p><code>public void setResponsable(TResponsableAtr res)</code></p>
     * <p> Especifica quien sera el responsable de la atraccion</p>
     * @param res - trabajador responsable de la atraccion
     */
    public void setResponsable(TResponsableAtr res){
        this.responsable = res;
    }
    /**
     * <h1><i>setAyudanteAtr</i></h1>
     * <p><code>public abstract void setAyudanteAtr()</code></p>
     * <p>Añade un ayudante de atraccion a la lista de ayudantes sin superar el maximo</p>
     * @param ayudante - trabajador ayudante
     * @return verdadero si ha sido posible añadir un nuevo ayudante, falso en caso contrario
     */
    public boolean setAyudanteAtr(TAyudanteAtr ayudante){
        boolean aux = false;
        if(listaAyudantes.size()<numAyudantes){
            listaAyudantes.add(ayudante);
            aux = true;
        }
        return aux;
    }
    
    /**
     * <h1><i>getResponsable</i></h1>
     * <p><code>public TResponsableAtr getResponsable()</code></p>
     * <p>Devuleve el responsable de la atraccion</p>
     * @return el trabajador tipo TResponsableAtr de la atraccion
     */
    public TResponsableAtr getResponsable(){
        return responsable;
    }
    
    /**
     * <h1><i>getAyudantes</i></h1>
     * <p><code>public List<TAyudanteAtr> getAyudantes()</code></p>
     * <p></p>
     * @return la lista de los ayudantes del responsable de la atracion
     */
    public List<TAyudanteAtr> getAyudantes(){
        return listaAyudantes;
    }
}
