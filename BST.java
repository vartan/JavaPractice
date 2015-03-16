/**
 * Given a sorted array, creates a binary search tree.
 */
public class BST {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		System.out.println(createMinimalBST(arr).toString());
	}
	public static BinaryTreeNode<Integer> createMinimalBST(int[] arr) {
		return createMinimalBST(arr,0,arr.length-1);
	}
	public static BinaryTreeNode<Integer> createMinimalBST(int[] arr, int start, int end) {
		if(end<start)return null;
		int mid = (start+end)/2;
		BinaryTreeNode<Integer> n = new BinaryTreeNode<Integer>(arr[mid]); // create this node;
		n.setLeft(createMinimalBST(arr,start,mid-1));
		n.setRight(createMinimalBST(arr,mid+1, end));
		return n;
	}
}