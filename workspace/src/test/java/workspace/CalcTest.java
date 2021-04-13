package workspace;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalcTest {

	@Test
	void testAdd() {
		fail("Not yet implemented");
	}

	@Test
	void testSumOnePlusTwo() {
		Calc calc = new Calc();
		assertEquals(3, calc.sum("1,2"));
	}
	
	@Test
	void testSumIntMaxPlusTwo() {
		Calc calc = new Calc();
		assertEquals(2147483649L, calc.sum("2147483647,2"));
	}
	
	@Test
	void testSumZeroPlusZero() {
		Calc calc = new Calc();
		assertEquals(0, calc.sum("0,0"));
	}
	
	@Test
	void testSumMinusOnePlusZero() {
		Calc calc = new Calc();
		assertEquals(-1, calc.sum("-1,0"));
	}
	
	@Test
	void testSumMinusOnePlusMinusZero() {
		Calc calc = new Calc();
		assertEquals(-1, calc.sum("-1,-0"));
	}
	
	@Test
	void testSumMinusOnePlusPositive10() {
		Calc calc = new Calc();
		assertEquals(9, calc.sum("-1,10"));
	}
	
	@Test
	void testSumMinusOnePlusPositiveIntMax() {
		Calc calc = new Calc();
		assertEquals(2147483646, calc.sum("-1,2147483647"));
	}
	
	@Test
	void testSumMinusOnePlusMinusIntMax() {
		Calc calc = new Calc();
		assertEquals(-2147483648, calc.sum("-1,-2147483647"));
	}
}
