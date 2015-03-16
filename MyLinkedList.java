import java.lang.StringBuilder;
public class MyLinkedList<T> {
	LinkedListNode<T> start;
	LinkedListNode<T> end;
	public MyLinkedList() {
		start=null;end=null;
	}
	public void add(T obj) {
		LinkedListNode<T> newNode = new LinkedListNode<>(obj);
		if(start==null) {
			start=newNode; 
			end=newNode;
		} else {
			end.next = newNode;
			end = newNode;
		}
	}
	public void remove(T obj) {
		LinkedListNode<T> node, runner;
		if(start==null) return;
		node = start;
		runner = node.next;
		if(start.obj.equals(obj)) {
			start = runner;
		} else {
			while(runner!=null && !runner.obj.equals(obj)) {
				runner=runner.next;
				node=node.next;
			}
			if(runner!=null) { // found the object in runner
				node.next = runner.next;
			}
			if(runner == end)
				end = node; 
		}
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		LinkedListNode<T> node = start;
		while(node!=null) {
			sb.append(node.toString());
			if(node!=end)
				sb.append(", ");
			node = node.next;
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		MyLinkedList<String> list = new MyLinkedList<>();
		list.add("test");
		list.add("test2");
		list.add("test3");
		System.out.println(list.toString());
	}
}