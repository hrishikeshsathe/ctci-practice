package cracking.the.code.chapter3;

import data.structures.MyStack;

public class Three_Two extends MyStack{
	MyStack minStack;
	
	Three_Two(){
		minStack = new MyStack();
	}
	
	public void push(int data){
		if(data <= min())
			minStack.push(data);
		super.push(data);
	}
	
	public int pop(){
		int data = super.pop();
		if(data == minStack.peek())
			minStack.pop();
		return data;
	}
	
	private int min(){
		int minValue = minStack.peek() != -1 ? minStack.peek() : Integer.MAX_VALUE;
		return minValue;
	}
	
	public static void main(String args[]){
		Three_Two myStack = new Three_Two();
		myStack.push(3);
		myStack.push(4);
		myStack.push(2);
		myStack.push(5);
		myStack.push(1);
		myStack.pop();
		myStack.pop();
		myStack.pop();
		System.out.println(myStack.min());
	}
}
