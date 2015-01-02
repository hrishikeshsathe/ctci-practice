package cracking.the.code.chapter1;

import java.util.HashSet;

public class One_One {

	public static void main(String argsp[]){
		checkUnique("hrishi");
	}
	public static void checkUnique(String input){
		HashSet<Character> temp = new HashSet<Character>();
		for(int i=0; i<input.length(); i++){
			if(!temp.add(input.charAt(i))){
				System.out.println("Not unique");
				return;
			}
		}
		System.out.println("Unique");
	}
}
