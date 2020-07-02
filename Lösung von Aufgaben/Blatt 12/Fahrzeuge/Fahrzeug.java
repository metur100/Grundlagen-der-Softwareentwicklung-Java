public abstract class Fahrzeug implements Gesamtgewicht {
	public int sitze;
	public int raeder;
	public int gewicht;
		
	public Fahrzeug(int sitze, int raeder, int gewicht) {
		this.sitze = sitze;
		this.raeder = raeder;
		this.gewicht = gewicht;
	}

	public int getSitze() {
		return sitze;
	}

	public int getRaeder() {
		return raeder;
	}

	public int getGewicht() {
		return gewicht;
	}

	@Override
	public int getGesamtgewicht() {
		return gewicht;
	}
}
