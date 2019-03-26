package es.uned.lsi.eped.pract2018_2019;

import es.uned.lsi.eped.DataStructures.List;

public class ValueSeq extends Value {
	/* Atributo que guarda el valor numérico */
	private List<Integer> listaEnteros;
	private ValorConAcarreo valor;
	
	/* Constructor: recibe un String con el valor numerico */
	public ValueSeq(String s) {
		listaEnteros= new List<Integer>();
		fragmentarNumero(s,listaEnteros);
		imprimeLista();
		valor = new ValorConAcarreo();
	}

	/*Metodo que transforma el valor numerico en un String */
	public String toString() {
		String valor="";
		for(int i=0;i<=listaEnteros.size();i++) valor=String.valueOf(listaEnteros.get(i))+" "+valor;
		return valor;
	}

	/* Metodo que modifica el valor numerico llamante, sumandole el valor numerico paremetro */
	public void addValue(Value n) {
		//List<Integer> resultado = new List<>();
		List<Integer> lista2 = ((ValueSeq) n).getListaEnteros();

		int longitud1 = this.listaEnteros.size();
		int longitud2 = lista2.size();
		int longitudMayor;
		int longitudMenor;
		List<Integer> listaMayor;
		List<Integer> listaMenor;

		//Otra forma de escribirlo: longitudMayor = longitud1>=longitud2 ?  longitud1 : longitud2; 
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
			Integer entero1 =listaEnteros.get(pos);	//System.out.println("pos1: "+pos+"---"+lista1);
			entero1+=lista2.get(pos)+valor.acarreo; 		//System.out.println("pos2: "+pos+"---"+lista1+"\n");
			valor.acarreo(entero1);
			listaEnteros.set(pos, valor.entero);
			pos++;
		}
		if(longitud1>=longitud2) {
			while(acarreo==1) {
				Integer entero1 =listaEnteros.get(pos);	
				entero1+=valor.acarreo; 
				valor.acarreo(entero1);
				listaEnteros.set(pos, valor.entero);
				pos++;
			}
		}
		else {
			while(pos<=longitudMayor) {
				Integer entero2 =lista2.get(pos);	
				entero2+=valor.acarreo; 
				valor.acarreo(entero2);
				listaEnteros.set(pos, valor.entero);
				pos++;
			}
		}

	}

	/* Metodo que modifica el valor numérico llamante, restándole el valor numérico parámetro */
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
	
	/**
	 * Fragmenta un String en una lista de numeros enteros
	 * @param s
	 * @param bloquesEnteros
	 */
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
			++pos;

			while(endIndex>=tamanoTipoEntero) {
				bloquesEnteros.insert(pos, Integer.parseInt(s.substring(beginIndex, endIndex)));
				endIndex=beginIndex;
				beginIndex-=tamanoTipoEntero;
				++pos;
			}
			if(endIndex < tamanoTipoEntero && endIndex>0) bloquesEnteros.insert(pos, Integer.parseInt(s.substring(0, endIndex)));			
		}
		else bloquesEnteros.insert(pos, Integer.parseInt(s));
	}

	private class ValorConAcarreo{
		Integer entero;
		int acarreo=0;

		public void acarreo(Integer e) {
			acarreo=0;
			if(e>1000000000) {
				e-=1000000000;
				acarreo=1;
			}
			entero=e;
		}
	}

	private void imprimeLista() {
		for(int i=listaEnteros.size();i>=0;i--) System.out.print(listaEnteros.get(i)+" ");
		System.out.println("\n");
	}

}
