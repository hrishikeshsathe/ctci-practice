package cracking.the.code.chapter3;

import java.util.ArrayList;
import java.util.Stack;

class Three_Three{
	ArrayList<Stack<Integer>> setOfStacks;
	
	public Three_Three(){
		setOfStacks = new ArrayList<Stack<Integer>>();
	}
	
	public void push(int data){
		Stack<Integer> last = getLastStack();
		if(last != null && last.size()<10){
			last.push(data);
		}
		else
		{
			last = new Stack<Integer>();
			last.push(data);
			setOfStacks.add(last);
		}
	}
	
	public int pop(){
		Stack<Integer> last = getLastStack();
		int data = (int) last.pop();
		if(last.size() == 0)
			setOfStacks.remove(last);
		return data;
	}
	
	public Stack<Integer> getLastStack(){
		if(setOfStacks.size() > 0)
			return setOfStacks.get(setOfStacks.size()-1);
		else
			return null;
	}
	
	public static void main(String args[]){
		Three_Three s = new Three_Three();
		for(int i=0; i<20; i++){
			s.push(i);
		}
		for(int i=0; i<20; i++){
			System.out.println(s.pop());
		}
	}
}