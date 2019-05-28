package es.uned.lsi.eped.pract2018_2019;
import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Before;
import org.junit.Test;

public class ValueSeqTest {
	String numero1 = "1234567890";
	String numero2 = "12";

	Operand valor1;
	Operand valor2;
	BigInteger b1;
	BigInteger b2;

	@Before
	public void before() {
		Value.valueClass = Value.ValueClass.SEQ;
		valor1 = new Operand(numero1);
		valor2 = new Operand(numero2);
		
		b1 = new BigInteger(numero1);
		b2 = new BigInteger(numero2);
	}
	
	@Test
	public void testToString() {
		assertEquals(numero1, valor1.toString());
	}

	
	@Test
	public void testAddvalueSeq() {
		b1=b1.add(b2);
		valor1.add(valor2);
		System.out.println("Suma -> esperado: "+b1.toString()+", obtenido: "+ valor1.toString());
		assertEquals(b1.toString(),valor1.toString());
	}

	@Test
	public void testMultValueSeq() {
		
		b1=b1.multiply(b2);
		valor1.mult(valor2);

		System.out.println("Mult -> esperado: "+b1.toString()+", obtenido: "+ valor1.toString());
		assertEquals(b1.toString(),valor1.toString());
	}
	
	@Test
	public void testSubValueSeq() {
		
		b1=b1.subtract(b2);
		valor1.sub(valor2);

		System.out.println("Sub -> esperado: "+b1.toString()+", obtenido: "+ valor1.toString());
		assertEquals(b1.toString(),valor1.toString());
	}
	/*
	@Test
	public void testSubFromValueSeq() {
		b2=b2.subtract(b1);
		valor2.subFromValue(valor1);

		System.out.println("SubFrom -> esperado: "+b2.toString()+", obtenido: "+ valor2.toString());
		assertEquals(b2.toString(),valor2.toString());
	}*/
	/**/
	@Test
	public void testGreater() {
		ValueSeq valor1a;
		ValueSeq valor2a;
		valor1a = new ValueSeq("200");
		valor2a = new ValueSeq("199");	
		assertTrue(valor1a.greater(valor2a));
		assertFalse(valor2a.greater(valor1a));
	}
	
	@Test
	public void testIsZero() {
		ValueSeq valorZero = new ValueSeq("0");
		ValueSeq valorNoZero = new ValueSeq("10000");
		assertTrue(valorZero.isZero());
		assertFalse(valorNoZero.isZero());
	}
}
