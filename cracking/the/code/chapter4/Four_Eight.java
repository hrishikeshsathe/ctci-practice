package cracking.the.code.chapter4;

import data.structures.MyTree;

public class Four_Eight{
	public static boolean containsTree(MyTree t1, MyTree t2){
		if(t2 == null)
			return true;
		return subTree(t1,t2);
	}
	
	public static boolean subTree(MyTree t1, MyTree t2){
		if(t1 == null)
			return false;
		if(t1.getData() == t2.getData()){
			if(matchTree(t1,t2)){
				return true;
			}
		}
		return (subTree(t1.getLeft(), t2) || subTree(t1.getRight(),t2));
	}
	
	public static boolean matchTree(MyTree t1, MyTree t2){
		if(t1==null && t2==null)
			return true;
		if(t1==null || t2==null)
			return false;
		if(t1.getData() != t2.getData())
			return false;
		else
			return (matchTree(t1.getLeft(),t2.getLeft()) && matchTree(t1.getRight(),t2.getRight()));
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
		
		MyTree root1 = new MyTree(2);
		MyTree g = new MyTree(4);
		MyTree h = new MyTree(5);
		
		root1.setLeft(g);
		root1.setRight(h);
		
		System.out.println(containsTree(root, root1));
	}
}