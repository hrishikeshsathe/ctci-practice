package codility;

import java.util.ArrayList;
import java.util.Stack;

public class OpenBrackets {
	public static void main(String args[]){
		openBracketsEasy();
	}

	public static void openBracketsEasy(){
		String openBracketPattern = "[\\(\\{\\[]";
		String closeBracketPattern = "[\\)\\]\\}]";
		String temp = "";
		String input = "[can {and it(it (mix) up ) } look silly]";
		ArrayList<String> parse = new ArrayList<String>();
		for(int i=0; i<input.length(); i++){
			if((String.valueOf(input.charAt(i))).matches(openBracketPattern)){
				if(!temp.equals("")){
					parse.add(temp.trim());
					parse.add("OPEN");
					temp = "";
				}
			}
			else if((String.valueOf(input.charAt(i))).matches(closeBracketPattern)){
				System.out.print(temp+" ");
				if(parse.size()>0 && parse.get(parse.size()-1).equals("OPEN"))
					parse.remove(parse.size()-1);
			}
			else{
				if(parse.size()>0){
					if(!parse.get(parse.size()-1).equals("OPEN")){
						temp = parse.get(parse.size()-1);
						parse.remove(parse.size()-1);
					}
				}
			temp += String.valueOf(input.charAt(i));
			}
		}
	}
	
	public static void openBrackets(){
		Stack<Character> storeBracket = new Stack<Character>();
		Stack<String> word = new Stack<String>();
		String openBracketPattern = "[\\(\\{\\[]";
		String closeBracketPattern = "[\\)\\]\\}]";
		String temp = "";
		String input = "[can {and it(it (mix) up ) } look silly]";
		for(int i=0; i<input.length(); i++){
			if((String.valueOf(input.charAt(i)).matches(openBracketPattern))){
				storeBracket.push(input.charAt(i));
				if(!temp.equals("")){
					word.push(temp.trim());
					word.push("OPEN");
					temp = "";
				}
			}
			else if((String.valueOf(input.charAt(i)).matches(closeBracketPattern))){
				word.push(temp.trim());
				switch(input.charAt(i)){
					case ')':
						if(!storeBracket.isEmpty() && storeBracket.peek() == '('){
							storeBracket.pop();
							if(!word.isEmpty()){
								if(!word.isEmpty())
									System.out.print(word.pop()+" ");
								if(!word.isEmpty() && word.peek().equalsIgnoreCase("OPEN"))
									word.pop();
							}
						}
						else{
							System.out.println("Error");
							return;
						}
						break;
					case ']':
						if(!storeBracket.isEmpty() && storeBracket.peek() == '['){
							storeBracket.pop();
							if(!word.isEmpty()){
								if(!word.isEmpty())
									System.out.print(word.pop()+" ");
								if(!word.isEmpty() && word.peek().equalsIgnoreCase("OPEN"))
									word.pop();
							}
						}
						else{
							System.out.println("Error");
							return;
						}
						break;
					case '}':
						if(!storeBracket.isEmpty() && storeBracket.peek() == '{'){
							storeBracket.pop();
							if(!word.isEmpty()){
								if(!word.isEmpty())
									System.out.print(word.pop()+" ");
								if(!word.isEmpty() && word.peek().equalsIgnoreCase("OPEN"))
									word.pop();
							}
						}
						else{
							System.out.println("Error");
							return;
						}
						break;
				}
			}
			else{
				if(!word.isEmpty() && !word.peek().equals("OPEN")){
				//while(!input.charAt(i).matches(openBracketPattern) && !input.charAt(i).matches(closeBracketPattern)){
					temp = word.pop();
					}
				temp += input.charAt(i);
				}
				
			}
		}
}

