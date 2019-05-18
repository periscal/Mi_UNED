package atracciones;

import java.util.List;
import java.util.Map;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import trabajadores.*;
/**
 * <p>Clase que representa una atracción del parque de atracciones. </p>
 * <p>En una atracción se deben definir diversas características como si acepta adultos y/o niños.
 * Cuál debe ser la altura máxima y/o mímina permitida para el acceso a la misma.
 * y, finalmente, si está activa o no.Y, si permite el uso de las ventajas de la bonificación VIP.</p>
 *  <p> También, respecto al personal del parque, un objeto Atraccion contiene 
 *  una lista de los ayudantes de atracción, así como también el trabajor responsable correspondiente</p>
 *  <p> Para dar cuenta de todas las atracciones, se dispone como atributos de clase un HashMap que almacena 
 *  todas las atracciones existentes, además de un contador del total de las mismas.</p>
 * @author Periscal Porteiro, Juan
 * @version 17/05/2019
 */
public abstract class Atraccion
{
	// Valores estaticos, iguales para todos las instancias de tipo "Turista"
	public static Map<Integer,Atraccion> atracciones = new HashMap<>();
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
	protected List<LocalDateTime> visitas; //Almacemana el momento de cada visita recibida
	protected boolean activa;

	/**
	 * <h1><i>Atraccion</i></h1>
	 * <p><code>public Atraccion(boolean adultos, boolean ninos, boolean permiteVIP,int numAyudantes)</code></p>
	 * <p> Construye un objeto Atraccion </p>
	 * @param adultos - booleano que indica si se permiten personas adultas en la atracción
	 * @param ninos - booleano que indica si se permiten niños en la atracción
	 * @param permiteVIP - booleano que indica si es posible aprovechar las ventajas del bono VIP en esta atracción
	 * @param numAyudantes - el número de ayudantes requerido por la atracción para su buen funcionamiento
	 */
	public Atraccion(boolean adultos, boolean ninos, boolean permiteVIP,int numAyudantes){
		this.adultos = adultos;
		this.ninos = ninos;
		this.permiteVIP = permiteVIP;
		this.numAyudantes = numAyudantes;
		this.idAtraccion = contadorIdAtraccion++;
		listaAyudantes = new ArrayList<>();
		visitas = new ArrayList<>();
		atracciones.put(idAtraccion,this);
		activa=true;
	}

	/**
	 * <h1><i>setResponsable</i></h1>
	 * <p><code>public void setResponsable(TResponsableAtr res)</code></p>
	 * <p> Especifica quien sera el responsable de la atraccion</p>
	 * @param res - trabajador responsable de la atraccion
	 */
	public void setResponsable(TResponsableAtr res){this.responsable = res;}

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
	public TResponsableAtr getResponsable(){return responsable;}

	/**
	 * <h1><i>getAyudantes</i></h1>
	 * <p><code>public List<TAyudanteAtr> getAyudantes()</code></p>
	 * <p></p>
	 * @return la lista de los ayudantes del responsable de la atracion
	 */
	public List<TAyudanteAtr> getAyudantes(){return listaAyudantes;}

	/**
	 * <h1><i>nuevaVisita</i></h1>
	 * <p><code>public void nuevaVisita(LocalDateTime visita)</code></p>
	 * <p>Añade a la lista de visitas de la atracción el instante
	 * que se produce la misma</p>
	 * @param visita - momento (fecha y hora) en el que se produce la visita
	 */
	public void nuevaVisita(LocalDateTime visita) {visitas.add(visita);}

	/**
	 * <h1><i>getVisitas</i></h1>
	 * <p><code> public List<LocalDateTime> getVisitas()</code></p>
	 * <p>Devuleve una lista con las fechas correspondientes 
	 * a las visitas recibidas por la atracción</p>
	 * @return la lista de las visitas recibidas por la atracción
	 */
	public List<LocalDateTime> getVisitas() { return visitas;}

	/**
	 * <h1><i>getNumAyudantes</i></h1>
	 * <p><code> public int getNumAyudantes() </code></p>
	 * <p>Devuleve el número total de ayudantes que debe tener la atracción</p>
	 * @return número entero de ayudantes necesarios
	 */
	public int getNumAyudantes() {return numAyudantes;}

	/**
	 * <h1><i>getId</i></h1>
	 * <p><code> public int getId() </code></p>
	 * <p>Devuleve el número identificador de la atracción</p>
	 * @return ID de la atracción
	 */
	public int getId() {return idAtraccion;}

	/**
	 * <h1><i>estaActiva</i></h1>
	 * <p><code> pestaActiva() </code></p>
	 * <p>Indica si la atracción está activa para su uso /p>
	 * @return estado de actividad de la atracción
	 */
	public boolean estaActiva() {return activa;}

	/**
	 * <h1><i>setActividad</i></h1>
	 * <p><code>public void setActividad(boolean estado) </code></p>
	 * <p>Activa o desactiva la atracción para su uso</p>
	 * @param nuevo estado de actividad de la atracción
	 */
	public void setActividad(boolean estado) {this.activa=estado;}
}
