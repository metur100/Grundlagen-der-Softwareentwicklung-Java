package caesar;


public class Caesar {

	// Attribut zum Speichern des Offsets
	private int offset;

	// Konstruktor
	public Caesar(int offset) {
		// Ueberpruefung des Wertebereichs
		if (offset >= -26 && offset <= 26) {
			this.offset = offset;
		} else {
			this.offset = 0;
		}
	}

	// Methode zum Verschluesseln
	public String encrypt(String klartext) {
		String geheimtext = "";
		char c;
		int index;

		for (int i = 0; i < klartext.length(); i++) {
			c = klartext.charAt(i);

			// Ueberpruefung des Wertebereichs
			if (c >= 'A' && c <= 'Z') {
				// Verschiebung des Zeichens
				index = c - 'A';
				index = (index + offset) % 26;
				// Negatives Ergebnis korrekt behandeln
				if (index < 0) {
					index += 26;
				}

				c = (char)(index + 'A');
			}

			// Geheimtext erzeugen
			geheimtext += c;
		}

		// Geheimtext zurueckgeben
		return geheimtext;
	}

	// Methode zum Entschluesseln
	public String decrypt(String geheimtext) {
		String klartext = "";
		char c;
		int index;

		for (int i = 0; i < geheimtext.length(); i++) {
			c = geheimtext.charAt(i);

			// Ueberpruefung des Wertebereichs
			if (c >= 'A' && c <= 'Z') {
				// Verschiebung des Zeichens
				index = c - 'A';
				index = (index - offset) % 26;
				// Negatives Ergebnis korrekt behandeln
				if (index < 0) {
					index += 26;
				}

				c = (char)(index + 'A');
			}

			// Klartext erzeugen
			klartext += c;
		}

		// Klartext zurueckgeben
		return klartext;
	}
	
}
