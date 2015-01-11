package cracking.the.code.chapter7;

import java.util.LinkedList;
import java.util.Queue;

public class Seven_Seven{
	public static void main(String args[]){
		System.out.println(kThSmallestNumber(4));
	}
	
	public static int kThSmallestNumber(int k){
		if(k < 0)
			return 0;
		int val = 0;
		Queue<Integer> q3 = new LinkedList<Integer>();
		Queue<Integer> q5 = new LinkedList<Integer>();
		Queue<Integer> q7 = new LinkedList<Integer>();
		q3.add(1);
		
		for(int i = 0; i <= k; i++){
			int v3 = q3.size() > 0? q3.peek() : Integer.MAX_VALUE;
			int v5 = q5.size() > 0? q5.peek() : Integer.MAX_VALUE;
			int v7 = q7.size() > 0? q7.peek() : Integer.MAX_VALUE;
			val = Math.min(v3, Math.min(v5, v7));
			
			if(v3 == val){
				q3.remove();
				q3.add(3 * val);
				q5.add(5 * val);
			}
			else if(v5 == val){
				q5.remove();
				q5.add(5 * val);
			}
			else if(v7 == val)
				q7.remove();
			q7.add(7 * val);
		}
		return val;
	}
}