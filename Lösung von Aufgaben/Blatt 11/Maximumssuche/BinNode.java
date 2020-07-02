public class BinNode {
	public int element;
	public BinNode left, right;

	public BinNode(int e, BinNode l, BinNode r) {
		element = e;
		left    = l;
		right   = r;
	}

	public BinNode(int e) {
		element = e;
		left = null;
		right = null;
	}

	// Auslesen des Binärbaums in Präfix-Reihenfolge
	public String toString() {
		String s = "";

		s = s + element + " ";

		if (left != null)
			s = s + left.toString();

		if (right != null)
			s = s + right.toString();

		return s;
	}
    
}
