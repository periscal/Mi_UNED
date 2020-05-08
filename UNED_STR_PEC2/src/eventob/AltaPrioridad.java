package eventob;

/** La clase AltaPrioridad se utilizará para crear hilos de Alta Prioridad
 *  Recibe un objeto evento, el cual se usará para llamar al método WaitAltaPrioridad
 */
public class AltaPrioridad implements Runnable {
	Evento evento;
	
    /** Constructor que inicializará el atributo evento (con el objeto pasado como parámetro desde el main) */
	public AltaPrioridad(Evento evento) {
		this.evento = evento;
	}

	/** Contiene el código que será ejecutado por un hilo */
	@Override
	public void run() {
		evento.WaitAltaPrioridad();
	}	
}
