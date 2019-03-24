package es.uned.lsi.eped.pract2018_2019;

import es.uned.lsi.eped.DataStructures.List;

public class ValueSeq extends Value {
	/* Atributo que guarda el valor numérico */
	private List<Integer> listaEnteros;
	
	/* Constructor: recibe un String con el valor numérico */
	public ValueSeq(String s) {
		listaEnteros= new List<Integer>();
		fragmentarNumero(s,listaEnteros);
	}
	
	/* Método que transforma el valor numérico en un String */
	public String toString() {
		return null;
	}

	/* Método que modifica el valor numérico llamante, sumándole el valor numérico parámetro */
	public void addValue(Value n) {
		Integer.
	}

	/* Método que modifica el valor numérico llamante, restándole el valor numérico parámetro */
	/* Sabemos que el mayor es el valor numérico llamante */
	public void subValue(Value n) {
	}

	/* Método que modifica el valor numérico llamante, restándolo del valor numérico parámetro */
	/* Sabemos que el mayor es el valor numérico parámetro */
	public void subFromValue(Value n) {
	}

	/* Método que modifica el valor numérico llamante, multiplicándolo por el valor numérico parámetro */
	public void multValue(Value n) {
	}

	/* Método que indica si el valor numérico llamante es mayor que el valor numérico parámetro */
	public boolean greater(Value n) {
		return false;
	}

	/* Método que indica si el valor numérico es cero */
	public boolean isZero() {
		return false;
	}

	private void fragmentarNumero(String s, List<Integer> bloquesEnteros/*,int digitosXbloque*/) {
		int longitud = s.length();
		int tamanoTipoEntero=9;
		
		int endIndex =longitud+1;
		int beginIndex=endIndex-tamanoTipoEntero;
		int pos=0;
		while(beginIndex>0) {
			bloquesEnteros.insert(pos, Integer.parseInt(s.substring(beginIndex, endIndex)));
			endIndex=beginIndex;
			beginIndex-=tamanoTipoEntero;
		}
	}
}
