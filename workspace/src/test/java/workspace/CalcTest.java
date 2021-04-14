package workspace;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalcTest {

	@Test
	void testSumOnePlusTwo() {
		Calc calc = new Calc();
		assertEquals(3, calc.sum("1,2"));
	}
	
	@Test
	void testSumNull() {
		Calc calc = new Calc();
		assertEquals(-1, calc.sum(null));
	}
	
	@Test
	@DisplayName("сложение больше 4 аргументов")
	void testSumFourArgs() {
		Calc calc = new Calc();
		assertEquals(7, calc.sum("1,1,2,3,0,0"));
	}
	
	@Test
	@DisplayName("сложение больше 4 аргументов с переносом строки")
	void testSumMoreArgsWithNewLine() {
		Calc calc = new Calc();
		assertEquals(-1, calc.sum("1,1,2,3,0,0,\n4"));
	}
	@Test
	@DisplayName("сложение больше 4 аргументов с переносом без разделителя")
	void testSumMoreArgsWithNewLineAndNoDelimeter() {
		Calc calc = new Calc();
		assertEquals(11, calc.sum("1,1,2,3,0,0\n4"));
	}
	
	@Test
	@DisplayName("сложение больше 4 аргументов с несколькими переносами")
	void testSumMoreArgsWithManyNewLines() {
		Calc calc = new Calc();
		assertEquals(-1, calc.sum("1,1,2,3,0,0\n\n4"));
	}
	
	@Test
	@DisplayName("сложение больше 4 аргументов с переносом без разделителя")
	void testSumWithNewLineAndOneArgs() {
		Calc calc = new Calc();
		assertEquals(-1, calc.sum("\n4"));
	}
	
	@Test
	@DisplayName("сложение с переносом в начале аргумента")
	void testSumWithNewLineAtStart() {
		Calc calc = new Calc();
		assertEquals(-1, calc.sum("\n4\n2"));
	}
	
	@Test
	@DisplayName("Ошибка сложения, аргумент пустой")
	void testSumEmptyArgs() {
		Calc calc = new Calc();
		assertEquals(-1, calc.sum("1,1,2,,0,0"));
	}
	
	@Test
	@DisplayName("сложение одного пустого аргумента")
	void testSumEmpty() {
		Calc calc = new Calc();
		assertEquals(-1, calc.sum(""));
	}
	
	@Test
	@DisplayName("сложение одного аргумента")
	void testSumOne() {
		Calc calc = new Calc();
		assertEquals(-1, calc.sum("1"));
	}
	
	@Test
	@DisplayName("сложение с рациональным")
	void testSumRational() {
		Calc calc = new Calc();
		assertEquals(-1, calc.sum("0,0.1"));
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
	@DisplayName("Три аргумента с ошибкой текст в третьем аргументе")
	void testSumOnePlusTwoPlusString() {
		Calc calc = new Calc();
		assertEquals(-1, calc.sum("1,2,еуые"));
//		assertThrows(NumberFormatException.class, ()->calc.sum("1,2,еуые"));
	}
	
	@Test
	@DisplayName("Три аргумента с переполнением инт")
	void testSumIntMaxPlusTwoPlusZero() {
		Calc calc = new Calc();
		assertEquals(2147483649L, calc.sum("2147483647,2,0"));
	}
	
	@Test
	@DisplayName("Три аргумента с ошибкой разделителя")
	void testSumZeroPlusZeroPlusThree() {
		Calc calc = new Calc();
		assertEquals(-1, calc.sum("0,0ж3"));
//		assertThrows(NumberFormatException.class, ()->calc.sum("0,0ж3"));
	}
	
	@Test
	@DisplayName("Три аргумента с негативным слагаемым")
	void testSumMinusOnePlusZeroPlusTwo() {
		Calc calc = new Calc();
		assertEquals(1, calc.sum("-1,0,2"));
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
	
	@Test
	void testSumStringPlusString() {
		Calc calc = new Calc();
//		assertThrows(ArithmeticException.class,()->{ calc.sum("test,test");});
		assertEquals(-1, calc.sum("test,test"));
	}
	
	@Test
	void testSumStringPlusMaxInt() {
		Calc calc = new Calc();
//		assertThrows(ArithmeticException.class,()->{ calc.sum("str,2147483647");});
		assertEquals(-1,calc.sum("str,2147483647"));
	}
	
	@Test
	void testSumMaxIntPlusChar() {
		Calc calc = new Calc();
		assertEquals(-1,calc.sum("-1,a"));
//		assertThrows(ArithmeticException.class,()->{ calc.sum("-1,a");});
	}
	
	@Test
	@DisplayName("Указан разделитель, но используются стандартные.")
	void testSumWithOptDelimeterOnlyStandartUsed() {
		Calc calc = new Calc();
		assertEquals(-1, calc.sum("//newDelimeter\n-1,10"));
	}
	
	@Test
	@DisplayName("Укзан разделитель, и он же используются . ")
	void testSumWithOptDelimeterUsed() {
		Calc calc = new Calc();
		assertEquals(9, calc.sum("//newDelimeter\n-1newDelimeter10"));
	}
	
	@Test
	@DisplayName("Укзан разделитель, и он же используются. Несколько аргументов ")
	void testSumWithOptDelimeterUsedMultipleTimes() {
		Calc calc = new Calc();
		assertEquals(29, calc.sum("//newDelimeter\n-1newDelimeter10newDelimeter10newDelimeter10"));
	}
	
	@Test
	@DisplayName("Укзан разделитель из чисел, и он же используются. Несколько аргументов ")
	void testSumWithOptDelimeterOfNumbers() {
		Calc calc = new Calc();
		assertEquals(29, calc.sum("//123\n-1123101231012310"));
	}
	
	@Test
	@DisplayName("Укзан разделитель, и он же используются вместе со стандартными. ")
	void testSumWithOptDelimeterAndStandartUsed() {
		Calc calc = new Calc();
		assertEquals(-1, calc.sum("//newDelimeter\n-1newDelimeter10,3\n1"));
	}
	
	@Test
	@DisplayName("Неверно Указан разделитель")
	void testSumWithErrorOnOptDelimeter() {
		Calc calc = new Calc();
		assertEquals(-1, calc.sum("/newDelimeter\n-1,10"));
	}
	
	@Test
	@DisplayName("Неверно Указан разделитель, нет завершения")
	void testSumWithErrorOnOptDelimeterNoEnd() {
		Calc calc = new Calc();
		assertEquals(-1, calc.sum("//newDelimeter-1,10\n2\n3"));
	}
	
}
