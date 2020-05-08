package eventob;

import java.util.Scanner;

/**
 * La clase controlEvento contiene la clase main para iniciar el programa
 */
public class controlEvento {
	/** Variable constante ALTABAJAMAX para definir el máximo numero de hilos */
	static final int ALTABAJAMAX = 50;
	
	/** Variables threadsAlta, threadsBaja y threadSignal que irán almacenando los hilos de Alta, Baja y Signal creados */
	static Thread[] threadsAlta = new Thread[ALTABAJAMAX];
	static Thread[] threadsBaja = new Thread[ALTABAJAMAX];
	static Thread threadSignal = new Thread();
	/** Objeto evento sobre el que trabajarán todos los hilos creados*/
	static Evento evento = new Evento();
	
	/** Método main principal.
	 * Aquí se crean los distintos hilos de Alta y Baja prioridad. Después se elige el Thread ID del hilo que se quiere despertar/finalizar
	 * Como en la cola de hilos dormidos están mezclados todos, se despiertan de golpe y se van recorriendo todos hasta encontrar el corresponde con el ID
	 * El resto de hilos se duermen
	 * 
	 * @param args argumentos del método main
	 * @throws InterruptedException (para el método Thread.sleep)
	 */
		public static void main(String[] args) throws InterruptedException {
			/** Variable ALTABAJA que recogerá el numero de hilos a crear (tanto de ALTA como de BAJA) */
			int ALTABAJA;
			/** Esta variable se usa para llevar un control de los indices de los arrays usados para los hilos */
			int hilosArrancados = 0;
			
			/** Esta variable recogerá la entrada de teclado para el numero de hilos a crear */
			Scanner in = new Scanner(System.in);
			
			System.out.print("\nIntroduce numero de hilos (ALTA/BAJA) a crear (maximo " + ALTABAJAMAX + "): ");
			ALTABAJA = Integer.parseInt(in.nextLine());
			
			System.out.println("\n-> Arrancamos los hilos <-\n");
			
			/** Se crea el mismo número de hilos de ALTA que de BAJA, por simplificar
			 *  Se crean los hilos de un modo alterno. Primero uno de Baja y luego uno de Alta */
			while(hilosArrancados < ALTABAJA) {			
		        threadsBaja[hilosArrancados] = new Thread(new BajaPrioridad(evento));
		        threadsBaja[hilosArrancados].start();	            
		        Thread.sleep(500);
				
		        threadsAlta[hilosArrancados] = new Thread(new AltaPrioridad(evento));
		        threadsAlta[hilosArrancados].start();	           
		        Thread.sleep(500);
				
				hilosArrancados++;
			}
			
			System.out.println("\n-> Despertamos los hilos <-");
			
			/** Mientras haya hilos dormidos, se indica el Thread ID del hilo que se quiere liberar
			 *  Se despiertan todos, y se van recorriendo hasta encontrar el corresponde con el ID. El resto de hilos se duermen. 
			 */
	        while(checkThreadsAlive(ALTABAJA)) {
				System.out.print("\n-> Indica el id de hilo que quieres despertar: ");
		        evento.setID(in.nextLine());
		        
	            threadSignal = new Thread(new SignalEvento(evento));
	            threadSignal.start();	            
	            Thread.sleep(500);
	        }
	        
	        in.close();
	        System.out.println("\nFIN\n");
		}
		
		/** Método que se encarga de comprobar si existen hilos (de Baja o Alta) sin finalizar (están dormidos)
		 *  De este modo controlamos que el programa tiene que finalizar cuando no quede ningún hilo sin finalizar */
		public static boolean checkThreadsAlive(int NUMHILOS) {
			int i;
			for (i = 0; i < NUMHILOS; i++) {
				if(!threadsBaja[i].getState().toString().equals("TERMINATED")) {
					return(true);
				}
				
				if(!threadsAlta[i].getState().toString().equals("TERMINATED")) {
					return(true);
				}
			}
			return(false);
		}
}
