public class LinkedListLoop {
	public static void main(String[] args) {
		LinkedListNode<Integer> head = new LinkedListNode<>(1);
		LinkedListNode<Integer> node = head;
		for(int i=2;i<=11;i++) {
			node = node.next(i);
		}

		node.next = head.next.next.next;
		node = head;
		for(int i=0;i<12;i++) {
			System.out.println(node.obj);
			node=node.next;
		}
		System.out.println();
		LinkedListNode runner = head;
		LinkedListNode fastRunner = head;
		int stepCount = 0;
		do {
			runner = runner.next;
			fastRunner = fastRunner.next.next;
			stepCount++;
		} while(runner != fastRunner);
		int stepCount2 = 0;
		do {
			runner = runner.next;
			fastRunner = fastRunner.next.next;
			stepCount2++;
		} while(runner != fastRunner);
		int loop_size = stepCount2;
		int k = loop_size - stepCount2;
		System.out.println("Step size: "+ stepCount2);
		System.out.println("k: "+k);
	}
}