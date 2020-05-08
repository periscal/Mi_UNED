package control;

public class HeaterStuckOn extends Exception {
	private static final long serialVersionUID = 1L;

	public HeaterStuckOn(String msg) {
		System.out.print(msg);
	}

}
