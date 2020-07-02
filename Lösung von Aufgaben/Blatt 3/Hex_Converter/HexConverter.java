public class HexConverter {

  	public static void main(String[] args) {
  		int zahl;
    	int mod;
    	int div;

    	// Argumente einlesen
    	zahl = Integer.parseInt(args[0]);

    	// Division und Modulo durchführen
    	div = zahl / 16;
    	mod = zahl % 16;

		// Erste Stelle ausgeben
    	switch (div) {
    		case 10:
      			System.out.print("A");
      			break;
			case 11:
			  	System.out.print("B");
			  	break;
			case 12:
			  	System.out.print("C");
			  	break;
			case 13:
			  	System.out.print("D");
			  	break;
			case 14:
			  	System.out.print("E");
			  	break;
			case 15:
			  	System.out.print("F");
			  	break;
			default:
			  	System.out.print(div);
			  	break;
    	}

		// Zweite Stelle ausgeben
		switch (mod) {
			case 10:
			  	System.out.print("A");
			  	break;
			case 11:
			  	System.out.print("B");
			  	break;
			case 12:
			  	System.out.print("C");
			  	break;
			case 13:
			  	System.out.print("D");
			  	break;
			case 14:
			  	System.out.print("E");
			  	break;
			case 15:
			  	System.out.print("F");
			  	break;
			default:
			  	System.out.print(mod);
			  	break;
    	}

		// Zeilenumbruch
		System.out.println();
	}
}
