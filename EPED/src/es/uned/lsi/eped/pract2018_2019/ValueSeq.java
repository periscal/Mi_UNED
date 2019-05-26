package es.uned.lsi.eped.pract2018_2019;

import es.uned.lsi.eped.DataStructures.Queue;

public class ValueSeq extends Value {
	/* Atributo que guarda el valor numerico */
	private Queue<Integer> colaCifras;

	/**
	 * <h2><i> ValueSeq</i></h2> 
	 * <p><code>public ValueSeq(String s)</code></p>
	 * <p> Crea una Cola (Queue) de enteros a partir de las cifras
	 * contenidas en la cadena de caracteres del parámetro</p>
	 * @param s cadena de caracteres con las cifras del numero
	 */
	public ValueSeq(String s) {
		colaCifras= new Queue<>();
		char[] cifras = s.toCharArray();
		for(int i = cifras.length-1; i>=0; i--) {//Se introducen primero las cifras de la derecha del nuemro
			colaCifras.enqueue(Character.getNumericValue(cifras[i]));
		}
	}

	/*Metodo que transforma el valor numerico en un String */
	public String toString() {
		String entero= "";
		Integer cabezaCola;
		for(int i=1;i<=colaCifras.size();i++) {
			cabezaCola = colaCifras.getFirst();
			entero=cabezaCola+entero;
			colaCifras.dequeue();
			colaCifras.enqueue(cabezaCola);
		}
		return entero;
	}

	/* Metodo que modifica el valor numerico llamante, sumandole el valor numerico paremetro */
	/**
	 * <h2><i> addValue</i></h2> 
	 * <p><code>public void addValue(Value n)</code></p>
	 * <p> Metodo que modifica el valor numerico llamante,
	 *  sumandole el valor numerico paremetro</p>
	 * @param n valor número que se le sumará al valor del llamante
	 */
	public void addValue(Value n) {
		Queue<Integer> colaMenor;
		Queue<Integer> colaMayor;

		if(this.colaCifras.size()>=((ValueSeq) n).colaCifras.size()) {
			colaMayor = this.colaCifras;
			colaMenor = ((ValueSeq) n).colaCifras;
		}
		else {
			colaMayor = ((ValueSeq) n).colaCifras;
			colaMenor = this.colaCifras;
		}
		this.colaCifras=sum(colaMayor,colaMenor);
	}

	/**
	 * <h2><i> subValue</i></h2> 
	 * <p><code>public void subValue(Value n)</code></p>
	 * <p> Metodo que modifica el valor numerico llamante, restandole el valor numerico parametro. 
	 * Sabemos que el mayor es el valor numerico llamante</p>
	 * @param n - valor número que se le restará al valor del llamante
	 */
	public void subValue(Value n) {
		Queue<Integer> colaMayor = this.colaCifras;
		Queue<Integer> colaMenor = ((ValueSeq) n).colaCifras;

		this.colaCifras=sub(colaMayor,colaMenor);
	}

	/**
	 * <h2><i> subFromValue</i></h2> 
	 * <p><code>subFromValue(Value n) </code></p>
	 * <p> Método que modifica el valor numérico llamante, restándolo del valor numérico parámetro. 
	 * Sabemos que el mayor es el valor numérico parámetro</p>
	 * @param n - valor número al que se le restará el valor del llamante
	 */
	public void subFromValue(Value n) {
		Queue<Integer> colaMayor = ((ValueSeq) n).colaCifras;
		Queue<Integer> colaMenor = this.colaCifras;
		this.colaCifras=sub(colaMayor,colaMenor);
	}

	/**
	 * <h2><i> multValue</i></h2> 
	 * <p><code>public void multValue(Value n) </code></p>
	 * <p> Método que modifica el valor numérico llamante,
	 * multiplicándolo por el valor numérico parámetro</p>
	 * @param n valor número por el que se multiplicará el llamante
	 */
	public void multValue(Value n) {
		Queue<Integer> resultado = new Queue<>();

		Queue<Integer> colaMenor;
		Queue<Integer> colaMayor;

		if(this.colaCifras.size()>=((ValueSeq) n).colaCifras.size()) {
			colaMayor = this.colaCifras;
			colaMenor = ((ValueSeq) n).colaCifras;
		}
		else {
			colaMayor = ((ValueSeq) n).colaCifras;
			colaMenor = this.colaCifras;
		}

		int multiplicador;
		for(int i=0;i<colaMenor.size();i++) {
			multiplicador=colaMenor.getFirst(); // Obtenemos la cabeza de la cola
			colaMenor.enqueue(multiplicador); //El primer elemento pasa a ser el ultimo de la cola
			colaMenor.dequeue(); 

			resultado = sum(mult(colaMayor,multiplicador,i), resultado);
		}
		this.colaCifras=resultado;
	}

	/**
	 * <h2><i> greater</i></h2> 
	 * <p><code>public boolean greater(Value n) </code></p>
	 * <p> Método que indica si el valor numérico llamante es mayor que el valor numérico parámetro</p>
	 * <p>Primero: compara las longitudes de los enteros, el de mayor longitud será necesariamente el número más grande</p>
	 * <p>Segundo: si son de longitudes iguales, se comparan cada cifra.Al tratarse de colas, se comienza la comparacion
	 * por las cifras de la derecha, ya que han sido las primera en encolarse</p>
	 * @param n valor número con el que se comapra el llamante
	 */
	public boolean greater(Value n) {
		Queue<Integer> colaParametro = ((ValueSeq) n).colaCifras;
		int llamanteLength = this.colaCifras.size();
		int parametroLength = colaParametro.size();
		boolean mayor=false;

		if     (llamanteLength>parametroLength) mayor=true;
		else if(llamanteLength<parametroLength) mayor=false;
		else { 
			//Si no se cumple lo anterior serán iguales
			int valorLlamante;
			int valorParametro;
			for(int i=0; i<llamanteLength;i++) {
				valorLlamante = colaCifras.getFirst();
				valorParametro = colaParametro.getFirst();
				if     (valorLlamante > valorParametro) mayor=true;
				else if(valorLlamante < valorParametro) mayor=false;
				colaCifras.dequeue();
				colaParametro.dequeue();
			}
		}
		return mayor;
	}

	/* Método que indica si el valor numérico es cero */
	public boolean isZero() {
		boolean zero = true;
		int valor=0;
		for(int i=0;i<colaCifras.size();i++) {
			zero = ((valor=colaCifras.getFirst())==0);
			colaCifras.enqueue(valor);
			colaCifras.dequeue();
		}
		return zero;
	}

	//----------------------------------------------------------------------

	private Queue<Integer> sum(Queue<Integer> colaMayor,Queue<Integer> colaMenor){
		Queue<Integer> resultado = new Queue<>();
		int suma;
		int cifra;
		int acarreo =0;

		while(!colaMenor.isEmpty()) {
			suma = colaMayor.getFirst()+colaMenor.getFirst()+acarreo;
			cifra=suma%10;
			acarreo=suma/10;
			resultado.enqueue(cifra);
			colaMayor.dequeue();
			colaMenor.dequeue();
		}
		while(!colaMayor.isEmpty()){
			suma = colaMayor.getFirst()+acarreo;
			cifra=suma%10;
			acarreo=suma/10;
			resultado.enqueue(cifra);
			colaMayor.dequeue();
		}
		if(acarreo!=0) resultado.enqueue(acarreo);
		
		return resultado;
	}

	private Queue<Integer> sub(Queue<Integer> colaMayor,Queue<Integer> colaMenor){
		Queue<Integer> resultado = new Queue<>();
		int resta;
		int cifra;
		int acarreo =0;
		int ultimoNoCero =0;
		int cont =0;
		
		//Se realiza la resta hasta agotar la cola menor
		while(!colaMenor.isEmpty()) {
			resta = colaMayor.getFirst()-colaMenor.getFirst()-acarreo;
			cifra = resta<0? resta + 10 : resta;
			acarreo=resta<0? 1 : 0;
			resultado.enqueue(cifra);
			colaMayor.dequeue();
			colaMenor.dequeue();
			cont++;
			if(cifra!=0) ultimoNoCero=cont;
		}
		
		//Se realiza la resta con el acarreo para la cola mayor
		while(!colaMayor.isEmpty()) {
			resta = colaMayor.getFirst()-acarreo;
			cifra = resta<0? resta + 10 : resta;
			acarreo=resta<0? 1 : 0;
			resultado.enqueue(cifra);
			colaMayor.dequeue();
			cont++;
			if(cifra!=0) ultimoNoCero=cont;
		}
		
		//Lo ceros a la izquierda se mueven a la cabeza de la cola
		for(int i =0; i<ultimoNoCero;i++) {
			resultado.enqueue(resultado.getFirst());
			resultado.dequeue();
		}
		
		// Se eliminan los ceros a la izquierda del numero
		int tamano = resultado.size();
		for(int i =ultimoNoCero; i<tamano;i++) {
			resultado.dequeue();
		}
		//Si la cola resultado queda vacía, entonces ésta debe representar el valor "0"
		if(resultado.size()==0) resultado.enqueue(0);
		
		return resultado;
	}
	
	private Queue<Integer> mult(Queue<Integer> colaMayor, int num, int pos){
		Queue<Integer> resultado = new Queue<>();
		int mult;
		int cifra;
		int acarreo =0;

		//Ponemos tantos 0's según como corresponda a la posición de la cifra multiplicadora
		for(int i=0;  i<pos; i++) resultado.enqueue(0);

		for(int i=0;  i<colaMayor.size(); i++) {
			mult = colaMayor.getFirst()*num + acarreo;
			cifra=mult%10;
			acarreo=mult/10;
			resultado.enqueue(cifra);
			colaMayor.enqueue(colaMayor.getFirst());
			colaMayor.dequeue();
		}
		if(acarreo!=0) resultado.enqueue(acarreo);

		return resultado;
	}
}
