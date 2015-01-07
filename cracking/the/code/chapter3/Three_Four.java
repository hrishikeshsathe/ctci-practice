package cracking.the.code.chapter3;

import java.util.Stack;

class Three_Four{
	public static void main(String args[]){
		Tower tower[] = new Tower[3];
		for(int i=0; i<3; i++)
			tower[i] = new Tower(i);
		for(int i = 4; i >= 1; i--)
			tower[0].add(i);
		tower[0].moveDisks(4, tower[1], tower[2]);
	}
	
}

class Tower{
	Stack<Integer> disk;
	int index;
	
	public Tower(int index){
		disk = new Stack<Integer>();
		this.index = index;
	}
	
	public void add(int i){
		disk.push(i);
	}
	
	public int index(){
		return index;
	}
	
	public void moveTopTo(Tower t){
		int top = disk.pop();
		t.add(top);
		System.out.println("From "+index()+" "+top+" To "+t.index());
	}
	
	public void moveDisks(int n, Tower destination, Tower buffer){
		if(n>0){
			moveDisks(n-1, buffer, destination);
			moveTopTo(destination);
			buffer.moveDisks(n-1, destination, this);
		}
	}
}
