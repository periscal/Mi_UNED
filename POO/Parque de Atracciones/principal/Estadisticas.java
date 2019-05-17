package principal;

import java.time.LocalDateTime;
import java.time.Year;
import java.time.temporal.IsoFields;
import java.util.HashMap;
import java.util.Map;
import atracciones.Atraccion;
import entradas.Entrada;

/**
 * Write a description of class Estadisticas here.
 * 
 * @author Periscal Porteiro, Juan
 * @version 17/05/2019
 */
public class Estadisticas
{
	public final int diasAno;

	// Estadisticas de visitantes
	private float promVisitDiario;	
	private float promVisitSemanal;
	private float promVisitMensual;
	private float promVisitAnual;
	private Map<Integer,Integer> visitantesDias;
	private Map<Integer,Integer> visitantesSemanas;
	private Map<Integer,Integer> visitantesMeses;

	// Estadisticas de Precios
	private float promPrecioAnual;
	private Map<Integer,Float> preciosDia;
	private Map<Integer,Float> preciosSemana;
	private Map<Integer,Float> preciosMes;

	// Estadisticas de Atracciones
	private Map<Integer, Map<Integer,Integer>>  atraccionesDia;
	private Map<Integer, Map<Integer,Integer>>  atraccionesSemana;
	private Map<Integer, Map<Integer,Integer>>  atraccionesMes;


	public Estadisticas(int ano) {
		//Dias del año del cual realizamos las estadisticas
		diasAno = Year.of(ano).length();

		// Estadisticas de visitantes ========================================
		promVisitSemanal=0;
		promVisitMensual=0;
		promVisitAnual=0;
		visitantesDias	= new HashMap<>(diasAno); 
		visitantesSemanas= new HashMap<>(53); 
		visitantesMeses	= new HashMap<>(12);

		// Estadisticas de Precios ========================================
		preciosDia	 = new HashMap<>(diasAno);
		preciosSemana= new HashMap<>(53);
		preciosMes	 = new HashMap<>(12);

		// Estadisticas de Atracciones ========================================
		atraccionesDia = new HashMap<>(diasAno);
		atraccionesSemana = new HashMap<>(53);
		atraccionesMes = new HashMap<>(12);
	}	

	/**
	 * <h1><i>calcular</i></h1>
	 * <p><code>public void calcular()</code></p>
	 * <p> Realiza todos los cálculos estadísticos en relación a las 
	 * entradas, turistas, trabajadores y atracciones</p>
	 */
	public void calcular() {
		LocalDateTime f; //Fecha entrada
		float p; // Precio entrada

		// El promedio de visitas anuales es equivalemte a todas las entradas a lo largo del 2019
		promVisitAnual = Entrada.entradas.size();
		promVisitMensual = promVisitAnual/12;
		promVisitDiario = promVisitAnual/diasAno;
		promVisitSemanal = promVisitDiario*7;

		preciosDia.clear();
		preciosSemana.clear();
		preciosMes.clear();
		promPrecioAnual=0;
		
		int dia=0;
		int semana=0;
		int mes=0;
		
		for(Entrada e: Entrada.entradas) {
			f = e.fechaEntrada();
			dia = f.getDayOfYear();
			semana =f.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR);
			mes = f.getMonthValue();

			// Estadisticas de visitantes ======================================
			visitantesDias.put(dia,visitantesDias.getOrDefault(dia,0)+1);
			visitantesSemanas.put(semana,visitantesSemanas.getOrDefault(semana,0)+1);
			visitantesMeses.put(mes,visitantesMeses.getOrDefault(mes,0)+1);

			// Estadisticas de Precios ========================================
			p = e.precioEntrada();
			promPrecioAnual +=p;
			preciosDia.put(dia,preciosDia.getOrDefault(dia,(float)0)+p);
			preciosSemana.put(semana,preciosSemana.getOrDefault(semana,(float)0)+p);
			preciosMes.put(mes,preciosMes.getOrDefault(mes,(float)0)+p);

		}
		// Estadisticas de Atracciones =======================================
		
		for(Atraccion a : Atraccion.atracciones.values()) {
			int idAtraccion = a.getId();
			Map<Integer, Integer> aD =	new HashMap<>();
			Map<Integer, Integer> as =	new HashMap<>();
			Map<Integer, Integer> aM =	new HashMap<>();

			for(LocalDateTime fechaHora : a.getVisitas() ) {
				dia = fechaHora.getDayOfYear();
				semana =fechaHora.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR);
				mes = fechaHora.getMonthValue();

				aD.put(dia,aD.getOrDefault(dia,0)+1);
				as.put(semana,as.getOrDefault(semana,0)+1);
				aM.put(mes,aM.getOrDefault(mes,0)+1);
			}
			atraccionesDia.put(idAtraccion,aD);
			atraccionesSemana.put(idAtraccion,as);
			atraccionesMes.put(idAtraccion,aM);
		}
	}

	// Metodos de visitantes
	public int visitantesDia	(int fecha) {return visitantesDias.getOrDefault(fecha,0);}

	public int visitantesSemana	(int fecha) {return visitantesSemanas.getOrDefault(fecha,0);}

	public int visitantesMes	(int fecha) {return visitantesMeses.getOrDefault(fecha,0);}
	public int visitantesAno	(int fecha) {return (int)promVisitAnual;}

	public float visitantesPromDia	 () {return promVisitDiario;}

	public float visitantesPromSemana() {return promVisitSemanal;}

	public float visitantesPromMes	 () {return promVisitMensual;}

	public float visitantesPromAno	 () {return promVisitAnual;}

	// Metodos de Precios
	public float precioDia	 (int fecha) {return preciosDia.getOrDefault(fecha,(float) 0)/visitantesDia(fecha);}

	public float precioSemana(int fecha) {return preciosSemana.getOrDefault(fecha,(float) 0)/visitantesSemana(fecha);}

	public float precioMes	 (int fecha) {return preciosMes.getOrDefault(fecha,(float) 0)/visitantesMes(fecha);}

	public float precioAno	 (int fecha) {return precioPromAno();}

	public float precioPromDia	  () {return precioPromAno();}

	public float precioPromSemana () {return precioPromAno();}

	public float precioPromMes	  () {return precioPromAno();}

	public float precioPromAno	  () {return promPrecioAnual/promVisitAnual;}

	// Metodos de Atracciones
	public int atraccionDia	 (int fecha, int idAtraccion) {	return atraccionesDia.get(idAtraccion).getOrDefault(fecha,0);}

	public int atraccionSemana (int fecha, int idAtraccion) {return atraccionesSemana.get(idAtraccion).getOrDefault(fecha,0);}

	public int atraccionMes	 (int fecha, int idAtraccion) {return atraccionesMes.get(idAtraccion).getOrDefault(fecha,0);}

	public int atraccionAno	 (int fecha, int idAtraccion) {
		int i = 0;
		for(int k=1; k<=12;k++) i+=atraccionesMes.get(idAtraccion).getOrDefault(k,0);
		return i
				;}

	public float atraccionPromDia	  (int idAtraccion) {return (float) atraccionAno(0,idAtraccion)/diasAno;}

	public float atraccionPromSemana  (int idAtraccion) {return atraccionPromDia(idAtraccion)*7;}

	public float atraccionPromMes	  (int idAtraccion) {return (float) atraccionAno(0,idAtraccion)/12;}

	public float atraccionPromAno	  (int idAtraccion) {return (float) atraccionAno(0,idAtraccion);}
}
