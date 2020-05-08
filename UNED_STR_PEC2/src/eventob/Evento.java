package eventob;

/** La clase Evento contiene los métodos necesarios para interactuar con los distintos hilos
 * En esta clase se crea un monitor del objeto instanciado de la misma y así aseguramos la exclusión mutua en el uso de dicho objeto
 */
public class Evento {
	/** La variable id guardará el Thread ID del hilo que queremos despertar */
	private String id;
	
	/** Constructor que inicializará la variable id como una cadena vacía */
	public Evento() {
		id = "";
	}
	
	/** Este método establece el atributo id de la clase Evento con la cadena id pasada como parámetro
	 *  Es decir establecemos el id introducido por teclado */
	public void setID(String id) {
		this.id = id;
	}
	
	/** Este método gestiona los hilos de Alta Prioridad
	 * En un principio libera el objeto y se queda a la espera de una notificación
	 * Comprobamos en cada iteración si el id del hilo es el id del hilo que buscamos para finalizar. 
	 * En caso afirmativo se finalizará el hilo y en caso negativo se volverá a dormir */
	public synchronized void WaitAltaPrioridad() {
		String idTemp = "";

		do {
			System.out.println("Thread " + Thread.currentThread().getId() + " -- Alta -- Se DUERME (wait)");
			try {
				wait();
			} catch (InterruptedException e) {
			}
			idTemp = Long.toString(Thread.currentThread().getId());
		} while(! id.equals(idTemp));

		System.out.println("Thread " + Thread.currentThread().getId() + " -- Alta -- Se DESPIERTA (del notifyAll)");
	}

	/** Este método gestiona los hilos de Baja Prioridad
	 * En un principio libera el objeto y se queda a la espera de una notificación
	 * Comprobamos en cada iteración si el id del hilo es el id del hilo que buscamos para finalizar. 
	 * En caso afirmativo se finalizará el hilo y en caso negativo se volverá a dormir */
	public synchronized void WaitBajaPrioridad() {
		/** Variable temporal para guardar el Thread ID del hilo */
		String idTemp = "";

		do {
			System.out.println("Thread " + Thread.currentThread().getId() + " -- Baja -- Se DUERME (wait)");
			try {
				wait();
			} catch (InterruptedException e) {
			}
			idTemp = Long.toString(Thread.currentThread().getId());
		} while(! id.equals(idTemp));
		System.out.println("Thread " + Thread.currentThread().getId() + " -- Baja -- Se DESPIERTA (del notifyAll)");
	}
	
	/** Este método despierta a todos los hilos que se encuentren en la cola de hilos (tanto de Baja como de Alta prioridad) */
	public synchronized void signalEvento() {
		notifyAll();
		System.out.println("\nsignalEvento -- Despierta a TODOS (notifyAll) -- Thread " + Thread.currentThread().getId());
	}
}
