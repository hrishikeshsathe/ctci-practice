package cracking.the.code.chapter1;

public class One_Seven {
	
	public static void main(String args[]){
		int[][] matrix = {{1,0,1},{0,1,1},{1,1,1}};
		checkForZeroes(matrix);
	}
	
	public static void checkForZeroes(int[][] matrix){
		boolean[] row = new boolean[matrix.length];
		boolean[] column = new boolean[matrix[0].length];

		for(int i=0; i<matrix.length; i++)
		{
			for(int j=0; j<matrix[0].length; j++){
				if(matrix[i][j]==0)
					{
						row[i]=true;
						column[j]=true;
					}
			}
		}
		nullifyRows(row, matrix);
		nullifyColumns(column, matrix);
	}

	public static void nullifyRows(boolean[] row,int[][] matrix)
	{
		for(int i=0; i<row.length; i++)
		{
			if(row[i]){
				for(int j=0;j<matrix.length;j++){
					matrix[i][j]=0;
				}
			}
		}
	}

	public static void nullifyColumns(boolean[] column, int[][] matrix)
	{
		for(int i=0; i<column.length; i++)
		{
			if(column[i]){
				for(int j=0;j<matrix[0].length;j++){
					matrix[j][i]=0;
				}
			}
		}
	}
}
