package cracking.the.code.chapter4;

import data.structures.MyTree;

public class Four_One extends MyTree{

	public Four_One(int data) {
		super(data);
		// TODO Auto-generated constructor stub
	}
	
	public int checkHeight(MyTree root){
		if(root == null)
			return 0;
		int left = checkHeight(root.getLeft());
		if(left == -1)
			return -1;
		int right = checkHeight(root.getRight());
		if(right == -1)
			return -1;
		int heightDiff = left - right;
		if(Math.abs(heightDiff) > 1)
			return -1;
		else
			return Math.max(left,right) + 1;
	}

	public boolean isBalanced(MyTree root)
	{
		if(checkHeight(root) != -1)
			return true;
		else
			return false;
	}

	public static void main(String args[]){
		Four_One root = new Four_One(1);
		Four_One a = new Four_One(2);
		Four_One b = new Four_One(3);
		Four_One c = new Four_One(4);
		Four_One d = new Four_One(5);
		Four_One e = new Four_One(6);
		Four_One f = new Four_One(7);
		
		root.setLeft(a);
		root.setRight(b);
		a.setLeft(c);
		a.setRight(d);
		b.setLeft(e);
		b.setRight(f);
		
		System.out.println(root.isBalanced(root));
	}

}
