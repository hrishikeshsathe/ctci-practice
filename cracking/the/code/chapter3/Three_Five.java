package cracking.the.code.chapter3;

import java.util.Stack;

public class Three_Five{
	Stack<Integer> oldStack;
	Stack<Integer> newStack;
	
	public Three_Five(){
		oldStack = new Stack<Integer>();
		newStack = new Stack<Integer>();
	}
	
	public void add(int data){
		newStack.push(data);
	}
	
	public int remove(){
		shiftStacks();
		return oldStack.pop();
	}
	
	public int peek(){
		shiftStacks();
		return oldStack.peek();
	}
	
	public void shiftStacks(){
		if(oldStack.isEmpty()){
			while(!newStack.isEmpty())
				oldStack.push(newStack.pop());
		}
	}
	
	public static void main(String args[]){
		Three_Five queue = new Three_Five();
		for(int i = 0; i < 10; i++){
			queue.add(i);
		}
		for(int i = 0; i < 10; i++){
			System.out.println(queue.remove());
		}
		
	}
}