package comun;

public class Principal {

	public static void main(String[] args) {

		Event evento = new Event();
		
		//se crean 10 hilos a partir del mismo objeto Event
		for(int i=0;i<10;i++) {
			(new Thread(evento)).start();
		}
	}
}
