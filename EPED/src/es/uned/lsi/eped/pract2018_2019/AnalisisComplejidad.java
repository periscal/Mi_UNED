package es.uned.lsi.eped.pract2018_2019;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Before;
import org.junit.Test;

import es.uned.lsi.eped.pract2018_2019.*;

public class AnalisisComplejidad {
	String numeroBase = "1234567890";
	int pimerSize=10;
	int segundoSize=4;

	@Before
	public void before() {
		Value.valueClass = Value.ValueClass.SEQ;
	}

	@Test
	public void test() {
		ValueSeq valor1;
		ValueSeq valor2;
		String ruta="analisisTemporal/";

		for(Method metodoValueSeq : ValueSeq.class.getDeclaredMethods()) {

			//Solo se analizan los metodos publicos
			if(Modifier.isPublic(metodoValueSeq.getModifiers())) {
				StringBuffer s = new StringBuffer();
				String numero1 =numeroBase;
				String numero2="";

				//Matriz de tiempos	
				double[][] tiempos = new double[pimerSize+1][segundoSize+1];

				for(int i =0; i<=pimerSize;i++) {
					s.append(numero1);
					numero1=s.toString();
					int cifrasPrimero = numero1.length();

					for(int j=0; j<=segundoSize;j++) {
						int cifrasSegundo = cifrasPrimero*j/segundoSize;
						//Se indica en la primera fila el tamaño del segundo operando
						if(i==0) tiempos[0][j] = j*100/segundoSize;
						//Se indica en la primera columna el tamaño del primer operando
						else if(j==0) tiempos[i][0] = cifrasPrimero;
						else {
							// La longitud del segundo operando sera un 25, 50, 75 o 100% la longitud del numero1 
							// dependiendo de la iteracion en la que se encuentre
							numero2 = numero1.substring(0, cifrasSegundo-1);

							valor1 = new ValueSeq(numero1);
							valor2 = new ValueSeq(numero2);

							tiempos[i][j]=time(metodoValueSeq.getName(),valor1, valor2);
						}
					}
				}
				imprimeMatriz(tiempos,ruta+metodoValueSeq.getName()+".txt");
			}
		}

	}
	private double time(String nombreMetodo, ValueSeq valor1, ValueSeq valor2) {
		//Calculo tiempo del metodo 
		double inicio =  System.nanoTime();
		switch (nombreMetodo) {
		case "addValue":	 valor1.addValue(valor2); break;
		case "subValue":	 valor1.subValue(valor2); break;
		case "subFromValue": valor2.subFromValue(valor1); break;
		case "greater":		 valor1.greater(valor2); break;
		case "isZero":		 valor1.isZero(); break;
		case "multValue":	 valor1.multValue(valor2); break;
		default: break;
		}
		double fin = System.nanoTime();
		return fin-inicio;
	}
	private void imprimeMatriz(double[][] matriz, String archivo) {
		FileWriter fichero = null;
		PrintWriter pw = null;
		try{
			fichero = new FileWriter(archivo);
			pw = new PrintWriter(fichero);

			for(int i =0; i<matriz.length;i++) {
				for(int j=0; j<matriz[i].length;j++) {
					System.out.print(matriz[i][j]+"\t\t");
					pw.print(matriz[i][j]+"\t");
				}
				System.out.println();
				pw.println();
			}
			pw.close();
		} catch (Exception e) {e.printStackTrace();} 
		finally {
			try {
				if (null != fichero)fichero.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
