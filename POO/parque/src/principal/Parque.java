package principal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import atracciones.*;
import entradas.*;
import trabajadores.*;
import turistas.*;

/**
 * Write a description of class parque here.
 * 
 * @author Periscal Porteiro, Juan
 * @version 17/05/2019
 */
public class Parque
{   
	public static LocalDateTime fechaActual=LocalDateTime.now();
	public static final int ANO =2019;
	// ===== Generación aleatoria de numeros
	static	Random aleatorizador = new Random();
	static Estadisticas estadisticas= new Estadisticas(ANO);
	static AtraccionesFuncionando gastoPersonal = new AtraccionesFuncionando(ANO);

	public static void main(String[] args){

		generarAtracciones();
		generarTrabajadores();
		generarTuristas();
		//GUI
		GUI gui = new GUI();
		gui.setVisible(true);
	}
	public static void generarAtracciones() {
		// ===== Creación de Atracciones
		//-- Atracciones Tipo A
		for(int i = 0;i<4; i++) new AtraccA();
		//-- Atracciones Tipo B
		for(int i = 0;i<6; i++) new AtraccB();
		//-- Atracciones Tipo C
		for(int i = 0;i<4; i++) new AtraccC();
		//-- Atracciones Tipo D
		for(int i = 0;i<3; i++) new AtraccD();	
		//-- Atracciones Tipo E
		for(int i = 0;i<7; i++) new AtraccE();
	}
	
	public static void generarTrabajadores() {
		for(Atraccion a : Atraccion.atracciones.values()) {

			String nombre ="NombreResponsable_"+Trabajador.contadorIdTrabajador;
			String apellidos="ApellidosResponsable_"+Trabajador.contadorIdTrabajador;
			a.setResponsable(new TResponsableAtr(nombre,apellidos));

			for(int i =0; i<a.getNumAyudantes();i++) {
				nombre ="Ayudante_"+Trabajador.contadorIdTrabajador;
				apellidos="ApellidosAyudante_"+Trabajador.contadorIdTrabajador;
				a.setAyudanteAtr(new TAyudanteAtr(nombre,apellidos));
			}
		}
	}

	public static void generarTuristas() {
		// Se recorre cada dia del año 2019 empezando por el 2019-01-01
		LocalDate fecha = LocalDate.of(ANO, 01, 01);
		LocalDate fechafin = fecha.plusYears(1);
		//Mientras la fecha sea anterior a la del año siguiente se irán recorriendo los dias del año
		while(fecha.isBefore(fechafin)) {

			for(int grupo=0; grupo<aleatorizador.nextInt(30); grupo++) {
				List<Turista> grupoTuristas = new ArrayList<>();

				//Hora aleatoria
				LocalTime horaRandom =  LocalTime.of(aleatorizador.nextInt(24), aleatorizador.nextInt(60));

				//Contamos los adultos, niños y senior que forman el grupo
				int numAdultos =0;
				int numNinos =0;
				int numSenior =0;

				//Siempre irá almenos un adulto (incluyendo senior dentro deste)
				String nombre ="Tnombre_"+Turista.contadorIdTurista;
				String apellidos="Tapellidos_"+Turista.contadorIdTurista;
				LocalDate nacimiento=LocalDate.now().minusYears(aleatorizador.nextInt(47)+18); 
				Turista tu= Turista.altaTurista(nombre, apellidos, nacimiento, fechaActual.toLocalDate());
				grupoTuristas.add(tu);

				int otrosMiembros = aleatorizador.nextInt(8); //Maximo numero de miembros grupo = 8
				
				//Selección aleatoria del tipo de turista que será cada miembro del grupo
				for(int miembro=0;miembro<otrosMiembros;miembro++) {
					nombre ="Tnombre_"+Turista.contadorIdTurista;
					apellidos="Tapellidos_"+Turista.contadorIdTurista;
					nacimiento=LocalDate.now().minusYears(aleatorizador.nextInt(100)); 
					tu= Turista.altaTurista(nombre, apellidos, nacimiento, fecha);
					grupoTuristas.add(tu);
					if(Adulto.class.isInstance(tu)) numAdultos++;
					else if(Nino.class.isInstance(tu)) numNinos++;
					else if(Senior.class.isInstance(tu)) numSenior++;
					
					//El turista realiza las visitas a direntes atracciones
					for(int id=0; id<aleatorizador.nextInt(Atraccion.contadorIdAtraccion);id++) {
						Atraccion.atracciones.get(aleatorizador.nextInt(Atraccion.contadorIdAtraccion)).nuevaVisita(LocalDateTime.of(fecha, horaRandom));
					}
				}
				//Creación de las entradas correspondientes a cada grupo de Turistas
				for(Turista t : grupoTuristas) {
					LocalDateTime momento = LocalDateTime.of(fecha, horaRandom);
					// Creación de las entradas según las características..
					Entrada.nuevaEntrada(t, momento, aleatorizador.nextBoolean(), (grupo ==4 && numAdultos==2 && numNinos==2));
				}
			}
			fecha=fecha.plusDays(1); //Pasamos al siguiente dia del año
		}
	}
}

