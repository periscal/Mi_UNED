package comun;

public class Planificador {

	public static int tiempos = 50; //Numero de instantes de ejecucion de CPU por defecto

	public static void main(String[] args) {

		//---------------------------------------
		// ----------  Crear TAREAS -------------
		//---------------------------------------
		Tarea.nuevaTarea(4, 1);
		Tarea.nuevaTarea(12, 3);
		Tarea.nuevaTarea(16, 8);

		String[][] diagrama = new String[Tarea.tareas.size()+2][tiempos];
		//----------------------------------------------------
		// ----------  TEST Utilizacion para EDF -------------
		//----------------------------------------------------
		if(Tarea.testEDF()) System.out.println("Test de Palnificacion basado en la Utilizacion para EDF -> SUPERADO\n" +
				"Todos los tiempos limite se cumpliran");
		else System.out.println("Test de Palnificacion basado en la Utilizacion para EDF ->  NO SUPERADO\n" +
				"Todos los tiempos limite NO se cumpliran");

		//---------------------------------------
		// ---------- PLANIFICACION -------------
		//---------------------------------------
		Tarea tareaActual=null;

		// Se realiza el analisis para 100 tiempos de computacion de CPU
		for (int i=0; i < tiempos;i++) {
			//-------------------------------------------------------------------------
			// ----------  Busqueda tarea con "TIEMPO LIMITE MAS CERCANO" -------------
			//-------------------------------------------------------------------------
			Tarea tareaEjecutar=null;
			int tiempoAux = Integer.MAX_VALUE;	

			for(Tarea t: Tarea.tareas) {
				//Si el tiempo limite de una tarea es menor que "tiempoAux" esta pasara a ser la tarea a ejecutar
				if(t.tiempoRestanteLimite()<tiempoAux && t.getEstado()!=Tarea.estadoTarea.SUSPENDIDA) {
					tiempoAux=t.tiempoRestanteLimite();
					tareaEjecutar = t;
				}
			}
			//-------------------------------------------------------------------------

			// Se ejecuta la tarea con menor tiempo restante para ser ejecutada
			if(tareaEjecutar !=null) tareaEjecutar.setEstado(Tarea.estadoTarea.EJECUTANDOSE); 

			// Si la tarea anterior no es la actual, esta pasa a EJECUTABLE
			if(tareaActual != null &&
					!tareaActual.equals(tareaEjecutar) &&
					tareaActual.getEstado()==Tarea.estadoTarea.EJECUTANDOSE) {
				tareaActual.setEstado(Tarea.estadoTarea.EJECUTABLE); 
			}

			tareaActual	=tareaEjecutar;

			// ****** Elaborando Diagrama GRANT **********
			diagrama[0][i]=String.valueOf(i);
			diagrama[1][i]="--";
			int j =2;
			for(Tarea t: Tarea.tareas) {
				switch(t.getEstado()) {
				case EJECUTANDOSE:
					diagrama[j][i]=String.valueOf(t.tiempoRestanteLimite()); break;
				case EJECUTABLE:
					diagrama[j][i]= "<>";break;
				case SUSPENDIDA:
					diagrama[j][i]= " ";break;
				}
				j++;
			}
			// *******************************************

			Tarea.instanteSiguiente();
		}

		//--------------------------------------------------------
		// ----------  Mostrar Diagrama GRANT -------------
		//--------------------------------------------------------
		for (int m=0; m < diagrama.length; m++) {
			for (int n=0; n < diagrama[0].length; n++) {
				System.out.print(diagrama[m][n]+"\t");
			}
			System.out.println();
		}
	}
}
