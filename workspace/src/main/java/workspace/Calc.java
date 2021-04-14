package workspace;

public class Calc {
 public int add() {
	 return 0;
 }

	public long sum(String expression) {
		Long result = 0L;
		String regex = "[,\n]";
		try {
			String input = expression;
			if (expression.startsWith("//")) {
				int endOfDelimeter = expression.indexOf("\n");
				regex=expression.substring(2, endOfDelimeter);
				input= expression.substring(endOfDelimeter+1);
				if(input.startsWith("\n")&&"".equals(regex)) {
					//вырожденный случай опционального разделителя указанного как перенос строки
					regex="\n";
					input=expression.substring(endOfDelimeter+2);
				}
			}
			
			String[] split = input.split(regex);
			if (split.length < 2)
				return -1;
			for (String string : split) {
				result += Long.valueOf(string.trim());
			}
		} catch (Exception e) {

			return -1;
		}

		return result;

	}
}
