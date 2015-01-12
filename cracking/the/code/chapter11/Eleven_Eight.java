package cracking.the.code.chapter11;

public class Eleven_Eight{
	private static RankNode root = null;
	
	public void track(int d){
		if(root == null)
			root = new RankNode(d);
		else
			root.insert(d);
	}
	
	public int getRankOfNumber(int d){
		return root.getRank(d);
	}
	
	public static void main(String args[]){
		Eleven_Eight x = new Eleven_Eight();
		x.track(20);
		x.track(15);
		x.track(10);
		x.track(5);
		x.track(13);
		x.track(25);
		x.track(23);
		x.track(24);
		System.out.println(x.getRankOfNumber(20));		
	}
}

class RankNode{
	RankNode left;
	RankNode right;
	int left_size;
	int data;
	
	public RankNode(int d){
		data = d;
	}
	
	public void insert(int d){
		if(d <= data){
			if(left == null)
				left = new RankNode(d);
			else
				left.insert(d);
			left_size++;
		}
		else{
			if(right == null)
				right = new RankNode(d);
			else
				right.insert(d);
		}
	}
	
	public int getRank(int d){
		if(d == data)
			return left_size;
		else if(d <= data){
			if(left == null)
				return -1;
			else
				return left.getRank(d);
		}	
		else{
			if(right == null)
				return -1;
			else
				return left_size + 1 + right.getRank(d);
		}
	}
	
}