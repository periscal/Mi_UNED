package control;

/**
 * TemperatureControla toma las acciones pertinentes para mantener
 * la camara de aire a una temperatura segura. 
 * <br>El "estado" del control indica las medidas tomadas ante el aumento de temperatura:
 * <br> 0 - La temperatura es menor que la temperatura limite
 * <br> 1 - La temperatura es mayor que la temperatura limite
 * <br> 2 - La temperatura es mayor que la temperatura limite y no ha funcionado el apagado del calentador
 * <br> 3 - La temperatura es mayor que la temperatura limite y no ha funcionado el aumento del caudal del refrigerante
 * <br> 4 - La temperatura es mayor que la temperatura limite y no ha funcionado la liberacion del gas mediante la valvula
 * @author Juan Periscal Porteiro
 * @version 1.0
 */
public class TemperatureControl {
	private  short estado;
	private int temperaturaLimite;

	/**
	 * El control comienza en el estado 0 (temperatura segura)
	 * @param temperaturaLimite temperatura en la cual el control dara alarma y dejara de funcionar
	 */
	public TemperatureControl(int temperaturaLimite) {
		estado=0;
		this.temperaturaLimite = temperaturaLimite;
	}

	/**
	 * Encendido del calentador de la camara
	 */
	public void heaterOn() {
		System.out.println("\n** Calentador camara encendido\n ");
	}


	/**
	 * Apagado del calentador de la camara
	 * @throws HeaterStuckOn
	 */
	public void heaterOff() throws HeaterStuckOn {
		throw new HeaterStuckOn("\n<!> Fallo en el apagado del calentador de la camara \n"); 
	}

	/**
	 * Incremento del caudal del refrigerante
	 * @throws TemperatureStillRising
	 */
	public void increaseCoolant() throws TemperatureStillRising {
		throw new TemperatureStillRising("\n<!!> No se logra bajar la temperatura de la camara tras el incremento del caudal del refrigerante\n ");
	}

	/**
	 * Apertura valvula de liberacion del gas de la camara
	 * @throws ValveStuck
	 */
	public void openValve() throws ValveStuck {
		throw new ValveStuck("\n<!!!> Fallo en la apertura de la valvula para la liberacion del gas\n ");
	}


	/**
	 *  Sonar la alarma y alertar a los servicios de emergencia 
	 */
	public void panic() {
		System.out.println("\n<!!!!> ALERTA: Han fallado todas las medidas de control de temperatura!!!.La temperatura sigue subiendo!!!\n ");
	}

	/**
	 * Recibe la temperatura y actua segun el estado en que se encuentre el control
	 * @param temperaturaCamara Temperatura interior de la camara
	 * @return devuleve el estado del control de temperatura
	 */
	public short recibeTemperatura(int temperaturaCamara) {
		if(temperaturaCamara> temperaturaLimite) {
			try {
				switch(estado) {
				case 1:
					this.heaterOff();
					System.out.println("\n ** Apagado de calentador\n ");
					break;
				case 2:
					this.increaseCoolant();
					System.out.println(" \n ** Incrementado caudal refrigerante\n ");
					break;
				case 3:
					this.openValve();
					System.out.println("\n ** Abierta valvula para liberacion gas\n ");
					break;
				case 4:
					this.panic();
					estado =5;
					break;
				default: 
					estado =1;
					break;
				}
			} 
			catch(HeaterStuckOn | TemperatureStillRising | ValveStuck e ) {
				estado++;
			} 
		}
		return estado;
	}
}
