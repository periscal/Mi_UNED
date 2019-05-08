package principal;

import java.time.LocalDateTime;
import java.time.Year;
import java.util.HashMap;
import java.util.Map;
import entradas.Entrada;

/**
 * Write a description of class Estadisticas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Estadisticas
{

    private int ano;
    private int diasAno;

    // Estadisticas de visitantes
    private float promVisitDiario;	
    private float promVisitSemanal;
    private float promVisitMensual;
    private float promVisitAnual;
    public Map<Integer,Integer> visitantesDias;
    public Map<Integer,Integer> visitantesSemanas;
    public Map<Integer,Integer> visitantesMeses;

    // Estadisticas de Precios
    private float promPrecioDiario;	
    private float promPrecioSemanal;
    private float promPrecioMensual;
    private float promPrecioAnual;
    public Map<Integer,Float> preciosDia;
    public Map<Integer,Float> preciosSemana;
    public Map<Integer,Float> preciosMes;

    // Estadisticas de Atracciones

    public Estadisticas(int ano) {
        this.ano=ano;
        //Dias del año del cual realizamos las estadisticas
        diasAno = Year.of(ano).length();

        // Estadisticas de visitantes ========================================
        promVisitSemanal=0;
        promVisitMensual=0;
        promVisitAnual=0;
        visitantesDias	= new HashMap<>(diasAno); 
        visitantesSemanas= new HashMap<>(52); 
        visitantesMeses	= new HashMap<>(12); 
        // -----Se inicializan los valores de Map a '0'
        for(int dia =1; dia<= diasAno;dia++) visitantesDias.put(dia, 0);
        for(int semana =1; semana<= 52;semana++) visitantesSemanas.put(semana, 0);
        for(int mes =1; mes<= 12;mes++) visitantesMeses.put(mes, 0);

        // Estadisticas de Precios ========================================
        promPrecioDiario = 0;	
        promPrecioSemanal = 0;
        promPrecioMensual = 0;
        promPrecioAnual = 0;
        preciosDia	 = new HashMap<>(diasAno);
        preciosSemana= new HashMap<>(diasAno/7);
        preciosMes	 = new HashMap<>(12);
        // --- Se inicializan los valores de Map a '0'
        for(int dia =1; dia<= diasAno;dia++) preciosDia.put(dia, (float) 0);
        for(int semana =1; semana<= 52;semana++) preciosSemana.put(semana, (float) 0);
        for(int mes =1; mes<= 12;mes++) preciosMes.put(mes, (float) 0);

        // Estadisticas de Atracciones ========================================

    }	

    public void calcular() {
        LocalDateTime f; //Fecha entrada
        float p; // Precio entrada

        // El promedio de visitas anuales es equivalemte a todas las entradas a lo largo del 2019
        promVisitAnual = Entrada.entradas.size();
        promVisitMensual = promVisitAnual/12;
        promVisitDiario = promVisitAnual/diasAno;
        promVisitSemanal = promVisitDiario*7;

        for(Entrada e: Entrada.entradas) {
            f = e.fechaEntrada();
            int dia = f.getDayOfYear();
            int semana =dia/7+1;
            int mes = f.getMonthValue();

            // Estadisticas de visitantes ========================================
            visitantesDias.replace(dia,visitantesDias.get(dia)+1);
            visitantesSemanas.replace(semana,-1/*visitantesSemanas.get(semana)+1*/);
            visitantesMeses.replace(mes,visitantesMeses.get(mes)+1);

            // Estadisticas de Precios ========================================
            p = e.precioEntrada();
            promPrecioAnual +=p;
            preciosDia.replace(dia,preciosDia.get(dia)+p);
            preciosSemana.replace(semana,(float) -1/*preciosSemana.get(semana)+p*/);
            preciosMes.replace(mes,preciosMes.get(mes)+p);

            // Estadisticas de Atracciones ========================================
        }
    }

    // Metodos de visitantes
    public int visitantesDia	(int fecha) {return visitantesDias.get(fecha);}

    public int visitantesSemana	(int fecha) {return visitantesSemanas.get(fecha);}

    public int visitantesMes	(int fecha) {return visitantesMeses.get(fecha);}//YearMonth.of(ano, fecha).lengthOfMonth()
    public int visitantesAno	(int fecha) {return (int)promVisitAnual;}

    public float visitantesPromDia	 () {return promVisitDiario;}

    public float visitantesPromSemana() {return promVisitSemanal;}

    public float visitantesPromMes	 () {return promVisitMensual;}

    public float visitantesPromAno	 () {return promVisitAnual;}

    // Metodos de Precios
    public float precioDia	 (int fecha) {return preciosDia.get(fecha)/visitantesDia(fecha);}

    public float precioSemana(int fecha) {return preciosSemana.get(fecha)/visitantesSemana(fecha);}

    public float precioMes	 (int fecha) {return preciosMes.get(fecha)/visitantesMes(fecha);}

    public float precioAno	 (int fecha) {return precioPromAno();}

    public float precioPromDia	  () {return promPrecioDiario/promVisitDiario;}

    public float precioPromSemana () {return promPrecioSemanal/promVisitSemanal;}

    public float precioPromMes	  () {return promPrecioMensual/promVisitMensual;}

    public float precioPromAno	  () {return promPrecioAnual/promVisitAnual;}

    // Metodos de Atracciones
}
