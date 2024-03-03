import java.util.ArrayList;
import java.util.Arrays;

public class BSTList {
	BSTNodeList root;
	int size;
	
	public BSTList() {
		root = null;
		size = 0;
	}
	
	public BSTList(BSTNodeList root, int size) {
		this.root = root;
		this.size = size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}

	public void makeEmpty() {
		root = null;
		size = 0;
	}
	
	public BSTNodeList find(Comparable v) { 
		BSTNodeList temp = root;
		while (temp != null && v.compareTo(temp.dataList.get(0)) != 0) {
			if (v.compareTo(temp.dataList.get(0)) < 0) {
				temp = temp.left;
			} else {
				temp = temp.right;
			}
		}
		if (temp == null)
			return null;
		else if (temp != null && v.compareTo(temp.dataList.get(0)) == 0) {
			if (!temp.dataList.contains(v)) return null;
		}
		return temp;

	}
	
	public BSTNodeList insert(Comparable v) {
		BSTNodeList temp = root;
		BSTNodeList parent = null;
		while (temp != null && v.compareTo(temp.dataList.get(0)) != 0) {
			if (v.compareTo(temp.dataList.get(0)) < 0) {
				parent = temp;
				temp = temp.left;
			} else {
				parent = temp;
				temp = temp.right;
			}
		}
		
		// case first no second no
		if(temp == null) {
			// new node list
			ArrayList<Pairdata> data = new ArrayList<Pairdata>();
			data.add((Pairdata) v);
			BSTNodeList n = new BSTNodeList(data, null, null, parent);
			// case tree is empty
			if(parent == null) {
				root = n;
				size += 1;
				return root;
			}
			// case tree not empty
			if (v.compareTo(parent.dataList.get(0)) < 0) {
				parent.left = n;
				n.parent = parent;
			} else {
				parent.right = n;
				n.parent = parent;
			}
			size += 1;
			return n;
			
		}
		// case first yes second no
		else if(temp != null && !temp.dataList.contains(v)) {
			temp.dataList.add((Pairdata) v);
			size += 1;
			return temp;
		}
		// case first yes second yes - duplicate
		else {
			return temp;
		}



	}
	
	public BSTNodeList findMin(BSTNodeList n) {
		BSTNodeList temp = n;
		if (temp == null)
			return null;
		while (temp.left != null) {
			temp = temp.left;
		}
		return temp;
	}

	

	
}
