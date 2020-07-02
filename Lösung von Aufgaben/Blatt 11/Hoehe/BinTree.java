public class BinTree {

	public BinNode root;

    // Loeschen eines Knotens
	public void delete(int element) {
		root = delete(root, element);
	}

    // rekursive Funktion zum Loeschen eines beliebigen Knoten
	private BinNode delete(BinNode bn, int element) {
		if (bn==null)
			return null;

		if (element < bn.element)
			bn.left = delete(bn.left, element);
		else if (element > bn.element)
			bn.right = delete(bn.right, element);
		else {
			// zu löschender Knoten gefunden?
			if (bn.right==null) return bn.left;
			if (bn.left==null) return bn.right;

			// jetzt behandeln wir den Fall, dass der zu loeschende
			// Knoten 2 Nachfolger hat
			BinNode tmp = bn;

			// suche Minimum im rechten Teilbaum des zu loeschenden Knoten
			bn = findMin(tmp.right);

			// Minimum im rechten Teilbaum loeschen
			bn.right = deleteMin(tmp.right);

			// links-Zeiger aktualisieren
			bn.left = tmp.left;

		}
		return bn;
	}



    // Minimum ab 'bn' loeschen
	private BinNode deleteMin(BinNode bn) {
		if (bn.left == null)
			return bn.right;

		bn.left = deleteMin(bn.left);
		return bn;
	}

    
    // Minimum ab 'root' rekursiv suchen
	public BinNode findMinimum() {
		return findMin(root);
	}

    // Minimum ab 'bn' rekursiv suchen
	private BinNode findMin(BinNode bn) {
		if (bn.left==null)
			return bn;
		else
			return findMin(bn.left);
	}

    // Maximum ab 'root' rekursiv suchen
	public BinNode findMaximum() {
		return findMax(root);
	}

    // Maximum ab 'bn' rekursiv suchen
	private BinNode findMax(BinNode bn) {
		if (bn.right==null)
			return bn;
		else
			return findMax(bn.right);
	}

    // Maximum ab 'root' iterativ suchen
	public BinNode findMaximumIt() {
		BinNode cur = root;
		while (cur.right != null) {
			cur = cur.right;
		}
		return cur;
	}

	public int determineHeight() {
		return determineHeight(root);
	}

  	public int determineHeight(BinNode bn) {
    	int leftHeight = -1;
    	int rightHeight = -1;

    	if (bn.left != null) {
      		leftHeight = determineHeight(bn.left);
    	}
    	if (bn.right != null) {
      		rightHeight = determineHeight(bn.right);
    	}

		if (leftHeight > rightHeight) {
      		return leftHeight + 1;
    	} else {
      		return rightHeight + 1;
    	}
  	}
    
	public boolean insertNode(BinNode bn) {
		BinNode child=null, parent=null;

		// Knoten suchen, nach welchem eingefuegt wird
		child = root;
		while( child != null) {
			parent = child;
			if (bn.element == child.element)     return false;
			else if (bn.element < child.element) child = child.left;
			else                                 child = child.right;
		}

		// Baum leer?
		if (parent==null)                     root = bn;
		// Einfuegen nach parent, links
		else if (bn.element < parent.element) parent.left = bn;
		// Einfuegen nach parent, rechts
		else                                  parent.right = bn;

		return true;
	}

    
	public BinNode findNode(int element) {
		BinNode  n = root;

		while (n != null) {
            if (element == n.element)	  { return n;    }
			else if (element < n.element) { n = n.left;  }
			else                          { n = n.right; }
		}
		return null;
	}
    

	public String toString() {
		return root.toString();
	}

    
    // Ausgabe des Baums
    public void print() {
        // Puffer fuer Baum
        char buffer[][] = new char[25][80];

        // Puffer initialisieren
        for (int y=0; y<25; y++) {
            for (int x=0; x<80; x++) {
                buffer[y][x] = ' ';
            }
        }

        // Baum auslesen
        int tiefe = print(root, 40, 1, buffer);

        // Ausgabe des Baums
        for (int y=0; y<tiefe; y++) {
            for (int x=0; x<80; x++) {
                System.out.print(buffer[y][x]);
            }
            System.out.println(); System.out.println();
        }
    }

    
    // rekursive Hilfsfunktion zur Ausgabe des Baums
    private int print(BinNode node, int indent, int tiefe, char buffer[][]) {
        int ltiefe, rtiefe;

        // Abbruch der Rekursion
        if (node==null)
            return tiefe;

        /* Knoten "ausgeben" */
        String str = Integer.toString(node.element);
        int startpos = str.length() / 2;
        for (int i=0; i<str.length(); i++) {
            buffer[tiefe][indent - startpos + i] = str.charAt(i);
        }

        /* Linken und rechten Teilbaum ausgeben */
        ltiefe = print(node.left, indent-12/tiefe, tiefe+1, buffer);
        rtiefe = print(node.right, indent+12/tiefe, tiefe+1, buffer);

        if (ltiefe > rtiefe) return ltiefe;
        return rtiefe;
    }


}
