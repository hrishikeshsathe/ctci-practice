package cracking.the.code.chapter9;

import java.util.ArrayList;

public class Nine_Nine{
	public static int GRID_SIZE = 8;
	
	public static void main(String args[]){
		Integer[] columns = new Integer[GRID_SIZE];
		ArrayList<Integer[]> result = new ArrayList<Integer[]>();
		placeQueens(0,columns,result);
		System.out.println(result);
	}
	
	public static void placeQueens(int row, Integer[] columns, ArrayList<Integer[]> result){
		if(row == GRID_SIZE)
			result.add(columns.clone());
		else{
			for(int col = 0; col < GRID_SIZE; col++){
				if(checkValid(col,row,columns)){
					columns[row] = col;
					placeQueens(row+1, columns, result);
				}
			}
		}
	}
	
	public static boolean checkValid(int col1, int row1, Integer[] columns){
		for(int row2 = 0; row2 < row1; row2++){
			int col2 = columns[row2];
			if(col2 == col1)
				return false;
			int colDist = Math.abs(col1-col2);
			int rowDist = row1-row2;
			if(rowDist == colDist)
				return false;
		}
		return true;
	}
}

