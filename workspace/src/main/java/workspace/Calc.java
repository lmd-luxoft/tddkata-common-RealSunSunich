package workspace;

public class Calc {
 public int add() {
	 return 0;
 }

	public long sum(String expression) {
		Long result = 0L;
		try {
			String[] split = expression.split(",");
			if (split.length < 2)
				return -1;
			for (String string : split) {
				result += Long.valueOf(string);
			}
		} catch (Exception e) {

			return -1;
		}

		return result;

	}
}
