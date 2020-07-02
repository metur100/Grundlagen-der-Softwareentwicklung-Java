public class Anhaenger implements Gesamtgewicht {
	private int anzahlAchsen;
	private int gewicht;
	private int gewichtLadung;

	public Anhaenger(int anzahlAchsen, int gewicht, int gewichtLadung) {
		this.anzahlAchsen = anzahlAchsen;
		this.gewicht = gewicht;
		this.gewichtLadung = gewichtLadung;
	}

	public int getAnzahlAchsen() {
		return anzahlAchsen;
	}

	public int getGewicht() {
		return gewicht;
	}

	public int getGewichtLadung() {
		return gewichtLadung;
	}

	@Override
	public int getGesamtgewicht() {
		return gewicht + gewichtLadung;
	}
}
