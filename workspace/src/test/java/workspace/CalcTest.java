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
	@DisplayName("�������� ������ 4 ����������")
	void testSumFourArgs() {
		Calc calc = new Calc();
		assertEquals(7, calc.sum("1,1,2,3,0,0"));
	}
	
	@Test
	@DisplayName("�������� ������ 4 ���������� � ��������� ������")
	void testSumMoreArgsWithNewLine() {
		Calc calc = new Calc();
		assertEquals(-1, calc.sum("1,1,2,3,0,0,\n4"));
	}
	@Test
	@DisplayName("�������� ������ 4 ���������� � ��������� ��� �����������")
	void testSumMoreArgsWithNewLineAndNoDelimeter() {
		Calc calc = new Calc();
		assertEquals(11, calc.sum("1,1,2,3,0,0\n4"));
	}
	
	@Test
	@DisplayName("�������� ������ 4 ���������� � ����������� ����������")
	void testSumMoreArgsWithManyNewLines() {
		Calc calc = new Calc();
		assertEquals(-1, calc.sum("1,1,2,3,0,0\n\n4"));
	}
	
	@Test
	@DisplayName("�������� ������ 4 ���������� � ��������� ��� �����������")
	void testSumWithNewLineAndOneArgs() {
		Calc calc = new Calc();
		assertEquals(-1, calc.sum("\n4"));
	}
	
	@Test
	@DisplayName("�������� � ��������� � ������ ���������")
	void testSumWithNewLineAtStart() {
		Calc calc = new Calc();
		assertEquals(-1, calc.sum("\n4\n2"));
	}
	
	@Test
	@DisplayName("������ ��������, �������� ������")
	void testSumEmptyArgs() {
		Calc calc = new Calc();
		assertEquals(-1, calc.sum("1,1,2,,0,0"));
	}
	
	@Test
	@DisplayName("�������� ������ ������� ���������")
	void testSumEmpty() {
		Calc calc = new Calc();
		assertEquals(-1, calc.sum(""));
	}
	
	@Test
	@DisplayName("�������� ������ ���������")
	void testSumOne() {
		Calc calc = new Calc();
		assertEquals(-1, calc.sum("1"));
	}
	
	@Test
	@DisplayName("�������� � ������������")
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
	@DisplayName("��� ��������� � ������� ����� � ������� ���������")
	void testSumOnePlusTwoPlusString() {
		Calc calc = new Calc();
		assertEquals(-1, calc.sum("1,2,����"));
//		assertThrows(NumberFormatException.class, ()->calc.sum("1,2,����"));
	}
	
	@Test
	@DisplayName("��� ��������� � ������������� ���")
	void testSumIntMaxPlusTwoPlusZero() {
		Calc calc = new Calc();
		assertEquals(2147483649L, calc.sum("2147483647,2,0"));
	}
	
	@Test
	@DisplayName("��� ��������� � ������� �����������")
	void testSumZeroPlusZeroPlusThree() {
		Calc calc = new Calc();
		assertEquals(-1, calc.sum("0,0�3"));
//		assertThrows(NumberFormatException.class, ()->calc.sum("0,0�3"));
	}
	
	@Test
	@DisplayName("��� ��������� � ���������� ���������")
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
	@DisplayName("������ �����������, �� ������������ �����������.")
	void testSumWithOptDelimeterOnlyStandartUsed() {
		Calc calc = new Calc();
		assertEquals(-1, calc.sum("//newDelimeter\n-1,10"));
	}
	
	@Test
	@DisplayName("����� �����������, � �� �� ������������ . ")
	void testSumWithOptDelimeterUsed() {
		Calc calc = new Calc();
		assertEquals(9, calc.sum("//newDelimeter\n-1newDelimeter10"));
	}
	
	@Test
	@DisplayName("����� �����������, � �� �� ������������. ��������� ���������� ")
	void testSumWithOptDelimeterUsedMultipleTimes() {
		Calc calc = new Calc();
		assertEquals(29, calc.sum("//newDelimeter\n-1newDelimeter10newDelimeter10newDelimeter10"));
	}
	
	@Test
	@DisplayName("����� ����������� �� �����, � �� �� ������������. ��������� ���������� ")
	void testSumWithOptDelimeterOfNumbers() {
		Calc calc = new Calc();
		assertEquals(29, calc.sum("//123\n-1123101231012310"));
	}
	
	@Test
	@DisplayName("����� �����������, � �� �� ������������ ������ �� ������������. ")
	void testSumWithOptDelimeterAndStandartUsed() {
		Calc calc = new Calc();
		assertEquals(-1, calc.sum("//newDelimeter\n-1newDelimeter10,3\n1"));
	}
	
	@Test
	@DisplayName("������� ������ �����������")
	void testSumWithErrorOnOptDelimeter() {
		Calc calc = new Calc();
		assertEquals(-1, calc.sum("/newDelimeter\n-1,10"));
	}
	
	@Test
	@DisplayName("������� ������ �����������, ��� ����������")
	void testSumWithErrorOnOptDelimeterNoEnd() {
		Calc calc = new Calc();
		assertEquals(-1, calc.sum("//newDelimeter-1,10\n2\n3"));
	}
	
}
