package cracking.the.code.chapter1;

public class One_Three {
	
	public static void main(String args[]){
		compareStrings("dsogs","godss");
	}

	public static void compareStrings(String s1, String s2){
		if(s1.length() != s2.length()){
			System.out.println("No permutation");
			return;
		}

		int[] count = new int[256];
		char[] charArr = s1.toCharArray();
		for(int i=0; i<charArr.length; i++){
			count[(charArr[i])]++;
		}
		for(int i=0; i<s2.length(); i++){
			if(--count[(s2.charAt(i))] < 0){
				System.out.println("No permutation");
				return;
			}
		}
		System.out.println("Permutation");
	}
}
