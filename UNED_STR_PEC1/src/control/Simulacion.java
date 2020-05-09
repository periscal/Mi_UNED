package control;

public class Simulacion {

	public static void main(String[] args) throws InterruptedException {
		TemperatureControl control = new TemperatureControl(180);
		
		int temperaturaCamara=160;
		control.heaterOn(); //Encendido del calentador
		
		while(control.recibeTemperatura(temperaturaCamara)<5) {
			temperaturaCamara+=3;
			Thread.sleep(500);
			System.out.println(temperaturaCamara);
		}
	}
}
