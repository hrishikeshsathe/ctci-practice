package cracking.the.code.chapter5;

public class Five_Five {

	public static void main(String args[]){
		long startTime = System.currentTimeMillis();
		bitsChanged(1048576555,1048575555);
		long endTime = System.currentTimeMillis();
		System.out.println("Normal - "+(endTime-startTime));
		startTime = System.currentTimeMillis();
		bitsChangedOptimized(1048576,1048575);
		endTime = System.currentTimeMillis();
		System.out.println("Optimized - "+(endTime-startTime));
		

	}
	
	public static void bitsChanged(long x, long y){
		int count = 0;
		for(long c = x ^ y; c != 0; c = c >> 1){
			count += c & 1;
		}
		System.out.println("Normal - "+count);
	}
	
	public static void bitsChangedOptimized(long x, long y){
		int count = 0;
		for(long c = x ^ y; c != 0; c = c & (c - 1)){
			count++;
		}
		System.out.println("Optimized - "+count);
	}
	
}
