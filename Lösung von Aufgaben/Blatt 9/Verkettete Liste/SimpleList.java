public class SimpleList {

	public static void main(String args[]) {
		Node head, node;

		// Liste aufbauen, immer am Kopf einfügen
		head = new Node(1, null);
		node = new Node(2, head); head = node;
		node = new Node(3, head); head = node;

		// Ausgabe der Liste
		Node current = head;
		while ( current != null) {
			System.out.println( "Element=" + current.element );
			current = current.next;
		}


	}
}
