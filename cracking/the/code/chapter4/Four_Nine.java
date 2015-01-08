package cracking.the.code.chapter4;

import data.structures.MyTree;

public class Four_Nine{
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
		int[] path = new int[7];
		checkPath(root,7,path,0);
	}
	
	public static void checkPath(MyTree root, int sum, int[] path, int level){
		if(root == null)
			return;
		int temp=0;
		path[level] = root.getData();
		for(int i = level; i>=0; i--)
		{
			temp += path[i];
			if(temp == sum){
				printPath(path,i,level);
			}
		}
		
		checkPath(root.getLeft(), sum, path, level+1);
		checkPath(root.getRight(), sum, path, level+1);
		path[level] = Integer.MIN_VALUE;
	}
	
	public static void printPath(int[] path,int start, int level){
		System.out.println();
		for(int i=start;i<=level;i++)
			System.out.print(path[i]+"->");
	}	
}