package control;

public class ValveStuck extends Exception {
	private static final long serialVersionUID = 1L;

	public ValveStuck(String msg) {
		System.out.print(msg);
	}

}
