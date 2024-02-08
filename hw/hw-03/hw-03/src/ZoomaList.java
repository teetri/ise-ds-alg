
public class ZoomaList extends CDLinkedList {
	int score = 0;

	public ZoomaList() {
		super();
	}

	public ZoomaList(CDLinkedList l) {
		header = l.header;
		size = l.size;
	}

	public void insert(int value, Iterator p) throws Exception {
		//fill code 
		
		if (p == null || !(p instanceof DListIterator)) {
			return;
		} else if (this.size == 0 || this.size == 1) {
			super.insert(value, p);
		} else {
			super.insert(value, p);
			if (((DListIterator) p).currentNode != header) {
				DListIterator l = (DListIterator) p;
				l.next();
				DListIterator r = new DListIterator(((DListIterator) p).currentNode);
				while (l.currentNode.data == r.currentNode.data) {
					if (l.currentNode.data == header.data) {
						l.currentNode = r.currentNode;
					} else {
						r.currentNode = l.currentNode;
					}
					int i = -1;
					while (l.currentNode.data == value) {
						l.currentNode = l.currentNode.previousNode;
						i++;
					}
					while (r.currentNode.data == value) {
						r.currentNode = r.currentNode.nextNode;
						i++;
					}
					if (i >= 3) {
						this.removeBetween(l, r, i);
						this.score += i;
						value = l.currentNode.data;
					} else {
						break;
					}

				}
			}

		}


	}

	
	public void removeBetween(DListIterator left, DListIterator right, int inc) {
		//fill code
		
		if (left.currentNode == right.currentNode) {
			return;
		}
		left.currentNode.nextNode = right.currentNode;
		right.currentNode.previousNode = left.currentNode;
		this.size -= inc;

	}

}
