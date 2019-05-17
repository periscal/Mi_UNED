package entradas;

import turistas.Turista;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
/**
 * Abstract class Entrada - write a description of the class here
 * 
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

	public Entrada(Turista p, LocalDateTime ahora, boolean vip){
		this.fechaEntrada=ahora;
		this.precioEntrada = PRECIO_BASE;
		if(vip) this.precioEntrada += COSTE_VIP;
		this.precioEntrada*=(1-p.getDescuentoTipoTurista()/100);
		entradas.add(this);
	}

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
