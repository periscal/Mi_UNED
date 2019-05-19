package entradas;

import turistas.Turista;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
/**
 * <p>La clase <code>Entrada</code> representa una entrada emitida en el parque de atracciones
 * para cada nuevo turista</p>
 * <p>Las diferentes características que definen una entrada son: la fecha y hora a la que es emitida,
 * el tipo de turista que la recibe, si incluye bonificación VIP y, por supuesto, su precio</p>
 * <p> Para dar cuenta de todas las entradas, se dispone como atributos de clase una lista que
 *  almacena todas las entradas emitidas, además de un contador del total de las mismas</p>
 * @author Periscal Porteiro, Juan
 * @version 17/05/2019
 */
public abstract class Entrada
{
	// Valores estaticos, iguales para todos las instancias de tipo "Entrada"
	public static List<Entrada> entradas = new ArrayList<>();
	public static final float PRECIO_BASE = 60;
	public static final float COSTE_VIP = 50;
	public static final float PORCEN_MINIMO = 10;
	public static final float PRECIO_MINIMO = PRECIO_BASE*PORCEN_MINIMO/100;

	public static enum Descuentos{
		ESTUDIANTE(10), JOVEN(10), DISCAPACIDAD(20);

		private float porcentajeDesc;

		private Descuentos(float desc) { porcentajeDesc=desc;}
		public float getDescuento() {return porcentajeDesc;}
	}
	//Valores para cada Entrada
	protected LocalDateTime fechaEntrada;
	protected float precioEntrada;
	protected boolean sumplementoVIP;
	protected String ticket="";

	/**
	 * <h1><i>Entrada</i></h1>
	 * <p><code>public Entrada(Turista p, LocalDateTime ahora, boolean vip)</code></p>
	 * <p> Construye un objeto Entrada </p>
	 * @param turista - objeto <code>Turista</code> propietario de la entrada
	 * @param ahora - momento en el que se emite la entrada
	 * @param vip - booleano que indica si el turista escoge la bonificación VIP
	 */
	public Entrada(Turista turista, LocalDateTime ahora, boolean vip){
		this.fechaEntrada=ahora;
		this.precioEntrada = PRECIO_BASE;
		if(vip) this.precioEntrada += COSTE_VIP;
		this.precioEntrada*=(1-turista.getDescuentoTipoTurista()/100);
		entradas.add(this);
	}

	/**
	 * <h1><i> ticket </i></h1>
	 * <p><code> public String ticket()</code></p>
	 * <p> Imprime el ticket de la entrada adquirida en la que
	 * se indicará su hora, precio, tipo de entrada y tipo de turista</p>
	 * @param porcenDesc - porcentaje de decrementar a aplicar al precio
	 */
	public String ticket() {
		System.out.println(ticket+precioEntrada);
		return ticket+precioEntrada;
	}

	/**
	 * <h1><i> decrementar </i></h1>
	 * <p><code> public void decrementar(float porcenDesc)</code></p>
	 * <p>Aplica un decrementar al precio de la entrada</p>
	 * @param porcenDesc - porcentaje de decrementar a aplicar al precio
	 */
	public void decrementar(float porcenDesc){
		float aux; 
		aux = precioEntrada-PRECIO_BASE*porcenDesc/100;
		precioEntrada=(aux >= PRECIO_MINIMO)? aux: PRECIO_MINIMO; 
	}

	/**
	 * <h1><i> descuento </i></h1>
	 * <p><code> public void descuento(Descuentos d)</code></p>
	 * <p>Aplica uno de los descuentos contemplados en el enumerado Descuentos al precio de la entrada</p>
	 * @param tipoDescuento - tipo de descuento
	 */

	public void descuento(Descuentos tipoDescuento) {
		decrementar((float) tipoDescuento.getDescuento());
	}
	public float precioEntrada() {return precioEntrada;}
	public LocalDateTime fechaEntrada() {return fechaEntrada;}

	/**
	 * <h1><i> esVIP </i></h1>
	 * <p><code> public boolean esVIP()</code></p>
	 * <p>Indica si la entrada lleva asociado el 
	 * suplemento VIP de "espera preferente".</p>
	 * @return valor de suplementoVIP
	 */
	public boolean esVIP(){return sumplementoVIP;}

	/**
	 * <h1><i> nuevaEntrada </i></h1>
	 * <p><code> public static Entrada nuevaEntrada(Turista t, LocalDateTime ahora, boolean vip, boolean familiar)</code></p>
	 * <p>Crea un tipo de entrada según las carácterísticas del turista y de la fecha en la que se emite.</p>
	 * <p>
	 * <table>
	 * <tr><th></th><th></th></tr>
	 * <tr><td>{@link #EFamiliar}:
	 *     <td> En el caso de que la famillia conste de 2 adultos y dos niños
	 * <tr><td>{@link #EDiaLaborable}:
	 *     <td> Para las visitas en los lunes, martes, miércoles y jueves no festivos
	 * <tr><td>{@link #ETarde}:
	 *     <td> Para las entradas emitidas a partir de las 16:00, que no sean familiares.
	 * <tr><td>{@link #EGeneral}:
	 *     <td> Entrada estándar para cualquier turista cualquier dia del año.
	 *<tr><td>{@link #EOtra}:
	 *     <td> Para otras entradas diferentes de los demás tipos definidos.
	 * </table>
	 * </p>
	 * @param turista - el turista al que se le emite la entrada
	 * @param ahora - la fecha y hora en la que se emite la entrada
	 * @param vip - valor booleano que indica si solicita el acceso VIP
	 * @param familiar - valor booleano que indica si la entrada encaja en la familia tipo habitual 
	 */
	public static Entrada nuevaEntrada(Turista turista, LocalDateTime ahora, boolean vip, boolean familiar) {
		Entrada e = null;
		// Creación de las entradas según las características..
		if(familiar) e = new EFamiliar(turista,ahora,vip);

		else if (LocalTime.from(ahora).isAfter(LocalTime.of(16, 0))) e = new ETarde(turista,ahora,vip);

		else if (ahora.getDayOfWeek().equals(DayOfWeek.MONDAY) 	 ||
				ahora.getDayOfWeek().equals(DayOfWeek.TUESDAY)	 ||
				ahora.getDayOfWeek().equals(DayOfWeek.WEDNESDAY)||
				ahora.getDayOfWeek().equals(DayOfWeek.THURSDAY)) e = new EDiaLaborable(turista,ahora,vip);

		else e = new EGeneral(turista,ahora,vip);

		// Aumento o descuento en función de la temporada en las que se emite la entrada
		LocalDate fecha = ahora.toLocalDate();
		float precio = e.precioEntrada();
		if( fecha.isAfter(LocalDate.of(2018, 12, 31)) && fecha.isBefore(LocalDate.of(2019,1,9))
		 || fecha.isAfter(LocalDate.of(2019, 4, 14)) && fecha.isBefore(LocalDate.of(2019,4,22))
		 || fecha.isAfter(LocalDate.of(2019, 7, 31)) && fecha.isBefore(LocalDate.of(2019,9,1))
		 || fecha.isAfter(LocalDate.of(2019, 11, 30)) && fecha.isBefore(LocalDate.of(2020,1,1))) {
			precio+= PRECIO_BASE*(1+15/100);
			
		}else if(fecha.isAfter(LocalDate.of(2019, 1, 31)) && fecha.isBefore(LocalDate.of(2019,3,1))
			|| fecha.isAfter(LocalDate.of(2019, 10, 31)) && fecha.isBefore(LocalDate.of(2019,12,1))) {
			e.decrementar(15);
		}
		
		//Generación ticket
		e.ticket ="//////////////////////////\n"
				+ "Entrada Parque\n\n"
				+ "Nombre: "+turista.getNombre()+" "+turista.getApellidos()+"\n"
				+ "Fecha: "+ ahora.getDayOfMonth()+"-"+ahora.getMonthValue()+"-"+ahora.getYear()+"\n"
				+ "Hora: " + ahora.getHour()+":"+ahora.getMinute()+"\n\n"
				+ "Tipo turista: "+turista.getClass().getSimpleName()+"\n"
				+ "Tipo entrada: "+ e.getClass().getSimpleName()+"\n"
				+ "Precio: ";

		return e;
	}
}
