package cracking.the.code.chapter5;

public class Five_Two{
	public static void main(String args[]){
		System.out.println(toBinary(0.25));
	}
	
	public static String toBinary(double num){
		if(num > 1 || num < 0){
			return "ERROR";
		}
		StringBuilder binaryString = new StringBuilder(".");
		while(num > 0){
			double r = num * 2;
			System.out.println(r);
			if(r>=1){
				binaryString.append("1");
				num = r - 1;
			}
			else{
				binaryString.append("0");
				num = r;
			}
		}
		return binaryString.toString();
	}
}