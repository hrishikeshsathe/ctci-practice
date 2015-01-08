package cracking.the.code.chapter4;

import data.structures.MyTree;

public class Four_Six {

	public static MyTree inOrderSucc(MyTree root){
		if(root == null)
			return null;
		if(root.getRight() != null)
			return leftMostChild(root.getRight());
		else{
			MyTree parent = root.getParent();
			MyTree temp = root;
			while(temp != null && parent.getLeft() != temp){
				temp = parent;
				parent = temp.getParent();
			}
			return parent;
		}
	}

	public static MyTree leftMostChild(MyTree root){
		if(root == null)
			return null;
		while(root.getLeft() != null)
			root = root.getLeft();
		return root;
	}
	
	public static void main(String args[]){
		MyTree root = new MyTree(1);
		MyTree a = new MyTree(2);
		MyTree b = new MyTree(3);
		MyTree c = new MyTree(4);
		MyTree d = new MyTree(5);
		MyTree e = new MyTree(6);
		MyTree f = new MyTree(7);
		
		root.setLeft(a);
		root.setRight(b);
		a.setLeft(c);
		a.setRight(d);
		b.setLeft(e);
		b.setRight(f);
		System.out.println(inOrderSucc(root).getData());
	}
}

