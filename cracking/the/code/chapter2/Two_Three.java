package cracking.the.code.chapter2;

import data.structures.Node;

public class Two_Three {

	public static void main(String args[]){
		Node head = new Node(1);
		head.append(2);
		head.append(3);
		head.append(4);
		head.append(5);
		Node toDelete = head.returnNode(3);
		toDelete.deleteCurrent();
		head.printList(head);
	}
}
