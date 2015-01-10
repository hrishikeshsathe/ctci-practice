package cracking.the.code.chapter9;

import java.util.ArrayList;

public class Nine_Five{

	public static String insertCharAt(String word, char c, int i){
		String start = word.substring(0,i);
		String end = word.substring(i);
		return start + c + end;
	}	
	
	public static ArrayList<String> getPerm(String str){
		if(str == null)
			return null;
		ArrayList<String> permutation = new ArrayList<String>();
		if(str.length() == 0){
			permutation.add("");
			return permutation;
		}
		
		char first = str.charAt(0);
		String remainder = str.substring(1);
		ArrayList<String> words = getPerm(remainder);
		for(String word: words){
			for(int i = 0; i<=word.length(); i++){
				String s = insertCharAt(word, first, i);
				permutation.add(s);
			}
		}
		return permutation;
	}
	
	public static void main(String args[]){
		ArrayList<String> x = getPerm("abcdefghijklo");
		System.out.println(x);
	}
}

