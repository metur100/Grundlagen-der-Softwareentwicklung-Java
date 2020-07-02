public class PKW extends Fahrzeug implements Anhaengerkupplung {
	private Anhaenger anhaenger;		

	public PKW(int sitze, int gewicht) {
		super(sitze, 4, gewicht);
	}

	@Override
	public Anhaenger ankuppeln(Anhaenger a) {
		Anhaenger prev = anhaenger;
		anhaenger = a;
		return prev;
	}

	@Override
	public Anhaenger entkuppeln() {
		Anhaenger prev = anhaenger;
		anhaenger = null;
		return prev;
	}

	@Override
	public boolean gekuppelt() {
		return anhaenger != null;
	}

	@Override
	public int getGesamtgewicht() {
		if (anhaenger != null) {
			return super.getGesamtgewicht() + anhaenger.getGesamtgewicht();
		}

		return super.getGesamtgewicht();
	}
}
