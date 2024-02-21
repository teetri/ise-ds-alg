import java.util.ArrayList;

public class ArrayListStack implements Stack {
	private ArrayList<Integer> a;

	// implement a default constructor and all methods from interface Stack.
	// Additional methods maybe required in order to run tests.
	public ArrayListStack() {
		this.a = new ArrayList<Integer>(100000);
	}

	public ArrayList<Integer> getA() {
		return this.a;
	}

	@Override
	public boolean isEmpty() {
		return this.a.isEmpty();
	}

	@Override
	public boolean isFull() {
		return this.a.size() == 100000;
	}

	@Override
	public void makeEmpty() {
		this.a.clear();
	}

	@Override
	public int top() throws Exception {
		return this.a.get(this.a.size() - 1);
	}

	@Override
	public void pop() throws Exception {
		this.a.remove(this.a.size() - 1);
	}

	@Override
	public void push(int data) throws Exception {
		a.add(data);
	}

}
