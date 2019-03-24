package es.uned.lsi.eped.pract2018_2019;

import es.uned.lsi.eped.DataStructures.List;

public class ValueSeq extends Value {
	/* Atributo que guarda el valor numérico */
	private List<Integer> listaEnteros;

	/* Constructor: recibe un String con el valor numérico */
	public ValueSeq(String s) {
		listaEnteros= new List<Integer>();
		fragmentarNumero(s,listaEnteros);
		imprimeLista();
	}

	/* Método que transforma el valor numérico en un String */
	public String toString() {
		String valor="";
		for(int i=0;i<=listaEnteros.size();i++) valor=String.valueOf(listaEnteros.get(i))+" "+valor;
		return valor;
	}

	/* Método que modifica el valor numérico llamante, sumándole el valor numérico parámetro */
	public void addValue(Value n) {
		List<Integer> lista2 = ((ValueSeq) n).getListaEnteros();

		int longitud1 = this.listaEnteros.size();
		int longitud2 = lista2.size();
		int longitudMayor,longitudMenor;
		List<Integer> listaMayor, listaMenor;
		
		if(longitud1>=longitud2) {
			longitudMayor=longitud1; listaMayor=listaEnteros;
			longitudMenor=longitud2; listaMenor=lista2;
		}
		else {
			longitudMayor=longitud2; listaMayor=lista2;
			longitudMenor=longitud1; listaMenor=listaEnteros;
		}
			
		int pos=1;
		int acarreo=0;
		while(pos<=longitudMenor) {
			Integer lista1 =listaEnteros.get(pos);	//System.out.println("pos1: "+pos+"---"+lista1);
			lista1+=lista2.get(pos)+acarreo; 		//System.out.println("pos2: "+pos+"---"+lista1+"\n");
			acarreo=0;
			if(lista1>1000000000) {
				lista1-=1000000000;
				acarreo=1;
			}
			listaEnteros.set(pos, lista1);
			pos++;
		}
		while(pos<=longitudMayor) {
			
		}
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


	public List<Integer> getListaEnteros() {
		return listaEnteros;
	}

	private void fragmentarNumero(String s, List<Integer> bloquesEnteros/*,int digitosXbloque*/) {
		int longitud = s.length();
		int tamanoTipoEntero=9;
		
		int pos=1;
		
		if(longitud>tamanoTipoEntero){
			int endIndex =longitud;
			int beginIndex=endIndex-tamanoTipoEntero;
			
			bloquesEnteros.insert(pos, Integer.parseInt(s.substring(beginIndex)));
			endIndex=beginIndex;
			beginIndex-=tamanoTipoEntero;
			pos++;

			while(beginIndex>=tamanoTipoEntero) {
				bloquesEnteros.insert(pos, Integer.parseInt(s.substring(beginIndex, endIndex)));
				endIndex=beginIndex;
				beginIndex-=tamanoTipoEntero;
				pos++;
			}
			endIndex=beginIndex;
			beginIndex=0;
			bloquesEnteros.insert(pos, Integer.parseInt(s.substring(beginIndex, endIndex)));
		}
		else bloquesEnteros.insert(pos, Integer.parseInt(s));
	}
	
	private void imprimeLista() {
		for(int i=listaEnteros.size();i>=0;i--) System.out.print(listaEnteros.get(i)+" ");
		System.out.println("\n");
	}

}
