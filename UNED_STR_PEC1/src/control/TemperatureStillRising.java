package control;

public class TemperatureStillRising extends Exception {
	private static final long serialVersionUID = 1L;

	public TemperatureStillRising(String msg) {
		System.out.print(msg);
	}

}
