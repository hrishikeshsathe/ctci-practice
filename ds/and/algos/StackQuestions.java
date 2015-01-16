package ds.and.algos;

import java.util.HashMap;
import java.util.Stack;

public class StackQuestions{
	public static void main(String args[]){
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		int[] arr = {1,5,6,7,7,7,0,1,1,0,6,5};
//		String input = "(){}[][[[]()]{}]";
//		balancingOfSymbol(input);
//		infixToPostfix();
//		evaluatePostfix();
//		reverseStack(stack);
		removeAdjacentDuplicates(arr);
	}
	
	public static void removeAdjacentDuplicates(int[] arr){
		Stack<Integer> stack = new Stack<Integer>();
		for(int i=0; i<arr.length;){
			if(stack.isEmpty() || stack.peek() != arr[i]){
				stack.push(arr[i]);
				i++;
			}
			else{
				while(i<arr.length && stack.peek() == arr[i]){
					stack.push(arr[i]);
					i++;
				}
				int top = stack.pop();
				while(!stack.isEmpty() && top == stack.peek())
					stack.pop();
			}
		}
		System.out.println(stack);
	}
	
	public static void reverseStack(Stack<Integer> stack){
		if(stack.isEmpty())
			return;
		int temp = stack.pop();
		reverseStack(stack);
		actualReverse(stack, temp);
	}

	public static void actualReverse(Stack<Integer> stack, int data){
		if(stack.isEmpty()){
			stack.push(data);
			return;
		}
		int temp = stack.pop();
		actualReverse(stack, data);
		stack.push(temp);
	}
	
	public static void evaluatePostfix(){
		String input = "12345*-**";
		Stack<Integer> temp = new Stack<Integer>();
		for(int i=0; i<input.length(); i++){
			if(String.valueOf(input.charAt(i)).matches("[\\-\\+\\/\\*]")){
				Integer op1 = temp.pop();
				Integer op2 = temp.pop();
				switch(input.charAt(i)){
					case '+':
						temp.push(op2+op1);
						break;
					case '-':
						temp.push(op2-op1);
						break;
					case '/':
						temp.push(op2/op1);
						break;
					case '*':
						temp.push(op2*op1);
						break;
				}
			}
			else{
				temp.push(Integer.parseInt(String.valueOf(input.charAt(i))));
			}
		}
		System.out.println(temp.pop());
	}
	
	public static void infixToPostfix(){
		Stack<Character> temp = new Stack<Character>();
		String input = "1*(2*(3-(4*5)))";
		HashMap<Character, Integer> priority = new HashMap<Character, Integer>();
		initializePriority(priority);
		for(int i = 0; i<input.length(); i++){
			if(input.charAt(i) == ')'){
				if(temp.isEmpty())
					System.out.println("Error");
				else{
					while(temp.peek() != '('){
						System.out.print(temp.pop());
						if(temp.isEmpty()){
							System.out.println("Error");
							return;
						}
					}
					temp.pop();
				}
			}
			else if(String.valueOf(input.charAt(i)).matches("[\\-\\+\\/\\*\\(]")){
				char t = input.charAt(i);
				while(true){
					if(!temp.isEmpty()){
						if(temp.peek() == '('){
							break;
						}
						else if(priority.get(temp.peek()) >= priority.get(t)){
							System.out.print(temp.pop());
						}
						else
							break;
					}
					else
						break;
				}
				temp.push(t);
			}
			else
				System.out.print(input.charAt(i));
		}
		while(!temp.isEmpty()){
			System.out.println(temp.pop());
		}
	}

	public static void initializePriority(HashMap<Character, Integer> priority){
		priority.put('+',1);
		priority.put('-',1);
		priority.put('*',2);
		priority.put('/',2);
		priority.put('(', 3);
	}

	
	public static void balancingOfSymbol(String input){
		Stack<Character> temp = new Stack<Character>();
		for(int i=0; i<input.length(); i++){
			if(input.charAt(i) == '(' || input.charAt(i) == '{' || input.charAt(i) == '['){
				temp.push(input.charAt(i));
			}
			else if(input.charAt(i) == ')' || input.charAt(i) == '}' || input.charAt(i) == ']'){
				switch(input.charAt(i)){
					case ')':
						if(!temp.isEmpty() && temp.peek() == '(')
							temp.pop();
						else{
							System.out.println("Error");
							return;
						}
						break;
					case '}':
						if(!temp.isEmpty() && temp.peek() == '{')
							temp.pop();
						else{
							System.out.println("Error");
							return;
						}
						break;
					case ']':
						if(!temp.isEmpty() && temp.peek() == '[')
							temp.pop();
						else{
							System.out.println("Error");
							return;
						}
						break;
				}
			}
		}
		if(temp.isEmpty())
			System.out.println("No error");
		else
			System.out.println("Error");
	}
}
