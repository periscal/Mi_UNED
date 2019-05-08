package principal;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import atracciones.*;
import entradas.*;
import turistas.*;
/**
 * Write a description of class parque here.
 * 
 * @author Periscal Porteiro, Juan
 * @version (a version number or a date)
 */
public class parque
{   
    public static GUI gui;

    // ===== Generación aleatoria de numeros
    static	Random aleatorizador = new Random();
    static Estadisticas estadisticas= new Estadisticas(2019);

    public static void main(String[] args){
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

        // Se recorre cada dia del año 2019 empezando por el 2019-01-01
        LocalDate fecha = LocalDate.of(2019, 01, 01);
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
                grupoTuristas.add(turistaRandom(1));
                int otrosMiembros = aleatorizador.nextInt(6); //Maximo numero de miembros grupo = 6
                //Selección aleatoria del tipo de turista que será cada miembro del grupo
                for(int miembro=0;miembro<otrosMiembros;miembro++) {
                    Turista t = turistaRandom(-1);
                    grupoTuristas.add(t);
                    Class claseTurista = t.getClass();
                    if(claseTurista.equals(Adulto.class)) numAdultos++;
                    else if(claseTurista.equals(Nino.class)) numNinos++;
                    else if(claseTurista.equals(Senior.class)) numSenior++;
                }
                //Creación de las entradas correspondientes a cada grupo de Turistas
                for(Turista t : grupoTuristas) {
                    LocalDateTime momento = LocalDateTime.of(fecha, horaRandom);
                    // Creación de las entradas según las características..
                    if(grupo ==4 && numAdultos==2 && numNinos==2) new EFamiliar(t,momento,aleatorizador.nextBoolean());
                    else if (horaRandom.isAfter(LocalTime.of(16, 0))) 	new ETarde(t,momento,aleatorizador.nextBoolean());
                    else if (fecha.getDayOfWeek().equals(DayOfWeek.MONDAY) 	 ||
                    fecha.getDayOfWeek().equals(DayOfWeek.TUESDAY)	 ||
                    fecha.getDayOfWeek().equals(DayOfWeek.WEDNESDAY)||
                    fecha.getDayOfWeek().equals(DayOfWeek.THURSDAY))new EDiaLaborable(t,momento,aleatorizador.nextBoolean());
                    else new EGeneral(t,momento,aleatorizador.nextBoolean());
                }
            }
            fecha=fecha.plusDays(1); //Pasamos al siguiente dia del año
        }
        //GUI
        gui = new GUI();
        gui.setVisible(true);
    }

    public static Turista turistaRandom(int tipoTurista) {
        //Random aleatorizador = new Random();
        Turista turista = null;
        String nombre =""+Turista.contadorIdTurista;
        String apellidos=""+Turista.contadorIdTurista;
        LocalDate nacimiento=null; 

        int t = (tipoTurista==0 || tipoTurista==1 || tipoTurista==2)? tipoTurista : aleatorizador.nextInt(3);
        //Caso 0: Niño, caso 1: Adulto, caso 2: Senior
        switch(t) {
            case 0:
            // Un niño tendrá entre 0 y 18 años
            nombre="NombreNiño_"+nombre;
            apellidos = "ApellidosNiño"+apellidos;
            nacimiento = LocalDate.now().minusYears(aleatorizador.nextInt(12));
            turista = new Nino(nombre,apellidos,nacimiento);
            break;
            case 1:
            nombre="NombreAdulto_"+nombre;
            apellidos = "ApellidosAdulto"+apellidos;
            // Un adulto tendrá entre 18 y 65 años
            nacimiento = LocalDate.now().minusYears(aleatorizador.nextInt(65-13+1)+13);
            turista = new Adulto(nombre,apellidos,nacimiento);
            break;
            case 2:
            nombre="NombreSenior_"+nombre;
            apellidos = "ApellidosSenior"+apellidos;
            // No se concibe la posibilidad de que acceda una persona mayor de 100 años
            nacimiento = LocalDate.now().minusYears(aleatorizador.nextInt(100)+13);
            turista = new Senior(nombre,apellidos,nacimiento);
            break;
            default: break;
        }	
        return turista;
    }
}

