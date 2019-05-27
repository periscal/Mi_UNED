package es.uned.lsi.eped.pract2018_2019;

import es.uned.lsi.eped.DataStructures.BTree;
import es.uned.lsi.eped.DataStructures.BTreeIF;
import es.uned.lsi.eped.DataStructures.Queue;
import es.uned.lsi.eped.DataStructures.QueueIF;
import es.uned.lsi.eped.DataStructures.Stack;

public class StackMachine {

	Stack<Node> pila; /*Del Estudiante: pila */
	Queue<Value.ValueClass> colaPostOrden;

	public StackMachine() {
		pila = new Stack<>();
		colaPostOrden = new Queue<>();
	}

	public Operand execute(SynTree syn) {
		postOrden(syn.getSynTree());
		/*Stack<Node> pilaAux = new Stack<>();
		
		//Invertimos la pila en una pila auxiliar
		//Quedando una expresion en notacion postfija
		while(!pila.isEmpty()) {
			pilaAux.push(pila.getTop());
			pila.pop();
		}
		
		// Se resuelve la expresion de forma postfija
		while(!pilaAux.isEmpty()) {	
			Node nodo=pilaAux.getTop();
			pilaAux.pop();
			
			if (nodo.getNodeType() == Node.NodeType.OPERAND) {
				pila.push((Operand) nodo);
			}else if ( nodo.getNodeType() == Node.NodeType.OPERATOR ) {
				Operand segundoOperando = (Operand)pila.getTop();
				pila.pop();
				Operand primerOperando = (Operand)pila.getTop();
				pila.pop();
				Operator.OperatorType tipoOperador = ((Operator)nodo).getOperatorType();
				switch(tipoOperador) {
					case ADD: primerOperando.add(segundoOperando); break;
					case SUB: primerOperando.sub(segundoOperando); break;
					case MULT:primerOperando.mult(segundoOperando);break;
				}
				pila.push((Operand) primerOperando);
		}
			}*/
		return (Operand) pila.getTop();
	}

	/* Recorrido del arbol en postorden */
	public void postOrden(BTreeIF<Node> t) {
		if ( !t.isEmpty() ) {
			if ( t.getLeftChild() != null ) { postOrden(t.getLeftChild()); }
			if ( t.getRightChild() != null ) { postOrden(t.getRightChild()); }
			/*pila.push(t.getRoot());*/
			
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
