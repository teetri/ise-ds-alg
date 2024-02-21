
public class UseStack {
	
	//implement this method.
	public static Stack sort(Stack s) throws Exception {
		Stack t = new ArrayListStack();
		while (!s.isEmpty()) {
			int x = s.top(); s.pop();
			while (!t.isEmpty() && t.top() < x) {
				s.push(t.top()); t.pop();
			}
			t.push(x);
			System.out.println(t.top());
		}
		return t;
	}

}

