package eventoa;

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
 * Aquí se crean los distintos hilos de Alta y Baja prioridad y luego se van despertando (primero los de Alta y luego los de Baja)
 * Como en la cola de hilos dormidos están mezclados todos, se despiertan de golpe y se van finalizando los de Alta, pero los de Baja
 * se vuelven a dormir hasta que estén todos los de Alta liberados
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

		/** Vamos liberando los hilos. Primero se liberan los de ALTA y luego los de BAJA
		 *  Entre medias creamos también hilos de Baja y de Alta (la misma cantidad que hemos creado al principio)
		 *  Mientras existan hilos de Baja dormidos seguiremos llamando al método signalEvento para liberarlos todos */
        while(checkThreadBajaAlive(ALTABAJA*2)) {
            threadSignal = new Thread(new SignalEvento(evento));
            threadSignal.start();
            
            Thread.sleep(500);
            
            if(hilosArrancados < ALTABAJA*2) {
            	System.out.print("\n[" + (hilosArrancados-ALTABAJA+1) + "/" + ALTABAJA + "] Creamos un hilo de BAJA y otro de ALTA\n");
	            threadsAlta[hilosArrancados] = new Thread(new BajaPrioridad(evento));
	            threadsAlta[hilosArrancados].start();
	        	Thread.sleep(500);
	        	
	            threadsBaja[hilosArrancados] = new Thread(new AltaPrioridad(evento));
	            threadsBaja[hilosArrancados].start();	            
	        	Thread.sleep(500);
	        	
	        	hilosArrancados++;
            }
        }
        
        in.close();
        System.out.println("\nFIN\n");
	}
	
	/** Método que se encarga de comprobar si existen hilos de BAJA sin finalizar (están dormidos)
	 *  De este modo controlamos que el programa tiene que finalizar cuando no quede ningún hilo de Baja sin finalizar */
	public static boolean checkThreadBajaAlive(int BAJA) {
		int i;
		for (i = 0; i < BAJA; i++) {
			if(!threadsBaja[i].getState().toString().equals("TERMINATED")) {
				return(true);
			}
		}
		return(false);
	}
}
