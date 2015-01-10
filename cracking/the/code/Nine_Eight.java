package cracking.the.code.chapter9;

public class Nine_Eight{
	public static int makeDenom(int[] denom, int amount, int index){
		if( index >= denom.length){
			return 1;
		}
		int ways = 0;
		int denomAmount = denom[index];
		for(int i=0; i*denomAmount <= amount; i++){
			int amountRemaning = amount - i*denomAmount;
			ways += makeDenom(denom, amountRemaning, index+1);
		}
		return ways;
	}
	
	public static int makeChange(int amount){
		int[] denom = {25,10,5,1};
		return makeDenom(denom, amount, 0);
	}
	
	public static void main(String args[]){
		System.out.println(makeChange(1));
	}
}