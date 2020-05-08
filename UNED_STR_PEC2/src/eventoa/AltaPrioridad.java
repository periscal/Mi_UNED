package eventoa;

/** La clase AltaPrioridad se utilizara para crear hilos de Alta Prioridad
 *  Recibe un objeto evento, el cual se usara para llamar al metodo WaitAltaPrioridad
 */
public class AltaPrioridad implements Runnable {
	Evento evento;
	
    /** Constructor que inicializará el atributo evento (con el objeto pasado como parametro desde el main) */
	public AltaPrioridad(Evento evento) {
		this.evento = evento;
	}

	/** Contiene el codigo que será ejecutado por un hilo */
	@Override
	public void run() {
		evento.WaitAltaPrioridad();
	}	
}
