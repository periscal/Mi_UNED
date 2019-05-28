package es.uned.lsi.eped.pract2018_2019;

import es.uned.lsi.eped.DataStructures.BTreeIF;
import es.uned.lsi.eped.DataStructures.Stack;

public class StackMachine {

	Stack<Node> pila;

	public StackMachine() {
		pila = new Stack<>();
	}

	public Operand execute(SynTree syn) {
		postOrden(syn.getSynTree());
		return (Operand) pila.getTop();
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
				Operand segundoOperando =(Operand) pila.getTop();
				pila.pop();
				Operand primerOperando =(Operand) pila.getTop();
				pila.pop();
				Operator.OperatorType tipoOperador = ((Operator)nodo).getOperatorType();
				switch(tipoOperador) {
					case ADD: primerOperando.add(segundoOperando); break;
					case SUB: primerOperando.sub(segundoOperando); break;
					case MULT:primerOperando.mult(segundoOperando);break;
				}
				pila.push((Operand) primerOperando);
			}
		}
	}
}
