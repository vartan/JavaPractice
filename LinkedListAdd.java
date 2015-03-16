import java.lang.StringBuffer;
public class LinkedListAdd {
	public static void main(String[] args) {
		LinkedListNode<Integer> list1Head = new LinkedListNode<>(1);
		list1Head.next(2).next(3);
		LinkedListNode<Integer> list2Head = new LinkedListNode<>(4);
		list2Head.next(5).next(6).next(7);

		int int1 = intVal(list1Head);
		int int2 = intVal(list2Head);

		int sum = int1+int2;
		LinkedListNode sumHead = intToLinkedList(sum);
		System.out.println(sumHead.toString());
	}
	public static int intVal(LinkedListNode<Integer> node) {
		int val = 0;
		do {
			val*=10;
			val+=node.obj;
		} while((node = node.next) != null);
		return val;
	}
	public static LinkedListNode<Integer> intToLinkedList(int num) {
		int numSize = (int)(Math.log10(num));
		LinkedListNode<Integer> head = null;
		LinkedListNode<Integer> node = null;
		for(int i=numSize;i>=0; i--) {
			int digit = (int)(num/Math.pow(10,i)) % 10;
			if(head == null) {
				head = new LinkedListNode<Integer>(digit);
				node = head;
			} else {
				node = node.next(digit);
			}
		}
		return head;
	}
}
