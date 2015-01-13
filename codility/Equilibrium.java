package codility;

public class Equilibrium {

	public static void main(String args[]){
//		int[] arr = {-15,-5,-10,-100,-4,-6,-2,-3,-8,-7};
		int[] arr = {15,5,10,-100,4,6,2,3,8,7};
		getEquilibriumIndex(arr,0,arr.length-1);
	}

	private static void getEquilibriumIndex(int[] arr, int start, int end) {
		// TODO Auto-generated method stub
		int sumBeforeMid = 0;
		int sumAfterMid = 0;
		int mid = (start+end)/2;
		for(int i = 0; i < mid; i++){
			sumBeforeMid += arr[i];
		}
		for(int i = mid+1; i <= arr.length-1; i++){
			sumAfterMid += arr[i];
		}
		System.out.println("Mid is "+arr[mid]+" Sum before = "+sumBeforeMid+" Sum after = "+sumAfterMid);
		if(sumBeforeMid == sumAfterMid){
			System.out.println("Mid = "+mid);
		}
		else if(sumBeforeMid < sumAfterMid){
			getEquilibriumIndex(arr, start, mid-1);
		}
		else
			getEquilibriumIndex(arr, mid+1, end);
	}
}
