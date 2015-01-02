package cracking.the.code.chapter1;

import java.util.Scanner;

public class One_Five {
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		if(input.length() < 3)
			System.out.println(input);
		else
			performCompression(input);
		in.close();
	}

	public static void performCompression(String input){
		StringBuffer answer = new StringBuffer();
		char last = input.charAt(0);
		int count = 1;
		for(int i = 1; i<input.length(); i++){
			if(last == input.charAt(i)){
				count++;
			}
			else
			{
				answer.append(last);
				answer.append(count);
				last = input.charAt(i);
				count = 1;
			}
		}
		answer.append(last);
		answer.append(count);
		if(answer.length() >= input.length())
			System.out.println(input);
		else
			System.out.println(answer);
	}
}
