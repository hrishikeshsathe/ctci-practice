package data.structures;

public class MyStack {
	Node top;
	
	public void push(int data){
		Node toPush = new Node(data);
		toPush.next = top;
		top = toPush;
	}
	
	public int pop(){
		if(top == null)
			return -1;
		Node toReturn = top;
		top = top.next;
		return toReturn.data;
	}
	
	public int peek(){
		if(top == null){
			return -1;
		}
		return top.data;
	}
}