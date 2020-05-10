package comun;

/**
 * 
 * @author Juan Periscal Porteiro
 */
public class Event implements Runnable{
	private int esperaAltaPrioridad;
	private int esperaBajaPrioridad;

	//CONSTRUCTOR
	public Event(){
		esperaAltaPrioridad = 0;
		esperaBajaPrioridad = 0;
	}

	//METODOS
	/**
	 * Espera de alta prioridad
	 */
	public synchronized void WaitAltaPrioridad() throws InterruptedException{
		esperaAltaPrioridad++;
		if (esperaAltaPrioridad==1) {
			this.signalEvent();
			return;
		}
	};

	/**
	 * Espera de baja prioridad
	 */
	public synchronized void WaitBajaPrioridad() throws InterruptedException{
		esperaBajaPrioridad++;
		if (esperaBajaPrioridad==1) {
			this.signalEvent();
			return;
		}
	};

	/**
	 * Este metodo se encarga de liberar un hilo de alta prioridad, 
	 * si existe alguno en espera. Si no, libera un hilo de espera
	 * de baja prioridad. Y si no hay presente ningun hilo a la espera
	 * este metodo no tiene efecto. 
	 * @throws InterruptedException  
	 */
	public synchronized void signalEvent() throws InterruptedException{
		synchronized(this) { 
			if(esperaAltaPrioridad > 0) {
				this.notify();
				esperaAltaPrioridad--;
			} else if (esperaBajaPrioridad > 0) {
				this.notify();
				esperaBajaPrioridad--;
			}
			Thread.sleep(1*1000); // el hilo espera 1 seg para liberarse
			System.out.println("Hilo "+Thread.currentThread().getId()+" liberado");
		}
	};

	/**
	 * Cuando se ejecuta este metodo el Evento se decide aleatoriamente
	 *  que tipo de espera se hara, de Alta o de Baja prioridad
	 */
	@Override
	public void run(){
		java.util.Random aleatorio = new java.util.Random();

		try {
			if (aleatorio.nextInt()%2 == 0) {
				this.WaitAltaPrioridad();
			}else {
				this.WaitBajaPrioridad();
			}
		}catch(InterruptedException e) {};
	};
}
