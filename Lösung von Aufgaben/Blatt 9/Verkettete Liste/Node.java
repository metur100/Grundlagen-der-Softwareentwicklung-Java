public class Node {
	public int element = 0;
	public Node next = null;

	// Konstruktor 1
	public Node(int e, Node n) {
		this.element = e;
		this.next = n;
	}

	// Konstruktor 2
	public Node(int e) {
		this.element = e;
	}
}
