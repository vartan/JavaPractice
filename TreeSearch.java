import java.util.*;
/**
 * Tree Search
 * Finds the distance between two nodes on a binary tree.
 */
public class TreeSearch {
	public static void main(String[] args) {
		new TreeSearch();
	}
	public TreeSearch() {
		int[] n = {1,2,3,4,5,6,7,8,9,10};
		BinaryTreeNode<Integer> tree = BST.createMinimalBST(n);
		System.out.println(distanceTo(tree, 5));
	}
	public int distanceTo(BinaryTreeNode<Integer> parentNode, int n) {

		Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
		parentNode.clearVisited();
		parentNode.visited = true;
		queue.add(parentNode);
		BinaryTreeNode<Integer> childNode = null;
		BinaryTreeNode<Integer> node = null;
		while(!queue.isEmpty()) {
			node = queue.remove();
			if(node.data == n) return distance(parentNode, node);
			if((childNode = node.getLeft())!=null) queue.add(childNode);
			if((childNode = node.getRight())!=null) queue.add(childNode);

		}
		return -1;
	}
	public int distance(BinaryTreeNode<Integer> parentNode, BinaryTreeNode<Integer> childNode) {
		int distance = 0;
		System.out.println("Distance: "+childNode.toString());
		while(true) {
			if(childNode == null)     return -1;
			if(childNode == parentNode) return distance;

			distance++;
			childNode = childNode.getParent();
		}
	}
}
