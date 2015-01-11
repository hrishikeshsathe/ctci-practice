package cracking.the.code.chapter9;

public class Nine_One{
	public static int countDown(int n){
		if(n < 0)
			return 0;
		if(n == 0)
			return 1;
		return countDown(n-1) + countDown(n-2) + countDown(n-3);
	}
	
	public static void main(String args[]){
		int[] m = new int[50];
		long startTime,endTime;
		startTime = System.currentTimeMillis();
		System.out.println(countDown(1));
		endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime);
		startTime = System.currentTimeMillis();
		System.out.println(countDown(7,m));
		endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime);
	}
	
	public static int countDown(int n, int[] m){
		if(n < 0)
			return 0;
		else if(n == 0)
			return 1;
		else if(m[n] > 0){
			return m[n];
		}
		else{
			m[n] = countDown(n-1,m) + countDown(n-2,m) + countDown(n-3,m);
			return m[n];
		}
	}
}