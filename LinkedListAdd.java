import java.lang.StringBuffer;
/**
 * Takes two linked lists of digits and adds them together.
 */
public class LinkedListAdd {
	public static void main(String[] args) {
		MyLinkedList<Integer> list1 = new MyLinkedList<>();
		list1.add(1);list1.add(2);list1.add(3);list1.add(0);
		MyLinkedList<Integer> list2 = new MyLinkedList<>();
		list2.add(4);list2.add(5);list2.add(6);
		System.out.println(list1.toString());
		System.out.println("+");
		System.out.println(list2.toString());
		System.out.println("_______");

		int int1 = intVal(list1);
		int int2 = intVal(list2);

		int sum = int1 + int2;
		MyLinkedList<Integer> sumHead = intToLinkedList(sum);
		System.out.println(sumHead.toString());

	}
	public static int intVal(MyLinkedList<Integer> list) {
		if(list==null || list.start == null)
			throw new NullPointerException();
		LinkedListNode<Integer> node = list.start;
		int val = 0;
		do {
			val*=10;
			val+=node.obj;
		} while((node = node.next) != null);
		return val;
	}
	public static MyLinkedList<Integer> intToLinkedList(int num) {
		int numSize = (int)(Math.log10(num));
		LinkedListNode<Integer> head = null;
		LinkedListNode<Integer> node = null;
		MyLinkedList<Integer> list = new MyLinkedList<>();
		int multiplier = (int)Math.pow(10,numSize);
		for(int i=numSize;i>=0; i--, multiplier/=10) {
			int digit = (int)(num/multiplier) % 10;
			list.add(digit);
		}
		return list;
	}
}
