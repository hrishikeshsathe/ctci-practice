package cracking.the.code.chapter2;

import java.util.LinkedList;
import java.util.Stack;

class Two_Eight{

	public static void main(String args[]){
		LinkedList<Integer> li = new LinkedList<Integer>();
		li.add(1);
		li.add(2);
		li.add(3);
		li.add(3);
		li.add(2);
		li.add(1);
		checkPalindrome(li);
		
	}
	
	public static void checkPalindrome( LinkedList<Integer> li){
		Stack<Integer> temp = new Stack<Integer>();
		int i=0;
		for(i = 0; i < li.size()/2; i++){
			temp.push(li.get(i));
		}
		for(;i < li.size(); i++){
			if(temp.pop() != li.get(i)){
				System.out.println("Not a palindrome");
				return;
			}
		}
		System.out.println("Palindrome");
	}
}