package data.structures;

import java.util.LinkedList;
import java.util.Queue;

public class MyTree{
	int data;
	MyTree left;
	MyTree right;
	MyTree parent;
	
	public MyTree(int data){
		this.data = data;
		this.left = null;
		this.right = null;
		this.parent = null;
	}
	
	public void setParent(MyTree parent){
		this.parent = parent;
	}
	
	public MyTree getParent(){
		return this.parent;
	}
	public void setData(int data){
		this.data = data;
	}
	
	public void setLeft(MyTree tree){
		this.left = tree;
		tree.setParent(this);
	}
	
	public void setRight(MyTree tree){
		this.right = tree;
		tree.setParent(this);
	}
	
	public int getData(){
		return this.data;
	}
	
	public MyTree getLeft(){
		return this.left;
	}
	
	public MyTree getRight(){
		return this.right;
	}
	
	public void preOrder(MyTree tree){
		if(tree != null){
			System.out.print(tree.getData()+"->");
			preOrder(tree.getLeft());
			preOrder(tree.getRight());
		}
	}
	
	public void inOrder(MyTree tree){
		if(tree != null){
			inOrder(tree.getLeft());
			System.out.print(tree.getData());
			inOrder(tree.getRight());
		}
	}
	
	public void postOrder(MyTree tree){
		if(tree != null){
			postOrder(tree.getLeft());
			postOrder(tree.getRight());
			System.out.print(tree.getData());
		}
	}
	
	public void BFS(MyTree tree){
		Queue<MyTree> q = new LinkedList<MyTree>();
		q.add(tree);
		while(!q.isEmpty()){
			MyTree temp = q.poll();
			System.out.print(temp.getData());
			if(temp.getLeft() != null)
				q.add(temp.getLeft());
			if(temp.getRight() != null)
				q.add(temp.getRight());
		}
	}
	
	public int getMaxRecursive(MyTree root){
		int left, right, root_val, max = Integer.MIN_VALUE;
		if(root != null){
			root_val = root.getData();
			left = getMaxRecursive(root.getLeft());
			right = getMaxRecursive(root.getRight());
			if(left < right){
				max = right;
			}
			else
			{
				max = left;
			}
			if(root_val > max){
				max = root_val;
			}
		}
		return max;
	}

	public boolean searchRecursive(MyTree root, int data){
		Boolean temp;
		if(root != null){
			if(root.getData() == data){
				return true;
			}
			else{
				temp = searchRecursive(root.getLeft(), data);
				if(temp == true)
					return temp;
				else
					return searchRecursive(root.getRight(), data);
			}
		}
		else{
			return false;
		}
	}

	public boolean searchBFS(MyTree tree, int data){
		Queue<MyTree> q = new LinkedList<MyTree>();
		q.add(tree);
		while(!q.isEmpty()){
			MyTree temp = q.poll();
			if(data == temp.getData()){
				return true;
			}
			if(temp.getLeft() != null)
				q.add(temp.getLeft());
			if(temp.getRight() != null)
				q.add(temp.getRight());
		}
		return false;
	}
}