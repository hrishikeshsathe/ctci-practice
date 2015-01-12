package cracking.the.code.chapter11;

public class Eleven_Three{
	public static void main(String args[]){
		int[] arr = {50,5,20,30,40};
		System.out.println(findElement(arr,0,4,5));
	}
	
	public static int findElement(int[] arr, int left, int right, int x){
		int mid = (left+right)/2;
		if(arr[mid]==x)
			return mid;
		if(right < left)
			return -1;
		if(arr[mid] > arr[left]){
			if(x >= arr[left] && x < arr[mid])
				return findElement(arr, left, mid-1, x);
			else
				return findElement(arr, mid+1, right, x);
		}
		else if(arr[mid] < arr[left]){
			if(x > arr[mid] && x <= arr[right])
				return findElement(arr, mid+1, right, x);
			else
				return findElement(arr, left, mid-1, x);
		}
		else if(arr[mid] == arr[left]){
			if(arr[mid] != arr[right]){
				return findElement(arr, mid+1, right, x);
			}
			else{
				int result = findElement(arr, left, mid-1, x);
				if(result == -1)
					return findElement(arr, mid+1, right, x);
				else
					return result;
			}
		}
		return -1;
	}
}