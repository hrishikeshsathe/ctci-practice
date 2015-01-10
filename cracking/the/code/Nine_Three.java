package cracking.the.code.chapter9;

public class Nine_Three{
	public static void main(String args[]){
		int arr[] = new int[5];
		arr[0]=-1;
		arr[1]=0;
		arr[2]=1;
		arr[3]=3;
		arr[4]=5;
		System.out.println(getKthElement(arr,0,4));
		System.out.println(getKthElementOpt(arr,0,4));
	}
	
	public static int getKthElement(int[] arr, int start, int end){
		if(start < 0 || end >= arr.length || end < start)
			return -1;
		int middle = (end + start)/2;
		if(arr[middle] == middle)	
			return middle;
		else if(arr[middle] < middle)
			return getKthElement(arr, middle+1, end);
		else	
			return getKthElement(arr, start, middle-1);
	}
	
	public static int getKthElementOpt(int[] arr, int start, int end){
		if(start < 0 || end >= arr.length || end < start)
			return -1;
		int middle = (end + start)/2;
		if(arr[middle] == middle)	
			return middle;
		int leftIndex = Math.min(middle-1, arr[middle]);
		int left = getKthElementOpt(arr, start, leftIndex);
		if(left >= 0)
			return left;
		int rightIndex = Math.max(middle+1, arr[middle]);
		int right = getKthElementOpt(arr, rightIndex, end);
		return right;
	}	
}