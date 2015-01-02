package data.structures;

public class Node{

	public Node next;
	public int data;
	
	public int getData(){
		return this.data;
	}
	
	public Node getNext(){
		return this.next;
	}
	
	public Node(int data){
		this.data = data;
		this.next = null;
	}
	
	public void append(int data){
		Node end = new Node(data);
		Node currentNode = this;
		while(currentNode.next != null){
			currentNode = currentNode.next;
		}
		currentNode.next = end;
	}
	
	public void insert(int insertAfter, int data){
		Node newNode = new Node(data);
		Node currentNode = this;
		Node temp = null;
		while(currentNode.data != insertAfter){
			currentNode = currentNode.next;
		}
		temp = currentNode.next;
		currentNode.next = newNode;
		newNode.next = temp;
	}
	
	public Node deleteHead(Node node){
		Node currentHead = node.next;
		node = null;
		return currentHead;
	}
	
	public void delete(int data){
		Node currentNode = this;
		while(currentNode.next.data != data){
			currentNode = currentNode.next;
		}
		@SuppressWarnings("unused")
		Node temp = currentNode.next;
		currentNode.next = currentNode.next.next;
		temp = null;
	}
	public Node insertHead(int data){
		Node newHead = new Node(data);
		newHead.next = this;
		return newHead;
	}
	
	public Node returnNode(int position){
		Node currentNode = this;
		int count = 1;
		while(count < position && currentNode.next != null){
			currentNode = currentNode.next;
			count++;
		}
		return currentNode;
	}
	
	public void printList(Node head){
		Node temp = head;
		while(temp.next != null){
			System.out.print(temp.data);
			temp = temp.next;
		}
		System.out.print(temp.data);
	}
	
	public void deleteCurrent(){
		Node current =  this;
		Node temp = current.next;
		System.out.println(current.getData()+" "+temp.getData());
		current.data = temp.data;
		current.next = temp.next;
		temp = null;

		//current.next = null;
		
	}
}