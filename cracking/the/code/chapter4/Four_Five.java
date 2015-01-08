package cracking.the.code.chapter4;

import data.structures.MyTree;

public class Four_Five{
	static int arr[] = new int[7];
	static int index = 0;
	static Integer last_node = null;
	
	public static void main(String args[]){
		MyTree root = new MyTree(4);
		MyTree a = new MyTree(2);
		MyTree b = new MyTree(6);
		MyTree c = new MyTree(1);
		MyTree d = new MyTree(9);
		MyTree e = new MyTree(5);
		MyTree f = new MyTree(7);
		
		root.setLeft(a);
		root.setRight(b);
		a.setLeft(c);
		a.setRight(d);
		b.setLeft(e);
		b.setRight(f);
		createArray(root);
		root.inOrder(root);
		checkBST();
		System.out.println(checkNoArray(root));
	}
	
	public static void createArray(MyTree root){
		if(root == null)
			return;
		createArray(root.getLeft());
		arr[index] = root.getData();
		index++;
		createArray(root.getRight());
	}
	
	public static void checkBST(){
		for(int i=0; i<6; i++){
			if(arr[i]>=arr[i+1]){
				System.out.println("Not a BST");
				return;
			}
		}
		System.out.println("BST");
	}
	
	public static boolean checkNoArray(MyTree root){
		if(root == null)
			return true;
		if(!checkNoArray(root.getLeft()))
			return false;
		if(last_node != null && root.getData() <= last_node)
			return false;
		last_node = root.getData();
		if(!checkNoArray(root.getRight()))
			return false;
		return true;
	}
}