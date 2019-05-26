package es.uned.lsi.eped.pract2018_2019;

import es.uned.lsi.eped.DataStructures.BTree;
import es.uned.lsi.eped.DataStructures.BTreeIF;
import es.uned.lsi.eped.DataStructures.Queue;
import es.uned.lsi.eped.DataStructures.QueueIF;
import es.uned.lsi.eped.DataStructures.Stack;

public class StackMachine {

	Stack<Operand> pila; /*Del Estudiante: pila */
	Queue<Value.ValueClass> colaPostOrden;

	public StackMachine() {
		pila = new Stack<>();
		colaPostOrden = new Queue<>();
	}

	public Operand execute(SynTree syn) {
		postOrden(syn.getSynTree());
		return pila.getTop();
	}

	/* Recorrido del arbol en postorden */
	public void postOrden(BTreeIF<Node> t) {
		if ( !t.isEmpty() ) {
			if ( t.getLeftChild() != null ) { postOrden(t.getLeftChild()); }
			if ( t.getRightChild() != null ) { postOrden(t.getRightChild()); }

			Node nodo = t.getRoot();
			if (nodo.getNodeType() == Node.NodeType.OPERAND) {
				pila.push((Operand) nodo);
			}else if ( nodo.getNodeType() == Node.NodeType.OPERATOR ) {
				Operand primerOperando = pila.getTop();
				pila.pop();
				Operator.OperatorType tipoOperador = ((Operator)nodo).getOperatorType();
				switch(tipoOperador) {
					case ADD: pila.getTop().add(primerOperando); break;
					case SUB: pila.getTop().sub(primerOperando); break;
					case MULT:pila.getTop().mult(primerOperando);break;
				}
				
			}
		}
	}

}
