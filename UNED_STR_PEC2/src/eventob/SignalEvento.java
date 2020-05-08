package eventob;

/** La clase SignalEvento se utilizará para despertar todos los hilos dormidos
 *  Recibe un objeto evento, el cual se usará para llamar al método SignalEvento
 */
public class SignalEvento implements Runnable {
	Evento evento;
	
    /** Constructor que inicializará el atributo evento (con el objeto pasado como parámetro desde el main) */
	public SignalEvento(Evento evento) {
		this.evento = evento;
	}

	/** Contiene el código que será ejecutado por un hilo */
	@Override
	public void run() {
		evento.signalEvento();
	}	
}
