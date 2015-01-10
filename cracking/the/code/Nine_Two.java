package cracking.the.code.chapter9;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;

public class Nine_Two{
	public static int[][] maze = new int[1000][1000];

	public static int[][] randomMatrix(int M, int N, int min, int max) {
		int[][] matrix = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				matrix[i][j] = randomIntInRange(min, max);
			}
		}
		return matrix;
	}
	
	public static int randomIntInRange(int min, int max) {
		return randomInt(max + 1 - min) + min;
		}
	public static int randomInt(int n) {
		return (int) (Math.random() * n);
		}
	
	public static void main(String args[]){
		maze = randomMatrix(1000, 1000, 0, 1);  
		for(int i = 0; i<1000; i++){
			for(int j = 0; j<1000; j++){
				System.out.print(maze[i][j]);
			}
			System.out.println();
		}
		ArrayList<Point> path = new ArrayList<Point>();
		HashMap<Point,Boolean> cache = new HashMap<Point,Boolean>();
		System.out.println(getPath(999,999,path));
		System.out.println(getPath(999,999,cache,path));

	}

	public static boolean getPath(int x, int y, ArrayList<Point> path){
		if(x<0 || y<0 | !isFree(x,y))
			return false;
		boolean isAtOrigin = (x==0) && (y==0);
		if(isAtOrigin || getPath(x-1,y,path) || getPath(x,y-1,path)){
			Point p = new Point(x,y);
			path.add(p);
			return true;
		}
		return false;
	}
	public static boolean getPath(int x, int y,HashMap<Point,Boolean> cache, ArrayList<Point> path){
		if(x<0 || y<0 | !isFree(x,y))
			return false;
		boolean isAtOrigin = (x==0) && (y==0);
		Point p = new Point(x,y);
		if(cache.containsKey(p))
			return cache.get(p);
		boolean success = false;
		if(isAtOrigin || getPath(x-1,y,cache,path) || getPath(x,y-1,cache,path)){
			path.add(p);
			success = true;
		}
		cache.put(p,success);
		return success;
	}

	private static boolean isFree(int x, int y) {
		// TODO Auto-generated method stub
		if (maze[x][y] == 0) {
			return false;
		} 
		else {
			return true;
		}
	}
}