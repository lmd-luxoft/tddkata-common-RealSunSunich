package workspace;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalcTest {

	@Test
	void testAdd() {
		fail("Not yet implemented");
	}

	@Test
	void testSum() {
		Calc calc = new Calc();
		assertEquals(3, calc.sum("1+2"));
	}
}
