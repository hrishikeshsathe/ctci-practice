package cracking.the.code.chapter2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

class Two_One{
	public static void main(String args[]){
		LinkedList<Integer> li = new LinkedList<Integer>();
		HashMap<Integer, Boolean> hm = new HashMap<Integer, Boolean>();
		li.add(1);
		li.add(2);
		li.add(3);
		li.add(3);
		li.add(2);
		li.add(1);
		Iterator<Integer> it = li.iterator();
		while(it.hasNext()){
			Integer x = it.next();
			if(hm.get(x) != null){
				it.remove();
			}
			else
			{
				hm.putIfAbsent(x, true);
			}
		}
		System.out.println(li);
	}
}