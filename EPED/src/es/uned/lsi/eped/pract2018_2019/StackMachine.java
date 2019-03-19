package es.uned.lsi.eped.pract2018_2019;

import es.uned.lsi.eped.DataStructures.BTree;
import es.uned.lsi.eped.DataStructures.BTreeIF;
import es.uned.lsi.eped.DataStructures.Queue;
import es.uned.lsi.eped.DataStructures.Stack;

public class StackMachine {

	Stack<Value.ValueClass> pila; /*Del Estudiante: pila */
	Queue<Value.ValueClass> colaPostOrden;
	
	public StackMachine() {
		pila = new Stack<Value.ValueClass>();
		colaPostOrden = new Queue<Value.ValueClass>();
	}
	
	public Operand execute(SynTree syn) {
		BTree<Node> b=syn.getSynTree();
		pila.push(b.getLeftChild());
		//while (colaPostOrden.)
		return (new Operand("0"));
	}
	
}
