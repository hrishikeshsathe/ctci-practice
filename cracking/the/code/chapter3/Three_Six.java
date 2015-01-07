package cracking.the.code.chapter3;

import data.structures.MyStack;

class Three_Six extends MyStack{
	MyStack myStack;
	MyStack sortedStack;
	
	public Three_Six(){
		myStack = new MyStack();
	}
	
	public MyStack sort(){
		sortedStack = new MyStack();
		int temp;
		while(myStack.peek() != -1)
		{
			temp = myStack.pop();
			while(sortedStack.peek() != -1 && sortedStack.peek() > temp){
				myStack.push(sortedStack.pop());
			}
			sortedStack.push(temp);
		}
		return sortedStack;
	}
	
	public void push(int data){
		myStack.push(data);
	}
	
	public int pop(){
		return myStack.pop();
	}
	
	public int peek(){
		return myStack.peek();
	}
	
	public static void main(String args[]){
		Three_Six stack = new Three_Six();
		stack.push(10);
		stack.push(5);
		stack.push(3);
		stack.push(12);
		stack.push(8);
		MyStack sortedStack = stack.sort();
		while(sortedStack.peek() != -1){
			System.out.println(sortedStack.pop());
		}
	}
}