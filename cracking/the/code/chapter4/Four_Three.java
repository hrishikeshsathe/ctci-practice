package cracking.the.code.chapter4;

import data.structures.MyTree;

class Four_Three{
	public static void main(String args[]){
		int arr[] = new int[11];
		for(int i=1; i<12; i++)
			arr[i-1] = i;
		MyTree root = createMinimalBST(arr, 0, 10);
		root.preOrder(root);
	}
	
	public static MyTree createMinimalBST(int arr[], int start, int end){
		if(end < start)
			return null;
		int mid = (end + start) / 2;
		MyTree root = new MyTree(arr[mid]);
		root.setLeft(createMinimalBST(arr, start, mid - 1));
		root.setRight(createMinimalBST(arr, mid + 1, end));
		return root;
	}
}