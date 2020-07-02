public class TestBinTree {

	public static void main(String args[]) {
        // Eingabedaten
		int nvals[] = { 9, 3, 12, 1, 6, 4, 7, 5, 13};
                
		BinTree btree = new BinTree();

		for (int i=0; i<nvals.length; i++) {
			btree.insertNode( new BinNode(nvals[i]) );
		}

		System.out.println("Baum zu Beginn");
		btree.print();

		System.out.println("Maximum des Baumes (rekursiv): " + btree.findMaximum());
		System.out.println("Maximum des Baumes (iterativ): " + btree.findMaximumIt());
	}
}
