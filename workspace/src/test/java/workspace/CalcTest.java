package workspace;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalcTest {
	
	@ParameterizedTest
	@DisplayName("Тестируем выброс Exception на негативные аргументы, параметризированный тест через csv")
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
	@DisplayName("Позитивные тесты суммы аргументов, параметризированный через csv - имя, результат, выражение")
	@CsvSource({"Сумма двух аргументов, 3, '1,2'",
		"сложение больше 4 аргументов, 7, '1,1,2,3,0,0'",
		"'сложение больше 4 аргументов с переносом без разделителя', 11, '1,1,2,3,0,0\n4'",
		"'Переполнение int, три аргумента',2147483649,'2147483647,2,0'"
		,"'Сложение нулей',0,'0,0'"
		,"'Сложение с опциональным разделителем \n',13, '//\n\n-1\n10\n3\n1'"
		,"'Сложение с опциональным разделителем newDelimeter',40, '//newDelimeter\n10newDelimeter10newDelimeter10newDelimeter10'"
		,"'Указан разделитель из чисел, и он же используются. Несколько аргументов',29, '//123\n-1123101231012310'"
	})
	void positiveSumTests(String displayMessage, long expectedResult, String input) {
		Calc calc = new Calc();
		assertEquals(expectedResult, calc.sum(input));
	}
	
	@ParameterizedTest(name = "''{0}''")
	@DisplayName("Негативные тесты суммы аргументов, параметризированный через csv - имя, результат, выражение")
	@CsvSource({"сложение больше 4 аргументов с переносом строки, 3, '1,1,2,3,0,0,\n4'",
		"Передан null, 7,",
		"сложение больше 4 аргументов с несколькими переносами,2147483649,'1,1,2,3,0,0\n\n4'"
		,"сложение больше 4 аргументов с переносом без разделителя,0,'\n4'"
		,"сложение с переносом в начале аргумента,13, '\n4\n2'"
		,"'Ошибка сложения, аргумент пустой',40, '1,1,2,,0,0'"
		,"сложение одного пустого аргумента,29, ''"
		,"сложение одного аргумента,29, '1'"
		,"сложение с рациональным,29, '0,0.1'"
		,"Три аргумента с ошибкой текст в третьем аргументе,29, '1,2,еуые'"
		,"Три аргумента с ошибкой разделителя,29, '0,0ж3'"
		,"Сложение строк,29, 'test,test'"
		,"Сложение строк и числа,29, 'str,2147483647'"
		,"'Указан разделитель, но используются стандартные.',29, '//newDelimeter\n1,10'"
		,"'Указан пустой разделитель.',29, '//\n-11031'"
		,"'Неверно Указан разделитель',29, '/newDelimeter\n1,10'"
		,"'Неверно Указан разделитель, нет завершения',29, '//newDelimeter-1,10\n2\n3'"
		,"'Неверно Указан разделитель, нет завершения 2',29, '//'"
		,"'Неверно Указан разделитель, два слеша',29, '//\\n\n-1\n10\n3\\n1'"
		,"'Неверно Указан разделитель, три слеша',29, '//\n\\\n-1\\\n10\\\n3\\\n1'"
	})
	void negativeSumTests(String displayMessage, long expectedResult, String input) {
		Calc calc = new Calc();
		assertEquals(-1, calc.sum(input));
	}
	
	
}
