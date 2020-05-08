package eventoa;

/** La clase Evento contiene los métodos necesarios para interactuar con los distintos hilos
 * En esta clase se crea un monitor del objeto instanciado de la misma y así aseguramos la exclusión mutua en el uso de dicho objeto
 */
public class Evento {
	/** La variable contadorAlta llevará la cuenta del número de hilos de Alta Prioridad que están dormidos */
	private short contadorAlta;
	
    /** Constructor que inicializará la variable contadorAlta */
	public Evento() {
		contadorAlta = 0;
	}
	
	/** Este método gestiona los hilos de Alta Prioridad
	 * También se encarga de incrementar y decrementar la variable contadorAlta (hilos de Alta prioridad que hay dormidos)
	 * En un principio libera el objeto y se queda a la espera de una notificación */
	public synchronized void WaitAltaPrioridad() {
		contadorAlta++;
		System.out.println("Thread " + Thread.currentThread().getId() + " -- Alta -- Se DUERME (wait) -- contadorAlta: " + contadorAlta);
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		contadorAlta--;
		System.out.println("Thread " + Thread.currentThread().getId() + " -- Alta -- Se DESPIERTA (del notifyAll) -- contadorAlta: " + contadorAlta);
	}

	/** Este método gestiona los hilos de Baja Prioridad
	 * En un principio libera el objeto y se queda a la espera de una notificación
	 * Por otro lado depende de la variable de condición contadorAlta. Hasta que no es igual a cero los hilos de Baja se irán durmiendo */
	public synchronized void WaitBajaPrioridad() {
		do {
			System.out.println("Thread " + Thread.currentThread().getId() + " -- Baja -- Se DUERME (wait)");
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while(contadorAlta > 0);
		System.out.println("Thread " + Thread.currentThread().getId() + " -- Baja -- Se DESPIERTA (del notifyAll)");
	}
	
	/** Este método despierta a todos los hilos que se encuentren en la cola de hilos (tanto de Baja como de Alta prioridad) */
	public synchronized void signalEvento() {
		notifyAll();
		System.out.println("\nsignalEvento -- Despierta a TODOS (notifyAll) -- Thread " + Thread.currentThread().getId());
	}
}
