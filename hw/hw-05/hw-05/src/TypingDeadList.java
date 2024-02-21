
public class TypingDeadList extends CDLinkedList {
	int score = 0;  //not used in this exam
	DListIterator start = null; // the first position of a word to remove
	DListIterator end = null; // last position of a word to remove

	public TypingDeadList() throws Exception {
		this("");
	}

	public TypingDeadList(String s) throws Exception {
		// initialize the list
		// each data comes from each character in s
		int n = s.length();
		DListIterator d = new DListIterator(header);
		for (int i = n - 1; i >= 0; i--) {
			insert(s.charAt(i), d);
		}

	}

	public void removeWord(String w) throws Exception {
		// remove the first occurrence of w
		// if w is not in the list, do nothing
		// reset start and end to null no matter what
		findWord(w);
		if (start == null)
			return;

		int dec = w.length();
		remove(dec);

	}

	public void findWord(String w) throws Exception {
		// update start and end to mark position of the first occurrence of w
		// The word cannot cross header node
		// If w is not in the list, do nothing.
		// w is assumed never to be an empty string.


		//fill code
		
		DListIterator i1 = new DListIterator(header);
		while (i1.hasNext() && i1.currentNode.nextNode != header && start == null) {
			i1.next();
			
			DListIterator j1 = new DListIterator(i1.currentNode);
			for (int j = 0; j < w.length(); j++) {
				if (j1.currentNode.data == w.charAt(j)) {
					if (j == w.length() - 1) {
						start = i1;
						end = j1;
						break;
					}
					j1.next();
				} else {
					break;
				}
			}
			
		}
		
	}

	public void remove(int dec) throws Exception { // this must be the last method in your code!
		// remove data from start to end, inclusive,
		// if start or end is at header, do nothing.
		// size to remove is one of the known parameter -> reduce the size parameter of
		// the list

		//fill code
		
		if(start.currentNode == header || end.currentNode == header) {return;}
		if(start == null || end == null) {return;}
		size -= dec;
		
		DListIterator beforeStart = new DListIterator(start.currentNode.previousNode);
		DListIterator afterEnd = new DListIterator(end.currentNode.nextNode);
		
		beforeStart.currentNode.nextNode = afterEnd.currentNode;
		afterEnd.currentNode.previousNode = beforeStart.currentNode;
		
		start = null;end = null;
	}

}
