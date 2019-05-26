package es.uned.lsi.eped.pract2018_2019;
import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Before;
import org.junit.Test;

public class ValueSeqTest {
	String numero1 = "1008";
	String numero2 = "2098";

	ValueSeq mayor;
	ValueSeq menor;
	BigInteger b1;
	BigInteger b2;

	@Before
	public void before() {
		ValueSeq valor1 = new ValueSeq(numero1);
		ValueSeq valor2 = new ValueSeq(numero2);
		b1 = new BigInteger(numero1);
		b2 = new BigInteger(numero2);
		int comp=b1.compareTo(b2);
		mayor = (comp>=0)? valor1:valor2;
		menor = (comp>0)? valor2:valor1;
	}
	
	@Test
	public void testToString() {
		ValueSeq valor1 = new ValueSeq(numero1);
		assertEquals(numero1, valor1.toString());
	}

	
	@Test
	public void testAddvalueSeq() {
		b1=b1.add(b2);
		mayor.addValue(menor);
		System.out.println("Suma -> esperado: "+b1.toString()+", obtenido: "+ mayor.toString());
		assertEquals(b1.toString(),mayor.toString());
	}

	@Test
	public void testMultValueSeq() {
		
		b1=b1.multiply(b2);
		mayor.multValue(menor);

		System.out.println("Mult -> esperado: "+b1.toString()+", obtenido: "+ mayor.toString());
		assertEquals(b1.toString(),mayor.toString());
	}
	
	@Test
	public void testSubValueSeq() {
		
		b1=b1.subtract(b2);
		mayor.subValue(menor);

		System.out.println("Sub -> esperado: "+b1.toString()+", obtenido: "+ mayor.toString());
		assertEquals(b1.abs().toString(),mayor.toString());
	}
	
	@Test
	public void testSubFromValueSeq() {
		b2=b2.subtract(b1);
		menor.subFromValue(mayor);

		System.out.println("SubFrom -> esperado: "+b2.toString()+", obtenido: "+ menor.toString());
		assertEquals(b2.toString(),menor.toString());
	}
	
	@Test
	public void testGreater() {
		ValueSeq valor1 = new ValueSeq(numero1);
		ValueSeq valor2 = new ValueSeq(numero2);
		int comp=b1.compareTo(b2);
		assertEquals(comp>0,valor1.greater(valor2));
	}
	
	@Test
	public void testIsZero() {
		ValueSeq valorZero = new ValueSeq("0");
		ValueSeq valorNoZero = new ValueSeq("10000");
		assertTrue(valorZero.isZero());
		assertFalse(valorNoZero.isZero());
	}
}
