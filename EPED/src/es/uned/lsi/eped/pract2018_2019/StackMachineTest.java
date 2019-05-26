package es.uned.lsi.eped.pract2018_2019;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Before;
import org.junit.Test;

import es.uned.lsi.eped.DataStructures.BTree;

public class StackMachineTest {

	String numero1 = "40";
	String numero2 = "150";
	String numero3 = "300";
	SynTree arbol;
	StackMachine sm;
	BigInteger b1;
	BigInteger b2;
	BigInteger b3;
	
	@Before
	public void before() {
		Value.valueClass = Value.ValueClass.SEQ;
		sm = new StackMachine();
		b1 = new BigInteger(numero1);
		b2 = new BigInteger(numero2);
		b3 = new BigInteger(numero3);
	}

	@Test
	public void testExecute1() {
		String resta =  "- + "+numero1+" "+numero2+" "+numero3;
		System.out.println(resta);
		arbol = new SynTree(resta);
		String obtenido =  sm.execute(arbol).toString();
		String esperado = b1.add(b2).subtract(b3).toString();
		System.out.println("-> esperado: "+esperado+", obtenido: "+ obtenido);
		assertEquals(esperado,obtenido);
	}
	
	@Test
	public void testExecute2() {
		String e =  "+ + "+numero1+" "+numero2+" "+numero3;
		System.out.println(e);
		arbol = new SynTree(e);
		String obtenido =  sm.execute(arbol).toString();
		String esperado = b1.add(b2).add(b3).toString();
		System.out.println("-> esperado: "+esperado+", obtenido: "+ obtenido);
		assertEquals(esperado,obtenido);
	}
	
	@Test
	public void testExecute3() {
		String resta =  "- "+numero1+" "+numero3;
		System.out.println(resta);
		arbol = new SynTree(resta);
		String obtenido =  sm.execute(arbol).toString();
		String esperado = b1.subtract(b3).toString();
		System.out.println("-> esperado: "+esperado+", obtenido: "+ obtenido);
		assertEquals(esperado,obtenido);
	}
}
