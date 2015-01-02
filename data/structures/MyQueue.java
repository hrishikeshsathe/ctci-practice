package data.structures;

public class MyQueue{
	Node first=null, last=null;
	
	public void enqueue(int data){
		if(first == null)
		{
			first = new Node(data);
			last = first;
		}
		else
		{
			last.next = new Node(data);
			last = last.next;
		}
	}
	
	public int dequeue(){
		if(first == null){
			return -1;
		}
		else{
			Node toReturn = first;
			first = first.next;
			return toReturn.data;
		}
	}
}