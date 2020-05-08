package eventoa;

/** La clase BajaPrioridad se utilizará para crear hilos de Baja Prioridad
 *  Recibe un objeto evento, el cual se usará para llamar al método WaitBajaPrioridad
 */
public class BajaPrioridad implements Runnable {
	Evento evento;
	
    /** Constructor que inicializará el atributo evento (con el objeto pasado como parámetro desde el main) */
	public BajaPrioridad(Evento evento) {
		this.evento = evento;
	}

	/** Contiene el código que será ejecutado por un hilo */
	@Override
	public void run() {
		evento.WaitBajaPrioridad();
	}	
}
