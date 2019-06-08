package es.uned.lsi.eped.pract2018_2019;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Before;
import org.junit.Test;

public class StackMachineTest {

	String numero1 = "12";
	String numero2 = "12";
	String numero3 = "23";
	String numero4 = "14";
	SynTree arbol;
	StackMachine sm;
	BigInteger b1;
	BigInteger b2;
	BigInteger b3;
	BigInteger b4;
	
	@Before
	public void before() {
		Value.valueClass = Value.ValueClass.SEQ;
		sm = new StackMachine();
		b1 = new BigInteger(numero1);
		b2 = new BigInteger(numero2);
		b3 = new BigInteger(numero3);
		b4 = new BigInteger(numero4);
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
	
	@Test
	public void testExecute4() {
		String s =  "+ + - "+numero1+" "+numero2+" "+numero3+" "+numero4;
		System.out.println(s);
		arbol = new SynTree(s);
		String obtenido =  sm.execute(arbol).toString();
		String esperado = b1.subtract(b2).add(b3).add(b4).toString();
		System.out.println("-> esperado: "+esperado+", obtenido: "+ obtenido);
		assertEquals(esperado,obtenido);
	}
	
	@Test
	public void testExecute5() {
		String s =  "+ + + "+numero1+" "+numero2+" "+numero3+" "+numero4;
		System.out.println(s);
		arbol = new SynTree(s);
		String obtenido =  sm.execute(arbol).toString();
		String esperado = b1.add(b2).add(b3).add(b4).toString();
		System.out.println("-> esperado: "+esperado+", obtenido: "+ obtenido);
		assertEquals(esperado,obtenido);
	}
}
