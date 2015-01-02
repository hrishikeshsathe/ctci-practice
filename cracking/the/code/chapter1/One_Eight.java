package cracking.the.code.chapter1;

class One_Eight{
	public static void main(String args[]){
		String s1 = "hrishi";
		String s2 = "hihris";
		s1 = s1.concat(s1);
		System.out.println(s1.contains(s2));
	}
}