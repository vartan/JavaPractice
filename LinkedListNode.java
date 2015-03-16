/**
 * Example linked list node I made
 */
public class LinkedListNode<T> {
	T obj;
	LinkedListNode<T> next;
	public LinkedListNode(T _obj) {
		obj = _obj;
	}
	// Helper function I made to make it easier to generate
	// a quick link of nodes
	public LinkedListNode<T> next(T _obj) {
		next = new LinkedListNode<>(_obj);
		return next;
	}
	public String toString() {
		return obj.toString();

	}
}