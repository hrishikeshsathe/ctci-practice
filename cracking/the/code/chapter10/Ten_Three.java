package cracking.the.code.chapter10;

public class Ten_Three{
	public static void main(String args[]){
		int[] arr = {1,2,3,5,6,7,8,9,10};
		byte[] bitArray = new byte[9];
		for(int i=0; i<arr.length; i++){
			bitArray[i/8] |= 1 << arr[i]%8;
		}
		for(int i =0; i<bitArray.length; i++){
			if(bitArray[i]==0){
				System.out.println(bitArray[i]);
			}
		}
	}
}