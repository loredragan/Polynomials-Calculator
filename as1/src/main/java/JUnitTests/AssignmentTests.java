package JUnitTests;
import MonomPolinom.*;
import InterfataGrafica.*;
import Main.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;

import org.junit.Test;


public class AssignmentTests {

	
	@Test
	public void testAdunarePozitiv() {
		Polinom p1 = new Polinom("+1x^2+1x^1+2");
		Polinom p2 = new Polinom("+1x^1+1");
		Polinom rezultatAsteptat = new Polinom("+1x^2+2x^1+3");
		Polinom rezultatObtinut = new Polinom();
		rezultatObtinut = OperatiiPolinom.aduna(p1, p2);
		for(int i=0; i< rezultatAsteptat.getPolinom().size(); i++) {
			assertEquals(rezultatAsteptat.getPolinom().get(i).getExponent(),rezultatObtinut.getPolinom().get(i).getExponent() );
			assertEquals(rezultatAsteptat.getPolinom().get(i).getCoeficient(),rezultatObtinut.getPolinom().get(i).getCoeficient() );
			
		}
	}
	
	@Test
	public void testAdunareNegativ() {
		Polinom p1 = new Polinom("+1x^2+1x^1+2");
		Polinom p2 = new Polinom("+1x^1+1");
		Polinom rezultatAsteptat = new Polinom("+1x^2+2x^1+2");
		Polinom rezultatObtinut = new Polinom();
		rezultatObtinut = OperatiiPolinom.aduna(p1, p2);
		assertNotEquals(rezultatAsteptat,rezultatObtinut);
	}
	
	@Test
	public void testScaderePozitiv() {
		Polinom p1 = new Polinom("+1x^2+1x^1+2");
		Polinom p2 = new Polinom("+1x^1+1");
		Polinom rezultatAsteptat = new Polinom("+1x^2");
		Polinom rezultatObtinut = new Polinom();
		rezultatObtinut = OperatiiPolinom.scade(p1, p2);
		for(int i=0; i< rezultatAsteptat.getPolinom().size(); i++) {
			assertEquals(rezultatAsteptat.getPolinom().get(i).getExponent(),rezultatObtinut.getPolinom().get(i).getExponent() );
			assertEquals(rezultatAsteptat.getPolinom().get(i).getCoeficient(),rezultatObtinut.getPolinom().get(i).getCoeficient() );
			
		}
	}
	
	@Test
	public void testScadereNegativ() {
		Polinom p1 = new Polinom("+1x^2+1x^1+2");
		Polinom p2 = new Polinom("+1x^1+1");
		Polinom rezultatAsteptat = new Polinom("+1x^2");
		Polinom rezultatObtinut = new Polinom();
		rezultatObtinut = OperatiiPolinom.scade(p1, p2);
		assertNotEquals(rezultatAsteptat,rezultatObtinut);
	}
	

	@Test
	public void testInmultirePozitiv() {
		Polinom p1 = new Polinom("+1x^2+1x^1+2");
		Polinom p2 = new Polinom("+1x^1+1");
		Polinom rezultatAsteptat = new Polinom("+1x^3+2x^2+3x^1+2");
		Polinom rezultatObtinut = new Polinom();
		rezultatObtinut = OperatiiPolinom.inmultire(p1, p2);
		for(int i=0; i< rezultatAsteptat.getPolinom().size(); i++) {
			assertEquals(rezultatAsteptat.getPolinom().get(i).getExponent(),rezultatObtinut.getPolinom().get(i).getExponent() );
			assertEquals(rezultatAsteptat.getPolinom().get(i).getCoeficient(),rezultatObtinut.getPolinom().get(i).getCoeficient() );
			
		}
		
	}
	
	@Test
	public void testInmultireNegativ() {
		Polinom p1 = new Polinom("+1x^2+1x^1+2");
		Polinom p2 = new Polinom("+1x^1+1");
		Polinom rezultatAsteptat = new Polinom("+1x^2+1");
		Polinom rezultatObtinut = new Polinom();
		rezultatObtinut = OperatiiPolinom.inmultire(p1, p2);
		assertNotEquals(rezultatAsteptat,rezultatObtinut);
	}
	
	@Test
	public void testDerivarePozitiv() {
		Polinom p1 = new Polinom("+1x^2+1x^1+2");
		Polinom rezultatAsteptat = new Polinom();
		Monom m1 = new Monom(2f,1f);
		Monom m2 = new Monom(1f,0f);
		rezultatAsteptat.getPolinom().add(m1);
		rezultatAsteptat.getPolinom().add(m2);
		Polinom rezultatObtinut = new Polinom();
		rezultatObtinut = OperatiiPolinom.derivare(p1);
		for(int i=0; i< rezultatAsteptat.getPolinom().size(); i++) {
			assertEquals(rezultatAsteptat.getPolinom().get(i).getExponent(),rezultatObtinut.getPolinom().get(i).getExponent() );
			assertEquals(rezultatAsteptat.getPolinom().get(i).getCoeficient(),rezultatObtinut.getPolinom().get(i).getCoeficient() );
			
		}
		
	}
	
	@Test
	public void testDerivareNegativ() {
		Polinom p1 = new Polinom("+1x^2+1x^1+2");
		Polinom rezultatAsteptat = new Polinom();
		Monom m1 = new Monom(2f,1f);
		Monom m2 = new Monom(1f,1f);
		rezultatAsteptat.getPolinom().add(m1);
		rezultatAsteptat.getPolinom().add(m2);
		Polinom rezultatObtinut = new Polinom();
		rezultatObtinut = OperatiiPolinom.derivare(p1);
		assertNotEquals(rezultatAsteptat,rezultatObtinut);
		
	}
	
	@Test
	public void testIntegrarePozitiv() {
		Polinom p1 = new Polinom("+3x^2+1");
		Polinom rezultatAsteptat = new Polinom();
		Monom m1 = new Monom(1f,3f);
		Monom m2 = new Monom(1f,1f);
		rezultatAsteptat.getPolinom().add(m1);
		rezultatAsteptat.getPolinom().add(m2);
		Polinom rezultatObtinut = new Polinom();
		rezultatObtinut = OperatiiPolinom.integrare(p1);
		for(int i=0; i< rezultatAsteptat.getPolinom().size(); i++) {
			assertEquals(rezultatAsteptat.getPolinom().get(i).getExponent(),rezultatObtinut.getPolinom().get(i).getExponent() );
			assertEquals(rezultatAsteptat.getPolinom().get(i).getCoeficient(),rezultatObtinut.getPolinom().get(i).getCoeficient() );
			
		}
		
	}
	
	@Test
	public void testIntegrareNegativ() {
		Polinom p1 = new Polinom("+3x^2+1");
		Polinom rezultatAsteptat = new Polinom();
		Monom m1 = new Monom(1f,3f);
		Monom m2 = new Monom(1f,0f);
		rezultatAsteptat.getPolinom().add(m1);
		rezultatAsteptat.getPolinom().add(m2);
		Polinom rezultatObtinut = new Polinom();
		rezultatObtinut = OperatiiPolinom.integrare(p1);
		assertNotEquals(rezultatAsteptat,rezultatObtinut);
	}
	
	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void testImpartirePozitiv() {
		Polinom p1 = new Polinom("+1x^2+2x^1+1");
		Polinom p2 = new Polinom("+1x^1");
		ArrayList<Polinom > rezultatAsteptat = new ArrayList<Polinom>();
		ArrayList<Polinom> rezultatObtinut = new ArrayList<Polinom>();
		rezultatObtinut = OperatiiPolinom.impartire(p1, p2);
//		System.out.println(rezultatObtinut.get(0));
//		System.out.println(rezultatObtinut.get(1));
		Polinom catAsteptat = new Polinom("+1x^1+2");
		Polinom restAsteptat = new Polinom("+1");
		rezultatAsteptat.add(catAsteptat);
		rezultatAsteptat.add(restAsteptat);
//		System.out.println(rezultatAsteptat.get(0));
//		System.out.println(rezultatAsteptat.get(1));
		
		equals(rezultatAsteptat.equals(rezultatObtinut));
		
	}
	
	
	@Test
	public void testImpartireNegativ() {
		Polinom p1 = new Polinom("+1x^2+2x^1");
		Polinom p2 = new Polinom("+1x^1");
		ArrayList<Polinom > rezultatAsteptat = new ArrayList<Polinom>();
		ArrayList<Polinom> rezultatObtinut = new ArrayList<Polinom>();
		rezultatObtinut = OperatiiPolinom.impartire(p1, p2);
//		System.out.println(rezultatObtinut.get(0));
//		System.out.println(rezultatObtinut.get(1));
		Polinom catAsteptat = new Polinom("+1x^1+2");
		Polinom restAsteptat = new Polinom("+1");
		rezultatAsteptat.add(catAsteptat);
		rezultatAsteptat.add(restAsteptat);
//		System.out.println(rezultatAsteptat.get(0));
//		System.out.println(rezultatAsteptat.get(1));
		
		assertNotEquals(rezultatAsteptat, rezultatObtinut);
		
	}
	
	
	@Test
	public void testParsarePozitiv() {
		Polinom p1 = new Polinom("+1x^2+1x^1+1");
		Polinom p2 = new Polinom();
		Monom monom1 = new Monom(1f,2f);
		Monom monom2 = new Monom(1f,1f);
		Monom monom3 = new Monom(1f,0f);
		p2.getPolinom().add(monom1);
		p2.getPolinom().add(monom2);
		p2.getPolinom().add(monom3);
		for(int i=0; i<p1.getPolinom().size(); i++) {
			assertEquals(p1.getPolinom().get(i).getExponent(),p2.getPolinom().get(i).getExponent());
			assertEquals(p1.getPolinom().get(i).getCoeficient(),p2.getPolinom().get(i).getCoeficient());
		}
		
	}
	
	@Test(expected = NumberFormatException.class)
	public void testParsareNegativ() {
		Polinom p1 = new Polinom("x^2+1x^1+1");
		Polinom p2 = new Polinom("+1x^2+1x^1+1");
		assertNotEquals(p1,p2);
		
	}
	
	
	
}
