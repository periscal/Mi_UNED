package es.uned.lsi.eped.pract2018_2019;

import es.uned.lsi.eped.DataStructures.List;

public class ValueSeq extends Value {
	/* Atributo que guarda el valor numerico */
	private List<Integer> listaEnteros;
	private ValorConAcarreo valor;
	//int longitud; 

	/* Constructor: recibe un String con el valor numerico */
	public ValueSeq(String s) {
		listaEnteros= new List<>();
		fragmentarNumero(s,listaEnteros);
		imprimeLista();
		valor = new ValorConAcarreo();
	}

	/*Metodo que transforma el valor numerico en un String */
	public String toString() {
		String entero="";
		for(int i=1;i<=listaEnteros.size();i++) entero=String.valueOf(listaEnteros.get(i))+" "+entero;
		return entero;
	}

	/* Metodo que modifica el valor numerico llamante, sumandole el valor numerico paremetro */
	public void addValue(Value n) {
		List<Integer> lista2 = ((ValueSeq) n).getListaEnteros();

		int longitud1 = this.listaEnteros.size();
		int longitud2 = lista2.size();
		int longitudMayor;
		int longitudMenor;

		/* Otra forma de escribirlo: longitudMayor = longitud1>=longitud2 ?  longitud1 : longitud2; */
		if(longitud1>=longitud2) {
			longitudMayor=longitud1;
			longitudMenor=longitud2;
		}
		else {
			longitudMayor=longitud2;
			longitudMenor=longitud1;
		}

		int pos=1;
		valor.acarreo=0;
		Integer entero1;
		Integer entero2;
		while(pos<=longitudMenor) {
			entero1 =listaEnteros.get(pos);
			entero2=lista2.get(pos);
			entero1+=entero2+valor.acarreo; 
			valor.acarreoSuma(entero1);
			listaEnteros.set(pos, valor.entero);
			pos++;
		}
		if(longitud1>=longitud2) {
			while(valor.acarreo==1) {
				entero1 =listaEnteros.get(pos);	
				entero1+=valor.acarreo; 
				valor.acarreoSuma(entero1);
				listaEnteros.set(pos, valor.entero);
				pos++;
			}
		}
		else {
			while(pos<=longitudMayor) {
				entero2 =lista2.get(pos);	
				entero2+=valor.acarreo; 
				valor.acarreoSuma(entero2);
				listaEnteros.set(pos, valor.entero);
				pos++;
			}
		}
		if(valor.acarreo==1)listaEnteros.insert(pos, 1);
	}

	/* Metodo que modifica el valor numerico llamante, restandole el valor numerico parametro */
	/* Sabemos que el mayor es el valor numerico llamante */
	public void subValue(Value n) {
		List<Integer> lista2 = ((ValueSeq) n).getListaEnteros();

		int longitud2 = lista2.size();

		int pos=1;
		valor.acarreo=0;
		Integer entero1;
		Integer entero2;
		while(pos<=longitud2) {
			entero1 =listaEnteros.get(pos);
			entero2 =lista2.get(pos);
			entero1-=entero2+valor.acarreo; 
			valor.acarreoResta(entero1);
			listaEnteros.set(pos, valor.entero);
			pos++;
		}
		while(valor.acarreo==1) {
			entero1 =listaEnteros.get(pos);	
			entero1-=valor.acarreo; 
			valor.acarreoResta(entero1);
			listaEnteros.set(pos, valor.entero);
			pos++;
		}
		this.reajustarLista();
	}

	/* Método que modifica el valor numérico llamante, restándolo del valor numérico parámetro */
	/* Sabemos que el mayor es el valor numérico parámetro */
	public void subFromValue(Value n) {
		List<Integer> lista2 = ((ValueSeq) n).getListaEnteros();
		System.out.println("----Usando subFromValue -------");
		int longitud1 = this.listaEnteros.size();
		int longitud2 = lista2.size();
		int pos=1;
		valor.acarreo=0;
		Integer entero1;
		Integer entero2;
		while(pos<=longitud1) {
			entero1 =listaEnteros.get(pos);
			entero2 =lista2.get(pos);
			entero2-=entero1+valor.acarreo; 
			valor.acarreoResta(entero2);
			listaEnteros.set(pos, valor.entero);
			pos++;
		}
		while(pos<=longitud2) {
			entero2 =lista2.get(pos);	
			entero2-=valor.acarreo; 
			valor.acarreoResta(entero2);
			listaEnteros.set(pos, valor.entero);
			pos++;
		}
		this.reajustarLista();

	}

	/* Método que modifica el valor numérico llamante, multiplicándolo por el valor numérico parámetro */
	public void multValue(Value n) {
	}

	/* Método que indica si el valor numérico llamante es mayor que el valor numérico parámetro */
	/**
	 * Primero: compara las longitudes de los enteros, el de mayor longitud ser� necesariamente el n�mero m�s grande
	 * Segundo: si son de longitudes iguales, se comparan cada fragmento de ambos n�meros almacenados en listas,
	 * 			empezando por los d�gitos de m�s a la izquierda del n�mero (los que se sit�an al final de la cola de la lista)
	 */
	public boolean greater(Value n) {
		List<Integer> lista2 = ((ValueSeq) n).getListaEnteros();
		int longitud1 = this.listaEnteros.size();
		int longitud2 = lista2.size();
		boolean mayor=false;

		if     (longitud1>longitud2) mayor=true;
		else if(longitud1<longitud2) mayor=false;
		else {
			int pos=longitud1;
			while(listaEnteros.get(pos).equals(lista2.get(pos)) && pos>0) pos--;
			if(pos==0) mayor=false;
			else mayor=listaEnteros.get(pos)>lista2.get(pos)? true : false;
		}
		return mayor;
	}

	/* Método que indica si el valor numérico es cero */
	public boolean isZero() {
		return listaEnteros.size()==1 && listaEnteros.get(1)==0;
	}

	// ==============================================================================================//
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
		int cotaEntero=1000000000;

		public void acarreoSuma(Integer e) {
			acarreo=0;
			if(e>cotaEntero) {
				e-=cotaEntero;
				acarreo=1;
			}
			entero=e;
		}

		public void acarreoResta(Integer e) {
			acarreo=0;
			if(e<0) {
				e+=cotaEntero;
				acarreo=1;
			}
			entero=e;
		}
	}

	private void reajustarLista() {
		int pos =  listaEnteros.size();
		while(listaEnteros.get(pos).equals(0))	listaEnteros.remove(pos--);
		if(listaEnteros.isEmpty()) listaEnteros.insert(1,0);
	}

	private void imprimeLista() {
		for(int i=listaEnteros.size();i>0;i--) System.out.print(listaEnteros.get(i)+" ");
		System.out.println("\n");
	}

}
