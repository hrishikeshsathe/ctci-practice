package cracking.the.code.chapter4;

import java.util.ArrayList;
import java.util.LinkedList;

import data.structures.MyTree;

public class Four_Four{
	static ArrayList<LinkedList<MyTree>> lists;
	
	public static void main(String args[]){
		lists = new ArrayList<LinkedList<MyTree>>();
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
		createLinkedLists(lists, root, 0);
		System.out.println("DFS - "+lists.size());
		lists = createLinkedListBFS(root);
		System.out.println("BFS - "+lists.size());
	}
	
	public static void createLinkedLists(ArrayList<LinkedList<MyTree>> lists, MyTree tree, int level){
		if(tree == null)
			return;
		LinkedList<MyTree> list = null;
		if(lists.size() == level){
			list = new LinkedList<MyTree>();
			lists.add(list);
		}
		else
			list = lists.get(level);
		list.add(tree);
		createLinkedLists(lists, tree.getLeft(), level+1);
		createLinkedLists(lists, tree.getRight(), level+1);
	}
	
	public static ArrayList<LinkedList<MyTree>> createLinkedListBFS(MyTree tree){
		if(tree == null)
			return null;
		LinkedList<MyTree> current = new LinkedList<MyTree>();
		current.add(tree);
		ArrayList<LinkedList<MyTree>> lists = new ArrayList<LinkedList<MyTree>>();
		
		while(current.size() > 0){
			lists.add(current);
			LinkedList<MyTree> parents = current;
			current = new LinkedList<MyTree>();
			for(MyTree parent : parents){
				if(parent.getLeft() != null)
					current.add(parent.getLeft());
				if(parent.getRight() != null)
					current.add(parent.getRight());
			}
		}
		return lists;
	}
}