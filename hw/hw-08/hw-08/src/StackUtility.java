
public class StackUtility {
	static String alphabets = "abcdefghijklmnopqrstuvwxyz";
	
	public static String operate(MyStack s1, MyStack s2) throws Exception {
		String result = "";
		int pair = s1.size() / 2;
		for (int i = 0; i < pair; i++) {
			int a = s1.top(); s1.pop();
			int b = s1.top(); s1.pop();
			int c = s2.top(); s2.pop();
			int y;
			if (c >= 0) {
				y = a + b;
			} else {
				y = a - b;
			}
			result = alphabets.charAt(y % alphabets.length()) + result;
		}
		return result;
	}
}
