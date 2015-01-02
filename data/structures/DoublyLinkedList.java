package data.structures;

class DoublyLinkedList {

	int data;
	DoublyLinkedList next;
	DoublyLinkedList previous;
	
	public DoublyLinkedList(int data){
		this.data = data;
		this.next = null;
		this.previous = null;
	}
	
	public void append(int data){
		DoublyLinkedList end = new DoublyLinkedList(data);
		DoublyLinkedList current = this;
		while(current.next != null){
			current = current.next;
		}
		current.next = end;
		end.previous = current;
	}
	
	public DoublyLinkedList insertHead(int data){
		DoublyLinkedList newHead = new DoublyLinkedList(data);
		newHead.next = this;
		this.previous = newHead;
		return newHead;
	}
	
	public void insert(int insertAfter, int data){
		DoublyLinkedList newNode = new DoublyLinkedList(data);
		DoublyLinkedList current = this;
		while(current.data != insertAfter){
			current = current.next;
		}
		newNode.next = current.next;
		newNode.previous = current;
		current.next.previous = newNode;
		current.next = newNode;
	}
	
	public DoublyLinkedList deleteHead(){
		DoublyLinkedList temp = this;
		DoublyLinkedList newHead = temp.next;
		newHead.previous = null;
		temp = null;
		return newHead;
	}
	
	public void delete(int data){
		DoublyLinkedList current = this;
		DoublyLinkedList toDelete;
		DoublyLinkedList nextNode;
		while(current.next.data != data){
			current = current.next;
		}
		nextNode = current.next.next;
		toDelete = current.next;
		current.next = toDelete.next;
		if(nextNode != null)
			nextNode.previous = current;
		toDelete = null;
	}
	
	public void printList(){
		DoublyLinkedList current = this;
		do
		{
			System.out.print(current.data);
			current = current.next;
		}
		while(current.next != null);
		System.out.print(current.data);
		System.out.println();
		do
		{
			System.out.print(current.data);
			current = current.previous;
		}
		while(current.previous != null);
		System.out.print(current.data);
	}
	
}