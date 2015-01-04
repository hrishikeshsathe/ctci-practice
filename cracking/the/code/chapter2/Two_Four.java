package cracking.the.code.chapter2;

import data.structures.Node;

class Two_Four{
	
	public static void main(String args[]){
		Node head = new Node(3);
		head.append(5);
		head.append(2);
		head.append(4);
		head.append(6);
		head = partition(head, 3);
		head.printList(head);
	}
	
	public static Node partition(Node head, int i){
		Node beforeStart = null;
		Node beforeEnd = null;
		Node afterStart = null;
		Node afterEnd = null;
		
		while(head != null){
			Node next = head.getNext();
			head.next = null;
			if(head.data < i){
				if(beforeStart == null){
					beforeStart = head;
					beforeEnd = beforeStart;
				}
				else
				{
					beforeEnd.next = head;
					beforeEnd = head;
				}
			}
			else{
				if(afterStart == null){
					afterStart = head;
					afterEnd = afterStart;
				}
				else{
					afterEnd.next = head;
					afterEnd = head;
				}	
			}
			head = next;
		}
		if(beforeStart == null){
			return afterStart;
		}
		beforeEnd.next = afterStart;
		return beforeStart;
	}
}