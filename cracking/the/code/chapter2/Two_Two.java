package cracking.the.code.chapter2;

import data.structures.Node;

class Two_Two{
	public static void main(String args[]){
		Node li = new Node(1);
		for(int i = 2; i < 6; i++){
			li.append(i);
		}
		kthToLastRecursive(li, 2);
		kthToLastIterative(li, 2);
	}
	
	public static int kthToLastRecursive(Node head, int k){
		if(head == null){
			return 0;
		}
		
		int i = kthToLastRecursive(head.getNext(), k) + 1;
		if(i==k){
			System.out.println(head.getData());
		}
		return i;
	}
	
	public static void kthToLastIterative(Node head, int k){
		if(head == null){
			return;
		}
		Node slowPointer = head;
		Node fastPointer = head;
		for(int i = 0; i < k-1; i++){
			fastPointer = fastPointer.getNext();
		}
		if(fastPointer == null){
			return;
		}
		while(fastPointer.getNext() != null){
			slowPointer = slowPointer.getNext();
			fastPointer = fastPointer.getNext();
		}
		System.out.println(slowPointer.getData());
	}
}