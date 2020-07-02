public class LinkedList {
	public Node head = null;

	public void insert(Node n) {
		n.next = head;
		head = n;
	}

	public int count() {
		Node current = head;
		int length = 0;

		while (current != null) {
			length++;
			current = current.next;
		}

		return length;
	}

	public void append(Node n) {
		// Sonderfall: Liste leer		
		if (head == null) {
			head = n;
			return;
		}

		Node current = head;

		while (current.next != null) {
			current = current.next;
		}

		current.next = n;
	}

	public LinkedList join(LinkedList other) {
		LinkedList ll = new LinkedList();

		Node current = head;

		while (current != null) {
			ll.append(new Node(current.element));
			current = current.next;
		}

		current = other.head;

		while (current != null) {
			ll.append(new Node(current.element));
			current = current.next;
		}

		return ll;
	}

	public void delete(int nummer) {
		Node current = head;

		// Sonderfall, soll das erste Element geloescht werden?
		if (head.element == nummer) {
			head = head.next;
			return ;
		}

		while( current.next != null) {
			if ( current.next.element == nummer) {
				current.next = current.next.next;
			}
			current = current.next;
		}

	}

	public void dump() {
		Node current = head;

		System.out.println("Ausgabe der kompletten Liste");
		while (current!=null) {
			System.out.println("   Element=" + current.element);
			current = current.next;
		}
	}
}
