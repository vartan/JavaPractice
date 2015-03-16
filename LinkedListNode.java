public class LinkedListNode<T> {
	T obj;
	LinkedListNode<T> next;
	public LinkedListNode(T _obj) {
		obj = _obj;
	}
	public LinkedListNode<T> next(T _obj) {
		next = new LinkedListNode<>(_obj);
		return next;
	}
	public String toString() {
		return obj.toString();

	}
}