public class TestList {

	public static void main(String args[]) {
		LinkedList l1 = new LinkedList();

		l1.append(new Node(1));
		l1.append(new Node(2));
		l1.append(new Node(3));
		l1.append(new Node(4));

		System.out.println("l1, length: " + l1.count());

		l1.dump();

		LinkedList l2 = new LinkedList();
		
		l2.append(new Node(5));
		l2.append(new Node(6));

		System.out.println("l2, length: " + l2.count());

		l2.dump();

		LinkedList l3 = l1.join(l2);

		System.out.println("l3, length: " + l3.count());

		l3.dump();
	}
}
