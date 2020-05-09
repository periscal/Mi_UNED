package comun;

/**
 * 
 * @author Juan Periscal Porteiro
 *
 */
public class Event implements Runnable{
	private int highPriorityWaiting;
	private int lowPriorityWaiting;
	private Object highWaiter;
	private Object lowWaiter;

	public Event(){
		highPriorityWaiting = 0;
		lowPriorityWaiting = 0;
		highWaiter = new Object();
		lowWaiter = new Object();

	}

	/**
	 * Espera de alta prioridad
	 */
	public synchronized void highPriorityWait() throws InterruptedException{
		synchronized(highWaiter) {
			synchronized(this) {
				highPriorityWaiting++;
				if (highPriorityWaiting==1) {
					this.signalEvent();
					return;
				}
			}
			highWaiter.wait();
		}
	};

	/**
	 * Espera de baja prioridad
	 */
	public synchronized void lowPriorityWait() throws InterruptedException{
		synchronized(lowWaiter) {
			synchronized(this) {
				lowPriorityWaiting++;
				if (lowPriorityWaiting==1) {
					this.signalEvent();
					return;
				}
			}
			lowWaiter.wait();
		}
	};

	/**
	 * @throws InterruptedException 
	 * 
	 */
	public synchronized void signalEvent() throws InterruptedException{
		synchronized(highWaiter) {
			synchronized(lowWaiter) {
				synchronized(this) { 
					if(highPriorityWaiting > 0) {
						highWaiter.notify();
						highPriorityWaiting--;
					} else if (lowPriorityWaiting > 0) {
						lowWaiter.notify();
						lowPriorityWaiting--;
					}
					Thread.sleep(1*1000); // el hilo espera 1 seg para liberarse
					System.out.println("Hilo "+Thread.currentThread().getId()+" liberado");
				}
			}
		}
	};

	@Override
	public void run(){
		// Se decide aleatoriamente que tipo de "Wait" se hara, de Alta o de Baja prioridad
		java.util.Random aleatorio = new java.util.Random();

		try {
			if (aleatorio.nextInt()%2 == 0) {
				this.highPriorityWait();
			}else {
				this.lowPriorityWait();
			}
		}catch(InterruptedException e) {};
	};
}
