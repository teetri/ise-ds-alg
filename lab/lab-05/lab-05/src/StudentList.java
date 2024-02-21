
public class StudentList extends CDLinkedList {
    // you can write additional methods.

	// implement this method
	public void swapNode(DListIterator i1, DListIterator i2) throws Exception {
		DListIterator t1p = new DListIterator(i1.currentNode.previousNode);
		DListIterator t1n = new DListIterator(i1.currentNode.nextNode);
		DListIterator t2p = new DListIterator(i2.currentNode.previousNode);
		DListIterator t2n = new DListIterator(i2.currentNode.nextNode);
		
		if (t1n.currentNode == i2.currentNode) {
			i1.currentNode.nextNode =t2n.currentNode;
			t2n.currentNode.previousNode = i1.currentNode;
			
			i2.currentNode.previousNode = t1p.currentNode;
			t1p.currentNode.nextNode = i2.currentNode;

			i1.currentNode.previousNode = i2.currentNode;
			i2.currentNode.nextNode = i1.currentNode;
		} else {
			i1.currentNode.nextNode = t2n.currentNode;
			t2n.currentNode.previousNode = i1.currentNode;
			
			i1.currentNode.previousNode = t2p.currentNode;
			t2p.currentNode.nextNode = i1.currentNode;
			
			i2.currentNode.nextNode = t1n.currentNode;
			t1n.currentNode.previousNode = i2.currentNode;
			
			i2.currentNode.previousNode = t1p.currentNode;
			t1p.currentNode.nextNode = i2.currentNode;
			
		}
	}
	
	// implement this method
	public void insertList(DListIterator i1, CDLinkedList lst) throws Exception {
		if (lst.isEmpty()) {return;}
		DListIterator i2 = new DListIterator(i1.currentNode.nextNode);
		DListIterator j1 = new DListIterator(lst.header);
		DListIterator j2 = new DListIterator(lst.header.nextNode);
		DListIterator j3 = new DListIterator(lst.header.previousNode);
		
		i1.currentNode.nextNode = j2.currentNode;
		j2.currentNode.previousNode = i1.currentNode;
		
		j3.currentNode.nextNode = i2.currentNode;
		i2.currentNode.previousNode = j3.currentNode;
	}

	// implement this method
	public void gender(String g) throws Exception {
		DListIterator i1 = new DListIterator(header);
		DListIterator g1 = new DListIterator(header);
		while (i1.hasNext() && i1.currentNode.nextNode != header) {
			i1.next();
			if (((Student) i1.currentNode.data).getSex() == g) {
				insert(i1.currentNode.data, g1);
				remove(findPrevious(i1));
				g1.next();
			}
		}
	}

}
