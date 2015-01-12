package cracking.the.code.chapter11;

class Eleven_Five{
	public static void main(String args[]){
		String[] strings = {"a","b","","c","d","e","f"};
		String s = "c";
		System.out.println(search(strings,s));
	}
	
	public static int search(String strings[], String s){
		if(strings == null || s == null || s == "")
			return -1;
		return searchR(strings,s,0,strings.length-1);
	}
	
	public static int searchR(String strings[], String s, int first, int last){
		if(first > last)
			return -1;
		int middle = (first + last) / 2;
		if(strings[middle].isEmpty()){
			int left = middle - 1;
			int right = middle + 1;
			while(true){
				if(left < first && right > last){
					return -1;
				}
				else if(right <= last && !strings[right].isEmpty()){
					middle = right;
					break;
				}
				else if(left >= first && !strings[left].isEmpty()){
					middle = left;
					break;
				}
				left--;
				right++;
			}
		}
		if(strings[middle].equals(s))
			return middle;
		else if(strings[middle].compareTo(s) < 0)
			return searchR(strings, s, middle+1, last);
		else
			return searchR(strings, s, first, middle-1);
	}
}