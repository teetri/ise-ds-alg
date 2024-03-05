
public class PriorityQueue {
	MyQueue q;

	public PriorityQueue(MyQueue q) {
		super();
		this.q = q;
	}

	// implement this.
	public void push(int x) throws Exception {
		int size = q.size();
		boolean inserted = false;
		
		if(q.isEmpty()) {
			q.insertLast(x);
			return;
		}
		
		for(int i = 0; i < size; i++) {
			int temp = q.removeFirst();
			if (x < temp && !inserted) {
				q.insertLast(x);
				inserted = true;
			}
			q.insertLast(temp);
		}
		
		if(!inserted) q.insertLast(x);
		

	}

	// implement this.
	public void pop() throws Exception {
		q.removeFirst();

	}

	// implement this
	public int top() throws Exception {
		
		return q.front();

	}

}
