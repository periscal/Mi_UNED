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

		/* Otra forma de escribirlo: ç
		 * longitudMayor = longitud1>=longitud2 ?  longitud1 : longitud2; */
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

	/**
	 * <h2><i> subValue</i></h2> 
	 * <p><code>public void subValue(Value n)</code></p>
	 * <p> Metodo que modifica el valor numerico llamante, restandole el valor numerico parametro. 
	 * Sabemos que el mayor es el valor numerico llamante</p>
	 * @param n - valor número que se le restará al valor del llamante
	 */
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
	
	/**
	 * <h2><i> subFromValue</i></h2> 
	 * <p><code>subFromValue(Value n) </code></p>
	 * <p> Método que modifica el valor numérico llamante, restándolo del valor numérico parámetro. 
	 * Sabemos que el mayor es el valor numérico parámetro</p>
	 * @param n - valor número al que se le restará el valor del llamante
	 */
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

	/**
	 * <h2><i> multValue</i></h2> 
	 * <p><code>public void multValue(Value n) </code></p>
	 * <p> Método que modifica el valor numérico llamante,
	 * multiplicándolo por el valor numérico parámetro</p>
	 * @param n - valor número por el que se multiplicará el llamante
	 */
	public void multValue(Value n) {
		List<Integer> resultado = new List<>(); // lista donde se almacenara el resultado
		List<Integer> lista2 = ((ValueSeq) n).getListaEnteros();
		List<Integer> listaMayor;
		List<Integer> listaMenor;
		
		int mult;    // fragmento del número del operando mayor
		int rMult;   // resultado de multiplicar 'mult' por un digito
		int rAcarreo=0;// el acarreo del la multiplicacion por un digito
		valor.acarreo=0;
		int longitud1 = this.listaEnteros.size();
		int longitud2 = lista2.size();
		int longitudMayor;
		int longitudMenor;

		if(longitud1>=longitud2) {
			listaMayor = this.listaEnteros;
			listaMenor = lista2;
		}
		else {
			listaMayor = lista2;
			listaMenor = this.listaEnteros;
		}
		
		longitudMayor = listaMayor.size();
		longitudMenor = listaMenor.size();
		
		for(int posMenor=1; posMenor<=longitudMenor;posMenor++) {
			char[] arrayDigitos = Character.toChars(listaMenor.get(posMenor));
			
			for(int posChar=0; posChar<arrayDigitos.length; posChar++) {
				int digito = Character.getNumericValue(arrayDigitos[posChar]);
				
				for(int posMayor=1; posMayor<=longitudMayor;posMayor++) {
					mult 	= listaMayor.get(posMayor)*digito+valor.acarreo;
					/*rMult 	= mult%10^(posMayor-1);//Math.pow(10, posMayor-1);
					rAcarreo= mult/10^(posMayor-1);*/
					valor.acarreoMult(mult);
					resultado.set(posMayor, valor.entero); 
				}
			}
		}
	}
	
	/**
	 * <h2><i> greater</i></h2> 
	 * <p><code>public boolean greater(Value n) </code></p>
	 * <p> Método que indica si el valor numérico llamante es mayor que el valor numérico parámetro</p>
	 * <p>Primero: compara las longitudes de los enteros, el de mayor longitud será necesariamente el número más grande</p>
	 * <p>Segundo: si son de longitudes iguales, se comparan cada fragmento de ambos números almacenados en listas,
	 * empezando por los dígitos de más a la izquierda del número (los que se sitúan al final de la cola de la lista)</p>
	 * @param n - valor número con el que se comapra el llamante
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
		public void acarreoMult(Integer e) {
			acarreo=0;
			if(e>cotaEntero) {
				e=e%cotaEntero;
				acarreo=e/cotaEntero;
			}
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
