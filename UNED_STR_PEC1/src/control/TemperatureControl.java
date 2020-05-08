package control;

/**
 * <br>La clase TemperatureControl contiene la clase main para iniciar el programa de control
 * <br>y contiene los métodos necesarios para interactuar con la cámara de gas
 * <br><br>
 * @author <a href="mailto:fmarcos68@alumno.uned.es">Fernando Marcos Mendez</a>
 * @version 1.0
 */
public class TemperatureControl {
	/** La variable temperatura guardará los valores de temperatura de la cámara */
	private static short temperature;
	/** La variable status guardará el valor de los distintos estados de la cámara
	 * 0 - estado inicial de puesta en marcha
	 * 1 - temperatura elevada
	 * 2 - no se puede apagar el calentador
	 * 3 - no se puede bajar la temperatura del gas aumentando el refrigerante
	 * 4 - no se puede liberar el gas de la cámara
	 * 5 - finalizar programa de control
	 */
	private static short status;
	
    /**
     * Constructor que inicializará el status a 0 y temperature a 20 (temperatura ambiente)
     */
	public TemperatureControl() {
		status = 0;
		temperature = 20;
	}

    /**
     * Método principal main de la Clase TemperatureControl 
     * <br>
     * En primer lugar encendemos la camara y comenzamos a calentar el gas
     * <br>
     * Después si la temperatura es elevada (p.e. 50 ºC) llamamos al método safeHeaterOff que controlará el estado de la cámara
     * 
     * @param args argumentos del método main
     * @throws InterruptedException (para el método Thread.sleep)
     */
	public static void main(String[] args) throws InterruptedException {
		//Finalizamos bucle de control cuando hay un estado de pánico y hemos enviado las alertas oportunas
		while(status != 5) {
			//Con el estado inicial (status=0) encendemos la cámara
			if(status == 0) {
				heaterOn();
				temperature = 20;
				//Establecemos un status al azar distinto de los valores de estado controlados
				status = 100;
				System.out.println("--> Encendemos la cámara");
			}
			
			//Incrementamos la temperatura de la cámara 1 grado cada segundo
			temperature++;
			Thread.sleep(1000);
			
			System.out.println("Temperatura: " + temperature);
			
			//Cuando la temperatura alcance el valor máximo permitido (p.e. 50ºC) lanzamos método de contingencia
			if(temperature == 50) {
				System.out.println("\n[ERROR 1] Temperatura MUY ELEVADA: " + temperature);
				System.out.println("--> Lanzamos método de contingencia");
				safeHeaterOff();
			}
		}
		
		System.out.println("\nFinalizamos el programa de control");
		Thread.sleep(5000);
	}
	
	/** Método para encender el calentador de la cámara */
	public static void heaterOn() {
	}
	
	/** Método para apagar el calentador de la cámara */
	public void heaterOff() throws HeaterStuckOn {
		throw new HeaterStuckOn("\n[ERROR 2] No se ha podido apagar la camara"); 
	}
	
	/** Método para inyectar más refrigerante para bajar la temperatura */
	public void increaseCoolant() throws TemperatureStillRising {
		throw new TemperatureStillRising("\n[ERROR 3] No se ha podido reducir la temperatura de la cámara inyectando mas refrigerante");
	}
	
	/** Método para abrir la cámara y expulsar el gas */
	public void openValve() throws ValveStuck {
		throw new ValveStuck("\n[ERROR 4] No se ha podido abrir la válvula de escap de la cámara de gas");
	}
	
	/** Método para hacer sonar la alarma y alertar a los servicios de emergencia */
	public void panic() {
		System.out.println("\n[ERROR] ALERTA: No se puede abrir la válvula de escape de la CAMARA DE GAS");
		System.out.println("\n--> Encendemos la alarma. Enviamos SMS, Telegram y Mails de Alertas. Realizamos llamada de Emergencia al telefono de Guardia");
	}
	
	/** Método de contingencia que intentará apagar el calentador de la cámara, inyectar más refrigerante, abrir la válvula de escape o encender la alarma y alertar */
	public static void safeHeaterOff() {
		TemperatureControl camera = new TemperatureControl();
		status = 1;
		
		//Mientras status no sea 0 ni 5, vamos recorriendo cada método de contingencia en orden según el enunciado
		while(status != 0 && status != 5) {
			try {
				Thread.sleep(1000);
				switch(status) {
				case 1:
					camera.heaterOff();
					System.out.println("--> Se ha apagado la cámara correctamente");
					status = 0;
					break;
				case 2:
					camera.increaseCoolant();
					System.out.println("--> Se ha inyectado refrigerante y ha disminuido la temperatura");
					status = 0;
					break;
				case 3:
					camera.openValve();
					System.out.println("--> Se ha abierto la cámara y se ha evacuado el gas");
					status = 0;
					break;
				case 4:
					camera.panic();
					status = 5;
					break;
				}
			} catch (InterruptedException e) {
			} catch(HeaterStuckOn e1) {
				status = 2;
			} catch(TemperatureStillRising e2) {
				status = 3;
			} catch(ValveStuck e3) {
				status = 4;
			}
		}
	}
}
