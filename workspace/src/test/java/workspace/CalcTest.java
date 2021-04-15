package workspace;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalcTest {
	
	@ParameterizedTest
	@DisplayName("��������� ������ Exception �� ���������� ���������, ������������������� ���� ����� csv")
	@CsvSource({"negatives not allowed -1, '//newDelimeter\n-1newDelimeter10,3\n1'",
		"negatives not allowed -1, '//\n\n-1\n10\n3\n1'",
		"'negatives not allowed -1,-0', '-1,-0'"
		,"'negatives not allowed -0', '1,-0'"
		,"'negatives not allowed -1', '-1,2147483647'"
		,"'negatives not allowed -1,-2147483647', '-1,-2147483647'"
		,"'negatives not allowed -1', '-1,a'"
		
	})
	void testSumByArgsThrowsExceptionsOnNegative(String expectedMessage, String input) {
		Calc calc = new Calc();
		ArithmeticException exception = assertThrows(ArithmeticException.class, ()->calc.sum(input));
		assertEquals(expectedMessage, exception.getMessage());
	}
	
	
	@ParameterizedTest(name = "''{0}''")
	@DisplayName("���������� ����� ����� ����������, ������������������� ����� csv - ���, ���������, ���������")
	@CsvSource({"����� ���� ����������, 3, '1,2'",
		"�������� ������ 4 ����������, 7, '1,1,2,3,0,0'",
		"'�������� ������ 4 ���������� � ��������� ��� �����������', 11, '1,1,2,3,0,0\n4'",
		"'������������ int, ��� ���������',2147483649,'2147483647,2,0'"
		,"'�������� �����',0,'0,0'"
		,"'�������� � ������������ ������������ \n',13, '//\n\n-1\n10\n3\n1'"
		,"'�������� � ������������ ������������ newDelimeter',40, '//newDelimeter\n10newDelimeter10newDelimeter10newDelimeter10'"
		,"'������ ����������� �� �����, � �� �� ������������. ��������� ����������',29, '//123\n-1123101231012310'"
	})
	void positiveSumTests(String displayMessage, long expectedResult, String input) {
		Calc calc = new Calc();
		assertEquals(expectedResult, calc.sum(input));
	}
	
	@ParameterizedTest(name = "''{0}''")
	@DisplayName("���������� ����� ����� ����������, ������������������� ����� csv - ���, ���������, ���������")
	@CsvSource({"�������� ������ 4 ���������� � ��������� ������, 3, '1,1,2,3,0,0,\n4'",
		"������� null, 7,",
		"�������� ������ 4 ���������� � ����������� ����������,2147483649,'1,1,2,3,0,0\n\n4'"
		,"�������� ������ 4 ���������� � ��������� ��� �����������,0,'\n4'"
		,"�������� � ��������� � ������ ���������,13, '\n4\n2'"
		,"'������ ��������, �������� ������',40, '1,1,2,,0,0'"
		,"�������� ������ ������� ���������,29, ''"
		,"�������� ������ ���������,29, '1'"
		,"�������� � ������������,29, '0,0.1'"
		,"��� ��������� � ������� ����� � ������� ���������,29, '1,2,����'"
		,"��� ��������� � ������� �����������,29, '0,0�3'"
		,"�������� �����,29, 'test,test'"
		,"�������� ����� � �����,29, 'str,2147483647'"
		,"'������ �����������, �� ������������ �����������.',29, '//newDelimeter\n1,10'"
		,"'������ ������ �����������.',29, '//\n-11031'"
		,"'������� ������ �����������',29, '/newDelimeter\n1,10'"
		,"'������� ������ �����������, ��� ����������',29, '//newDelimeter-1,10\n2\n3'"
		,"'������� ������ �����������, ��� ���������� 2',29, '//'"
		,"'������� ������ �����������, ��� �����',29, '//\\n\n-1\n10\n3\\n1'"
		,"'������� ������ �����������, ��� �����',29, '//\n\\\n-1\\\n10\\\n3\\\n1'"
	})
	void negativeSumTests(String displayMessage, long expectedResult, String input) {
		Calc calc = new Calc();
		assertEquals(-1, calc.sum(input));
	}
	
	
}
