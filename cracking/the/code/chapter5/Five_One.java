package cracking.the.code.chapter5;

public class Five_One{
	public static void main(String args[]){
		int n = 15;
		int m = 3;
		int i = 0;
		int j = 2;
		
		int mask = ~0 << (j+1);
		System.out.println(Integer.toBinaryString(mask));
		mask = mask | ((1 << i) - 1);
		System.out.println(Integer.toBinaryString(mask));
		n = n & mask;
		System.out.println(Integer.toBinaryString(n));
		n = n | (m << i);
		System.out.println(Integer.toBinaryString(n));
	}
}