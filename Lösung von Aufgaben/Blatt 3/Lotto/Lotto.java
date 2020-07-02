public class Lotto {

  	public static void main(String[] args) {
    	int[] a;
    	int zahl;
    	int position;
    	boolean gefunden;

		// Loesung auch ohne Array moeglich
    	a = new int[6];

    	position = 0;
    	while (position < a.length) {
      		// Zufallszahl zwischen 1 und 49 erzeugen (1 Punkt)
      		zahl = (int)(Math.random() * (49)) + 1;

      		// Überprüfen, ob Zahl bereits gezogen (2 Punkte)
      		gefunden = false;
      		for (int i = 0;i < position;i++) {
        		if (a[i] == zahl) {
          			gefunden = true;
        		}
      		}

      		// Zahl festlegen (1 Punkt)
      		if (!gefunden) {
        		a[position] = zahl;
        		position++;
      		}
   		}

		// Ausgabe der Zahlen (1 Punkt)
    	for (int i = 0;i < a.length;i++) {
      		System.out.println(a[i]);
    	}
  	}
}
