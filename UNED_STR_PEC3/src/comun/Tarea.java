package comun;

/**
 * 
 * @author Juan Periscal Porteiro
 */
public class Tarea {
	public static int instante = 0;

	public static java.util.ArrayList<Tarea> tareas = new java.util.ArrayList<Tarea>();

	public enum estadoTarea{EJECUTANDOSE , SUSPENDIDA , EJECUTABLE}

	private int periodo; //Tiempo mínimo entre ejecuciones del proceso
	private int WCET; //Tiempo de ejecución del proceso en el peor caso
	private int tiempoRestanteLimite;// Tiempo que queda el instante en el que la tarea debe estar finalizada
	private int tiempoEjecutado; //Tiempo que ha estado ejecutandose
	private estadoTarea estado;

	private Tarea(int _periodo , int _WCET) {
		periodo = _periodo;
		WCET=_WCET;
		tiempoEjecutado=0;
		estado = estadoTarea.EJECUTABLE;
		tiempoRestanteLimite = _periodo;
	}

	// -------------------------------
	// ----- Metodos de instancia ----
	public int tiempoRestanteLimite() {return tiempoRestanteLimite;}

	public void setEstado(Tarea.estadoTarea e) {this.estado=e;}
	
	public estadoTarea getEstado() {return this.estado;}

	// ------------------------------
	// ----- Metodos de Clase -------
	public static Tarea nuevaTarea(int _periodo , int _WCET) {
		Tarea t = new Tarea(_periodo,_WCET);
		tareas.add(t);
		return t;
	}

	/**
	 * Test de planificabilidad para planificación de primero el
	 * tiempo límite más temprano.
	 * @return 'true', si el conjunto de tareas se puede planificar
	 * basado en la utilidad para EDF; 'false' en caso contrario.
	 */
	public static boolean testEDF() {
		float usoCPU=0;
		for(Tarea t: tareas) usoCPU +=(t.WCET/t.periodo);
		return  usoCPU < 1F;
	}

	/**
	 * Este metodo controla las caracteristicas y estado de cada tarea a cada instante
	 */
	public static void instanteSiguiente() {
		instante++;
		for(Tarea t: tareas) {
			if(t.estado != estadoTarea.SUSPENDIDA) t.tiempoRestanteLimite--;
			//La tarea en ejecucion incrementa su tiempo en ejecucion
			if(t.estado==estadoTarea.EJECUTANDOSE) t.tiempoEjecutado = (t.tiempoEjecutado+1)%t.periodo;

			if(t.tiempoEjecutado >= t.WCET) t.estado=estadoTarea.SUSPENDIDA;

			if(instante % t.periodo==0) {// Se comprueba si la tarea necesita volver a ejecutarse

				switch(t.estado) {
				case EJECUTANDOSE:
					System.out.println("Finalizacion tarea aun en EJECUCION.Tiempo incumplido");
					break;
				case EJECUTABLE:
					System.out.println("Finalizacion tarea aun SIN EJECUTAR.Tiempo incumplido");
					break;
				case SUSPENDIDA:
					break;
				}
				//Reinicia la tarea como disponible para ejecutarse
				t.tiempoEjecutado = 0; //Reinicia el contador del tiempo ejecutado
				t.estado=estadoTarea.EJECUTABLE; // Pasa a estar disponible para ser ejecutada
				t.tiempoRestanteLimite=t.periodo;
			}
		}
	}
}
