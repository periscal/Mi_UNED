package principal;

import java.time.LocalDate;
import java.time.Year;
import java.time.temporal.IsoFields;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import atracciones.Atraccion;
import trabajadores.Trabajador;

/**
 * La clase AtraccionesFuncionando  indicara, para un año natural, que atracciones de las que estan disponibles
 * estan activas (el usuario puede usarlas) o no. Las atracciones que esten inactivas implica que no requeriran
 * de los servicios de los trabajadores correspondientes, lo que hace fluctuar los costes laborales.
 * 
 * @author Periscal Porteiro, Juan
 * @version 17/05/2019
 */
public class AtraccionesFuncionando
{	
	private int ano;
	private int diasAno;
	// Datos de gastos
	private float promGastoDiario;	
	private float promGastoSemanal;
	private float promGastoMensual;
	private float promGastoAnual;

	private Map<Integer,Float> gastosDia;
	private Map<Integer,Float> gastosSemana;
	private Map<Integer,Float> gastosMes;

	/**
	 * <h1><i>AtraccionesFuncionando</i></h1>
	 * <p><code>public AtraccionesFuncionando(int ano)</code></p>
	 * <p> Construye un objeto AtraccionesFuncionando </p>
	 * @param ano - año para el que se realiza el analisis del gasto
	 */
	public AtraccionesFuncionando(int ano) {
		this.ano=ano;
		//Dias del año del cual realizamos las estadisticas
		diasAno = Year.of(ano).length();

		promGastoDiario = 0;	
		promGastoSemanal = 0;
		promGastoMensual = 0;
		promGastoAnual = 0;

		gastosDia	 = new HashMap<>(diasAno);
		gastosSemana= new HashMap<>(53);
		gastosMes	 = new HashMap<>(12);
	}

	public void calcular() {
		gastosDia.clear();
		gastosSemana.clear();
		gastosMes.clear();
		promGastoAnual=0;
		
		for(Atraccion a: Atraccion.atracciones.values()) {
			//Pagamos a los empleados cada uno de los 12 meses

			for (int mes =1; mes<=12;mes++) {
				sumaGasto(a.getResponsable().getSueldo(), LocalDate.of(ano, mes, 28));

				for(Trabajador t : a.getAyudantes()) sumaGasto(t.getSueldo(), LocalDate.of(ano, mes, 28));
			}
		}
		promGastoMensual = promGastoAnual/12;
		promGastoDiario = promGastoAnual/diasAno;
		promGastoSemanal = promGastoDiario*7;
	}

	private void sumaGasto(float cantidad, LocalDate fecha) {
		int dia = fecha.getDayOfYear();
		int semana =fecha.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR);
		int mes = fecha.getMonthValue();

		gastosDia.put(dia,gastosDia.getOrDefault(dia,(float)0)+cantidad);
		gastosSemana.put(semana,gastosSemana.getOrDefault(semana,(float)0)+cantidad);
		gastosMes.put(mes,gastosMes.getOrDefault(mes,(float)0)+cantidad);
		promGastoAnual +=cantidad;
	}
	
	public String[] listaAyudantes(int idAtraccion) {
		List<String> listaAyudantes= new ArrayList<>();
		for(Trabajador trabajador : Atraccion.atracciones.get(idAtraccion).getAyudantes()) listaAyudantes.add(trabajador.getNombre());
		return listaAyudantes.toArray(new String[0]);
	}

	// Metodos de gastos
	public float gastoDia	 (int fecha) {return gastosDia.getOrDefault(fecha,(float)0);}

	public float gastoSemana(int fecha) {return gastosSemana.getOrDefault(fecha,(float)0);}

	public float gastoMes	 (int fecha) {return gastosMes.getOrDefault(fecha,(float)0);}

	public float gastoAno	 (int fecha) {return gastoPromAno();}

	public float gastoPromDia	 () {return promGastoDiario;}

	public float gastoPromSemana () {return promGastoSemanal;}

	public float gastoPromMes	 () {return promGastoMensual;}

	public float gastoPromAno	 () {return promGastoAnual;}

}