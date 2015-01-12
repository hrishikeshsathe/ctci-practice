package cracking.the.code.chapter11;

public class Eleven_One{
	public static void main(String args[]){
		int[] a = new int[10];
		a[0] = 5;
		a[1] = 6;
		a[2] = 7;
		a[3] = 8;
		a[4] = 9;
		int[] b = {0,1,2,3,4};
		System.out.println(merge(a,b));
		for(int i=0; i<a.length; i++){
			System.out.println(a[i]);
		}
	}
	
	public static int[] merge(int[] a, int[] b){
		int aLastIndex = 4;
		int aFreeIndex = 9;
		int bLastIndex = 4;
		while(bLastIndex >=0){
			if(aLastIndex>=0 && a[aLastIndex] > b[bLastIndex]){
				a[aFreeIndex] = a[aLastIndex];
				aLastIndex--;
			}
			else{
				a[aFreeIndex] = b[bLastIndex];
				bLastIndex--;
			}
			aFreeIndex--;
		}
		return a;
	}
}